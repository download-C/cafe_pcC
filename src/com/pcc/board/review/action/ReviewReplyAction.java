package com.pcc.board.review.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 한글 처리
		String uploadPath = request.getRealPath("/upload");
		MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath , 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		ReviewDAO dao = new ReviewDAO();
		
		// 매니저 로그인 여부 확인
		HttpSession session = request.getSession();
		String mgr_num = (String)session.getAttribute("mgr_num");
		if(mgr_num != null) {
			int review_num = Integer.parseInt(multipartRequest.getParameter("review_num"));
			int review_password = Integer.parseInt(multipartRequest.getParameter("review_password"));
			String review_subject = multipartRequest.getParameter("review_subject");
			String review_content = multipartRequest.getParameter("review_content");
			String review_file = multipartRequest.getParameter("review_file");
			String review_ip = request.getRemoteAddr();
			
	
			ReviewDTO dto = new ReviewDTO();
			dto.setMgr_num(Integer.parseInt(mgr_num));
			dto.setReview_password(review_password);
			dto.setReview_subject(review_subject);
			dto.setReview_content(review_content);
			dto.setReview_ip(review_ip);
			dto.setReview_file(review_file);
			
			review_num = dao.reviewReply(review_num, dto);
			
			request.setAttribute("dto", dto);
		
			ActionForward forward = new ActionForward();
			forward.setPath("/ReviewContent.rv?review_num="+review_num+"&pageNum=1");
			forward.setRedirect(true);
			return forward;
		}
	return null;
	}
}
