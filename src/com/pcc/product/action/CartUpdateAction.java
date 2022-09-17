package com.pcc.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.product.db.CartDAO;
import com.pcc.product.db.CartDTO;

import action.Action;
import vo.ActionForward;

public class CartUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("3. CartUpdateAction");

		//==================================================
		

		//한글 처리
		request.setCharacterEncoding("UTF-8");
		
	
		//장바구니에서 변경된 prod_count, total_price -> update
		//CartDAO 객체 생성
		CartDTO cart_dto = new CartDTO();
		CartDAO cart_dao = new CartDAO();
		
		cart_dto.setCart_num(Integer.parseInt(request.getParameter("cart_num")));
		cart_dto.setProd_count(Integer.parseInt(request.getParameter("prod_count")));
		cart_dto.setTotal_price(Integer.parseInt(request.getParameter("total_price")));
		
		
		cart_dao.updateCart(cart_dto);
		
		
				
		return null;
	}

}
