package com.pcc.board.review.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;
import com.pcc.member.db.MemberDAO;

import action.Action;
import vo.ActionForward;

public class ReviewDelete implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		if(session != null) {
			
			int review_num = Integer.parseInt(request.getParameter("review_num"));
			String mgr_num = (String)session.getAttribute("mgr_num");
			String mem_num = (String)session.getAttribute("mem_num");
			String review_password = request.getParameter("review_password");
			
			if(mgr_num == null && mem_num == null) {
				out.println("<script>");
				out.println("alert('로그인해주세요');");
				out.println("location.href='./Login.pcc';");
				out.println("</script>");
			}
			
			ReviewDAO dao = new ReviewDAO();
			ReviewDTO dto = dao.getReviewContent(review_num);
			if(mem_num != null)
			if(dto.getReview_password() == Integer.parseInt(review_password)) {
				dao.ReviewDelete(session, review_num, Integer.parseInt(mem_num));
				dao.alert(response, "글이 삭제되었습니다.", "./ReviewList.rv");
				return null;
			} else if(mgr_num != null) {
				dao.ReviewDelete(session, review_num, Integer.parseInt(mgr_num));
				out.println("<script>");
				out.println("alert('삭제되었습니다.';");
				out.println("location.href='./ReviewList.rv';");
				out.println("</script>");
				return null;
			} 
			
		} else {
			MemberDAO dao = new MemberDAO();
			dao.alert(response, "세션이 만료되어 로그인 페이지로 돌아갑니다.", "location.href='./MainPage.pcc';");
					
		}
		return null;
	}

}
