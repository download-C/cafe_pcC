package com.pcc.QnAboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.QnAboard.db.QnABoardDAO;
import com.pcc.QnAboard.db.QnABoardDTO;

import qna.action.Action;
import vo.ActionForward;

public class QnAContentAction implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("QnAContent_execute() 호출");
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		String pageNum = (String)request.getAttribute("pageNum");
		if (pageNum==null) {
			pageNum = "1";
		}
		System.out.println("pageNum : " + pageNum);
		
		QnABoardDTO dto = new QnABoardDTO();
		
		QnABoardDAO dao = new QnABoardDAO();
		dao.updateReadCount(qna_num);
		System.out.println(qna_num + "번 문의사항 조회수 1 증가 ");
		dto = dao.getQnAContent(qna_num);
		//dao.getQnAReadCount(qna_num);
		
		System.out.println( "DTO : " + dto );
		 
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", Integer.parseInt(pageNum));
		System.out.println("pageNum" + pageNum);
		request.setAttribute("qna_num", qna_num);
		System.out.println("pageNum : " + pageNum);		
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("./QnA/QnAContent.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
