package com.pcc.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.product.db.CartDAO;
import com.pcc.product.db.CartDTO;
import com.pcc.product.db.OrderDAO;
import com.pcc.product.db.OrderDTO;

import action.Action;
import vo.ActionForward;

public class OrderWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("3. OrderWriteAction");
		
		//한글 처리
		request.setCharacterEncoding("UTF-8");
		
		
		//==================================================

		
		//전달정보 저장
		//OrderDTO 객체 생성
		OrderDTO order_dto = new OrderDTO();
		
		//cart_num, order_price 만 넘겨받기
		//dto.setCart_num(Integer.parseInt(request.getParameter("cart_num")));
		order_dto.setOrder_price(Integer.parseInt(request.getParameter("order_price")));
		//System.out.println(order_dto.getOrder_price());


		
		//==================================================
		
		CartDTO cart_dto = new CartDTO();
		CartDAO cart_dao = new CartDAO();
		//dao 메서드 중에서 카트에 담긴 상품을 모두 가져오는 메서드 호출
		List<CartDTO> cartList = cart_dao.getCartList();
		

		//VIEW 페이지 정보 전달을 위해서 request 영역에 저장
		request.setAttribute("cartList", cartList);
		request.setAttribute("order", order_dto.getOrder_price());

		
		//==================================================

		
		
		System.out.println("5. OrderWriteAction 돌아옴");
		ActionForward forward = new ActionForward();
		forward.setPath("./product/order.jsp");
		forward.setRedirect(false);
		//왜 디스패쳐에서 값이 뜨는 가........
		
		return forward;
	}

}
