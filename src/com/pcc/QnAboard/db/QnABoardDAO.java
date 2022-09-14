package com.pcc.QnAboard.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			
			e.printStackTrace();
		} catch (SQLException e) {
			
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
	
	
	// 3. 문의사항 글쓰기 메서드  -----------------------------------------
	
	public int QnAWrite (QnABoardDTO dto) {
		int QnA_num = 0;
		try {
			con = getConnect();
			sql = "select max(qna_num) from qna_boards";
			System.out.println(" select문 성공! ");
			
			pstmt = con.prepareStatement(sql);
			System.out.println(" pstmt 성공! ");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				QnA_num = rs.getInt(1)+1;
			}
			System.out.println(" QnA_num : " + QnA_num);
			
			sql = "insert into qna_boards (QnA_num, QnA_writer_type, mem_num, QnA_password, "
					+ "qna_subject, QnA_content, QnA_readcount, QnA_re_ref, QnA_re_lev, QnA_re_seq, "
					+ "qna_date, QnA_ip, QnA_file) "
					+ "values (?,2,123,?,?,?,?,?,?,?,now(),?,?) ";
			System.out.println("SQL 완료");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, QnA_num);
			pstmt.setInt(2, dto.getQna_password());
			pstmt.setString(3, dto.getQna_subject());
			pstmt.setString(4, dto.getQna_content());
			System.out.println(" content 완료 ");
			pstmt.setInt(5, dto.getQna_readcount());
			System.out.println(" readcount 완료 ");
			
			pstmt.setInt(6, 1);
			pstmt.setInt(7, 1);
			pstmt.setInt(8, 1);
			
			pstmt.setString(9, "123");
			pstmt.setString(10, dto.getQna_file());
			
			pstmt.executeUpdate();
			System.out.println(" sql 구문 실행 완료 ");
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		return QnA_num;
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
	
		public List<QnABoardDTO> getQnABoardList() {
			
			List<QnABoardDTO> qnaboardlist = new ArrayList<QnABoardDTO>();
			
			try {
				con = getConnect();
				
				sql = "select * from qna_boards";
				
				pstmt = con.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					QnABoardDTO dto = new QnABoardDTO();
					
					dto.setQna_num(rs.getInt("qna_num"));
					dto.setQna_writer_type(rs.getInt("qna_writer_type"));
					dto.setMem_num(rs.getInt("mem_num"));
					dto.setQna_password(rs.getInt("qna_password"));
					dto.setQna_subject(rs.getString("qna_subject"));
					dto.setQna_content(rs.getString("qna_content"));
					dto.setQna_readcount(rs.getInt("qna_readcount"));
					dto.setQna_re_ref(rs.getInt("qna_re_ref"));
					dto.setQna_re_lev(rs.getInt("qna_re_lev"));
					dto.setQna_re_seq(rs.getInt("qna_re_seq"));
					dto.setQna_date(rs.getTimestamp("qna_date"));
					dto.setQna_ip(rs.getString("qna_ip"));
					dto.setQna_file(rs.getString("qna_file"));
					
					qnaboardlist.add(dto);
					
				} // while 
				
				System.out.println(" C : 게시판 목록 모두 저장 완료! ");
				System.out.println(" C : " + qnaboardlist);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				closeDB();
			}
			
			
			
			return qnaboardlist;
		}

		public List<QnABoardDTO> getQnABoardList(int startRow, int pageSize) {
			
			List<QnABoardDTO> qnaboardlist = new ArrayList<QnABoardDTO>();
			
			try {
				con = getConnect();
				
				sql = "select * from qna_boards order by QnA_num desc limit ?,?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setInt(1, startRow-1);
				pstmt.setInt(2, pageSize);
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					QnABoardDTO dto = new QnABoardDTO();
					
					dto.setQna_num(rs.getInt("qna_num"));
					dto.setQna_writer_type(rs.getInt("qna_writer_type"));
					dto.setMem_num(rs.getInt("mem_num"));
					dto.setQna_password(rs.getInt("qna_password"));
					dto.setQna_subject(rs.getString("qna_subject"));
					dto.setQna_content(rs.getString("qna_content"));
					dto.setQna_readcount(rs.getInt("qna_readcount"));
					dto.setQna_re_ref(rs.getInt("qna_re_ref"));
					dto.setQna_re_lev(rs.getInt("qna_re_lev"));
					dto.setQna_re_seq(rs.getInt("qna_re_seq"));
					dto.setQna_date(rs.getTimestamp("qna_date"));
					dto.setQna_ip(rs.getString("qna_ip"));
					dto.setQna_file(rs.getString("qna_file"));
					
					qnaboardlist.add(dto);
					
				} // while 
				
				System.out.println(" C : 게시판 목록 모두 저장 완료! ");
				System.out.println(" C : " + qnaboardlist);
				
				
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
	
	
	
	// 6. 작성한 글 가져오는 메서드  -----------------------------------------
	
	public QnABoardDTO getQnAContent (int QnA_num) {
		System.out.println( "DAO : getQnAContent() 메서드 실행" );
		
		QnABoardDTO dto = null;
		
		try {
			con = getConnect();
			
			sql = "select * from qna_boards where QnA_num=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, QnA_num);
			
			//pstmt.executeQuery();
			rs = pstmt.executeQuery();

			if(rs.next()) {
				
				dto = new QnABoardDTO();
				
				dto.setQna_num(rs.getInt("qna_num"));
				dto.setQna_writer_type(rs.getInt("qna_writer_type"));
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setQna_password(rs.getInt("qna_password"));
				dto.setQna_subject(rs.getString("qna_subject"));
				dto.setQna_content(rs.getString("qna_content"));
				dto.setQna_readcount(rs.getInt("qna_readcount"));
				dto.setQna_re_ref(rs.getInt("qna_re_ref"));
				dto.setQna_re_lev(rs.getInt("qna_re_lev"));
				dto.setQna_re_seq(rs.getInt("qna_re_seq"));
				dto.setQna_date(rs.getTimestamp("qna_date"));
				dto.setQna_ip(rs.getString("qna_ip"));
				dto.setQna_file(rs.getString("qna_file"));

				System.out.println(QnA_num+"의 dto: "+dto);
			}
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return dto;
		
	}		
		

	public int getQnAReadCount(int QnA_num) {
		
	
		int cnt = 0;
		try {
			
			con = getConnect();
			sql = "select QnA_readcount from qna_boards where QnA_num=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, QnA_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return cnt = rs.getInt(1)+1;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return cnt;
	}

	public void updateReadCount(int QnA_num) {
		
		try {
			con = getConnect();
			sql = "update qna_boards set QnA_readcount=QnA_readcount+1 "
					+ "where QnA_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, QnA_num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeDB();
		}
		
		
	}
	
		
	// 7.   -----------------------------------------
	
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
	
	
	
	
}

