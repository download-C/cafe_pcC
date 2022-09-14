package com.pcc.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.StringManager;

import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class LoginAction implements Action {
	String message = "";

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		System.out.println("3. LoginAction");
		
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
//		System.out.println(phone);
		
		MemberDAO dao = new MemberDAO();
		
//		System.out.println("dto: "+dto);
		
//		// 사용자가 로그인폼에서 입력한 phone과 password를 가지고 있는 dto 생성
//		MemberDTO dto = dao.getMember(phone, password);
		
		// 아이디와 비밀번호 일치 여부 확인
		int result = dao.loginMember(phone, password);

		System.out.println("5. LoginAction 돌아옴");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	
		if(result == 1) {
			MemberDTO dto = dao.getMember(phone, password);
			String mem_num = String.valueOf(dto.getMem_num());
			// 세션값으로 mem_num 생성
			message = dto.getName()+"님, 환영합니다!";
			HttpSession session = request.getSession();
			session.setAttribute("mem_num", mem_num);
			session.setAttribute("message", message);
			session.setMaxInactiveInterval(600);
		
			System.out.println("mem_num 세션값 생성 성공!");
			
			out.println("<script>");
			out.println("alert('로그인에 성공했습니다.');");
			out.println("location.href='./MainPage.pcc';");
			out.println("</script>");
			
		} else {
			out.println("<script>");
			out.println("alert('아이디 또는 비밀번호가 일치하지 않습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return null ;
	}

}
