package com.pcc.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.product.db.CartDAO;
import com.pcc.product.db.CartDTO;
import com.pcc.product.db.OrderDAO;
import com.pcc.product.db.OrderDTO;

import action.Action;
import vo.ActionForward;

public class OrderAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("3. OrderAction");

		//한글 처리
		request.setCharacterEncoding("UTF-8");

		//==================================================

		
		//전달정보 저장(order_price, pickup_time)
		//OrderDTO 객체 생성
		OrderDTO order_dto = new OrderDTO();
		
		order_dto.setOrder_price(Integer.parseInt(request.getParameter("order_price")));
		order_dto.setPickup_time(Integer.parseInt(request.getParameter("pickup_time")));
		
		OrderDAO order_dao = new OrderDAO();
		order_dao.orderWrite(order_dto);
		
		
		//System.out.println(order_dto.getOrder_price());

		
		//==================================================

		//전달 정보 저장(checked) update
		
		CartDTO cart_dto = new CartDTO();
		//데이터가 null값인 것들만 select 해와서 checked를 update하기

		//CartDAO 객체 생성
		CartDAO cart_dao = new CartDAO();
		cart_dao.checked(cart_dto);
		
		//세션값 가져오기
		HttpSession session=request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		
		//dao 메서드 중에서 카트에 담긴 상품을 모두 가져오는 메서드 호출
		List<CartDTO> cartList = cart_dao.getCartList(mem_num);
		System.out.println("5. OrderAction 돌아옴");

		//VIEW 페이지 정보 전달을 위해서 request 영역에 저장
		request.setAttribute("cartList", cartList);
		request.setAttribute("order_dto", order_dto);

		
		//==================================================

		
		
		//결제 후 주문 내역을 확인
		
		ActionForward forward = new ActionForward();
		forward.setPath("./product/orderList.jsp");
		forward.setRedirect(true);

		
		return forward;
	}

}
