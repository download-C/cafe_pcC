package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		String review_num = request.getParameter("review_num");
		
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = dao.getReviewContent(Integer.parseInt(review_num));
		System.out.println(review_num+"번 글의 정보 : "+dto);
		
		request.setAttribute("dto", dto);
		request.setAttribute("review_num", review_num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./review/reviewUpdateForm.jsp");
		forward.setRedirect(false);
		return forward;
		
//		dao.alert(response, "비밀번호가 일치하여 리뷰 수정 페이지로 이동합니다.", 
//				"location.href='./ReviewUpdateForm.rv?review_num="+review_num+"&pageNum=1';");
//		
//		return null;
	}

}
