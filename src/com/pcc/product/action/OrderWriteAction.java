package com.pcc.product.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				
		//전달정보 저장
		//OrderDTO 객체 생성
		OrderDTO dto = new OrderDTO();
		
		//order_price만 넘겨받기
		
		return null;
	}

}
