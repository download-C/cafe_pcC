package com.pcc.board.qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.qna.db.QnABoardDAO;
import com.pcc.board.qna.db.QnABoardDTO;

import action.Action;
import vo.ActionForward;

public class QnAReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		
		QnABoardDAO dao = new QnABoardDAO();
		QnABoardDTO dto = dao.getQnAContent(qna_num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("qna_num", qna_num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./qna/qnaReplyForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
