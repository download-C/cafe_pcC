package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = dao.getReviewContent(review_num);
		
		request.setAttribute("dto", dto);
		request.setAttribute("review_num", review_num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./review/reviewReplyForm.jsp");
		forward.setRedirect(false);
		
		return forward;
		
	}

}
