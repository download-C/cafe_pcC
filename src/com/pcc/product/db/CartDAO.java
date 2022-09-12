package com.pcc.product.db;

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


// 카트 관련 모든 메서드를 생성하는 클래스

public class CartDAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public CartDAO () {
//		System.out.println("DAO : DB 연결을 위한 모든 정보 준비 완료");
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
//		System.out.println("DAO : DB 연결 해제");
	}

	
	
	// 3. 장바구니 생성 cartWrite()  -----------------------------------------
	
	public void cartWrite(CartDTO dto) {
		System.out.println("4. cartWrite DAO");
		int cart_num = 0;//카트 번호 저장
		
		//전달된 정보 저장(prod_num, mem_num)
		//=> 전달되는 파라미터값의 경우
		//   테이블에 저장되는 값이면 형변환 O
		//   테이블에 저장 안 되는 값이면 형변환 X
		
		
		try{
			//1. 드라이버 로드
			//2. 디비 연결
			con = getConnect();
			//3. sql 작성 & pstmt 객체
			//   카트 번호(cart_num) 계산 (생성된 마지막 번호 + 1)
			sql = "select max(cart_num) from carts";
			pstmt = con.prepareStatement(sql);
			//4. sql 실행
			rs = pstmt.executeQuery();//DB 값을 다 가져오겠다
			
			//5. 데이터 처리(글번호 계산 : 마지막 글번호 + 1)
			if(rs.next()){
				cart_num = rs.getInt("max(cart_num)")+1;
			}
			else{
				cart_num = 1;
			}
			
//			System.out.println(" DAO : 카트번호  cart_num : " + cart_num);
			
			//카트 데이터 입력
			//3. sql 작성 & pstmt 객체
			sql = "insert into carts(cart_num, prod_num, requirements, total_price)"
					+ " values(?,?,?,?);";
			
			pstmt = con.prepareStatement(sql);
			
			//???
			pstmt.setInt(1, cart_num);
			//pstmt.setInt(2,  dto.getMem_num());
			pstmt.setInt(2,  dto.getProd_num());
			pstmt.setString(3, dto.getRequirements());
			pstmt.setInt(4, dto.getTotal_price());
			
			//4. sql 실행
			pstmt.executeUpdate();//insert 구문은 Update 사용
			
//			System.out.println(" DAO : 카트 담기 완료");
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
	}

	
	// 4. 카트에 담는 상품 1개의 정보 조회 getProduct(int prod_num)  -----------------------------------------
	public CartDTO getProduct(int prod_num) {
		System.out.println(" 4. getProduct DAO");
		CartDTO dto = null;
		
		try{
			//1,2 디비연결
			con = getConnect();
			//3. sql 작성(select) & pstmt 객체
			sql = "select * from products where prod_num=?";
			pstmt = con.prepareStatement(sql);
			// ???
			pstmt.setInt(1, prod_num);
			
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			//5. 데이터 처리
			if(rs.next()){
				//DB에 특정 상품의 정보를 가져와서 저장
				
				//DB->DTO
				dto = new CartDTO();
				
				dto.setProd_num(rs.getInt("prod_num"));
			}
//			System.out.println(" DAO : " + prod_num + "번 상품 정보 가져옴");
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return dto;		

	}
	
	
	
	
	// 5. 카트에 담는 회원의 정보 가져오기(  -----------------------------------------
	public CartDTO getMember(int mem_num) {
		System.out.println("4. getMember DAO");
		CartDTO dto = null;
		
		try{
			//1,2 디비연결
			con = getConnect();
			//3. sql 작성(select) & pstmt 객체
			sql = "select * from members where mem_num=?";
			pstmt = con.prepareStatement(sql);
			// ???
			pstmt.setInt(1, mem_num);
			
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			//5. 데이터 처리
			if(rs.next()){
				//DB에 특정 상품의 정보를 가져와서 저장
				
				//DB->DTO
				dto = new CartDTO();
				
				dto.setMem_num(rs.getInt("mem_num"));
			}
//			System.out.println(" DAO : " + mem_num + "번 상품 정보 가져옴");
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return dto;		

	}

	
	
	
	
	// 6.  카트에 담긴 상품 목록 (all) - getCartList() -----------------------------------------
	
	public List<CartDTO> getCartList() {
		System.out.println("4. cartList DAO");
		
		//카트의 상품 모두를 저장하는 배열(가변길이)
		List<CartDTO> cartList = new ArrayList<CartDTO>();
		
		try{
			//1. 드라이버 로드
			//2. 디비 연결
			con = getConnect();
			//3. sql 작성 & pstmt 객체
			sql ="select * from carts";
//			sql_prod = "select c.prod_num, p.prod_name, p.prod_img, p.prod_real_img " +
//						"from products p join carts c on c.prod_num = p.prod_num;";
					
			pstmt = con.prepareStatement(sql);
			
			//4. sql 실행
			rs = pstmt.executeQuery();
			
			//5. 데이터 처리
			while(rs.next()){
				//데이터가 있을 때, true면 DB에 저장된 정보를 DTO에 저장 -> List저장

				//DB -> DTO로 저장
				CartDTO dto = new CartDTO();
				dto.setCart_num(rs.getInt("cart_num"));
				dto.setProd_num(rs.getInt("prod_num"));
				dto.setRequirements(rs.getString("requirements"));
				dto.setTotal_price(rs.getInt("total_price"));
				
				//DTO -> List
				cartList.add(dto);
				
				
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeDB();
		}
		return cartList;
	}
	
	
	
	// 7.   -----------------------------------------
	
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
	
	
	
	
}

