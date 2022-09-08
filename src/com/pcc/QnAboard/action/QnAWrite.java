package com.pcc.QnAboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;
import com.pcc.QnAboard.db.QnABoardDAO;

import qna.action.Action;
import vo.ActionForward;

public class QnAWrite implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String phone = (String)request.getAttribute("phone");
		
		
		QnABoardDAO dao = new QnABoardDAO();
		
		dao.getMem_num(request.getAttribute("phone"));
		
		
		
		return null;
	}

}
