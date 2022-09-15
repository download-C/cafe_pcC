package com.pcc.QnAboard.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.QnAboard.db.QnABoardDAO;
import com.pcc.QnAboard.db.QnABoardDTO;

import qna.action.Action;
import vo.ActionForward;

public class QnADelete implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		HttpSession session = request.getSession();
		int mgr_num = Integer.parseInt((String)session.getAttribute("mgr_num"));
		int mem_num = Integer.parseInt((String)session.getAttribute("mem_num"));
		int qna_password = Integer.parseInt(request.getParameter("qna_password"));

		QnABoardDAO dao = new QnABoardDAO();
		QnABoardDTO dto = dao.getQnAContent(qna_num);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(mgr_num != 0 && mem_num == 0) {
			dao.QnADelete(session, qna_num, mgr_num);
		}else if(mem_num != 0 && mgr_num == 0) {
			dao.QnADelect(session, qna_num, mem_num, qna_password);
		}

		System.out.println(qna_num+"번 공지사항 삭제 완료");
		
		out.println("<script>");
		out.println("alert('삭제되었습니다');");
		out.println("location.href='./QnABoardList.qna';");
		out.println("</script>");
		
		return null;
	}
	
	
	
	
	
	
	
}
