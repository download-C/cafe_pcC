package com.pcc.board.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.notice.db.NoticeDAO;
import com.pcc.board.notice.db.NoticeDTO;

import action.Action;
import vo.ActionForward;

public class NoticeContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("NoticeContentAction_execute() 호출");
		
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		String pageNum = request.getParameter("pageNum");
		NoticeDTO dto = new NoticeDTO();
//		if(dto.getMgr_num() != 1234) {
			NoticeDAO dao = new NoticeDAO();
			dao.updateReadCount(notice_num);
			System.out.println("조회수 1 증가");
			dto = dao.getNoticeContent(notice_num);
//		}
				
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("notice_num", notice_num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./notice/noticeContent.jsp");
		forward.setRedirect(false);
			
		return forward;
	}

}
