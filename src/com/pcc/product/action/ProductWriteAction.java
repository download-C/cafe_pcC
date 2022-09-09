package com.pcc.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.product.db.ProductDAO;
import com.pcc.product.db.ProductDTO;
import action.Action;
import vo.ActionForward;

public class ProductWriteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println(" M : ProductWriteAction_execute() 호출 ");
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// 전달정보 저장(상품 번호, 상품명, 카테고리, 가격)
		// ProductDTO 객체 생성
		ProductDTO dto = new ProductDTO();
		//dto.setProd_num(Integer.parseInt(request.getParameter("prod_num")));
		dto.setProd_name(request.getParameter("prod_name"));
		dto.setCategory(request.getParameter("category"));
		dto.setPrice(Integer.parseInt(request.getParameter("price")));
		
		
		System.out.println(" M : "+dto);
		
		// DB에 정보 저장
		// ProductDAO 객체 생성
		ProductDAO dao = new ProductDAO();
		
		// DB에 글정보를 저장
		dao.productWrite(dto);
		
		//페이지 이동정보 저장(리턴)
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("./ProductList.pr");
		forward.setRedirect(true);
		//true -> sendRedirect() : 주소와 화면 모두 바뀜 ->이걸로 넘어가기!
		//false -> 디스패치방식 forward() : 주소는 바뀌지 않고 화면만 바뀜
		
		
		return forward;
	}
}
