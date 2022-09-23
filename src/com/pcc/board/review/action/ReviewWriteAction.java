package com.pcc.board.review.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pcc.board.review.db.ReviewDAO;
import com.pcc.board.review.db.ReviewDTO;

import action.Action;
import vo.ActionForward;

public class ReviewWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		System.out.println("ReviewWriteAction_execute() 호출");
		
		// 파일 업로드 프로그램 설치 후 사용.
		
		String uploadPath = request.getRealPath("/upload");
		MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath , 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		ReviewDAO dao = new ReviewDAO();
		
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String mem_num = (String)session.getAttribute("mem_num");	
		String name = multipartRequest.getParameter("name");
		String review_password = multipartRequest.getParameter("review_password");
		String review_subject = multipartRequest.getParameter("review_subject");
		String review_content = multipartRequest.getParameter("review_content");
		String review_file = multipartRequest.getFilesystemName("review_file");
											  // 업로드된 파일의 진짜 이름
		
		ReviewDTO dto = new ReviewDTO();
		
		System.out.println(review_password);
		if(mem_num != null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
			if(review_password == "") {
				out.println("<script>");
				out.println("alert('비밀번호를 입력해주세요');");
				out.println("history.back();");
				out.println("</script>");
			}
			
			dto.setMem_num(Integer.parseInt(mem_num)); 		// 세션값 회원번호
			dto.setName(name);						// 회원이름
			dto.setReview_password(Integer.parseInt(review_password)); //  비밀번호
			dto.setReview_subject(review_subject);			// 제목
			dto.setReview_content(review_content);			// 내용
			dto.setReview_file(review_file);				// 파일
			dto.setReview_ip(request.getRemoteAddr());	// 아이피
			dto.setReview_file(review_file);				// 파일 이름
			
			
			int review_num = dao.reviewWrite(dto);
//			System.out.println("DTO:"+dto);
			dto = dao.getReviewContent(review_num);
//			System.out.println("dto: "+dto);
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
