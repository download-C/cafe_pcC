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
		
		int QnA_num = Integer.parseInt(request.getParameter("QnA_num"));
		String pageNum = request.getParameter("pageNum");
		
		QnABoardDTO dto = new QnABoardDTO();
		QnABoardDAO dao = new QnABoardDAO();
		//dao.getQnABoardCount(QnA_num);
		dao.updateReadCount(QnA_num);
		System.out.println(" 조회수 1 증가 ");
		dto = dao.getQnAContent(QnA_num);
		System.out.println( "DTO : " + dto );
		
		request.setAttribute("dto",dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("QnA_num", QnA_num);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("./QnA/QnAContent.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
