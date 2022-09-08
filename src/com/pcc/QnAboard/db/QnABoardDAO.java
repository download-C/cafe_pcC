package com.pcc.QnAboard.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
			
			sql = "insert into qna_boards(QnA_num, QnA_writer_type, mgr_num, "
					+ "mem_num, QnA_password, QnA_subject, QnA_content, QnA_readcount, "
					+ "QnA_re_ref, QnA_re_lev, QnA_re_seq, QnA_date, QnA_ip, QnA_file) " 
					+ "values(?,?,?,123,?,?,?,?,?,?,?,now(),123123,?)";
					
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, QnA_num);
			pstmt.setInt(2, dto.getQnA_writer_type());
			pstmt.setInt(3, dto.getmgr_num());
			pstmt.setInt(4, dto.getmem_num());
			pstmt.setInt(5, dto.getQnA_password());
			
			pstmt.setString(6, dto.getQnA_subject());
			pstmt.setString(7, dto.getQnA_content());
			pstmt.setInt(8, dto.getQnA_readcount());
			
			pstmt.setInt(9, dto.getQnA_re_ref());
			pstmt.setInt(10, dto.getQnA_re_lev());
			pstmt.setInt(11, dto.getQnA_re_seq());
			//pstmt.setString(12, dto.getQnA_ip());
			pstmt.setString(12, dto.getQnA_file());
			
			pstmt.executeUpdate();
			
			System.out.println(" DAO : 문의사항 정보 저장 완료! ");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			closeDB();
		}
	}

	public void getMem_num(Object attribute) {
		
		
	}
	
	
	
	// 4. 문의사항 목록 조회  -----------------------------------------
	
	

	
	
	// 5.   -----------------------------------------
	
	
	
	
	// 6.   -----------------------------------------
	
	
	
	
	// 7.   -----------------------------------------
	
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
	
	
	
	
}

