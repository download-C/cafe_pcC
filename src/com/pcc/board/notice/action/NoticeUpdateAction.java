package com.pcc.board.notice.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.notice.db.NoticeDAO;
import com.pcc.board.notice.db.NoticeDTO;
import com.pcc.member.db.MemberDAO;

import action.Action;
import vo.ActionForward;

public class NoticeUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		System.out.println("한글 처리 완료");
		
		
		NoticeDAO dao = new NoticeDAO();
		String pageNum = request.getParameter("pageNum");
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		NoticeDTO dto = new NoticeDTO();
		dto.setNotice_num(notice_num);
		dto.setNotice_subject(request.getParameter("notice_subject"));
		dto.setNotice_content(request.getParameter("notice_content"));
		dto.setNotice_file(request.getParameter("notice_file"));
		System.out.println("noticeUpdateForm.jsp 파라미터값 DTO에 저장 완료");
		System.out.println("==============================");

		ActionForward forward = new ActionForward();
		int result = dao.NoticeUpdate(dto, notice_num);
		
	// 자바에서 JS 호출하기 (request와 response가 있는 Action 페이지만 가능)
		if(result == -1){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println(	"alert('비밀번호가 다릅니다.');");
			out.println(	"history.back();");
			out.println("</script>");
			// 이미 페이지가 이동했기 때문에 html과 연결을 끊어야 함. 
			out.close();
			
			return null; // 컨트롤러로 이동하지 않음.
			
		} else if(result == 0){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println(	"alert('글이 없습니다.');");
			out.println(	"history.back();");
			out.println("</script>");
			// 이미 페이지가 이동했기 때문에 html과 연결을 끊어야 함. 
			out.close();
			
			return null; // 컨트롤러로 이동하지 않음.
			
		} else {
			request.setAttribute("dto", dto);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("notice_num", notice_num);
			
			MemberDAO daoM = new MemberDAO();
			daoM.alert(response, "공지사항을 수정했습니다.", 
					"location.href='./NoticeContent.no?notice_num="+notice_num+"&pageNum="+pageNum+"';");
			response.setContentType("text/html; charset=UTF-8");

			return null;
		}
		
		
	}

}
