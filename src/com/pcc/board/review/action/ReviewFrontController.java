package com.pcc.board.review.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

public class ReviewFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 방식, POST 방식 호출 - doGet(), doPost() 실행");
		
		System.out.println("---------------- 1. 가상 주소 계산 시작 ----------------");
// 1. servlet 파일이 들어있는 프로젝트명 (== 가상주소) 계산 ---------------------
			
			// 1-1. URI 불러오기
			String requestURI = request.getRequestURI();
//			System.out.println(" Controller : requestUIR = "+requestURI);
			// 1-2. context Path 불러오기
			String ctxPath = request.getContextPath();
//			System.out.println(" Controller : ctxPath = "+ctxPath);
			// 1-3. URI를 context Path 길이만큼 자르기
			String command = requestURI.substring(ctxPath.length());
			System.out.println(" Controller : command = "+command);
		
		System.out.println("----------------- 1. 가상 주소 계산 완료 ----------------");
		System.out.println();
		
		System.out.println("---------------- 2. 가상 주소 매핑 시작 ----------------");
// 2. 가상주소 매핑 (web.xml에 적혀있는 대로 .bo로 끝나는 주소 사용) -------------
		// 2-1. 페이지 이동 정보를 담을 Action과 ActionForward 객체 생성
		Action action = null; 	
		ActionForward forward = null;
		
// ----------------- URI에 따른 if(command.equals(""))-else 문 생성 자리 시작----------------
	
		// 2-1. 리뷰 작성 페이지로 이동
		if(command.equals("/ReviewWrite.rv")) {
			action = new ReviewWrite();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		// 2-2. 리뷰 내용 DB에 저장
		else if(command.equals("/ReviewWriteAction.rv")) {
			action = new ReviewWriteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		// 2-3. 리뷰 목록 불러오기
		else if(command.equals("/ReviewList.rv")){
			action = new ReviewListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		// 2-4. 리뷰 내용 불러오기
		else if(command.equals("/ReviewContent.rv")) {
			action = new ReviewContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// 2-5. 리뷰 수정/삭제 버튼 눌렀을 때 비밀번호 입력 폼으로 연결
		else if(command.equals("/ReviewPasswordForm.rv")) {
			String button = request.getParameter("button");
			System.out.println(button);
			request.setAttribute("button", button);
			forward = new ActionForward();
			forward.setPath("./review/reviewPassword.jsp");
			forward.setRedirect(false);
		}
		// 2-6. 비밀번호 입력 시 DB와 일치 여부 확인
		else if(command.equals("/ReviewPasswordCheck.rv")) {
			action = new ReviewPasswordCheck();
			try{
				forward = action.execute(request, response);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		// 2-7. 리뷰 수정 페이지로 이동
		else if(command.equals("/ReviewUpdate.rv")){
			action = new ReviewUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(command.equals("/ReviewUpdateForm.rv")){
			forward = new ActionForward();
			forward.setPath("./review/reviewUpdateForm.jsp");
			forward.setRedirect(false);
		}
		
		// 2-7. 수정된 리뷰 DB에 저장하기
		else if(command.equals("/ReviewUpdateAction.rv")) {
			action = new ReviewUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		// 2-8. 리뷰 내용 삭제하기
		else if(command.equals("/ReviewDelete.rv")) {
			action = new ReviewDelete();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// 2-9. 매니저 리뷰 답글 적는 페이지 이동
		else if(command.equals("/ReviewReplyForm.rv")){
			action = new ReviewReplyFormAction();
			try{
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 2-10. 매니저 리뷰 답글 달기
		else if(command.equals("/ReviewReply.rv")) {
			action = new ReviewReplyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

// ----------------- URI에 따른 if(command.equals(""))-else 문 생성 자리 끝----------------
		System.out.println("---------------- 2. 가상 주소 매핑 완료 ----------------");
		System.out.println();
		
		System.out.println("---------------- 3. 가상 주소 이동 시작 ----------------");
// 3. 가상주소 이동 (페이지 정보에 따라 이동 방법을 sendRedirect(true), forward(false)로 정해줌
		if(forward != null) {
			// 3-1. sendRedirect 방식 (DB 연동으로 이동정보를 보낼 때)
			if(forward.isRedirect()) {
				System.out.println(" Controller : true");
				System.out.println(forward.getPath()+" 이동");
				System.out.println("방식 : sendRedirect() 방식");
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				System.out.println("des.forward() 성공!");
				dis.forward(request, response);
			
			// 3-2. forward 방식 (DB 연동 없이 페이지만 전환할 때)
			} else {
				System.out.println(" Controller : false");
				System.out.println(forward.getPath()+" 이동");
				System.out.println("방식 : forward() 방식");
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
		System.out.println("---------------- 3. 가상 주소 이동 완료 ----------------");
		System.out.println();
		System.out.println();
		System.out.println();
		
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
