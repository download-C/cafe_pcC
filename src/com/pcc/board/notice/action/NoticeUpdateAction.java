package com.pcc.board.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.notice.db.NoticeDAO;
import com.pcc.board.notice.db.NoticeDTO;

import action.Action;
import vo.ActionForward;

public class NoticeUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("한글 처리 완료");
		
		
		NoticeDAO dao = new NoticeDAO();
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		NoticeDTO dto = dao.getNoticeContent(notice_num);
		System.out.println(notice_num+"번 글의 정보를 가진 NoticeDTO 객체 생성");
		System.out.println("==============================");
		System.out.println("DTO : "+dto);
		System.out.println("==============================");
		dto.setNotice_num(notice_num);
		dto.setNotice_subject(request.getParameter("notice_subject"));
		dto.setNotice_content(request.getParameter("notice_content"));
		dto.setNotice_file(request.getParameter("notice_file"));
		System.out.println("noticeUpdateForm.jsp 파라미터값 DTO에 저장 완료");
		System.out.println("==============================");
		System.out.println("DTO : "+dto);
		System.out.println("==============================");

		dao.NoticeUpdate(dto, notice_num);
		System.out.println("공지사항 업데이트 완료");
		
		request.setAttribute("dto", dto);
		request.setAttribute("notice_num", notice_num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/NoticeContent.no");
		forward.setRedirect(false);
		return forward;
	}

}
