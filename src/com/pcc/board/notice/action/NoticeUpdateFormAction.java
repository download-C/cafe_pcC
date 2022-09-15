package com.pcc.board.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.notice.db.NoticeDAO;
import com.pcc.board.notice.db.NoticeDTO;

import action.Action;
import vo.ActionForward;

public class NoticeUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("NoticeUpdateFormAction_execute() 호출");
		
		
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = dao.getNoticeContent(notice_num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("notice_num", notice_num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./notice/noticeUpdateForm.jsp");
		return forward;
	}

}
