package com.pcc.board.review.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		// 0. BoardDAO 객체 생성 후 필요한 정보 불러오기
		ReviewDAO dao = new ReviewDAO();
		int cnt = dao.getReviewCount();

		// 페이징 처리 1. DB 정보 호출 -------------------------------------

		String urlPageSize = "10";

		urlPageSize = request.getParameter("pageSize");
		if (urlPageSize == null) {
			urlPageSize = "10";
		}

		int pageSize = Integer.parseInt(urlPageSize);
//		System.out.println("페이지 사이즈 : "+pageSize);

		String pageNum = request.getParameter("pageNum");
//		System.out.println("페이지 번호 : "+pageNum);
		if (pageNum == null) {
			pageNum = "1";
		}
//		System.out.println("페이지 번호 : "+pageNum);

		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;

		// 페이징 처리 2. 목록 하단에 페이지 이동 버튼 만들기 ---------------
		List<ReviewDTO> reviewList = dao.getReviewList(startRow, pageSize);

		int pageCount = (cnt/pageSize)+(cnt%pageSize==0 ? 0:1);
		int pageBlock = 5;
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage+pageBlock-1;

		if(endPage>pageCount) endPage=pageCount;
		System.out.println("페이징 처리 완료");

		request.setAttribute("reviewList", reviewList);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cnt", cnt);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		ActionForward forward = new ActionForward();
		forward.setPath("./review/reviewList.jsp");
		forward.setRedirect(false);
		System.out.println("reviewList.jsp로 이동");
		return forward;
	}

}
