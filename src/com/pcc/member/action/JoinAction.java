package com.pcc.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. JoinAction");
		
		request.setCharacterEncoding("UTF-8");
		MemberDTO dto = new MemberDTO();
		System.out.println(" DTO객체생성");
		
		dto.setPhone(request.getParameter("phone"));
		System.out.println(" phone: "+dto.getPhone());
		dto.setPassword(request.getParameter("password"));
		System.out.println(" password: "+dto.getPassword());
		dto.setName(request.getParameter("name"));
		System.out.println(" name : "+dto.getName());
		
		MemberDAO dao = new MemberDAO();
		System.out.println(" DAO객체생성");
		dao.JoinMember(dto);
		System.out.println(" JoinMemeber 메서드 실행");
		
		
//		System.out.println("5. JoinAction 돌아옴");
//		ActionForward forward = new ActionForward();
//		forward.setPath("./LoginForm.me");
//		forward.setRedirect(true);
//		return forward ;
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('회원가입이 완료되었습니다. 로그인 페이지로 이동합니다.')");
		out.println("location.href='./LoginForm.me';");
		out.println("</script>");
		
		return null;
	}

}
