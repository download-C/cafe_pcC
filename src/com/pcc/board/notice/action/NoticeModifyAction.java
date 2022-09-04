package com.pcc.board.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.notice.db.NoticeDAO;
import com.pcc.board.notice.db.NoticeDTO;

import action.Action;
import vo.ActionForward;

public class NoticeModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("NoticeModifyAction_execute() 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		String pageNum = request.getParameter("page_Num");
		
		NoticeDTO dto = new NoticeDTO();
		request.setAttribute("pageNum", pageNum);
		
		System.out.println("NoticeDTO 객체 생성");
		
		// DB에 저장된 공지사항 글 정보 불러오기
		
		
	
		
		ActionForward forward = new ActionForward();


		
		return forward;
	}

}
