package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;
import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;
import com.pcc.member.db.MemberDAO;

import action.Action;
import vo.ActionForward;

public class ReviewContentAction implements Action {

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("ReviewContent_execute() 호출");
		
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		String mgr_num = (String)session.getAttribute("mgr_mum");
		
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		String pageNum = (String)request.getAttribute("pageNum");
		
		if (pageNum == null) {
			pageNum = "1";
//			System.out.println("pageNum : " + pageNum);
		}
		
		if(mem_num != null) {
			
			ReviewDAO dao = new ReviewDAO();
			ReviewDTO dto = dao.getReviewContent(review_num);
			System.out.println("===========================");
			System.out.println("dto:"+dto);
			System.out.println("===========================");
			if(Integer.parseInt(mem_num) != dto.getMem_num()){
				dao.updateReviewReadcount(review_num);
			System.out.println("본인이 쓴 글이 아니므로 "+review_num + "번 문의사항 조회수 1 증가 ");
			}
			//dao.getReviewReadCount(review_num);
			
			System.out.println( "DTO : " + dto );
			 
			request.setAttribute("dto", dto);
			request.setAttribute("pageNum", Integer.parseInt(pageNum));
//			System.out.println("pageNum" + pageNum);
			request.setAttribute("review_num", review_num);
//			System.out.println("pageNum : " + pageNum);		
			request.setAttribute("review_name", dto.getReview_name());
			
			ActionForward forward = new ActionForward();
			
			forward.setPath("./Review/ReviewContent.jsp");
			forward.setRedirect(false);
			
			return forward;
			
		} else if (mgr_num != null) {
			ReviewDTO dto = new ReviewDTO();
			
			ReviewDAO dao = new ReviewDAO();
			dto = dao.getReviewContent(review_num);

			System.out.println( "DTO : " + dto );
			 
			request.setAttribute("dto", dto);
			request.setAttribute("pageNum", Integer.parseInt(pageNum));
			request.setAttribute("review_num", review_num);
			request.setAttribute("rmn", Integer.toString(dto.getMem_num()));
			
			ActionForward forward = new ActionForward();
			
			forward.setPath("./Review/ReviewContent.jsp");
			forward.setRedirect(false);
			
			return forward;
			
		} else {
			MemberDAO dao = new MemberDAO();
			dao.alert(response, "로그인 후 이용 가능합니다.", "location.href='./LoginForm.me';");
			return null;
		}
	}
}