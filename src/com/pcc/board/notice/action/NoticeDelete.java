package com.pcc.board.notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.notice.db.NoticeDAO;

import action.Action;
import vo.ActionForward;

public class NoticeDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		HttpSession session = request.getSession();
		
		int mgr_num = Integer.parseInt((String)session.getAttribute("mgr_num")); 
//		메니저로 로그인했을 때 사용해야 함.	
		
//		response.setContentType("text/html; charset=UTF-8");		
//		PrintWriter out = response.getWriter();
//		out.println("<script>");
//		out.println("alert('정말 삭제하시겠습니까?');");
//		
		NoticeDAO dao = new NoticeDAO();
		dao.noticeDelete(notice_num, mgr_num);
		System.out.println(notice_num+"번 공지사항 삭제 완료");
		
//		out.println("location.href='./NoticeList.no';");
//		out.print("</script>");
		
		
		
	
		return null;
	}

}
