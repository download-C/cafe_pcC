package com.pcc.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class IdCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("3. IdCheck");
		request.setCharacterEncoding("UTF-8");
		
		String phone = request.getParameter("phone");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getPhoneCheck(phone);
		
		String result="";
		
		if(dto.getPhone()!=null){
			//아이디 중복
			result="아이디 중복";
		}else{
			//아이디 없음
			result="아이디 사용가능";
		}
		//결과 출력
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.close();
		
//		System.out.println("3. IdCheck 돌아옴");
//		ActionForward forward = new ActionForward();
//		forward.setPath("./JoinAction.me");
//		forward.setRedirect(true);
		return null ;
	}

}
