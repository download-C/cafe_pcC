package com.pcc.board.notice.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pcc.member.db.MemberDAO;

import action.Action;
import vo.ActionForward;

public class NoticeFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 방식, POST 방식 호출 - doGet(), doPost() 실행");
		
		System.out.println("--------- 1. 가상 주소 계산 시작 ---------");
// 1. servlet 파일이 들어있는 프로젝트명 (== 가상주소) 계산 ---------------------
			
			// 1-1. URI 불러오기
			String requestURI = request.getRequestURI();
			System.out.println(" Controller : requestUIR = "+requestURI);
			// 1-2. context Path 불러오기
			String ctxPath = request.getContextPath();
			System.out.println(" Controller : ctxPath = "+ctxPath);
			// 1-3. URI를 context Path 길이만큼 자르기
			String command = requestURI.substring(ctxPath.length());
			System.out.println(" Controller : command = "+command);
		
		System.out.println("--------- 1. 가상 주소 계산 완료 ---------");
		System.out.println();
		
		System.out.println("--------- 2. 가상 주소 매핑 시작 ---------");
// 2. 가상주소 매핑 (web.xml에 적혀있는 대로 .no로 끝나는 주소 사용) -------------
		// 2-1. 페이지 이동 정보를 담을 Action과 ActionForward 객체 생성
		Action action = null; 	
		ActionForward forward = null;
		
// ----------------- URI에 따른 if(command.equals(""))-else 문 생성 자리 시작----------------
		// 2-1. 공지사항 글 쓰기 양식
		if(command.equals("/NoticeWrite.no")) {
			HttpSession session = request.getSession();
			String MgrID = (String) session.getAttribute("mgr_num"); 
			if(MgrID != null) {
				forward = new ActionForward();
				forward.setPath("./notice/noticeWriteForm.jsp");
				forward.setRedirect(false);
			} else {
				MemberDAO dao = new MemberDAO();
				dao.alert(response, "권한이 없습니다.", "history.back();");
			}
			
		}
		// 2-2. 공지사항 글 DB에 올리기
		else if(command.equals("/NoticeWriteAction.no")) {
//			System.out.println(command);
			action = new NoticeWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 2-3. 공지사항 목록 불러오기
		else if(command.equals("/NoticeList.no")) {
			action = new NoticeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 2-4. 선택한 공지사항 내용 보기
		else if(command.equals("/NoticeContent.no")){
			action = new NoticeContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 2-5. 공지사항 수정 정보 불러오기
		else if(command.equals("/NoticeUpdate.no")) {
			action = new NoticeUpdate();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

//		else if(command.equals("/NoticeUpdateForm.no")){
//			action = new NoticeUpdateFormAction();
//			try {
//				forward = new ActionForward();
//				forward.setPath("./notice/noticeUpdateForm.jsp");
//				forward.setRedirect(false);
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		// 2-6. 공지사항 수정 정보 DB에 반영하기
		else if(command.equals("/NoticeUpdateAction.no")){
			action = new NoticeUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 2-7. 공지사항 삭제하기
		else if(command.equals("/NoticeDelete.no")){
			action = new NoticeDelete();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/NoticeDeleteCheck.no")){
			action = new NoticeDeleteCheck();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		
		
		
		
// ----------------- URI에 따른 if(command.equals(""))-else 문 생성 자리 끝----------------
		System.out.println("--------- 2. 가상 주소 매핑 완료 ---------");
		System.out.println();
		
		System.out.println("--------- 3. 가상 주소 이동 시작 ---------");
// 3. 가상주소 이동 (페이지 정보에 따라 이동 방법을 sendRedirect(true), forward(false)로 정해줌
		if(forward != null) {
			System.out.println("forward는 null이 아닙니다");
			// 3-1. sendRedirect 방식 (DB 연동으로 이동정보를 보낼 때)
			if(forward.isRedirect()) {
				System.out.println(" Controller : true");
				System.out.println(forward.getPath()+" 이동");
				System.out.println("방식 : sendRedirect() 방식");
				response.sendRedirect(forward.getPath());
			
			// 3-2. forward 방식 (DB 연동 없이 페이지만 전환할 때)
			} else {
				System.out.println(" Controller : false");
				System.out.println(forward.getPath()+" 이동");
				System.out.println("방식 : forward() 방식");
				RequestDispatcher dis 
				= request.getRequestDispatcher(forward.getPath());
				System.out.println("dis 성공!");
				dis.forward(request, response);
				System.out.println("forward 성공!");
			}
		}
		System.out.println("--------- 3. 가상 주소 이동 완료 ---------");
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}
	
	

}
