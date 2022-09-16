package com.pcc.board.review.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewPasswordCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int mem_num = Integer.parseInt((String)session.getAttribute("mem_num"));
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		int review_password = Integer.parseInt(request.getParameter("review_password")); 
		
		ReviewDTO dto = new ReviewDTO();
		ReviewDAO dao = new ReviewDAO();
		dto = dao.getReviewContent(review_num);
		
		if(review_password == dto.getReview_password()) {
			dao.ReviewDelete(session, review_num, mem_num, review_password);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제되었습니다');");
			out.println("loaction.href='./ReviewList.rv'");
			out.println("</script>");
			
			return null;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('비밀번호가 다릅니다.');");
		out.println("history.back();");
		out.println("</script>");
		
		return null;
	}

}
