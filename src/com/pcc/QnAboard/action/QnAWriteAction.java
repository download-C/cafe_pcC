package com.pcc.QnAboard.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pcc.QnAboard.db.QnABoardDAO;
import com.pcc.QnAboard.db.QnABoardDTO;

import qna.action.Action;
import vo.ActionForward;

public class QnAWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println(" M : QnAWriteAction_execute() 메서드 호출 실행 ");
		
		// 0. 한글처리
		request.setCharacterEncoding("UTF-8");
		System.out.println(" 한글처리 완료! ");

		
//		int qna_password = (Integer.parseInt(request.getParameter("qna_password")));
//		String qna_subject = request.getParameter("qna_subject");
//		String qna_content = request.getParameter("qna_content");
//		String qna_file = request.getParameter("qna_file");
		
		// 1. QnAWriteForm.jsp에서 받은 정보(제목, 내용, 첨부파일)를 담을 BoardDTO 생성 후 저장
		QnABoardDTO dto = new QnABoardDTO();
		System.out.println("DTO 객체 생성 완료");
		System.out.println(" 값 불러오기!");
		
		dto.setQna_password(Integer.parseInt(request.getParameter("qna_password")));
		System.out.println("비밀번호 불러오기");
		dto.setQna_subject(request.getParameter("qna_subject"));
		System.out.println("제목 불러오기");
		dto.setQna_content(request.getParameter("qna_content"));
		System.out.println("내용 불러오기");
		dto.setQna_file(request.getParameter("qna_file"));
		System.out.println("파일 불러오기");
		dto.setQna_ip(request.getRemoteAddr());
	    System.out.println("ip 불러오기");
		
		System.out.println(" 파라미터 값 DTO에 저장 완료! ");
		
		System.out.println(" M : " + dto);
		
		// 2. DB에 정보 저장
		
		QnABoardDAO dao = new QnABoardDAO();
		
		int qna_num = dao.QnAWrite(dto);
	
		System.out.println(" DAO 객체 생성 후 DB에 저장 완료");
//		request.setAttribute("pageNum", "1");
	
		
		ActionForward forward = new ActionForward();
		forward.setPath("./QnAContent.qna?qna_num=" + qna_num);
		forward.setRedirect(true);
		System.out.println(" QnAContent.qna로 이동 ");
		
		return forward;
	}
	
	

}
