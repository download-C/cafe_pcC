package com.pcc.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class MypageDelete implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println(" M : MypageDelete_execute() 호출 ");
		
		// MemberDTO 객체 생성
//		MemberDTO dto = new MemberDTO();
//		
//		// MemberDAO 객체 생성
//		MemberDAO dao = new MemberDAO();
//		dao.memberContent(dto);
//						
		
//		dto.setMem_num(mem_num);
//		dto.setPassword(password);
//
//
//		int result = dao.deleteMember(dto);
//		
//		ActionForward forward = new ActionForward();
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int mem_num = Integer.parseInt((String)session.getAttribute("mem_num"));
		String password = request.getParameter("password");
		
		MemberDAO dao = new MemberDAO();
	
		MemberDTO dto = dao.getMember(mem_num);
		
		if(password.equals(dto.getPassword())) {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
						
			int result = dao.deleteMember(dto);	
				
			if(result == 1){
				session.invalidate();
				//페이지 이동정보 저장(리턴)
	//			forward.setPath("./mypageContent.me");
	//			forward.setRedirect(true);		
				out.println("<script type='text/javascript'>alert('회원 탈퇴 성공!'); "
						+ "location.href='./Login.pcc';</script>");
				out.flush();
						
			} else{
				out.println("<script type='text/javascript'>alert('회원 삭제 실패!'); "
						+ "history.back();</script>");
				out.flush();
			}
			return null;
			
		} else {
			dao.alert(response, "비밀번호가 틀립니다.", "history.back();");
			return null;
		}
	}
}
