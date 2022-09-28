package com.pcc.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.product.db.OrderDAO;
import com.pcc.product.db.OrderDTO;

import action.Action;
import vo.ActionForward;

public class OrderListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("3. OrderListAction");

		//한글 처리
		request.setCharacterEncoding("UTF-8");
			
		//세션값 가져오기
		HttpSession session=request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		
		
		//==================================================

		
		//주문별 상품 정보 가져오는 리스트
		OrderDAO order_dao = new OrderDAO();
		List<OrderDTO> orderProductList = order_dao.getOrderProductList(mem_num);
		
		//orders에서 주문 리스트 값을 가져오기
		List<OrderDTO> orderList = order_dao.getOrderList(mem_num);

		System.out.println("5. OrderListAction 돌아옴");
		
		//VIEW 페이지 정보 전달을 위해서 request 영역에 저장
		request.setAttribute("orderProductList", orderProductList);
		request.setAttribute("orderList", orderList);
		
		System.out.println(request.getAttribute("orderList"));
		System.out.println(request.getAttribute("orderProductList"));
		//==================================================
		
		
		// 주문 내역 리스트를 확인하는 페이지로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("./product/orderList.jsp");
		forward.setRedirect(false);
		
		return forward;
		
	}

}
