package com.pcc.board.qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.qna.db.QnABoardDAO;
import com.pcc.board.qna.db.QnABoardDTO;
import com.pcc.member.db.MemberDAO;

import action.Action;
import vo.ActionForward;

public class QnAWriteAction implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println(" M : QnAWriteAction_execute() 메서드 호출 실행 ");
		
		// 0. 한글처리
		request.setCharacterEncoding("UTF-8");
		System.out.println(" 한글처리 완료! ");
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		System.out.println("mem_num"+mem_num);

		int qna_password = Integer.parseInt(request.getParameter("qna_password"));
		String qna_subject = request.getParameter("qna_subject");
		String qna_content = request.getParameter("qna_content");
		String qna_file = request.getParameter("qna_file");
		String name = request.getParameter("name");
		
		// 1. QnAWriteForm.jsp에서 받은 정보(제목, 내용, 첨부파일)를 담을 BoardDTO 생성 후 저장
		QnABoardDTO dto = new QnABoardDTO();
		System.out.println("DTO 객체 생성 완료");
		System.out.println(" 값 불러오기!");
		
		MemberDAO daoM = new MemberDAO();
		
		dto.setMem_num(Integer.parseInt(mem_num));
		dto.setName(name);
		dto.setQna_password(qna_password);
		dto.setQna_subject(qna_subject);
		dto.setQna_content(qna_content);
		dto.setQna_file(qna_file);
		dto.setQna_ip(request.getRemoteAddr());
		
		System.out.println(" M : " + dto);
		
		// 2. DB에 정보 저장
		
		QnABoardDAO dao = new QnABoardDAO();
		
		int qna_num = dao.QnAWrite(dto);
	
		System.out.println(" DAO 객체 생성 후 DB에 저장 완료");
		
		daoM.alert(response, "리뷰를 작성했습니다.", 
				"location.href='./QnAContent.qna?qna_num="+qna_num+"&pageNum=1';");
		
		return null;
	}	

}
