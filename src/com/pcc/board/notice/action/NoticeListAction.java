package com.pcc.board.notice.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.board.notice.db.NoticeDAO;
import com.pcc.board.notice.db.NoticeDTO;

import action.Action;
import vo.ActionForward;

public class NoticeListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

	// 0. BoardDAO 객체 생성 후 필요한 정보 불러오기
		NoticeDAO dao = new NoticeDAO();
		int cnt = dao.getNoticeCount();
		
	// 페이징 처리 1. DB 정보 호출 -------------------------------------
		
		int pageSize = 10;
		String pageNum = request.getParameter("pageNum");
		
		if (pageNum == null) {
			pageNum = "1";
		}
		
		String urlPageSize = request.getParameter("pageSize");
		if(urlPageSize == null) {
			urlPageSize = "10";
		}
		
		pageSize = Integer.parseInt(urlPageSize);
		
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1)*pageSize+1;
		int endRow = currentPage*pageSize;
		
	// 페이징 처리 2. 목록 하단에 페이지 이동 버튼 만들기 ---------------
		List<NoticeDTO> noticeList = dao.getNoticeList(startRow, pageSize);
	
		int pageCount = (cnt/pageSize)+(cnt%pageSize==0 ? 0:1);
		int pageBlock = 10;
		int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
		int endPage = startPage+pageBlock-1;
		
		if(endPage>pageCount) endPage=pageCount;
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("cnt", cnt);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		ActionForward forward = new ActionForward();
		forward.setPath("./notice/noticeList.jsp");
		forward.setRedirect(false);

		return forward;

	}

}
