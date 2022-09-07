package com.pcc.reservation.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



// 예약 관련 모든 메서드를 생성하는 클래스

public class ReservationDAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ReservationDAO () {
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
	
	
	public int reservation(ReservationDTO dto) {
		int result = -1;
		
				try{
					con = getConnect();
			
	
	
	
	
	String res_date = dto.getRes_date();
	String res_hour = dto.getRes_hour();
	
	int res_num_of_persons = dto.getRes_num_of_persons();
	
	int month = Integer.parseInt(res_date.substring(5, 7));
	int day = Integer.parseInt(res_date.substring(8, 10));
	int hour = Integer.parseInt(res_hour);
	
	
	int table_total = 20;
	int table_occupied=  0;
	int table_possible = table_total - table_occupied;
	

	if((month>0 && month<13) && (day>0 && day<32) && (hour>0 && hour<10)){

		switch(hour) {
	      case 1:
	      	table_occupied = 5;
	      	
	      	if(res_num_of_persons < 5 && res_num_of_persons >0 ){
	    		if(table_possible > 0) {
	    		   	   System.out.println("예약가능");
	    		   	   sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	    			
					
	    		   	   pstmt = con.prepareStatement(sql);
					
	    		   	   pstmt.setInt(1, dto.getRes_num()+1);
	    		   	   pstmt.setInt(2, dto.getMem_num()+1);
	    		   	   pstmt.setString(3, dto.getRes_date());
	    		   	   pstmt.setString(4, dto.getRes_hour());
	    		   	   pstmt.setInt(5, dto.getRes_num_of_persons());
					
			
	    		   	   pstmt.executeUpdate();	
	    		
	    		   	   table_occupied += 1;
	    			   result = 1;
	    			}
	    			else {
	    		    	   System.out.println("예약이 불가능 합니다");
	    		               result = 2;
	    			}
	    		
	    	} 
	    	else if(res_num_of_persons > 4 && res_num_of_persons < 9){
	    		if(table_possible > 1) {
	    		   	   System.out.println("예약가능");
	    		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	    			
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, dto.getRes_num()+1);
					pstmt.setInt(2, dto.getMem_num()+1);
					pstmt.setString(3, dto.getRes_date());
					pstmt.setString(4, dto.getRes_hour());
					pstmt.setInt(5, dto.getRes_num_of_persons());
					
			
					pstmt.executeUpdate();	
	    		
					table_occupied += 1;	
	    		   	   result = 3;
	    			}
	    			else {
	    		    	   System.out.println("예약이 불가능 합니다");
	    		              	result = 4;
	    			}
	    	}
	    	else{
	    		System.out.println("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
	    	}
	    			result = 0;
	    			break;
	    			
	    			
	    		case 2:
	    		table_occupied = 5;
	    		
	    		if(res_num_of_persons < 5 && res_num_of_persons >0 ){
	        		if(table_possible > 0) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        			   result = 1;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		               result = 2;
	        			}
	        		
	        	} 
	        	else if(res_num_of_persons > 4 && res_num_of_persons < 9){
	        		if(table_possible > 1) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        		   	   result = 3;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		              	result = 4;
	        			}
	        	}
	        	else{
	        		System.out.println("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
	        	}
	        			result = 0;
	    				break;
	    		case 3:
	    		table_occupied = 9;
	    		if(res_num_of_persons < 5 && res_num_of_persons >0 ){
	        		if(table_possible > 0) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        			   result = 1;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		               result = 2;
	        			}
	        		
	        	} 
	        	else if(res_num_of_persons > 4 && res_num_of_persons < 9){
	        		if(table_possible > 1) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        		   	   result = 3;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		              	result = 4;
	        			}
	        	}
	        	else{
	        		System.out.println("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
	        	}
	        			result = 0;
	        			
	    				break;
	    				
	    	case 4:
			table_occupied = 7;
			if(res_num_of_persons < 5 && res_num_of_persons >0 ){
	    		if(table_possible > 0) {
	    		   	   System.out.println("예약가능");
	    		   	 sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	    			
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, dto.getRes_num()+1);
					pstmt.setInt(2, dto.getMem_num()+1);
					pstmt.setString(3, dto.getRes_date());
					pstmt.setString(4, dto.getRes_hour());
					pstmt.setInt(5, dto.getRes_num_of_persons());
					
			
					pstmt.executeUpdate();	
	    		
					table_occupied += 1;	
	    			   result = 1;
	    			}
	    			else {
	    		    	   System.out.println("예약이 불가능 합니다");
	    		               result = 2;
	    			}
	    		
	    	} 
	    	else if(res_num_of_persons > 4 && res_num_of_persons < 9){
	    		if(table_possible > 1) {
	    		   	   System.out.println("예약가능");
	    		   	   sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	    			
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, dto.getRes_num()+1);
					pstmt.setInt(2, dto.getMem_num()+1);
					pstmt.setString(3, dto.getRes_date());
					pstmt.setString(4, dto.getRes_hour());
					pstmt.setInt(5, dto.getRes_num_of_persons());
					
			
					pstmt.executeUpdate();	
	    		
					table_occupied += 1;
	    		   	   result = 3;
	    			}
	    			else {
	    		    	   System.out.println("예약이 불가능 합니다");
	    		              	result = 4;
	    			}
	    	}
	    	else{
	    		System.out.println("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
	    	}
	    			result = 0;
	    		
					break;
					
					
	    	case 5:
			table_occupied = 8;
			if(res_num_of_persons < 5 && res_num_of_persons >0 ){
	    		if(table_possible > 0) {
	    		   	   System.out.println("예약가능");
	    		   	   sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	    			
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, dto.getRes_num()+1);
					pstmt.setInt(2, dto.getMem_num()+1);
					pstmt.setString(3, dto.getRes_date());
					pstmt.setString(4, dto.getRes_hour());
					pstmt.setInt(5, dto.getRes_num_of_persons());
					
			
					pstmt.executeUpdate();	
	    		
					table_occupied += 1;
					
	    			   result = 1;
	    			   
	    			}
	    			else {
	    		    	   System.out.println("예약이 불가능 합니다");
	    		               result = 2;
	    			}
	    		
	    	} 
	    	else if(res_num_of_persons > 4 && res_num_of_persons < 9){
	    		if(table_possible > 1) {
	    		   	   System.out.println("예약가능");
	    		   	   sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	    			
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, dto.getRes_num()+1);
					pstmt.setInt(2, dto.getMem_num()+1);
					pstmt.setString(3, dto.getRes_date());
					pstmt.setString(4, dto.getRes_hour());
					pstmt.setInt(5, dto.getRes_num_of_persons());
					
			
					pstmt.executeUpdate();	
	    		
					table_occupied += 1;
	    		   	   result = 3;
	    			}
	    			else {
	    		    	   System.out.println("예약이 불가능 합니다");
	    		              	result = 4;
	    			}
	    	}
	    	else{
	    		System.out.println("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
	    	}
	    			result = 0;
	    			
					break;
					
					
	    	case 6:
			table_occupied = 15;
			if(res_num_of_persons < 5 && res_num_of_persons >0 ){
	    		if(table_possible > 0) {
	    		   	   System.out.println("예약가능");
	    		   	   sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	    			
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, dto.getRes_num()+1);
					pstmt.setInt(2, dto.getMem_num()+1);
					pstmt.setString(3, dto.getRes_date());
					pstmt.setString(4, dto.getRes_hour());
					pstmt.setInt(5, dto.getRes_num_of_persons());
					
			
					pstmt.executeUpdate();	
	    		
					table_occupied += 1;
	    			   result = 1;
	    			}
	    			else {
	    		    	   System.out.println("예약이 불가능 합니다");
	    		               result = 2;
	    			}
	    		
	    	} 
	    	else if(res_num_of_persons > 4 && res_num_of_persons < 9){
	    		if(table_possible > 1) {
	    		   	   System.out.println("예약가능");
	    		   	   sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	    			
					
					pstmt = con.prepareStatement(sql);
					
					pstmt.setInt(1, dto.getRes_num()+1);
					pstmt.setInt(2, dto.getMem_num()+1);
					pstmt.setString(3, dto.getRes_date());
					pstmt.setString(4, dto.getRes_hour());
					pstmt.setInt(5, dto.getRes_num_of_persons());
					
			
					pstmt.executeUpdate();	
	    		
					table_occupied += 1;
	    		   	   result = 3;
	    			}
	    			else {
	    		    	   System.out.println("예약이 불가능 합니다");
	    		              	result = 4;
	    			}
	    	}
	    	else{
	    		System.out.println("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
	    	}
	    			result = 0;
	    		
					break;
					
					
	    	case 7:
	    		table_occupied = 20;
	    		if(res_num_of_persons < 5 && res_num_of_persons >0 ){
	        		if(table_possible > 0) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        			   result = 1;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		               result = 2;
	        			}
	        		
	        	} 
	        	else if(res_num_of_persons > 4 && res_num_of_persons < 9){
	        		if(table_possible > 1) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        		   	   result = 3;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		              	result = 4;
	        			}
	        	}
	        	else{
	        		System.out.println("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
	        	}
	        			result = 0;
	        		
	    				break;
	    				
	    	case 8:
	    		table_occupied = 18;
	    		if(res_num_of_persons < 5 && res_num_of_persons >0 ){
	        		if(table_possible > 0) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        			   result = 1;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		               result = 2;
	        			}
	        		
	        	} 
	        	else if(res_num_of_persons > 4 && res_num_of_persons < 9){
	        		if(table_possible > 1) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        		   	   result = 3;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		              	result = 4;
	        			}
	        	}
	        	else{
	        		System.out.println("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
	        	}
	        			result = 0;
	        		
	    				break;
	    				
	    	case 9:
	    		table_occupied = 17;
	    		if(res_num_of_persons < 5 && res_num_of_persons >0 ){
	        		if(table_possible > 0) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        			   result = 1;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		               result = 2;
	        			}
	        		
	        	} 
	        	else if(res_num_of_persons > 4 && res_num_of_persons < 9){
	        		if(table_possible > 1) {
	        		   	   System.out.println("예약가능");
	        		   	sql = "insert into cafe_pcc values(?, ?, cast(? as DATE), cast(? as TIME), ?)";
	        			
	    				
	    				pstmt = con.prepareStatement(sql);
	    				
	    				pstmt.setInt(1, dto.getRes_num()+1);
	    				pstmt.setInt(2, dto.getMem_num()+1);
	    				pstmt.setString(3, dto.getRes_date());
	    				pstmt.setString(4, dto.getRes_hour());
	    				pstmt.setInt(5, dto.getRes_num_of_persons());
	    				
	    		
	    				pstmt.executeUpdate();	
	        		
	    				table_occupied += 1;
	        		   	   result = 3;
	        			}
	        			else {
	        		    	   System.out.println("예약이 불가능 합니다");
	        		              	result = 4;
	        			}
	        	}
	        	else{
	        		System.out.println("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
	        	}
	        			result = 0;
	    				
	    				break;
	    			
	    		
	    	}
	      	
		
	    }
					} catch(Exception e){
						e.printStackTrace();
					} finally{
						closeDB();
					}

		return result;

		
	}
	
}

	
	
	
	
	
	
	// 4.   -----------------------------------------
	
	
	
	
	// 5.   -----------------------------------------
	
	
	
	
	// 6.   -----------------------------------------
	
	
	
	
	// 7.   -----------------------------------------
	
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	


