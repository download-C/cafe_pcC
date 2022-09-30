package com.pcc.manager.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.manager.db.ManagerDAO;
import com.pcc.manager.db.ManagerDTO;

import action.Action;
import vo.ActionForward;

public class ManagerLoginAction implements Action {
	String message;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mgr_id = request.getParameter("mgr_id");
		String mgr_password = request.getParameter("mgr_password");
		
		System.out.println("매니저 정보"+mgr_id +""+mgr_password);
		ManagerDAO dao = new ManagerDAO();
		
		int result = dao.loginManager(mgr_id, mgr_password);
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			ManagerDTO dto = dao.getManager(mgr_id, mgr_password);
			String mgr_num = String.valueOf(dto.getMgr_num());
//			Cookie idCookie = new Cookie("mgr_num",  mgr_num);
//			response.addCookie(idCookie);
			message = dto.getMgr_name()+"님, 환영합니다!";
			HttpSession session = request.getSession();
			session.setAttribute("mgr_num", mgr_num);
			session.setAttribute("message", message);
			session.setMaxInactiveInterval(3000);

			System.out.println("세션값 생성 성공!");
			
			out.println("<script>");
			out.println("alert('"+message+"');");
			out.println("location.href='./MainPage.pcc';");
			out.println("</script>");
			
		} else {
			out.println("<script>");
			out.println("alert('아이디 또는 비밀번호가 일치하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return null;
	}

}
