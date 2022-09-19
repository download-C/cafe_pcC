package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("ReviewContent_execute() 호출");
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		String pageNum = request.getParameter("pageNum");
		
		ReviewDAO dao = new ReviewDAO();
		
		ReviewDTO dto = new ReviewDTO();
		if(mem_num != null) {
			
			dao.updateReviewReadcount(review_num);
			System.out.println(review_num+"번 리뷰글 조회수 증가");
		} 
		dto = dao.getReviewContent(review_num);	
		
		
		request.setAttribute("dto", dto);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("review_num", review_num);
		request.setAttribute("rmn", Integer.toString(dto.getMem_num()));
		
		System.out.println(dto.getMem_num());
		
		ActionForward forward = new ActionForward();
		forward.setPath("./review/reviewContent.jsp");
		forward.setRedirect(false);
		
		return forward;
				
	}

}