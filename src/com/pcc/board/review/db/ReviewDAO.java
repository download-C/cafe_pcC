package com.pcc.board.review.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.sun.xml.internal.txw2.Document;

// 게시판 관련 모든 메서드를 생성하는 클래스

public class ReviewDAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ReviewDAO () {
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
	

	// 3. 리뷰 게시글 DB에 넣는 메서드
	public void reviewWrite(ReviewDTO dto) {
		int review_num =0;
		
		try {
			con = getConnect();
			sql = "select max(review_num) from review_boards";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				review_num = rs.getInt(1)+1;
			}
			System.out.println("review_num :"+review_num+"으로 업데이트 완료");
			
			sql = "insert into review_boards(review_num, review_writer_type, mgr_num, mem_num, review_password, "
					+ "review_subject, review_content, review_readcount, review_re_ref, review_re_lev,"
					+ "review_re_seq, review_date, review_ip, review_file) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,now(),?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			pstmt.setInt(2, 2);
			pstmt.setInt(3, 0);
			pstmt.setInt(4, dto.getMem_num());
			pstmt.setInt(5, dto.getReview_password());
			pstmt.setString(6, dto.getReview_subject());
			pstmt.setString(7, dto.getReview_content());
			pstmt.setInt(8, dto.getReview_readcount());
			pstmt.setInt(9, dto.getReview_re_ref());
			pstmt.setInt(10, dto.getReview_re_lev());
			pstmt.setInt(11, dto.getReview_re_seq());
			pstmt.setString(12, dto.getReview_ip());
			pstmt.setString(13, dto.getReview_file());
			
			pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
				
	}
	
	
	// 4. 조회수 올리는 메서드 -----------------------------------------
	public int updateReviewReadcount(int review_num) {
		int ctn = 0;
		try {
			con = getConnect();
			sql = "select count(*) from review_boards";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return ctn = rs.getInt(1)+1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return 0;
	}

	// 5.   -----------------------------------------
	public ReviewDTO getReviewContent(int review_num) {
		ReviewDTO dto = new ReviewDTO();
		
		try {
			con = getConnect();
			sql = "select * from review_boards where review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new ReviewDTO();
				dto.setReview_num(review_num);
				dto.setReview_writer_type(rs.getInt("review_writer_type"));
				dto.setMgr_num(rs.getInt("mgr_num"));
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setReview_password(rs.getInt("review_password"));
				dto.setReview_subject(rs.getString("reveiw_subject"));
				dto.setReview_content(rs.getString("review_content"));
				dto.setReview_readcount(rs.getInt("review_readcount"));
				dto.setReview_re_ref(rs.getInt("review_re_ref"));
				dto.setReview_re_lev(rs.getInt("review_re_lev"));
				dto.setReview_re_seq(rs.getInt("review_re_seq"));
				dto.setReview_date(rs.getTimestamp("review_date"));
				dto.setReview_ip(rs.getString("review_ip"));
				dto.setReview_file(rs.getString("reveiw_file"));
			}
			System.out.println(review_num+"번 리뷰 불러오기 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	
		return dto;
	}
	
	
	
	
	
	
	
	
	// 6.   -----------------------------------------
	
	
	
	
	// 7.   -----------------------------------------
	
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
	
	
	
	
}

