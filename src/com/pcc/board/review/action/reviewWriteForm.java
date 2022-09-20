package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.member.db.MemberDAO;

import action.Action;
import vo.ActionForward;

public class reviewWriteForm implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		
		if(mem_num != null) {
			MemberDAO dao = new MemberDAO();
			
			String name = dao.getName(Integer.parseInt(mem_num));
			request.setAttribute("name", name);
			forward.setPath("./review/reviewWriteForm.jsp");
			forward.setRedirect(false);
			System.out.println("reviewWriteForm.jsp로 이동");
			return forward;
		} else {
			MemberDAO dao = new MemberDAO();
			dao.alert(response, "로그인 후 사용 가능합니다.", "location.href='./Login.pcc';");
		}
		
		return null;
	}

}
