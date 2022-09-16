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
		
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		int mgr_num = Integer.parseInt(request.getParameter("mgr_num"));
		int mem_num = Integer.parseInt(request.getParameter("mem_num"));
		int qna_password = Integer.parseInt(request.getParameter("qna_password"));
		
		if (mgr_num == 0 || mem_num == 0) {
			out.println("<script>");
			out.println("alert('로그인해주세요');");
			out.println("location.href='./Login.pcc';");
			out.println("</script>");
		}
		
		QnABoardDAO dao = new QnABoardDAO();
		QnABoardDTO dto = dao.getQnAContent(qna_num);
		
		if (mgr_num != 0 && mem_num == 0) {
			dao.QnADelete(session, qna_num, mgr_num);
		}else if(mem_num !=0 && mgr_num == 0) {
			dao.QnADelete(session, qna_num, mem_num, qna_password);
		}
		
		out.println("<script>");
		out.println("alert('삭제되었습니다.';");
		out.println("location.href='./QnABoardList.qna';");
		out.println("</script>");
		
		return null;
	}

	
	
}
	
	
	
	
	

