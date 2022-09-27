package com.pcc.board.qna.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.qna.db.QnADAO;
import com.pcc.board.qna.db.QnADTO;

import action.Action;
import vo.ActionForward;

public class QnAReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		
		QnADAO dao = new QnADAO();
		QnADTO dto = dao.getQnAContent(qna_num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("qna_num", qna_num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./QnA/QnAReplyForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
