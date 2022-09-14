package com.pcc.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// 회원 관련 모든 메서드를 생성하는 클래스

public class MemberDAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public MemberDAO () {
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
			
			sql = "insert into members(mem_num, phone, password, name, reg_date)"
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
		
		// 4. DB에서 phone과 password 정보를 불러오는 메서드 -------
		public MemberDTO getMember(String phone, String password) {
			System.out.println("4. getMember(p,p) DAO");
			MemberDTO dto = new MemberDTO();
			dto.setPhone(phone);
			dto.setPassword(password);
			
			
			return dto;
		}
		
		// 4-1. DB에서 phone 정보를 불러오는 메서드 -------
				public MemberDTO getPhoneCheck(String phone) {
					System.out.println("4.  getPhoneCheck DAO");
					MemberDTO dto = new MemberDTO();
					dto.setPhone(phone);
					
					
					return dto;
				}
				
	
		
		// 5.  아이디 중복 체크 IdCheck()---------------------
		
		
		
		
		
		
		// 6. 로그인을 위한 아이디와 비밀번호 일치 여부 확인loginMember() ----------
		public int loginMember(MemberDTO dto) {
			System.out.println("4. loginMember DAO");
			int result = -1;
			
			try {
				con = getConnect();
				sql = "select password from members where phone=?";
				pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, dto.getPhone());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(dto.getPassword().equals(rs.getString("password"))){
						System.out.println(" 로그인 성공");
						result = 1;
					} else {
						System.out.println(" 비밀번호 오류");
						result = -1;
					}
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

		
		

	 
		


	
	
	
	// 6.   -----------------------------------------
	
	
	
	
	// 7.   -----------------------------------------
	
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
	
	
	
	
}

