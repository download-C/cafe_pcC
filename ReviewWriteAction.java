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
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		
		if(mem_num != null) {
			String review_password = request.getParameter("review_password");
			if(review_password == "") {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호를 입력해주세요');");
				out.println("history.back();");
				out.println("</script>");
			}
			String review_name = request.getParameter("review_name");
			String review_subject = request.getParameter("review_subject");
			String review_content = request.getParameter("review_content");
			String review_file = request.getParameter("review_file");
			
			ReviewDTO dto = new ReviewDTO();
			
			dto.setMem_num(Integer.parseInt(mem_num));
			dto.setReview_name(review_name);
			dto.setReview_password(Integer.parseInt(review_password));
			dto.setReview_subject(review_subject);
			dto.setReview_content(review_content);
			dto.setReview_file(review_file);
			
			ReviewDAO dao = new ReviewDAO();
			int review_num = dao.reviewWrite(dto);
			System.out.println("DTO:"+dto);
			dto = dao.getReviewContent(review_num);
			System.out.println("dto: "+dto);
			request.setAttribute("dto", dto);
			
//			ActionForward forward = new  ActionForward();
//			forward.setPath("/ReviewContent.rv?review_num="+review_num+"&pageNum=1");
//			forward.setRedirect(false);
//			System.out.println("ActionForward 성공");
			
			dao.alert(response, "리뷰가 작성되었습니다.", "location.href='./ReviewContent.rv?review_num="+review_num+"&pageNum=1';");
			return null;
			
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
