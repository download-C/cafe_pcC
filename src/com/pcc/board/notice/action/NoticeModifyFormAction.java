package com.pcc.board.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.notice.db.NoticeDAO;
import com.pcc.board.notice.db.NoticeDTO;

import action.Action;
import vo.ActionForward;

public class NoticeModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("NoticeModifyFormAction_execute() 호출");
		
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		String page_num = request.getParameter("page_num");
		
		NoticeDAO dao = new NoticeDAO();
		
		
		NoticeDTO dto = dao.getNoticeModifyForm(notice_num);
		request.setAttribute("dto", dto);
		request.setAttribute("page_num", page_num);
		System.out.println(notice_num+"번 글 보내기 성공!");
	
		ActionForward forward = new ActionForward();
		System.out.println("ActionForward 객체 생성");
		forward.setPath("/NoticeModifyFormAction.no");
		System.out.println("noticeModifyForm.jsp로 경로 설정");
		forward.setRedirect(false);
		System.out.println("이동 방식 설정 완료");
		// 여기서 안 넘어감 ㅠㅠㅠㅠㅠㅠ
		return forward;
	}

}
