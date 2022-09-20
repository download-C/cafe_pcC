package com.pcc.board.review.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		request.setCharacterEncoding("UTF-8");
		String uploadPath = request.getRealPath("/upload");
		MultipartRequest multipartRequest 
		= new MultipartRequest(request, uploadPath, 10*1024*1024, "utf-8", new DefaultFileRenamePolicy()); 

		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");
		String mgr_num = (String)session.getAttribute("mgr_num");
		
		String review_num = multipartRequest.getParameter("review_num");
		String name = multipartRequest.getParameter("name");
		String review_password = multipartRequest.getParameter("review_password");
		String review_subject = multipartRequest.getParameter("review_subject");
		String review_content = multipartRequest.getParameter("review_content");
		String review_oldfile = multipartRequest.getParameter("review_oldfile");
		
				
		ReviewDAO dao = new ReviewDAO();
		ReviewDTO dto = dao.getReviewContent(Integer.parseInt(review_num)); 
		dto.setName(name);
		dto.setReview_password(Integer.parseInt(review_password));
		dto.setReview_subject(review_subject);
		dto.setReview_content(review_content);
		
		if(mem_num != null) {
			if(multipartRequest.getFilesystemName(review_oldfile) != null ) {
			dto.setReview_file(review_oldfile);
		}
			dao.ReviewUpdate(dto, Integer.parseInt(mem_num));
			
			dao.alert(response, "리뷰 수정에 성공하였습니다.", "location.href='./ReviewContent.rv?review_num="+review_num+"&pageNum=1';");
			
			return null;
			
		
		} else if(mgr_num != null) {
			dao.ReviewUpdate(dto);
			
			dao.alert(response, "리뷰 수정에 성공하였습니다.", "location.href='./ReviewContent.rv?review_num="+review_num+"&pageNum=1';");
			
			return null;
		}
		
		return null;
	}

}
