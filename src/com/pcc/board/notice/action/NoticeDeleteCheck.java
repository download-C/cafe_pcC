package com.pcc.board.notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class NoticeDeleteCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		String result = "정말 삭제하시겠습니까?";
		
		response.setContentType("text/html' charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert("+result+")");
		out.println("</script>");
		
		
		return null;
	}

}
