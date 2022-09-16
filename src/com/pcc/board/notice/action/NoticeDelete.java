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
		
		response.setContentType("text/html; charset=UTF-8");		
		PrintWriter out = response.getWriter();
		
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		System.out.println("삭제할 글 번호 :"+notice_num);
		HttpSession session = request.getSession();
		int mgr_num = Integer.parseInt((String)session.getAttribute("mgr_num"));
		System.out.println("삭제하는 매니저 번호 : "+mgr_num);
		if(mgr_num != 0) {
			NoticeDAO dao = new NoticeDAO();
			dao.noticeDelete(notice_num, mgr_num);
			System.out.println(notice_num+"번 공지사항 삭제 완료");
			
			out.println("<script>");
			out.println("alert('삭제되었습니다.');");
			out.println("location.href='./NoticeList.no';");
			out.println("</script>");
			
			return null;

		}
			out.println("<script>");
			out.println("alert('삭제 권한이 없습니다.');");
			out.println("history.back()");
			out.println("</script>");

			return null;
	}

}
