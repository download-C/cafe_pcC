package com.pcc.board.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.notice.db.NoticeDAO;

import action.Action;
import vo.ActionForward;

public class NoticeDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		int mgr_num = Integer.parseInt(request.getRequestedSessionId());
//		메니저로 로그인했을 때 사용해야 함.	

//		NoticeDAO.alter(response, "정말로 삭제하시겠습니까?");		
		
		NoticeDAO dao = new NoticeDAO();
		dao.noticeDelete(notice_num, mgr_num);
		System.out.println(notice_num+"번 공지사항 삭제 완료");
		ActionForward forward = new ActionForward();
		forward.setPath("/NoticeList.no");
		forward.setRedirect(false);
		return forward;
	}

}
