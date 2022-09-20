package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewPasswordFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		String mgr_num = (String)session.getAttribute("mgr_num");
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = dao.getReviewContent(review_num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("review_num", review_num);
		
		ActionForward forward = new ActionForward();
		System.out.println("세션값에 따른 페이지 이동");
		if(mem_num != null){
			forward.setPath("./review/reviewReplyForm.jsp");
			forward.setRedirect(false);
			
			return forward;
		} else if(mgr_num != null) {
			forward.setPath("/ReviewPasswordCheck.rv?review_num="+review_num);
			forward.setRedirect(true);
			return forward;
			
		}
		return null;
	}

}
