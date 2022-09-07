package com.pcc.member.action;

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
		
		// 한글처리
		request.setCharacterEncoding("UTF-8");
		
		// 전달정보 저장
		HttpSession session = request.getSession();
		int mem_num = Integer.parseInt(request.getParameter("mem_num"));
		String password = request.getParameter("password");
		
		// MemberDTO dto = new MemberDTO();
		
		
		// DB에 정보 저장
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
				
		int result = dao.deleteMember(mem_num);
		
		ActionForward forward = new ActionForward();
		
		if(result ==1){
			session.invalidate();
			//페이지 이동정보 저장(리턴)
			forward.setPath("./mypage/mypageDelete.jsp");
			forward.setRedirect(true);
		}
		else{
			System.out.println("회원 삭제 실패");
		}
				
		return forward;
		
	}

}
