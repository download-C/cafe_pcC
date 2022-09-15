package com.pcc.board.review.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		HttpSession session = request.getSession();
		int mgr_num = Integer.parseInt((String)session.getAttribute("mgr_num"));
		int mem_num = Integer.parseInt((String)session.getAttribute("mem_num"));
		int review_password = Integer.parseInt(request.getParameter("review_password"));
		
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = dao.getReviewContent(review_num);
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(mgr_num != 0 && mem_num ==0) {
			dao.ReviewDelete(session, review_num, mgr_num);
		} else if(mem_num != 0 && mgr_num == 0){
			dao.ReviewDelete(session, review_num, mem_num, review_password);
		} 
		
		out.println("<script>");
		out.println("alert('삭제되었습니다.';");
		out.println("location.href='./ReviewList.rv';");
		out.println("</script>");
		
		return null;
	}

}
