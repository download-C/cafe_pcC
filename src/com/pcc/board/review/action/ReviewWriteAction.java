package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;
import com.sun.prism.paint.Stop;

import action.Action;
import vo.ActionForward;

public class ReviewWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("ReviewWriteAction_execute() 호출");
		request.setCharacterEncoding("UTF-8");
		System.out.println("한글 처리");
		
		int review_password = Integer.parseInt(request.getParameter("review_password"));
		String review_subject = request.getParameter("review_subject");
		String review_content = request.getParameter("review_content");
		String review_file = request.getParameter("review_file");
		
		ReviewDTO dto = new ReviewDTO();
		
		dto.setReview_password(review_password);
		dto.setReview_subject(review_subject);
		dto.setReview_content(review_content);
		dto.setReview_file(review_file);
		
		System.out.println("DTO:"+dto);
		ReviewDAO dao = new ReviewDAO();
		dao.reviewWrite(dto);
		
		
		ActionForward forward = new  ActionForward();
		forward.setPath("./ReviewContent.rv?review_num="+dto.getReview_num());
		forward.setRedirect(true);
		
		return forward;
	}

}
