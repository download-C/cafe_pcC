package com.pcc.product.action;


import java.io.PrintWriter;

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
		
		System.out.println("옵션 1 : "+ request.getParameter("requirements"));

		
		String mem_num = request.getParameter("mem_num");
		
//		System.out.println("mem_num : "+ mem_num);
		
		if(mem_num == ""){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('로그인 후 이용하실 수 있습니다.');");
			out.println("location.href='LoginForm.me';");
			out.println("</script>");
			out.close();
		}
		
		//======================================================================
		
//		System.out.println(request.getParameter("prod_num"));
		
		//전달정보 저장
		//CartDTO 객체 생성
		CartDTO dto = new CartDTO();
		//dto.setCart_num(Integer.parseInt(request.getParameter("cart_num")));
		dto.setProd_num(Integer.parseInt(request.getParameter("prod_num")));
		dto.setMem_num(Integer.parseInt(request.getParameter("mem_num")));
		dto.setRequirements(request.getParameter("requirements"));
		dto.setProd_count(Integer.parseInt(request.getParameter("prod_count")));
		dto.setTotal_price(Integer.parseInt(request.getParameter("total_price")));
		
		System.out.println("옵션 2 : "+ dto.getRequirements());
		
		//DB에 정보 저장
		//ProductDAO 객체 생성
		CartDAO dao = new CartDAO();
		dao.cartWrite(dto);
		
		System.out.println("5. CartWriteAction 돌아옴");
		//dao.getMember(mem_num);
		
		
		
		// 출력 view 페이지로 이동
		
		
		ActionForward forward = new ActionForward();
//		boolean skip_cart = false;
		
		//productContent.jsp 파일의 "담기"버튼을 눌렸을 때
//		if(skip_cart == false){
			forward.setPath("./Cart.pr");
			forward.setRedirect(true);				
//		}
		//productContent.jsp 파일의 "주문하기"버튼을 눌렸을 때
//		else{
//			forward.setPath("./OrderWrite.pr");
//			forward.setRedirect(true);				
//		}
		
		
		
		return forward;
	}

}
