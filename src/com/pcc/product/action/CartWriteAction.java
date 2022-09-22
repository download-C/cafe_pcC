package com.pcc.product.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.product.db.CartDAO;
import com.pcc.product.db.CartDTO;

import action.Action;
import vo.ActionForward;

public class CartWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("3. CartWriteAction");
		
		//한글 처리
		request.setCharacterEncoding("UTF-8");
		
		//전달정보 저장
		//CartDTO 객체 생성
		CartDTO dto = new CartDTO();
		
		//dto.setCart_num(Integer.parseInt(request.getParameter("cart_num")));
		dto.setProd_num(Integer.parseInt(request.getParameter("prod_num")));
		dto.setMem_num(Integer.parseInt(request.getParameter("mem_num")));
		dto.setRequirements(request.getParameter("requirements"));
		dto.setProd_count(Integer.parseInt(request.getParameter("prod_count")));
		dto.setTotal_price(Integer.parseInt(request.getParameter("total_price")));
		
		
		//DB에 정보 저장
		//ProductDAO 객체 생성
		CartDAO dao = new CartDAO();
		dao.cartWrite(dto);
		
		System.out.println("5. CartWriteAction 돌아옴");
		//dao.getMember(mem_num);
		
		
		
		// 출력 view 페이지로 이동
		
		
		ActionForward forward = new ActionForward();
		boolean skip_cart = false;
		
		//productContent.jsp 파일의 "담기"버튼을 눌렸을 때
		if(skip_cart == false){
			forward.setPath("./Cart.pr");
			forward.setRedirect(true);				
		}
		//productContent.jsp 파일의 "주문하기"버튼을 눌렸을 때
		else{
			forward.setPath("./OrderWrite.pr");
			forward.setRedirect(true);				
		}
		
		
		
		return forward;
	}

}
