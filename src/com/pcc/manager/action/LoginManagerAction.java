package com.pcc.manager.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.manager.db.ManagerDAO;
import com.pcc.manager.db.ManagerDTO;

import action.Action;
import vo.ActionForward;

public class LoginManagerAction implements Action {
	String message;
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mgr_id = request.getParameter("mgr_id");
		String mgr_password = request.getParameter("mgr_password");
		
		ManagerDAO dao = new ManagerDAO();
		ManagerDTO dto = dao.getManager(mgr_id, mgr_password);
	
		System.out.println(dto);
		
		int result = dao.loginManager(dto);
		
		ActionForward forward = new ActionForward();
		if(result == 1) {
			String mgr_num = String.valueOf(dto.getMgr_num());
//			Cookie idCookie = new Cookie("mgr_num",  mgr_num);
//			response.addCookie(idCookie);
			message = dto.getMgr_name()+"님, 환영합니다!";
			HttpSession session = request.getSession();
			session.setAttribute("mgr_num", mgr_num);
			session.setAttribute("message", message);
			session.setMaxInactiveInterval(600);

			System.out.println("세션값 생성 성공!");
			
			forward.setPath("./MainPage.pcc");
			forward.setRedirect(true);
		} else {
			message = "아이디와 비밀번호가 일치하지 않습니다.";
			forward.setPath("./LoginManager.mgr");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
