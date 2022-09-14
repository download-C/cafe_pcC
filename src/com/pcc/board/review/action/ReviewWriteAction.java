package com.pcc.board.review.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("ReviewWriteAction_execute() 호출");
		request.setCharacterEncoding("UTF-8");
		System.out.println("한글 처리");
		HttpSession session = request.getSession();
		String mgr_num = (String)session.getAttribute("mgr_num");
		if(mgr_num != null) {
			
			int review_password = Integer.parseInt(request.getParameter("review_password"));
			String review_subject = request.getParameter("review_subject");
			String review_content = request.getParameter("review_content");
			String review_file = request.getParameter("review_file");
			
			ReviewDTO dto = new ReviewDTO();
		
			dto.setMgr_num(Integer.parseInt(mgr_num));
			dto.setReview_password(review_password);
			dto.setReview_subject(review_subject);
			dto.setReview_content(review_content);
			dto.setReview_file(review_file);
			
			System.out.println("DTO:"+dto);
			ReviewDAO dao = new ReviewDAO();
			int review_num = dao.managerReviewWrite(dto);
			dto = dao.getReviewContent(review_num);
			System.out.println("dto: "+dto);
			request.setAttribute("dto", dto);
			if(Integer.toString(dto.getMgr_num()) != null) {
				request.setAttribute("name", "관리자");
			}
			
			ActionForward forward = new  ActionForward();
			forward.setPath("/ReviewContent.rv?review_num="+review_num+"&pageNum=1");
			forward.setRedirect(false);
			System.out.println("ActionForward 성공");
			return forward;
			
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('접근 권한이 없습니다');");
			out.println("history.back();");
			out.println("</script>");
			return null;
		}
	}

}
