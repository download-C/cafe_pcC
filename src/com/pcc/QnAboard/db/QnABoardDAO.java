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
		int qna_num = 0;
		try {
			con = getConnect();
			sql = "select max(qna_num) from qna_boards";
			System.out.println(" select문 성공! ");
			
			pstmt = con.prepareStatement(sql);
			System.out.println(" pstmt 성공! ");
		} catch(Exception e) {
			e.printStackTrace();
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
					dto.setQnA_ip(rs.getString("QnA_ip"));
					dto.setQnA_file(rs.getString("QnA_file"));
					
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

