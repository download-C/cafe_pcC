package com.pcc.board.qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.qna.db.QnADTO;
import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class QnAWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		if(session != null) {
			String mem_num = (String)session.getAttribute("mem_num");
			System.out.println("MEM_NUM : "+mem_num);
			String mgr_num = (String)session.getAttribute("mgr_num");
			System.out.println("MGR_NUM : "+mgr_num);
			
			if(mem_num != null) {
				MemberDAO dao = new MemberDAO();
				request.setAttribute("name", dao.getName(Integer.parseInt(mem_num)));
				
				ActionForward forward = new ActionForward();
				forward.setPath("./QnA/QnAWriteForm.jsp");
				forward.setRedirect(false);
				return forward;
				
			} else {
				MemberDAO dao = new MemberDAO();
				dao.alert(response, "로그인 후 이용 가능합니다.", "location.href='./LoginForm.me';");
				return null;
			}
		}
		return null;
	}
}

