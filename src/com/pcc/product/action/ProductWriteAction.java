package com.pcc.product.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pcc.product.db.ProductDAO;
import com.pcc.product.db.ProductDTO;
import action.Action;
import vo.ActionForward;

public class ProductWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("3. ProductWriteAction");
//		System.out.println(" M : ProductWriteAction_execute() 호출 ");
		// 한글처리
		//request.setCharacterEncoding("UTF-8");
		// 전달정보 저장(상품 번호, 상품명, 카테고리, 가격)
		// ProductDTO 객체 생성
		//ProductDTO dto = new ProductDTO();
		//dto.setProd_num(Integer.parseInt(request.getParameter("prod_num")));
		//dto.setProd_name(request.getParameter("prod_name"));
		//dto.setCategory(request.getParameter("category"));
		//dto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		
		//System.out.println(" M : "+dto);
		
		// DB에 정보 저장
		// ProductDAO 객체 생성
		//ProductDAO dao = new ProductDAO();
		
		// DB에 글정보를 저장
		//dao.productWrite(dto);
		
		//페이지 이동정보 저장(리턴)
		//-----------------------------------
		//비즈니스 로직(데이터베이스 처리)을 위한 데이터 준비 작업 수행
		//=>글쓰기 폼에서 작성 후 글쓰기 버튼 클릭 시 현재 Action 객체로 이동
		//=>폼 파라미터 가져와서 준비 작업 수행(= 게시물 정보 저장)
		
		//파일 업로드 처리를 위해 MultipartRequest 객체 활용(cos.jar 파일 필요)
		//1. 파일 업로드 위치(이클립스 프로젝트 상의 경로) 저장
		String uploadPath = "img/product";;
		
		//2. 파일 크기 지정(10MB 제한)
		int fileSize = 1024 * 1024 * 10;
		
		//3. 현재 프로젝트(서블릿)를 처리하는 객체인 서블릿 컨텍스트 객체
		ServletContext context = request.getServletContext();
		
		//4. 업로드 파일이 저장되는 실제 경로를 얻어오기
		//=>ServletContext 객체의 getRealPath() 메서드 호출
		//가상의 업로드 폴더명을 파라미터로 전달
		String realPath = context.getRealPath(uploadPath);
//		System.out.println(realPath);
		//
		//실제 업로드 될 폴더 위치
		
		//5. MultipartRequest 객체 생성
		//=> 생성자 파라미터로 파일 업로드에 필요한 각종 파라미터를 전달
		MultipartRequest multi = new MultipartRequest(
				request, //1)실제 요청 정보가 포함된 request 객체
				realPath,//2)실제 업로드 폴더 경로
				fileSize,//3)업로드 파일 크기
				"UTF-8",  //4)파일명에 대한 인코딩 방식
				new DefaultFileRenamePolicy() 
				//5)중복 파일명에 대한 처리를 담당하는 객체(파일명 뒤에 1부터 붙임)
		);
		//객체 생성되는 시점에 업로드 파일은 실제 폴더에 업로드 
		//--------------------------
		//6. MultipartRequest 객체의 getParameter()메서드를 호출하여
		//   폼 파라미터 데이터 가져와서 ProductDTO 객체에 저장
				
		ProductDTO dto = new ProductDTO();
		dto.setProd_name(multi.getParameter("prod_name"));
		dto.setCategory(multi.getParameter("category"));
		dto.setPrice(Integer.parseInt(multi.getParameter("price")));
		dto.setProd_img(multi.getOriginalFileName("prod_img"));//원본 파일명
		dto.setProd_real_img(multi.getFilesystemName("prod_img"));//실제 업로드 파일명
		
//		System.out.println(" M : "+dto);
				
		// DB에 정보 저장
		// ProductDAO 객체 생성
		ProductDAO dao = new ProductDAO();
				
		// DB에 글정보를 저장
		dao.productWrite(dto);
				
		
		System.out.println("5. productWriteAction 돌아옴");
		//페이지 이동정보 저장(리턴)
		ActionForward forward = new ActionForward();
		forward.setPath("./ProductList.pr");
		forward.setRedirect(true);
		//true -> sendRedirect() : 주소와 화면 모두 바뀜 ->이걸로 넘어가기!
		//false -> 디스패치방식 forward() : 주소는 바뀌지 않고 화면만 바뀜
		
		
		return forward;
	}
}
