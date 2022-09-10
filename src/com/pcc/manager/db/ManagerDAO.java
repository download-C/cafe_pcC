package com.pcc.manager.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ManagerDAO {
	
	// 매니저 관련 모든 메서드를 생성하는 클래스

		private Connection con = null;
		private String sql ="";
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		public ManagerDAO () {
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
		
		// 3. 매니저의 정보를 DB에서 가져오는 메서드
		public ManagerDTO getManager(String mgr_id, String mgr_password) {
			ManagerDTO dto = new ManagerDTO();
			dto.setMgr_id(mgr_id);
			dto.setMgr_password(mgr_password);
			
			return dto;
		}
		
		// 4. 매니저 로그인하는 메서드
		public int loginManager(ManagerDTO dto) {
			int result = -1;
			
			try {
				con = getConnect();
				sql = "select mgr_password from managers where mgr_id = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getMgr_password());
				rs = pstmt.executeQuery();
				if(rs.next()) {
					if(dto.getMgr_password().equals(rs.getString("mgr_password"))) {
						System.out.println("매니저 로그인 성공");
						result = 1;
					} else {
						System.out.println("비밀번호 오류");
						result = -1;
					}
				} else {
					System.out.println("아이디 오류");
					result = 0;
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				closeDB();
			}
			return result;
		}
		

}
