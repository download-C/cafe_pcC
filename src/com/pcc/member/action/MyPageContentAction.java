package com.pcc.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class MyPageContentAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println(" M : MypageContentAction_execute() 호출 ");
		
		HttpSession session = request.getSession();
		
		if(session != null) {
			
			String mem_num = (String)session.getAttribute("mem_num");
			
			if(mem_num != null) {
				
				// 한글처리
				request.setCharacterEncoding("UTF-8");
				
				// 전달정보 저장(제목,비밀번호,이름,내용)
				MemberDTO dto = new MemberDTO();
				
				// DB에 정보 저장
				// MemberDAO 객체 생성
				MemberDAO dao = new MemberDAO();
				
				dto = dao.memberContent(Integer.parseInt(mem_num));
				
				request.setAttribute("dto", dto);
				
				//페이지 이동정보 저장(리턴)
				ActionForward forward = new ActionForward();
				forward.setPath("./mypage/myPage.jsp");
				forward.setRedirect(false);
				
				return forward;
			}
			
			
		}else{
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			session.invalidate();
			out.println("<script type='text/javascript'>alert('세션이 만료되어 로그인 페이지로 이동합니다.'); "
					+ "location.href='./Login.pcc';</script>");
			out.flush();
		}
		
		return null;
	}
}
