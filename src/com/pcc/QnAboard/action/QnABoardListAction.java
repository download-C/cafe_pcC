package com.pcc.QnAboard.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.QnAboard.db.QnABoardDAO;
import com.pcc.QnAboard.db.QnABoardDTO;

import qna.action.Action;
import vo.ActionForward;

public class QnABoardListAction implements Action{

	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
	System.out.println(" M : QnABoardList_execute() 호출 ");
	
	// QnABoardDAO 객체 생성
	QnABoardDAO dao = new QnABoardDAO();
	
	// ---- 페이징 처리 시작
	
	// DAO에서 생성한 글 갯수 조회 메서드 호출
	int cnt = dao.getQnABoardCount();
	
	String urlPageSize = request.getParameter("pageSize");
	if(urlPageSize == null) {
		urlPageSize = "1";
	}
	int pageSize = Integer.parseInt(urlPageSize);
	
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null) {
		pageNum = "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);
	
	int startRow = (currentPage-1)*pageSize+1;
	
	int endRow = currentPage * pageSize;

	// ---- 페이징 처리 끝
	
	List<QnABoardDTO> qnaboardlist = dao.getQnABoardList(startRow, pageSize);
	
	System.out.println(" M : 게시판 글 정보 저장 완료했습니다. ");
	
	// ---- 두번째 페이징 처리 시작
	
	int pageCount = cnt/pageSize + (cnt%pageSize == 0? 0:1);
	
	int pageBlock = 3;
	
	int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
	
	int endPage = startPage + pageBlock -1;
	if(endPage>pageCount) {
		endPage = pageCount;
	}

	// ---- 두번째 페이징 처리 끝
	
	request.setAttribute("qnaboardlist", qnaboardlist);
	
	ActionForward forward = new ActionForward();
	
	forward.setPath("./QnA/QnABoardListAll.jsp");
	forward.setRedirect(false);
	
	return forward;
	
	}
}
