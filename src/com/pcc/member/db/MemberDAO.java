package com.pcc.member.db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.pcc.board.review.db.ReviewDTO;

// 회원 관련 모든 메서드를 생성하는 클래스

public class MemberDAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDAO () {
		System.out.println("DAO : DB 연결을 위한 모든 정보 준비 완료");
	}
	
	// 0. alert창 띄우는 메서드 
	public void alert(HttpServletResponse response, String msg, String path) {
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println("<script>");
			out.println("alert('"+msg+"');");
			out.println(path);
			out.println("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeDB();
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
	
	
	// 3.  회원가입 메서드 JoinMember(MemberDTO dto)----------------
		public void JoinMember(MemberDTO dto){
			System.out.println("4. JoinMember DAO");
			int mem_num=0;
			
			try {
			con=getConnect();
			sql = "select max(mem_num) from members";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				mem_num = rs.getInt(1)+1;
			}	
			System.out.println(" DAO : 회원번호? "+mem_num);
			
			sql = "insert into members(mem_num, phone, password, name, regdate)"
					+ "values(?,?,?,?,now())";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, mem_num);
			pstmt.setString(2, dto.getPhone());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getName());
			
			pstmt.executeUpdate();
			System.out.println(" DAO : 회원가입 성공! ");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeDB();
			}
			
		}
		
		// 4-2. DB에서 mem_num으로 회원 정보 불러오는 메서드 -------
		public String getName(int mem_num) {
			System.out.println("4. getMember(p,p) DAO");
			String name = "";
			MemberDTO dto = new MemberDTO();
			
			dto.setMem_num(mem_num);
						
			try {
				con=getConnect();
				sql = "select * from members where mem_num=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, mem_num);
				rs = pstmt.executeQuery();
				
				if(rs.next()){

					name = rs.getString("name");

					System.out.println("rs dto:"+dto);
					return name;
				}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return name;
		}
		
		public MemberDTO getMember(String phone, String password) {
			System.out.println("4. getMember(p,p) DAO");
			MemberDTO dto = new MemberDTO();
			dto.setPhone(phone);
			dto.setPassword(password);
						
			try {
				con=getConnect();
				sql = "select * from members where phone=?";
				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, phone);
				rs = pstmt.executeQuery();
				
				if(rs.next()){
										
					dto.setMem_num(rs.getInt("mem_num"));
					dto.setName(rs.getString("name"));
					dto.setReg_date(rs.getTimestamp("regdate"));
					
					System.out.println("rs dto:"+dto);
					
					return dto;
				}
			
			}catch(Exception e){
				e.printStackTrace();
			}
			return dto;
		}
		

		
		// 5.  아이디 중복 체크 IdCheck()---------------------
		
		public boolean IdCheck(String phone) {
			System.out.println("4. IdCheck DAO");
			boolean result = false;
			
			try {
				con = getConnect();
				sql = "select * from members where phone=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, phone);
				rs = pstmt.executeQuery();
				System.out.println("phone: "+phone);
				
				if(rs.next()) {
					
					if(phone.equals(rs.getString("phone"))){
						System.out.println("이미 사용중인 아이디입니다.");
						result= false;
					} else {
						System.out.println("사용 가능한 아이디입니다.");
						result= true;
					}
				} else result = true;
				
				System.out.println(" DAO : 로그인 체크 완료("+result+")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}

		// 6. 로그인을 위한 아이디와 비밀번호 일치 여부 확인loginMember() ----------
		public int loginMember(String phone, String password) {
			System.out.println("4. loginMember DAO");
			int result = -1;
			System.out.println(password);
			try {
				con = getConnect();
				sql = "select password from members where phone=?";
				pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, phone);
//				System.out.println("phone:"+phone);
				rs = pstmt.executeQuery();
				
				//휴대폰 번호가 DB에 있을 때 
				if(rs.next()) {
					// 비밀번호가 DB에 있을 때
					if(password.equals(rs.getString("password"))){
						System.out.println(" 로그인 성공");
						result = 1;
					// 비밀번호가 DB랑 일치하지 않을 때
					} else {
						System.out.println(" 비밀번호 오류");
						result = -1;
					}
				// 휴대폰 번호가 DB에 없을 때
				} else {
					System.out.println(" 아이디 오류");
					result = 0;
				}
				System.out.println(" DAO : 로그인 체크 완료("+result+")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}

	
	// 7.  리뷰 글 수정 메서드 -----------------------------------------
		public int ReviewUpdate(ReviewDTO dto, int review_num) {
			int result = -1;

			System.out.println("ReviewUpdate() 호출");
			
			System.out.println("dto: "+dto+"=======================");
			
			try {
				con = getConnect();
				
				sql = "update review_boards "
						+ "set review_subject=?, review_content=?, "
						+ "review_file=? where review_num = ?";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setString(1,dto.getReview_subject());
				pstmt.setString(2, dto.getReview_content());
				pstmt.setString(3, dto.getReview_file());
				pstmt.setInt(4, review_num);
				System.out.println("review_num: "+dto.getReview_num());
				System.out.println("dto: "+dto);
				
				pstmt.executeUpdate();
				
				System.out.println("DB에 리뷰 업데이트 완료");
				
				result = 1;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return result;
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
		}
	
	
	
}

