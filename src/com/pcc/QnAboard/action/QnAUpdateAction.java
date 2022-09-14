package com.pcc.QnAboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.QnAboard.db.QnABoardDAO;
import com.pcc.QnAboard.db.QnABoardDTO;

import qna.action.Action;
import vo.ActionForward;

public class QnAUpdateAction implements Action{

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("QnAUpdateAction_execute() 호출");
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		String pageNum = request.getParameter("pageNum");
		
		QnABoardDAO dao = new QnABoardDAO();
		
		QnABoardDTO dto = dao.getQnAUpdateContent(qna_num);
		System.out.println(" 수정 할 데이터 " + dto);
		
		request.setAttribute("dto", dto);
		request.setAttribute("qna_num", qna_num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./QnA/QnAUpdateForm.jsp");
		forward.setRedirect(false);
		
		
		
		return forward;
	}

}


