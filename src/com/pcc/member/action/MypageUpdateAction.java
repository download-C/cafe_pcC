package com.pcc.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.member.db.MemberDAO;
import com.pcc.member.db.MemberDTO;

import action.Action;
import vo.ActionForward;

public class MypageUpdateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		// DB에 정보 저장
		
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
						
		MemberDTO dto = new MemberDTO();
		dto.setMem_num(Integer.parseInt(request.getParameter("mem_num")));
		dto.setPhone(request.getParameter("phone"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		

		dao.updateMember(dto);
				
		//페이지 이동정보 저장(리턴)
		ActionForward forward = new ActionForward();
		forward.setPath("./mypageContent.me");
		forward.setRedirect(true);
				
		return forward;
	
	}
 
}
