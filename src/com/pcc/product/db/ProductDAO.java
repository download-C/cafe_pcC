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



// 제품 관련 모든 메서드를 생성하는 클래스

public class ProductDAO {

	private Connection con = null;
	private String sql ="";
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ProductDAO () {
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
	
	
	// 3. 상품등록 글쓰기 - productWrite()  -----------------------------------------
	public void productWrite(ProductDTO dto){
		System.out.println("\n DAO : productWrite(productDTO dto) 호출 ");
		int prod_num = 0;  //글번호 저장 
		
		try {
			//1.드라이버로드
			//2.디비 연결
			con = getConnect();
			//3. sql 작성 & pstmt 객체
			//  상품 번호(prod_num) 계산 (생성된 가장 마지막 상품번호 + 1)			
			sql = "select max(prod_num) from products";
			pstmt = con.prepareStatement(sql);
			//4. sql 실행
			rs = pstmt.executeQuery();//DB의 값을 다 가져오겠다
			
			// * 워크벤치 select 결과
			//  - 삼각형 커서가 있을경우  rs.next() == true
			//  - 원 커서가 있을 경우 rs.next() == false
			//  - 커서가 없을경우  rs.next() == false
			
			// 5. 데이터 처리 (글번호 계산:마지막글번호 + 1)
			if(rs.next()){//false -> 데이터 없음, true -> 데이터 있음
				// getInt() => 컬럼의 값을 리턴, 만약에 값이 sql-null경우 0 리턴
				//prod_num = rs.getInt()+1;
				prod_num = rs.getInt("max(prod_num)")+1;
			}
			else  {
				prod_num = 1;
			}
			
			System.out.println(" DAO : 상품번호 prod_num : " + prod_num);
			
			// 게시판 글 쓰기
			// 3. sql작성 & pstmt 객체
			sql = "insert into products values(?,?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			
			// ???
			pstmt.setInt(1, prod_num);
			pstmt.setString(2, dto.getProd_name());
			pstmt.setString(3, dto.getCategory());
			pstmt.setInt(4, dto.getPrice());
			
			// 4. SQL 실행
			pstmt.executeUpdate();//insert구문은 update사용
			
			System.out.println(" DAO : 글 작성 완료! ");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
	}
	// 3. 상품등록 글쓰기 - productWrite()  -----------------------------------------
	
	
	
	// 4. 상품 목록 조회(all) - getProductList()  -----------------------------------------
	public List<ProductDTO> getProductList(){
		
		// 글정보 모두를 저장하는 배열(가변길이)
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		try{
			//1. 드라이버로드
			//2. 디비 연결
			con = getConnect();
			// 3. sql 작성 & pstmt 객체
			sql = "select * from products";
			pstmt = con.prepareStatement(sql);
			
			// 4. sql 실행
			rs = pstmt.executeQuery();
						
			// 5. 데이터 처리
			while(rs.next()){
				//데이터가 있을 때, true면 DB에 저장된 정보를 DTO에 저장 -> List저장
				
				//DB -> DTO로 저장
				ProductDTO dto = new ProductDTO();
				dto.setProd_num(rs.getInt("prod_num"));
				dto.setProd_name(rs.getString("prod_name"));
				dto.setCategory(rs.getString("category"));
				dto.setPrice(rs.getInt("price"));
				
				//DTO -> List
				productList.add(dto);
				
			}//while문 종료
			
			System.out.println(" C : 상품 목록 모두 저장 완료");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			closeDB();
		}
		return productList;
	}
	
	// 4. 상품 목록 조회(all) - getProductList()  -----------------------------------------
	
	
	// 5. 상품 목록 조회 - 페이징 처리  -----------------------------------------
	
	
	
	
	// 6. 글 개수 조회(all) - getProductCount()  -----------------------------------------
	public int getProductCount(){
		System.out.println("\n DAO : getProductCount() 실행");
		int cnt = 0;
		
		try {
			// 1.2. 디비 연결 (커넥션풀)
			con = getConnect();
			// 3. sql 작성(select) & pstmt 객체 
			sql = "select count(*) from products";
			pstmt = con.prepareStatement(sql);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			// 5. 데이터 처리
			if(rs.next()){
				// 데이터 있을때
				//cnt = rs.getInt("count(*)");
				cnt = rs.getInt(1); // 1번 인덱스
			}
			
			System.out.println(" DAO : 글 개수 - 총 : "+cnt+"개");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return cnt;
	}	
	// 6. 글 개수 조회(all) - getProductCount()  -----------------------------------------


	
	// 7. 특정 상품 1개의 정보 조회 getProduct(prod_num) -----------------------------------------
	public ProductDTO getProduct(int prod_num) {
		System.out.println(" DAO : getProduct(prod_num) 호출 ");
		ProductDTO dto = null;
	
		try {
			// 1.2. 디비연결
			con = getConnect();
			// 3. sql작성(select) & pstmt 객체
			sql = "select * from products where prod_num=?";
			pstmt = con.prepareStatement(sql);
			// ???
			pstmt.setInt(1, prod_num);
			
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			// 5. 데이터 처리
			if(rs.next()){
				// DB에 특정 번호의 글번호를 저장

				// DB -> DTO
				dto = new ProductDTO();
				
				dto.setProd_num(rs.getInt("prod_num"));
				dto.setProd_name(rs.getString("prod_name"));
				dto.setCategory(rs.getString("category"));
				dto.setPrice(rs.getInt("price"));
				
			}//if
			
			System.out.println(" DAO : "+prod_num+"번 상품 상세페이지 정보 저장 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}
		
		return dto;		
		
	}
	// 7. 특정 상품 1개의 정보 조회 getProduct(prod_num) -----------------------------------------
	
	
	
	
	// 8.   -----------------------------------------
	
	
	
	
	// 9.   -----------------------------------------
	
	
	
	
	// 10.   -----------------------------------------
	
	
	
	
	
	
	
}

