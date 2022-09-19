package com.pcc.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. LogoutAction");
		HttpSession session = request.getSession();
		String mem_num = (String) session.getAttribute("mem_num");
		System.out.println("mem_num: "+mem_num);
		System.out.println("세션 아이디: "+session.getId());
		
		if(session != null) {
			session.invalidate();
			System.out.println("세션 정보 초기화 완료");
			System.out.println("session: "+session);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그아웃되었습니다.');");
			out.println("location.href='./MainPage.pcc';");
			out.println("</script>");
			
			return null;
		} 
		
		return null;
	}

}
