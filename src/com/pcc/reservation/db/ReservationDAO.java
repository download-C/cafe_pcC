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

import com.pcc.reservation.db.ReservationDTO;

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
		int result = -1;

		int res_num = 0;
		int table_occupied = 0;
		try {
			con = getConnect();

			int res_num_of_persons = dto.getRes_num_of_persons();
			String res_date = dto.getRes_date();
			String res_time = dto.getRes_hour();

			int month = Integer.parseInt(res_date.substring(5, 7));
			int day = Integer.parseInt(res_date.substring(8, 10));
			int hour = Integer.parseInt(res_time.substring(0, 2));

			int table_total = 20;
			int table_possible = (table_total - 5) - table_occupied;

			if ((month > 0 && month < 13) && (day > 0 && day < 32) && (hour > 12 && hour < 22)) {

				sql = "select max(res_num), max(table_occupied) from reservations";
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();

				if (rs.next()) {

					res_num = rs.getInt(1) + 1;
					table_occupied = rs.getInt(2) + 1;
				}

				for (int i = hour; i < hour + 1; i++) {
					if (res_num_of_persons < 5 && res_num_of_persons > 0 && table_possible > 0) {

						System.out.println("예약가능");
						sql = "insert into reservations values(?, ?, cast(? as DATE), cast(? as TIME), ?, ?, ?)";

						pstmt = con.prepareStatement(sql);

						pstmt.setInt(1, res_num);
						pstmt.setInt(2, dto.getMem_num());
						pstmt.setString(3, dto.getRes_date());
						pstmt.setString(4, dto.getRes_hour());
						pstmt.setInt(5, dto.getRes_num_of_persons());
						pstmt.setInt(6, dto.getTable_total());
						pstmt.setInt(7, table_occupied);

						pstmt.executeUpdate();

						result = 1;
					} else if (res_num_of_persons > 4 && res_num_of_persons < 9 && table_possible > 1) {
						System.out.println("예약가능");
						sql = "insert into reservations values(?, ?, cast(? as DATE), cast(? as TIME), ?, ?, ?)";

						pstmt = con.prepareStatement(sql);

						pstmt.setInt(1, res_num);
						pstmt.setInt(2, dto.getMem_num());
						pstmt.setString(3, dto.getRes_date());
						pstmt.setString(4, dto.getRes_hour());
						pstmt.setInt(5, dto.getRes_num_of_persons());
						pstmt.setInt(6, dto.getTable_total());
						pstmt.setInt(7, table_occupied);

						pstmt.executeUpdate();

						result = 2;

					}

					else {
						System.out.println("예약이 불가능 합니다.");

						result = 3;
					}

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
				dto.setRes_date(rs.getString(3));
				dto.setRes_hour(rs.getString(4));
				dto.setRes_num_of_persons(rs.getInt(5));
				dto.setTable_total(rs.getInt(6));
				dto.setTable_occupied(rs.getInt(7));
				
				reservationList.add(dto);
				
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			closeDB();
		}
		 
		
		
		return reservationList;
		
	}
	
	public List<ReservationDTO> memberReservationList(){
		int res_num = 0;
		
		List<ReservationDTO> memberReservationList = new ArrayList<ReservationDTO>();
		
		
		try{
		con = getConnect();
		
		sql = "select res_num, mem_num, res_date, res_hour, res_num_of_persons from reservations where mem_num = ? ";  
		pstmt = con.prepareStatement(sql);
		
		ReservationDTO dto = new ReservationDTO();
		
		pstmt.setInt(1, dto.getMem_num());
		
		rs = pstmt.executeQuery();	
		
			
			while(rs.next()){
				
				
				dto.setRes_num(rs.getInt(1));
				dto.setMem_num(rs.getInt(2));
				dto.setRes_date(rs.getString(3));
				dto.setRes_hour(rs.getString(4));
				dto.setRes_num_of_persons(rs.getInt(5));
			
				
				memberReservationList.add(dto);
				
			}
					
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			closeDB();
		}
		
		
		
		
		
		return memberReservationList;
	}

}

// 4. -----------------------------------------

// 5. -----------------------------------------

// 6. -----------------------------------------

// 7. -----------------------------------------

// 8. -----------------------------------------

// 9. -----------------------------------------

// 10. -----------------------------------------
