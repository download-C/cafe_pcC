package com.pcc.QnAboard.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.QnAboard.db.QnABoardDAO;
import com.pcc.QnAboard.db.QnABoardDTO;

import qna.action.Action;
import vo.ActionForward;

//public class QnABoardListAction implements Action{

//	public ActionForward execute(HttpServletRequest request, 
//			HttpServletResponse response) throws Exception {
//		
//	System.out.println(" M : QnABoardList_execute() 호출 ");
//	
//	QnABoardDAO dao = new QnABoardDAO();
//	int cnt = dao.getQnABoardCount();
//	
//	// 페이징처리 1. DB 정보 호출 -------------------------------
//	
//	String urlPageSize = "5";
//	
//	
//	
//	}
//}
