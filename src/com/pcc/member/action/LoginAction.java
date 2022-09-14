package com.pcc.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class LoginAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		System.out.println("3. LoginAction");
		
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
		
		// 사용자가 로그인폼에서 입력한 phone과 password를 가지고 있는 dto 생성
		MemberDTO dto = dao.getMember(phone, password);
		
		// 아이디와 비밀번호 일치 여부 확인
		int result = dao.loginMember(dto);
		
		
		
		System.out.println("5. LoginAction 돌아옴");
		ActionForward forward = new ActionForward();
		if(result == 1) {
			// 세션값으로 mem_num 생성
			request.setAttribute("mem_num", dto.getMem_num());
			System.out.println(" mem_num 세션값 생성");
			forward.setPath("./MyPage.me");
			forward.setRedirect(true);
		} else {
			forward.setPath("./members/LoginForm.jsp");
			forward.setRedirect(false);
		}
		
		return forward ;
	}

}
