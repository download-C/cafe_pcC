package com.pcc.QnAboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.QnAboard.db.QnABoardDAO;
import com.pcc.QnAboard.db.QnABoardDTO;
import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;

import qna.action.Action;
import vo.ActionForward;

public class QnAUpdateProAction implements Action{

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		System.out.println("QnAUpdateProAction_execute() 호출");
		
		request.setCharacterEncoding("UTF-8");

		String pageNum = (String)request.getAttribute("pageNum");
		
		QnABoardDTO dto = new QnABoardDTO();
		
		dto.setQna_num(Integer.parseInt(request.getParameter("qna_num")));
		dto.setQna_subject(request.getParameter("qna_subject"));
		dto.setQna_content(request.getParameter("qna_content"));
		dto.setQna_file(request.getParameter("qna_file"));
		
		QnABoardDAO dao = new QnABoardDAO();
		
		//int result = dao.getQnAUpdateContent(dto);
		
		
		return null;
	}

	
	
	
	
}
