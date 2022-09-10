package com.pcc.manager.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.manager.db.ManagerDAO;
import com.pcc.manager.db.ManagerDTO;

import action.Action;
import vo.ActionForward;

public class LoginManagerAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String mgr_id = request.getParameter("mgr_id");
		String mgr_password = request.getParameter("mgr_password");
		
		ManagerDAO dao = new ManagerDAO();
		ManagerDTO dto = dao.getManager(mgr_id, mgr_password);
		
		int result = dao.loginManager(dto);
		
		ActionForward forward = new ActionForward();
		if(result == 1) {
			request.setAttribute(Integer.toString(dto.getMgr_num()), "mgr_num");

			forward.setPath("/MainPage.pcc");
			forward.setRedirect(false);
		} else {
			forward.setPath("./LoginManager.mgr");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
