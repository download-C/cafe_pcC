package com.pcc.board.notice.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.notice.db.NoticeDAO;
import com.pcc.board.notice.db.NoticeDTO;

import action.Action;
import vo.ActionForward;

public class NoticeWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("NoticeWriteAction_execute() 호출");
	// 0. 한글 처리
		request.setCharacterEncoding("UTF-8");
		System.out.println("한글 처리 완료");
		
	// 1. noticeWriteForm.jsp에서 받은 정보(제목, 내용, 첨부파일)를 담을 BoardDTO 생성 후 저장
		NoticeDTO dto = new NoticeDTO();
		System.out.println("NoticeDTO 객체 생성");

//		dto.setNotice_subject(request.getParameter("notice_subject"));
//		dto.setNotice_content(request.getParameter("notice_content"));
//		dto.setNotice_file(request.getParameter("notice_file"));
		dto.setNotice_subject(request.getParameter("notice_subject"));
		dto.setNotice_content(request.getParameter("notice_content"));
		dto.setNotice_file(request.getParameter("notice_file"));
		System.out.println("파라미터 값 DTO에 저장 완료");
		
		System.out.println(" Model : "+dto);
		
	// 2. DB에 정보 저장
		NoticeDAO dao = new NoticeDAO();
		dao.noticeWrite(dto);
		System.out.println("DAO 객체 생성");
		ActionForward forward = new ActionForward();
		forward.setPath("/NoticeList.no");
		forward.setRedirect(true);
		System.out.println("NoticeList.no로 이동");
		
		return forward;
	}

}
