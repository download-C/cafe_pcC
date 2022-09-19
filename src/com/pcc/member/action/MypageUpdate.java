package com.pcc.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class MypageUpdate implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println(" M : MypageUpdate_execute() 호출 ");
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 전달정보 저장
		int mem_num = Integer.parseInt(request.getParameter("mem_num"));

		
		// DB에 정보 저장
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
				
		MemberDTO dto = new MemberDTO();

		
		dao.memberContent(dto);
		
		request.setAttribute("dto", dto);
		
		
		//페이지 이동정보 저장(리턴)
		ActionForward forward = new ActionForward();
		forward.setPath("./mypage/mypageUpdate.jsp");
		forward.setRedirect(false);
		
		return forward;
		
	}

}
