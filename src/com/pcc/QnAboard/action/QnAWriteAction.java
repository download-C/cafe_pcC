package com.pcc.QnAboard.action;

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
		
		// 1. QnAWriteForm.jsp에서 받은 정보(제목, 내용, 첨부파일)를 담을 BoardDTO 생성 후 저장
		QnABoardDTO dto = new QnABoardDTO();
		System.out.println("DTO 객체 생성 완료");
		
		dto.setQnA_password(Integer.parseInt(request.getParameter("QnA_password")));
		System.out.println("비밀번호 불러오기");
		dto.setQnA_subject(request.getParameter("QnA_subject"));
		System.out.println("제목 불러오기");
		dto.setQnA_content(request.getParameter("QnA_content"));
		System.out.println("내용 불러오기");
		dto.setQnA_file(request.getParameter("QnA_file"));
		System.out.println("파일 불러오기");
		dto.setQnA_ip(request.getRemoteAddr());
	    System.out.println("ip 불러오기");
		
		System.out.println(" 파라미터 값 DTO에 저장 완료! ");
		
		System.out.println(" M : " + dto);
		
		// 2. DB에 정보 저장
		
		QnABoardDAO dao = new QnABoardDAO();
		
		int QnA_num = dao.QnAWrite(dto);
	
		System.out.println(" DAO 객체 생성 후 DB에 저장 완료");

	
		
		ActionForward forward = new ActionForward();
		forward.setPath("./QnAContent.bo?QnA_num=" + QnA_num);
		forward.setRedirect(true);
		System.out.println(" QnAContent.bo로 이동 ");
		
		return forward;
	}
	
	

}
