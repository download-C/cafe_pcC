package com.pcc.board.qna.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class QnAPasswordCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		int mem_num = Integer.parseInt((String)session.getAttribute("mem_num"));
		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
		int qna_password = Integer.parseInt(request.getParameter("qna_password")); 
		
		ReviewDTO dto = new ReviewDTO();
		ReviewDAO dao = new ReviewDAO();
		dto = dao.getReviewContent(qna_num);
		System.out.println(qna_num+"번 글의 비밀번호 : "+ dto.getReview_password());
		
		if(qna_password == dto.getReview_password()) {
//			dao.ReviewDelete(session, review_num, mem_num, review_password);
//			
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('삭제되었습니다');");
//			out.println("loaction.href='./ReviewList.qna'");
//			out.println("</script>");
			
			String button = request.getParameter("button");
//			System.out.println("button : "+button);
			
			if(button.equals("update")) {
//				ActionForward forward = new ActionForward();
//				forward.setPath("/ReviewUpdate.qna?review_num="+review_num);
//				forward.setRedirect(true);
//				System.out.println("글 수정을 위한 정보 불러오기 필요");
//				return forward;
				dao.alert(response, "비밀번호가 일치하여 문의사항 수정 페이지로 이동합니다.", 
						"location.href='./QnAUpdate.qna?qna_num="+qna_num+"&pageNum=1';");
				return null;
			} else if(button.equals("delete")) {
//				ActionForward forward = new ActionForward();
//				forward.setPath("./QnADelete.qna?qna_num="+qna_num);
//				forward.setRedirect(true);
//				return forward;
				
				dao.alert(response, "비밀번호가 일치하여 글을 삭제합니다.", 
						"location.href='./QnADelete.qna?qna_num="+qna_num+"';");
				
				return null;
			}
		} else {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('비밀번호가 다릅니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return null;
	}

}
