package com.pcc.reservation.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.pcc.member.db.MemberDAO;
import com.pcc.reservation.db.ReservationDTO;
import com.sun.xml.internal.txw2.Document;

// 예약 관련 모든 메서드를 생성하는 클래스

public class ReservationDAO {

	private Connection con = null;
	private String sql = "";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public ReservationDAO() {
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
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
			System.out.println("DAO : DB 자원(rs, pstmt, con) 해제 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("DAO : DB 연결 해제");
	}

	// 3. -----------------------------------------

	public int reservation(ReservationDTO dto) throws Exception {
		
		int result = -1;  // 1: 예약 가능, 0: 오전 예약 가득 참, -1: 오후 예약 가득 참 
		int res_num = 0;
		int res_table = 0;
		
		try {
			con = getConnect();
			
			// 예약 시간이 오전(10시~13시)일 때
			if(dto.getRes_time() < 13) {
				// 특정 날의 오전 예약 개수 구하기
				sql = "select sum(res_table) from reservations where res_date = ? and res_time between 10 and 13";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setDate(1, dto.getRes_date());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){					
					// 예약된 테이블 총 개수가 15개 이하일 때 예약 가능
					if(rs.getInt("count(res_num)") < 15) {
						res_num = rs.getInt("res_num") + 1;
					} else {result = 0;}
					
					sql = "insert into reservations (res_num, mem_num, name, res_date, "
							+ "res_time, res_persons, res_table values(?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, res_num);
					pstmt.setInt(2, dto.getMem_num());
					pstmt.setString(3, dto.getName());
					pstmt.setDate(4, dto.getRes_date());
					pstmt.setInt(5, dto.getRes_time());
					pstmt.setInt(6, dto.getRes_persons());
						res_table = (dto.getRes_persons()/4) +(dto.getRes_persons()%4==0?0:1);
					pstmt.setInt(6, res_table);
					
					pstmt.executeUpdate();
					result = 1;
				} 

			// 예약 시간이 오후(13시~17시)일 때
			} else if(dto.getRes_time() >17) {
				sql = "select sum(table) from reservations where res_date = ? and res_time between 13 and 17";
				
				pstmt = con.prepareStatement(sql);
				
				pstmt.setDate(1, dto.getRes_date());
				
				rs = pstmt.executeQuery();
				
				if(rs.next()){					
					// 예약된 테이블 총 개수가 15개 이하일 때 예약 가능
					if(rs.getInt("count(res_num)") < 15) {
						res_num = rs.getInt("res_num") + 1;
					} else {result = -1;}
					
					sql = "insert into reservations (res_num, mem_num, name, res_date, "
							+ "res_time, res_persons, res_table values(?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, res_num);
					pstmt.setInt(2, dto.getMem_num());
					pstmt.setString(3, dto.getName());
					pstmt.setDate(4, dto.getRes_date());
					pstmt.setInt(5, dto.getRes_time());
					pstmt.setInt(6, dto.getRes_persons());
						res_table = (dto.getRes_persons()/4) +(dto.getRes_persons()%4==0?0:1);
					pstmt.setInt(6, res_table);
					
					pstmt.executeUpdate();
					
					result = 1;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		return result;
	}

	
	
	public List<ReservationDTO> reservationList() {
		List<ReservationDTO> reservationList = new ArrayList<ReservationDTO>();
		
		try{
			con = getConnect();
			
			sql = "select* from reservations";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				ReservationDTO dto = new ReservationDTO();
				
				
				dto.setRes_num(rs.getInt(1));
				dto.setMem_num(rs.getInt(2));
				dto.setRes_date(rs.getDate(3));
				dto.setRes_persons(rs.getInt(4));

				reservationList.add(dto);
				
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			closeDB();
		}
		 
		
		
		return reservationList;
		
	}
	
	public List<ReservationDTO> reservationList(int startRow, int pageSize) {
		List<ReservationDTO> reservationList = new ArrayList<ReservationDTO>();
		
		try{
			con = getConnect();
			
			sql = "select * from reservations where res_date > 2022-09-19 and res_date < 2022-09-25 limit ?, ?";   
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, startRow - 1);
			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				ReservationDTO dto = new ReservationDTO();
				
				
				dto.setRes_num(rs.getInt(1));
				dto.setMem_num(rs.getInt(2));
				dto.setRes_date(rs.getDate(3));
				dto.setRes_persons(rs.getInt(4));
				
				reservationList.add(dto);
				
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			closeDB();
		}
		 
		
		
		return reservationList;
		
	}
	
	
	
	
	public List<ReservationDTO> memberReservationList(int mem_num){
		int res_num = 0;
		
		List<ReservationDTO> memberReservationList = new ArrayList<ReservationDTO>();
		
		try{
		con = getConnect();
		
		sql = "select res_num, mem_num, res_date, res_num_of_persons from reservations where mem_num = ? ";  
		pstmt = con.prepareStatement(sql);
		
//		ReservationDTO dto = new ReservationDTO();
		
		pstmt.setInt(1, mem_num);
		
		rs = pstmt.executeQuery();	
		
			
			while(rs.next()){
				ReservationDTO dto = new ReservationDTO();
				
				res_num = res_num + 1;
				dto.setRes_num(res_num);
				dto.setMem_num(rs.getInt(2));
				dto.setRes_date(rs.getDate(3));
				dto.setRes_persons(rs.getInt(4));
				System.out.println("dto: "+dto);
				
				memberReservationList.add(dto);
			}
					
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			closeDB();
		}

		return memberReservationList;
	}
	
	public List<ReservationDTO> memberreservationList(int mem_num, int startRow, int pageSize) {
		List<ReservationDTO> memberreservationList = new ArrayList<ReservationDTO>();
		
		try{
			con = getConnect();
			
			sql = "select * from reservations where mem_num = ? and res_date > 2022-09-19 and res_date < 2022-09-25 limit ?, ?";   
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mem_num);
			pstmt.setInt(2, startRow - 1);
			pstmt.setInt(3, pageSize);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				
				ReservationDTO dto = new ReservationDTO();

				dto.setRes_num(rs.getInt(1));
				dto.setMem_num(rs.getInt(2));
				dto.setRes_date(rs.getDate(3));
				dto.setRes_persons(rs.getInt(4));
				
				memberreservationList.add(dto);
			}
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			closeDB();
		}
		return memberreservationList;	
	}
	
	// 예약
	public int getReservationCount(){
		int cnt=0;
		
		// 1.2. 디비 연결(커넥션 풀)
		try{
			con = getConnect();
			// 3. sql 작성(select) & pstmt 객체
			sql = "select count(*) from reservations";
			pstmt = con.prepareStatement(sql);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 데이터 처리
			if(rs.next()){
				//  데이터 있을때
				 cnt = rs.getInt(1);
				//cnt = rs.getInt(1); // 1번 인덱스
			}
//			
			System.out.println(" DAO : 예약 개수 - 총 : "+cnt+"개");
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			closeDB();
		}

		return cnt;
	}

}
