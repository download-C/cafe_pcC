package com.pcc.board.notice.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.eclipse.jdt.internal.compiler.ast.NumberLiteral;

import com.pcc.manager.db.ManagerDAO;
import com.pcc.manager.db.ManagerDTO;
import com.sun.org.apache.bcel.internal.generic.DASTORE;

// 게시판 관련 모든 메서드를 생성하는 클래스

public class NoticeDAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public NoticeDAO () {
		System.out.println("DAO : DB 연결을 위한 모든 정보 준비 완료");
	}
	
	// 1. CP를 이용한 DB 연결 -----------------------------------------
	private Connection getConnect() {
		try {
			// 1-1. 프로젝트 정보 초기화
			Context initCTX = new InitialContext();
			// 1-2. 초기화된 프로젝트 중 데이터 관련 정보 불러오기
			DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/cafe_pcc");
			con = ds.getConnection();
			
			System.out.println("DAO : DB 연결 완료");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	// 2. getConnect() 메서드의 역순으로 DB 연결 해제 ------------------
	
	private void closeDB() {
		try {
			if(rs != null)	rs.close();
			if(pstmt != null)  pstmt.close();
			if(con != null)  con.close();
			System.out.println("DAO : DB 자원(rs, pstmt, con) 해제 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DAO : DB 연결 해제");
	}
	
	
	// 3.  공지사항 글쓰기 메서드 -----------------------------------------
		public int noticeWrite(NoticeDTO dto) {
			int notice_num = 0;
			try {
				con = getConnect();
				sql = "select max(notice_num) from notice_boards";
				System.out.println("select문 성공!");
				pstmt = con.prepareStatement(sql);
				System.out.println("pstmt 성공!");
				rs = pstmt.executeQuery();
				System.out.println("RS 성공!");
				
				if(rs.next()) {
					notice_num = rs.getInt(1)+1;
				}
				System.out.println("notice_num "+notice_num+"으로 업데이트 완료");
				
				sql = "insert into notice_boards(notice_num, mgr_num, notice_subject, "
					  +"notice_content, notice_readcount, notice_date, notice_file) "
					  +"values(?,1111,?,?,?,now(),?)";
						
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, notice_num);
			
				pstmt.setString(2, dto.getNotice_subject());
				pstmt.setString(3, dto.getNotice_content());
				pstmt.setInt(4,  dto.getNotice_readcount());
				pstmt.setString(5, dto.getNotice_file());
				
				pstmt.executeUpdate();
				
				System.out.println("DAO : 공지사항 정보 저장 완료");
				
				System.out.println("notice_num : "+dto.getNotice_num());
					
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return notice_num;
				
	}
	
	
	// 4. 공지사항 목록 조회  -----------------------------------------
	public List<NoticeDTO> getNoticeList() {
		System.out.println("getNoticeList() 호출");
		List<NoticeDTO> noticeList = new ArrayList<>();
		try {
			con = getConnect();
			sql = "select * from notice_boards";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setNotice_num(rs.getInt(1));
				dto.setMgr_num(rs.getInt(2));
				dto.setNotice_subject(rs.getString(3));
				dto.setNotice_content(rs.getString(4));
				dto.setNotice_readcount(rs.getInt(5));
				dto.setNotice_date(rs.getTimestamp(6));
				dto.setNotice_file(rs.getString(7));
				
				noticeList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return noticeList;
	}
	
	
	public List<NoticeDTO> getNoticeList(int startRow, int pageSize) {
		System.out.println("getNoticeList(int startRow, int pageSize) 호출");
		
		List<NoticeDTO> noticeList = new ArrayList<>();
		try {
			con = getConnect();
			sql = "select * from notice_boards order by notice_num desc limit ?, ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				NoticeDTO dto = new NoticeDTO();
				dto.setNotice_num(rs.getInt(1));
				dto.setMgr_num(rs.getInt(2));
				dto.setNotice_subject(rs.getString(3));
				dto.setNotice_content(rs.getString(4));
				dto.setNotice_readcount(rs.getInt(5));
				dto.setNotice_date(rs.getTimestamp(6));
				dto.setNotice_file(rs.getString(7));
				
				noticeList.add(dto);
				System.out.println("공지사항 정보 저장 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return noticeList;
	}
	
	
	// 6. 조회수 가져오기 메서드  -----------------------------------------
	public int getNoticeCount() {
		int cnt = 0;
		try {
			con = getConnect();
			sql = "select count(*) from notice_boards";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return cnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return 0;
		
	}

	// 6. 조회수 올리는 메서드  -----------------------------------------
	public void updateNoticeReadCount(int notice_num) {
		try {
			con = getConnect();
			sql = "update notice_boards set notice_readcount=notice_readcount+1 "
					+ "where notice_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// 7. 공지사항 글 내용 가져오기 -----------------------------
	public NoticeDTO getNoticeContent(int notice_num) {
		System.out.println("getNoticeBoard() 호출");
		NoticeDTO dto = null;
		
		try{
			con = getConnect();
			sql = "select * from notice_boards where notice_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new NoticeDTO();
				dto.setNotice_num(notice_num);
				dto.setNotice_subject(rs.getString("notice_subject"));
				dto.setNotice_content(rs.getString("notice_content"));
				dto.setNotice_readcount(rs.getInt("notice_readcount"));
				dto.setNotice_date(rs.getTimestamp("notice_date"));
				dto.setNotice_file(rs.getString("notice_file"));
			}
			System.out.println(notice_num+"번 공지사항 저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return dto;
	}

	

	// 8. 공지사항 글 수정 메서드 -----------------------------------------
	public int NoticeUpdate(NoticeDTO dto, int notice_num) {
		int result = -1;

		System.out.println("NoticeUpdate() 호출");
		
		System.out.println("dto: "+dto+"=======================");
		
		
		try {
			con = getConnect();
			
			sql = "update notice_boards "
					+ "set notice_subject=?, notice_content=?, "
					+ "notice_file=? where notice_num = ?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,dto.getNotice_subject());
			pstmt.setString(2, dto.getNotice_content());
			pstmt.setString(3, dto.getNotice_file());
			pstmt.setInt(4, notice_num);
			System.out.println("notice_num: "+dto.getNotice_num());
			System.out.println("dto: "+dto);
			
			pstmt.executeUpdate();
			
			System.out.println("DB에 공지사항 업데이트 완료");
			
			result = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return result;
	}

	// 9. 공지사항 지우기  -----------------------------------------
	public void noticeDelete(int notice_num, int mgr_num) {
		// 9-1. if 문으로 유저의 정보가 매니저일 경우
		if(mgr_num != 0 ){
			try {
				con = getConnect();
				ManagerDAO dao = new ManagerDAO();
				ManagerDTO dto = dao.getManager(mgr_num);
				if( dto.getMgr_num() == mgr_num ){
					sql = "delete from notice_boards where notice_num=?";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, notice_num);
					pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			
		} 
	}	
	
}

