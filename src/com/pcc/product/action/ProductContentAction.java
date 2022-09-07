package com.pcc.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.product.db.ProductDAO;
import com.pcc.product.db.ProductDTO;

import action.Action;
import vo.ActionForward;

public class ProductContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println(" M : ProductContentAction_execute() 호출 ");
		
		// 전달된 정보 저장(prod_num, page_num)
		// => 전달되는 파라메터값의 경우 
		//   테이블에 저장되는 값이면 형변환 O
		//   테이블에 저장안되는 값이면 형변환 X
		int prod_num = Integer.parseInt(request.getParameter("prod_num"));
		String page_num = request.getParameter("page_num");
		
		// ProductDAO 객체 생성
		ProductDAO dao = new ProductDAO();
		
		// 게시판 글 1개의 정보를 가져와서 출력
		ProductDTO dto = dao.getProduct(prod_num);
		
		// Model 객체 정보 출력 X
		//   view 에서 정보 출력O
		// => model 객체 있는 정보를 view 이동
		
		// request 영역에 저장
		request.setAttribute("dto", dto);
		//request.setAttribute("dto2", dao.getProduct(prod_num));
		request.setAttribute("page_num", page_num); //출력할때 사용

		
		// 출력 view 페이지로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./product/productContent.jsp");
		forward.setRedirect(false);		
		
		
		return forward;
	}

}
