package com.pcc.product.action;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import action.Action;
import vo.ActionForward;

public class ProductFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(" GET 방식, POST 방식 호출 - doGet(), doPost() 실행");
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
		
		System.out.println("--------- 2. 가상 주소 매핑 시작 ---------");
 //2. 가상주소 매핑 (web.xml에 적혀있는 대로 .pr로 끝나는 주소 사용) -------------
		// 2-1. 페이지 이동 정보를 담을 Action과 ActionForward 객체 생성
		Action action = null; 	
		ActionForward forward = null;
		
// ----------------- URI에 따른 if(command.equals(""))-else 문 생성 자리 시작----------------
		//관리자계정 - 상품 등록 페이지
		if(command.equals("/ProductWrite.pr")){
			// 글쓰기 페이지 보여주기 (DB정보 필요없음)
			System.out.println(" C : /ProductWrite.pr 호출 ");
			System.out.println(" C : DB정보가 필요없음-view페이지로 이동 ");
			
			forward = new ActionForward();
			forward.setPath("./product/writeForm.jsp");
			forward.setRedirect(true);//디스패치 방식 -> 가상주소가 유지
		}
		
		//상품 등록 넘기기
		else if(command.equals("/ProductWriteAction.pr")){
			System.out.println(" C : /ProductWriteAction.pr 호출 ");
			
			// ProductWriteAction() 객체 생성
			//ProductWriteAction pwAction = new ProductWriteAction();
			action = new ProductWriteAction();
			System.out.println(" C : DB작업 o, 페이지 이동");
			try {
//			    forward = pwAction.execute(request, response);
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//상품 리스트 보는 페이지
		else if(command.equals("/ProductList.pr")){
			System.out.println(" C : /ProductList.pr 호출");
			System.out.println(" C : DB정보가 필요, 페이지 이동 X, 페이지 출력");
			
			//ProductListAction() 객체 생성
			//ProductListAction listAction = new ProductListAction();
			action = new ProductListAction();
			try{
				System.out.println(" C : 해당 Model 객체 호출");
				forward = action.execute(request, response);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		//상품 상세 페이지 
		else if (command.equals("/ProductContent.pr")) {
			System.out.println(" C : /ProductContent.pr 호출 ");
			System.out.println(" C : DB정보 사용, 출력");
			
			// ProductContentAction 객체
			action = new ProductContentAction();
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
			// 3-1. sendRedirect 방식 (DB 연동으로 이동정보를 보낼 때)
			if(forward.isRedirect()) {
				System.out.println(" Controller : true");
				System.out.println(forward.getPath()+" 이동");
				System.out.println("방식 : sendRedirect() 방식");
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
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
		System.out.println("--------- 3. 가상 주소 이동 완료 ---------");
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
