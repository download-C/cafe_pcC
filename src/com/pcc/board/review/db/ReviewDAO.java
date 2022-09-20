package com.pcc.board.review.db;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

// 게시판 관련 모든 메서드를 생성하는 클래스

public class ReviewDAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ReviewDAO () {
		System.out.println("DAO : DB 연결을 위한 모든 정보 준비 완료");
	}
	
	// 0. alert() 띄우는 메서드
	public void alert(HttpServletResponse response, String msg, String path) {
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println(path);
			out.println("</script>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// 1. CP를 이용한 DB 연결 -----------------------------------------
	private Connection getConnect() {
		try {
			// 1-1. 프로젝트 정보 초기화
			Context initCTX = new InitialContext();
			// 1-2. 초기화된 프로젝트 중 데이터 관련 정보 불러오기
			DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/cafe_pcc");
			con = ds.getConnection();
			
//			System.out.println("DAO : DB 연결 완료");
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
//			System.out.println("DAO : DB 자원(rs, pstmt, con) 해제 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DAO : DB 연결 해제");
	}
	

	// 3-1. 리뷰 게시글 DB에 넣는 메서드
	public int reviewWrite(ReviewDTO dto) {
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
			
			sql = "insert into review_boards(review_num, review_writer_type, mem_num, name, "
					+ "review_password, review_subject, review_content, review_readcount, review_re_ref, review_re_lev,"
					+ "review_re_seq, review_date, review_ip, review_file) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,now(),?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			pstmt.setInt(2, 2); // 1은 관리자, 2는 회원
			pstmt.setInt(3, dto.getMem_num());
			pstmt.setString(4, dto.getName());
			pstmt.setInt(5, dto.getReview_password());
			pstmt.setString(6, dto.getReview_subject());
			pstmt.setString(7, dto.getReview_content());
			pstmt.setInt(8, dto.getReview_readcount());
			pstmt.setInt(9, review_num);
			pstmt.setInt(10, 0);
			pstmt.setInt(11, 0);
			pstmt.setString(12, dto.getReview_ip());
			pstmt.setString(13, dto.getReview_file());
			
			pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
					
		return review_num;
	}
	
	// 3-2. 관리자가 리뷰에 답글 다는 메서드 ------------------------------
	public int reviewReply(int review_num, ReviewDTO dto) {
		
		try {
			con = getConnect();
			sql = "select max(review_num) from review_boards";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				review_num = rs.getInt(1)+1;
			}
			
			sql = "insert into review_boards(review_num, review_writer_type, mgr_num, review_name, "
					+ "review_password, review_subject, review_content, review_readcount, review_re_ref, review_re_lev,"
					+ "review_re_seq, review_date, review_ip, review_file) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,now(),?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			pstmt.setInt(2, 1); // 1은 관리자, 2는 회원
			pstmt.setInt(3, dto.getMgr_num());
			pstmt.setString(4,  "관리자");
			pstmt.setInt(5, dto.getReview_password());
			System.out.println("글 제목:"+dto.getReview_subject());
			pstmt.setString(6, dto.getReview_subject());
			pstmt.setString(7, dto.getReview_content());
			pstmt.setInt(8, dto.getReview_readcount());
			pstmt.setInt(9, review_num);
			pstmt.setInt(10, 1);
			pstmt.setInt(11, 1);
			pstmt.setString(12, dto.getReview_ip());
			pstmt.setString(13, dto.getReview_file());
			
			pstmt.executeUpdate();
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
					
		return review_num;
	}
	
	
	// 4-1. DB에 저장된 조회수 가져와서 1 올리기 -----------------------------------------
	public int getReviewCount() {
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
	
	// 4-2. DB에서 1 올라간 조회수 저장  ------------------------
	public void updateReviewReadcount(int review_num) {
		
		try {
			con = getConnect();
			sql = "update review_boards set review_readcount = review_readcount+1 " 
					+ "where review_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	// 5. 리뷰 글 가져오기 -----------------------------------------
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
				dto.setReview_subject(rs.getString("review_subject"));
				dto.setReview_content(rs.getString("review_content"));
				dto.setReview_readcount(rs.getInt("review_readcount"));
				dto.setReview_re_ref(rs.getInt("review_re_ref"));
				dto.setReview_re_lev(rs.getInt("review_re_lev"));
				dto.setReview_re_seq(rs.getInt("review_re_seq"));
				dto.setReview_date(rs.getTimestamp("review_date"));
				dto.setReview_ip(rs.getString("review_ip"));
				dto.setReview_file(rs.getString("review_file"));
			}
			System.out.println(review_num+"번 리뷰 불러오기 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	
		return dto;
	}
	

	
	// 6. 리뷰 게시판 목록 조회  -----------------------------------------
	public List<ReviewDTO> getReviewList() {
		System.out.println("getReviewList() 호출");
		
		List<ReviewDTO> reviewList = new ArrayList<>(); 
		
		try {
			con = getConnect();
			sql = "select * from review_boards";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				ReviewDTO dto = new ReviewDTO();
				dto.setReview_num(rs.getInt(1));
				dto.setReview_writer_type(rs.getInt(2));
				dto.setMgr_num(rs.getInt(3));
				dto.setMem_num(rs.getInt(4));
				dto.setName(rs.getString(5));
				dto.setReview_password(rs.getInt(6));
				dto.setReview_subject(rs.getString(7));
				dto.setReview_content(rs.getString(8));
				dto.setReview_content(rs.getString(9));
				dto.setReview_re_ref(rs.getInt(10));
				dto.setReview_re_lev(rs.getInt(11));
				dto.setReview_re_seq(rs.getInt(12));
				dto.setReview_date(rs.getTimestamp(13));
				dto.setReview_ip(rs.getString(14));
				dto.setReview_file(rs.getString(15));
				
				reviewList.add(dto);
				
				System.out.println("리뷰 목록 저장 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return reviewList;
	}
	
	public List<ReviewDTO> getReviewList(int startRow, int pageSize) {
		System.out.println("getReviewList(int startRow, int pageSize) 호출");
		
		List<ReviewDTO> reviewList = new ArrayList<>(); 
		
		try {
			con = getConnect();
			sql = "select * from review_boards order by review_num desc limit ?, 10";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow-1);
//			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
					ReviewDTO dto = new ReviewDTO();
					dto.setReview_num(rs.getInt(1));
					dto.setReview_writer_type(rs.getInt(2));
					dto.setMgr_num(rs.getInt(3));
					dto.setMem_num(rs.getInt(4));
					dto.setName(rs.getString(5));
					dto.setReview_password(rs.getInt(6));
					dto.setReview_subject(rs.getString(7));
					dto.setReview_content(rs.getString(8));
					dto.setReview_readcount(rs.getInt(9));
					dto.setReview_re_ref(rs.getInt(10));
					dto.setReview_re_lev(rs.getInt(11));
					dto.setReview_re_seq(rs.getInt(12));
					dto.setReview_date(rs.getTimestamp(13));
					dto.setReview_ip(rs.getString(14));
					dto.setReview_file(rs.getString(15));
					
					reviewList.add(dto);
			}
			System.out.println("한 페이지에 "+pageSize+"개 리뷰 목록 저장 완료");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return reviewList;
	
	}
	
	
	// 7-1. 매니저가 리뷰 수정하는 메서드   -----------------------------------------
	public ReviewDTO ReviewUpdate(ReviewDTO dto) {
		
		System.out.println("ReviewUpdate() 호출");
		try {
			con = getConnect();
			sql = "update review_boards set review_subject=?, review_content=?, "
					+ "review_file=? where review_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getReview_subject());
			pstmt.setString(2, dto.getReview_content());
			pstmt.setString(3, dto.getReview_file());
			pstmt.setInt(4, dto.getReview_num());
			
			pstmt.executeUpdate();
				
		} catch (Exception e ) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return dto;
	}
	// 7-2. 회원이 리뷰 수정하는 메서드 
	public ReviewDTO ReviewUpdate(ReviewDTO dto, int mem_num) {
		
		System.out.println("ReviewUpdate() 호출");
		try {
			con = getConnect();
			sql = "update review_boards set review_subject=?, review_content=?, "
					+ "review_file=? where review_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getReview_subject());
			pstmt.setString(2, dto.getReview_content());
			pstmt.setString(3, dto.getReview_file());
			pstmt.setInt(4, dto.getReview_num());
			
			pstmt.executeUpdate();
				
		} catch (Exception e ) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return dto;
	}
	
	
	
	// 8.  관리자용 리뷰 글 지우기 메서드 -----------------------------------------
	public void ReviewDelete(HttpSession session, int review_num, int mgr_num) {		
		
		try{
			con = getConnect();
			sql = "delete from review_boards where review_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			
			pstmt.executeUpdate();
			
			System.out.println("관리자용 글 삭제 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}		
	}

	// 회원용 리뷰글 삭제 메서드
	public void ReviewDelete(int review_num, int mem_num) {
		try {
			con = getConnect();
		
			// 사용자가 입력한 비밀번호와 DB의 비밀번호가 일치할 경우 삭제함.
			sql = "delete from review_boards where review_num = ? and review_password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, review_num);
			
			pstmt.executeUpdate();
			System.out.println("회원용 글 삭제 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
	
	
	
	
}

