package com.pcc.QnAboard.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.QnAboard.db.QnABoardDAO;
import com.pcc.QnAboard.db.QnABoardDTO;

import qna.action.Action;
import vo.ActionForward;

public class QnAPasswordCheck implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		int mem_num = Integer.parseInt((String)session.getAttribute("mem_num"));
		int qna_num = Integer.parseInt((String)session.getAttribute("qna_num"));
		int qna_password = Integer.parseInt((String)session.getAttribute("qna_password"));
		
		QnABoardDTO dto = new QnABoardDTO();
		QnABoardDAO dao = new QnABoardDAO();
		dto = dao.getQnAContent(qna_num);
		
		if(qna_password == dto.getQna_password()) {
			dao.QnADelete(session, qna_num, mem_num, qna_password);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제되었습니다');");
			out.println("loaction.href='./QnABoardList.qna'");
			out.println("</script>");

			return null;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('비밀번호 오류입니다');");
		out.println("loaction.href='./QnABoardList.qna'");
		out.println("</script>");

		return null;
		
	}

}
