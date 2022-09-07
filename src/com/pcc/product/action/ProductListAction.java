package com.pcc.product.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.product.db.ProductDAO;
import com.pcc.product.db.ProductDTO;

import action.Action;
import vo.ActionForward;

public class ProductListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		//ProductDAO 객체 생성
		ProductDAO dao = new ProductDAO();
		
		//상품 목록에 게시되어 있는 전체 상품 개수
		 //cnt = dao.getProductList();
		
		//페이징 처리(X)
		
		//dao 메서드 중에서 게시판 글 정보를 모두 가져오는 메서드 호출
		List<ProductDTO> productList = dao.getProductList(); //페이징 X
		
		//view 페이지 정보 전달을 위해서 request 영역에 저장
		request.setAttribute("productList", productList);
		
		System.out.println(" M : 리스트 정보 저장 request 영역");
		
		//화면에 출력
		//페이지 이동(화면 전환)
		ActionForward forward = new ActionForward();
		forward.setPath("./product/productList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}
}
