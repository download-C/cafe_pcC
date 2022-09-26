 package com.pcc.board.qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.qna.db.QnADAO;
import com.pcc.board.qna.db.QnADTO;
import com.pcc.member.db.MemberDAO;

import action.Action;
import vo.ActionForward;

public class QnAUpdateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
System.out.println("QnAUpdateProAction_execute() 호출");
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("한글 처리 완료");

		QnADAO dao = new QnADAO();
		//System.out.println("DAO : " +dao);
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		
		
		
		System.out.println("qna_num : " + qna_num);
	
		QnADTO dto = dao.getQnAContent(qna_num);
		System.out.println(qna_num + "번의 글을 정보를 가진 QnADTO 객체 생성");
		System.out.println("==============================");
		System.out.println("DTO : " + dto);
		System.out.println("==============================");
		dto.setQna_num(qna_num);
		dto.setQna_subject(request.getParameter("qna_subject"));
		dto.setQna_content(request.getParameter("qna_content"));
		dto.setQna_file(request.getParameter("qna_file"));
		System.out.println("QnAUpdateForm.jsp 파라미터값 DTO에 저장 완료");
		
		dao.QnAUpdate(dto, qna_num);
		System.out.println("문의사항 업데이트 완료");
		
		request.setAttribute("dto", dto);
		request.setAttribute("qna_num", qna_num);
		
//		ActionForward forward = new ActionForward();
//		forward.setPath("/QnAContent.qna");
//		forward.setRedirect(false);
//		
//		return forward;
	
		
		dao.alert(response, "글을 수정했습니다.", "location.href='./QnAContent.qna?qna_num="+qna_num+"&pageNum=1';");
		System.out.println("얼러트 성공!");
		return null;
	}
}

