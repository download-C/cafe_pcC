package com.pcc.QnAboard.action;

import java.io.IOException;
import java.nio.channels.ClosedByInterruptException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.digester.SystemPropertySource;

import qna.action.Action;
import vo.ActionForward;

public class QnAFrontController extends HttpServlet {
	
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
		// 2. 가상주소 매핑 (web.xml에 적혀있는 대로 .bo로 끝나는 주소 사용) -------------
		// 2-1. 페이지 이동 정보를 담을 Action과 ActionForward 객체 생성
		Action action = null; 	
		ActionForward forward = null;
		
// ----------------- URI에 따른 if(command.equals(""))-else 문 생성 자리 시작----------------
		
//		if(command.equals("/QnAWrite.bo")) {
//			//action = new QnAWriteMemberInfo();
//			// 회원번호
//			forward = new ActionForward();
//			forward.setPath("QnAWriteForm.bo");
//			forward.setRedirect(false);
//		}
// ▲ 로그인 한 회원의 세션 아이디(회원번호)를 이용해 개인정보를 갖고 오는 메서드
		
		// 2-1. 공지사항 글 쓰기 양식
		if(command.equals("/QnAWriteForm.bo")) {
			forward = new ActionForward();
			forward.setPath("./QnA/QnAWriteForm.jsp");
			forward.setRedirect(false);
			System.out.println(" QnAWriteForm.bo 가상 주소로 이동 ");
		}
		
		// 2-2. 공지사항 글 DB에 올리기
		else if (command.equals("/QnAWriteAction.bo")) {
			System.out.println(" C : /QnAWriteAction.bo 호출 ");
			action = new QnAWriteAction();
			try	{
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		// 2-2. 문의사항 작성한 글 페이지로 넘어가기 
			else if(command.equals("/QnAContent.bo")) {
				System.out.println( " C : QnAContent.bo 호출 ");
				action = new QnAContentAction();					
				try {
					forward = action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			

		// 2-3. QnA게시판 목록으로 이동
		 
			else if (command.equals("/QnABoardList.bo")) {
				System.out.println(" C : QnABoardList.bo 호출 ");
				System.out.println(" C : DB정보가 필요함, 페이지 이동 X, 해당 페이지 출력O ");
				
				 action = new QnABoardListAction();
		try {
			System.out.println(" C : 해당 Model 객체 호출 ");
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
				}
			}
		
		// 2-4. 선택한 문의사항 내용 보기
//		else if (command.equals("/QnAContent.bo")) {
//			action = new QnAContentAction();
//			try {
//				forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
			


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
