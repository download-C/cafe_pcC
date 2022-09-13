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
	
	QnABoardDAO dao = new QnABoardDAO();
	int cnt = dao.getQnABoardCount();

	System.out.println(" M : 게시판 글 정보 저장 완료 ");

			
	// 페이징처리 1. DB 정보 호출 -------------------------------
	
	
	String urlPageSize = "5";
	
	urlPageSize = request.getParameter("pageSize");
	if(urlPageSize == null) {
		urlPageSize = "5";
	}
	
	int pageSize = Integer.parseInt(urlPageSize);
	
	String pageNum = request.getParameter("pageNum");
	if(pageNum == null) {
		pageNum = "1";
	}
	
	int currentPage = Integer.parseInt(pageNum);
	int startRow = (currentPage -1)*pageSize+1;
	int endRow = currentPage*pageSize;
	
	// 페이징처리 2. 목록 하단에 페이지 이동 버튼 만들기 -------------------------------
	List<QnABoardDTO> qnaboardlist = dao.getQnABoardList(startRow, pageSize);
	
	
	int pageCount = (cnt/pageSize)+(cnt%pageSize==0 ? 0:1);
	int pageBlock = 5;
	int startPage = ((currentPage-1)/pageBlock)*pageBlock+1;
	int endPage = startPage+pageBlock-1;
	
	if(endPage>pageCount) endPage=pageCount;
	
	request.setAttribute("qnaboardlist", qnaboardlist);
	request.setAttribute("pageNum", pageNum);
	request.setAttribute("cnt", cnt);
	request.setAttribute("pageBlock", pageBlock);
	request.setAttribute("pageCount", pageCount);
	request.setAttribute("startPage", startPage);
	request.setAttribute("endPage", endPage);
	System.out.println( "페이징 처리 완료" );
	
	
	ActionForward forward = new ActionForward();
	forward.setPath("./QnA/QnABoardListAll.jsp");
	forward.setRedirect(false);
	
	return forward;

		}
	
	}