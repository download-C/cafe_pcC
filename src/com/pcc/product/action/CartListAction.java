package com.pcc.product.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.product.db.CartDAO;
import com.pcc.product.db.CartDTO;

import action.Action;
import vo.ActionForward;

public class CartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("3. CartListAction");
		//세션값 가져오기
		HttpSession session=request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
//

//		System.out.println(mem_num);
		
		
		//==================================================
		
		
		//CartDAO 객체 생성
		CartDAO dao = new CartDAO();
		
		//한글 처리
		request.setCharacterEncoding("UTF-8");
		
//		//전달정보 저장
//		//CartDTO 객체 생성
//		CartDTO dto = new CartDTO();
		

		//dao 메서드 중에서 카트에 담긴 상품을 모두 가져오는 메서드 호출
		List<CartDTO> cartList = dao.getCartList(mem_num);
		
//		System.out.println("2번"+cartList);


		//VIEW 페이지 정보 전달을 위해서 request 영역에 저장
		request.setAttribute("cartList", cartList);

		
		//==================================================

		
		//화면에 출력
		//페이지 이동
		System.out.println("5. CartListAction 돌아옴");
		ActionForward forward = new ActionForward();
		forward.setPath("./product/cart.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}