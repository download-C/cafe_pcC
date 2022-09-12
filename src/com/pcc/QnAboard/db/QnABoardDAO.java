package com.pcc.QnAboard.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

// 게시판 관련 모든 메서드를 생성하는 클래스

public class QnABoardDAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public QnABoardDAO () {
		System.out.println("DAO : DB 연결을 위한 모든 정보 준비 완료");
	}
	
	// 1. CP를 이용한 DB 연결 -----------------------------------------
	private Connection getConnect() {
		try {
			// 1-1. 프로젝트 정보 초기화
			Context initCTX = new InitialContext();
			System.out.println("프로젝트 정보 초기화 완료");
			// 1-2. 초기화된 프로젝트 중 데이터 관련 정보 불러오기
			DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/cafe_pcc");
			System.out.println("초기화된 프로젝트 중 데이터 관련 정보 불러오기 완료");
			con = ds.getConnection();
			System.out.println("con 완료");
			
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
			e.printStackTrace();
		}
		System.out.println("DAO : DB 연결 해제");
	}
	
	
	// 3. 공지사항 글쓰기 메서드  -----------------------------------------
	
	public void QnAWrite (QnABoardDTO dto) {
		int QnA_num = 0;
		try {
			con = getConnect();
			sql = "select max(QnA_num) from qna_boards";
			System.out.println(" select문 성공! ");
			
			pstmt = con.prepareStatement(sql);
			System.out.println(" pstmt 성공! ");
			
			rs = pstmt.executeQuery();
			System.out.println(" RS 성공! ");
			
			if(rs.next()) {
				QnA_num = rs.getInt(1)+1;
				System.out.println("QnA_num "+QnA_num+"으로 업데이트 완료");
			}
			
			sql = "insert into qna_boards(QnA_num, QnA_writer_type, "
					+ "mem_num, QnA_password, QnA_subject, QnA_content, QnA_readcount, "
					+ "QnA_re_ref, QnA_re_lev, QnA_re_seq, QnA_date, QnA_ip, QnA_file) " 
					+ "values(?,?,?,123,?,?,?,?,?,?,?,now(),123123,?)";
					
			pstmt = con.prepareStatement(sql);
			System.out.println("pstmt 완료");
			
			pstmt.setInt(1, QnA_num);
			System.out.println("pstmt QnA_num 완료");
			
			pstmt.setInt(2, dto.getQnA_writer_type());
			System.out.println("pstmt QnA_writer_type 완료");
			//pstmt.setInt(3, dto.getmgr_num());
			pstmt.setInt(3, dto.getmem_num());
			System.out.println("pstmt mem_num 완료");
			
			pstmt.setInt(4, dto.getQnA_password());
			System.out.println("pstmt QnA_password 완료");
			
			pstmt.setString(5, dto.getQnA_subject());
			System.out.println("pstmt QnA_subject 완료");
			pstmt.setString(6, dto.getQnA_content());
			System.out.println("pstmt QnA_content 완료");
			pstmt.setInt(7, dto.getQnA_readcount());
			
			pstmt.setInt(8, dto.getQnA_re_ref());
			pstmt.setInt(9, dto.getQnA_re_lev());
			pstmt.setInt(10, dto.getQnA_re_seq());
			//pstmt.setString(12, dto.getQnA_ip());
			pstmt.setString(11, dto.getQnA_file());
			
			pstmt.executeUpdate();
			System.out.println("executeUpdate 완료");
			
			System.out.println(" DAO : 문의사항 정보 저장 완료! ");
			System.out.println(" DTO : " + dto);
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			closeDB();
		}
	}
	
	// 회원번호로 개인정보를 불러오는 메서드

	public void getMemberInfo(HttpSession sessionID) {
		
		
//		try {
//			con = getConnect();
//			
//			sql = "select * from members where mem_num =?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, sessionID);
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	// 4. 문의사항 목록 조회  -----------------------------------------
	
	// 글 전체 목록 조회 메서드 - getQnABoardList()
	
		public ArrayList<QnABoardDTO> getQnABoardList(int startRow, int pageSize) {
			
			ArrayList<QnABoardDTO> qnaboardlist = new ArrayList<QnABoardDTO>();
			
			try {
				con = getConnect();
				
				sql = "select * from qna_boards";
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					QnABoardDTO dto = new QnABoardDTO();
					
					dto.setQnA_num(rs.getInt("QnA_num"));
					dto.setQnA_writer_type(rs.getInt("QnA_writer_type"));
					dto.setmem_num(rs.getInt("mem_num"));
					dto.setQnA_password(rs.getInt("QnA_password"));
					dto.setQnA_subject(rs.getString("QnA_subject"));
					dto.setQnA_content(rs.getString("QnA_content"));
					dto.setQnA_readcount(rs.getInt("QnA_readcount"));
					dto.setQnA_re_ref(rs.getInt("QnA_re_ref"));
					dto.setQnA_re_lev(rs.getInt("QnA_re_lev"));
					dto.setQnA_re_seq(rs.getInt("QnA_re_seq"));
					dto.setQnA_date(rs.getTimestamp("QnA_date"));
					dto.setQnA__ip(rs.getString("QnA_ip"));
					dto.setQnA__file(rs.getString("QnA_file"));
					
					qnaboardlist.add(dto);
					
				} // while 
				
				System.out.println(" C : 게시판 목록 모두 저장 완료! ");
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeDB();
			}
			
			
			
			return qnaboardlist;
		}

	
	
	// 5.   -----------------------------------------
	
	// 글 개수 조회 메서드	
		
		public int getQnABoardCount() {
			System.out.println( " \n DAO : getQnABoardCount() 메서드 실행 ");
			int cnt = 0;
			
			try {
				con = getConnect();
				
				sql = "select count(*) from qna_boards";
				
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					cnt = rs.getInt(1);
				}
				
				System.out.println(" DAO : 글 개수 - 총 : " + cnt + "개 입니다.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeDB();
			}
			return cnt;
		}
	
	
	
	// 6.   -----------------------------------------
	
	
	
	
	// 7.   -----------------------------------------
	
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
	
	
	
	
}

