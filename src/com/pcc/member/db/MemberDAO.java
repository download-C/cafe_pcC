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
	
	
	// 3.   -----------------------------------------
	
	// 마이페이지 리스트
	
	public MemberDTO memberList(MemberDTO dto){
		System.out.println("\n DAO : memberList(BoardDTO dto) 호출 ");
		
		try{
			//1.드라이버로드
			//2.디비 연결
			con = getConnect();
			//3. sql 작성 & pstmt 객체
			//  게시판 글번호(bno) 계산 (작성된 가장 마지막글번호 + 1)			
			sql = "select * from members";
			pstmt = con.prepareStatement(sql);
			//4. sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 데이터 처리
			if(rs.next()){
				dto.setMem_num(rs.getInt("mem_num"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setReg_date(rs.getTimestamp("regdate"));
				
				System.out.println(" DAO : 회원정보 저장 완료");
				System.out.println(" DAO : "+dto.toString());
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return dto;
	}
	
	
	
	// 4.   -----------------------------------------
	
	// 마이페이지 수정
	
	public int updateMember(MemberDTO dto){
		int result = -1;
		
		try {
			// 1.2 디비연결
			con = getConnect();
			
			// 3. sql & pstmt
			// 1) 수정하려는 정보와 회원, 본인 여부 체크
			// 2) 본인일때만, 정보수정
			sql = "select pw from members where mem_num = ?";
			pstmt = con.prepareStatement(sql);
			
			// ???
			pstmt.setInt(1, dto.getMem_num());
			
		    // 4. sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 데이터 처리
			 // 2) 본인일때만, 정보수정
			if(rs.next()){
				//회원
				if(dto.getPassword().equals(rs.getString("password"))){
					//회원, 비밀번호 동일=>본인
                    //회원, 비밀번호 동일=>본인
					
					// 3. sql (update) & pstmt
					// 특정 사용자의 정보(이름,나이,성별,이메일)을 수정
					sql="update members set password=? name=?  where id=?";
				    pstmt = con.prepareStatement(sql);
				    
				    // ????
				    pstmt.setString(1, dto.getPassword());
				    pstmt.setString(2, dto.getName());
				    pstmt.setInt(3, dto.getMem_num());
				    
					// 4. sql 실행
					pstmt.executeUpdate();
					
					result = 1;
					System.out.println("DAO : 정보 수정 완료!");
				}else{
					//회원, 비밀번호 오류
					result = 0;
				}
			}else{
				//비회원
				result = -1;
			}
			System.out.println(" DAO : 디비동작 처리 끝(수정처리)("+result+")");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}	
	

	// 5.   -----------------------------------------
	
	// 마이페이지 삭제
	
	public int deleteMember(MemberDTO dto){
		int result = -1;
		
		
		try {
			// 1.2. 디비연결
			con = getConnect();
			// 3. sql 생성 & pstmt 객체
			sql = "select * from members where mem_num=?";
			pstmt = con.prepareStatement(sql);
			// ???
			pstmt.setInt(1, dto.getMem_num());
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터처리	
			if(rs.next()){
				if(dto.getPassword().equals(rs.getString("password"))){
					// 본인
					// 3. sql(delete) & pstmt 객체
					sql = "delete from members where mem_num=?";
					pstmt = con.prepareStatement(sql);
					// ??? 
					pstmt.setInt(1, dto.getMem_num());
					// 4. sql 실행
					result = pstmt.executeUpdate();
					// result = 1;
				}else{
					// 비밀번호 오류
                    result = 0;
				}
			}else{
				// 비회원
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		return result;
	
	}
	
	
	// 6.   -----------------------------------------
	
	
	
	
	// 7.   -----------------------------------------
	
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
	
	
	
	
}

