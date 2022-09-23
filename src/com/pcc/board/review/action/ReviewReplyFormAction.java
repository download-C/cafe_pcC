package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		String mgr_num = (String)session.getAttribute("mgr_num");
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = dao.getReviewContent(review_num);
		System.out.println(review_num+"번 글 정보 조회완료");
		
		request.setAttribute("dto", dto);
		request.setAttribute("review_num", review_num);
		
		ActionForward forward = new ActionForward();
		if(mgr_num != null){
			forward.setPath("./review/reviewReplyForm.jsp");
			forward.setRedirect(false);
			
			return forward;
		}
		return null;
	}

}
