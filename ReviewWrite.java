package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewWrite implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		if(mem_num != null) {
		
			int review_password = Integer.parseInt(request.getParameter("review_password"));
			String review_subject = request.getParameter("review_subject");
			String review_content = request.getParameter("review_content");
			String review_file = request.getParameter("review_file");
			
			ReviewDTO dto = new ReviewDTO();
			dto.setReview_password(review_password);
			dto.setReview_subject(review_subject);
			dto.setReview_content(review_content);
			dto.setReview_file(review_file);
			
			ReviewDAO dao = new ReviewDAO();
			review_num = dao.reviewWrite(dto);
		
			ActionForward forward = new ActionForward();
			forward.setPath("./ReviewContent.rv?review_num="+review_num+"&pageNum=1");
			return forward;

		}
		return null;
	}

}
