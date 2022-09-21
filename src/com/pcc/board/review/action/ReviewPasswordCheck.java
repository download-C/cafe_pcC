package com.pcc.board.review.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewPasswordCheck implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		String mgr_num = (String)session.getAttribute("mgr_num");
		int review_num = Integer.parseInt(request.getParameter("review_num"));
		
		ReviewDTO dto = new ReviewDTO();
		ReviewDAO dao = new ReviewDAO();
		dto = dao.getReviewContent(review_num);
		
		System.out.println("회원 번호 : "+mem_num+", 매니저 번호 : "+mgr_num);
//			dao.ReviewDelete(session, review_num, mem_num, review_password);
//			
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>");
//			out.println("alert('삭제되었습니다');");
//			out.println("loaction.href='./ReviewList.rv'");
//			out.println("</script>");
			
			String button = request.getParameter("button");
//			System.out.println("button : "+button);
			
			// 업데이트 버튼 눌렀을 때
			if(button.equals("update")) {
				if(mem_num != null) {
					int review_password = Integer.parseInt(request.getParameter("review_password")); 
					if(review_password == dto.getReview_password()) {
	//				ActionForward forward = new ActionForward();
	//				forward.setPath("/ReviewUpdate.rv?review_num="+review_num);
	//				forward.setRedirect(true);
	//				System.out.println("글 수정을 위한 정보 불러오기 필요");
	//				return forward;
						dao.alert(response, "비밀번호가 일치하여 리뷰 수정 페이지로 이동합니다.", 
								"location.href='./ReviewUpdate.rv?review_num="+review_num+"';");
						return null;
					} else {
						dao.alert(response, "비밀번호가 다릅니다.", 
								"location.href='history.back()';");
					}	
				} else if(mgr_num != null) {
					dao.alert(response, "관리자이므로 비밀번호 없이 리뷰 수정 페이지로 이동합니다.", 
							"location.href='./ReviewUpdate.rv?review_num="+review_num+"';");
					return null;
				}
			// 삭제 버튼 눌렀을 때 
			} else if(button.equals("delete")) {
				
				if(mem_num != null) {
					int review_password = Integer.parseInt(request.getParameter("review_password")); 
					if(review_password == dto.getReview_password()) {
	//				ActionForward forward = new ActionForward();
	//				forward.setPath("/ReviewUpdate.rv?review_num="+review_num);
	//				forward.setRedirect(true);
	//				System.out.println("글 수정을 위한 정보 불러오기 필요");
	//				return forward;
						dao.alert(response, "비밀번호가 일치하여 리뷰를 삭제합니다.", 
								"location.href='./ReviewDelete.rv?review_num="+review_num+"';");
						return null;
					} else {
						dao.alert(response, "비밀번호가 다릅니다.", 
								"location.href='history.back()';");
						return null;
					}	
				} else if(mgr_num != null) {
					dao.alert(response, "관리자이므로 비밀번호 입력 없이 리뷰를 삭제합니다.", 
							"location.href='./ReviewDelete.rv?review_num="+review_num+"';");
					return null;
				}
				
			} else {
				dao.alert(response, "로그인이 필요합니다.", "location.href='./Login.pcc';");
			}
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('비밀번호가 다릅니다.');");
		out.println("history.back();");
		out.println("</script>");
		
		return null;
	}

}
