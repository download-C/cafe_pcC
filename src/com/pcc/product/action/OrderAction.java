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
			
		//세션값 가져오기
		HttpSession session=request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		
		
		//==================================================
		
		
		//checked 값 now()로 넣어주는 update() 메서드 실행
		
		CartDTO cart_dto = new CartDTO();
		//데이터가 null값인 것들만 select 해와서 checked를 update하기

		//CartDAO 객체 생성
		CartDAO cart_dao = new CartDAO();
		cart_dao.checked(cart_dto, mem_num);
		
		
		//==================================================
		
		
		//OrderDTO 객체 생성
		OrderDTO order_dto = new OrderDTO();
		
		//가져온 값들을 DTO에 넣기(order_price, pickup_time)
		order_dto.setOrder_price(Integer.parseInt(request.getParameter("order_price")));
		order_dto.setPickup_time(Integer.parseInt(request.getParameter("pickup_time")));
		
		OrderDAO order_dao = new OrderDAO();
		order_dao.orderWrite(order_dto, mem_num);
		
		System.out.println("5. OrderAction 돌아옴");

		
		//==================================================
		
		
		//결제 후 주문 내역 리스트를 확인하는 페이지로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./OrderList.pr");
		forward.setRedirect(true);
		
		return forward;
	}

}
