//package com.pcc.QnAboard.action;
//
//import java.io.PrintWriter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.pcc.QnAboard.db.QnABoardDAO;
//import com.pcc.QnAboard.db.QnABoardDTO;
//import com.sun.corba.se.impl.protocol.BootstrapServerRequestDispatcher;
//
//import qna.action.Action;
//import vo.ActionForward;
//
//public class QnADeleteAction implements Action{
//
//	public ActionForward execute(HttpServletRequest request, 
//			HttpServletResponse response) throws Exception {
//		
//		System.out.println(" M : QnADeleteAction_execute() 메서드 호출됨 ");
//		
//		int qna_num = Integer.parseInt(request.getParameter("qna_num"));
//		System.out.println("qna_num : " + qna_num);
//		String pageNum = request.getParameter("pageNum");
//		System.out.println("pageNum : " + pageNum);
//		int qna_password = Integer.parseInt(request.getParameter("qna_password"));
//		System.out.println("qna_password : " + qna_password);
//		
//		QnABoardDAO dao = new QnABoardDAO();
//		
//		QnABoardDTO dto = dao.getBoard(qna_num);
//		System.out.println(" M : 삭제할 데이터 " + dto);
//		
//		request.setAttribute("dto", dto);
//		System.out.println("dto : " + dto);
//		request.setAttribute("qna_num", qna_num);
//		System.out.println("qna_num : " + qna_num);
//		request.setAttribute("pageNum", pageNum);
//		System.out.println("pageNum : " + pageNum);
//		request.setAttribute("qna_password", qna_password);
//		System.out.println("qna_password : " + qna_password);
//		
//		ActionForward forward = new ActionForward();
//		forward.setPath("./QnADelete.jsp");
//		forward.setRedirect(false);
//			
//		return forward;
//	}
//	
//	
//	
//
//}
