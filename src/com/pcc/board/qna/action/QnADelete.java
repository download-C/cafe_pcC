package com.pcc.board.qna.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.qna.db.QnADAO;
import com.pcc.board.qna.db.QnADTO;

import action.Action;
import vo.ActionForward;

public class QnADelete implements Action{

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("QnADelete_execute() 호출");
		
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(session != null) {
			String qna_num = request.getParameter("qna_num");
			String mem_num = (String)session.getAttribute("mem_num");
			String mgr_num = (String)session.getAttribute("mgr_num");
			
			QnADAO dao = new QnADAO();
			if(mem_num != null) {
				dao.QnADelete(Integer.parseInt(qna_num), Integer.parseInt(mem_num));				
				dao.alert(response, "글이 삭제되었습니다","location.href='./QnAList.qna?pageNum=1';");
				System.out.println("글 삭제 완료");
			} else if(mgr_num != null) {
				dao.QnADelete(Integer.parseInt(qna_num));				
				dao.alert(response, "글이 삭제되었습니다","location.href='./QnAList.qna?pageNum=1';");	
			}
				return null;

		} else {
				out.println("<script>");
				out.println("alert('로그인해주세요');");
				out.println("location.href='./Login.pcc';");
				out.println("</script>");
		}
			return null;
	}
}
