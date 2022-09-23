package com.pcc.product.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.product.db.CartDAO;
import com.pcc.product.db.CartDTO;

import action.Action;
import vo.ActionForward;

public class CartDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("3. CartDeleteAction");
		//==================================================
		

		//한글 처리
		request.setCharacterEncoding("UTF-8");
		
		System.out.println(request.getParameter("cart_num"));
	
		//장바구니에서 삭제된 상품의 cart_num -> delete 작업
		//CartDAO 객체 생성
		CartDAO cart_dao = new CartDAO();
		
		int cart_num = Integer.parseInt(request.getParameter("cart_num"));
		
		cart_dao.deleteCart(cart_num);
		
		System.out.println("5. CartDeleteAction 돌아옴");
//		System.out.println("==============================");
//		System.out.println();
        
//        response.setContentType("text/html; charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.println("<script>");
//        out.println("opener.location.reload()");
//        out.println("window.close();");
//        out.println("</script>");
		ActionForward forward = new ActionForward();
		forward.setPath("Cart.pr");
		forward.setRedirect(true);
		
		return forward;
	}

}
