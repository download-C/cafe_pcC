package com.pcc.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		MemberDTO dto = new MemberDTO();
		System.out.println("DTO객체생성");
		
		dto.setPhone(request.getParameter("phone"));
		System.out.println("phone: "+dto.getPhone());
		dto.setPassword(request.getParameter("password"));
		System.out.println("password: "+dto.getPassword());
		dto.setName(request.getParameter("name"));
		System.out.println("name : "+dto.getName());
		
		
		MemberDAO dao = new MemberDAO();
		System.out.println("DAO객체생성");
		dao.JoinMember(dto);
		System.out.println("JoinMemeber 메서드 실행");
		
		ActionForward forward = new ActionForward();
		forward.setPath("./LoginForm.me");
		forward.setRedirect(true);
		return forward ;
	}

}
