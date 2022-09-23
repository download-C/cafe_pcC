package com.pcc.reservation.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pcc.reservation.action.ReservationAction;

import action.Action;
import vo.ActionForward;

public class ReservationFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 방식, POST 방식 호출 - doGet(), doPost() 실행");
		
		System.out.println("--------- 1. 가상 주소 계산 시작 ---------");
		// 1. servlet 파일이 들어있는 프로젝트명 (== 가상주소) 계산 ---------------------
			
			// 1-1. URI 불러오기
			String requestURI = request.getRequestURI();
			System.out.println(" Controller : requestURI = "+requestURI);
			// 1-2. context Path 불러오기
			String ctxPath = request.getContextPath();
			System.out.println(" Controller : ctxPath = "+ctxPath);
			// 1-3. URI를 context Path 길이만큼 자르기
			String command = requestURI.substring(ctxPath.length());
			System.out.println(" Controller : command = "+command);
		
		System.out.println("--------- 1. 가상 주소 계산 완료 ---------");
		System.out.println();
		
		System.out.println("--------- 2. 가상 주소 매핑 시작 ---------");
// 2. 가상주소 매핑 (web.xml에 적혀있는 대로 .re로 끝나는 주소 사용) -------------
		// 2-1. 페이지 이동 정보를 담을 Action과 ActionForward 객체 생성
			Action action = null;
			ActionForward forward = null;
			
			if(command.equals("/Reservation.re")){
				System.out.println(" C : /Reservation.re");
				
				forward = new ActionForward();
				forward.setPath("./reservation/reservationForm.jsp");
				forward.setRedirect(false);	
			} 
			else if(command.equals("/ReservationAction.re")){
		    	action = new ReservationAction();
		    	try{
		    		forward = action.execute(request, response);
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
		    	
			} 
//			else if(command.equals("/ReservationContent.re")){
//				action = new ReservationContentAction();
//				try{
//		    		forward = action.execute(request, response);
//		    	} catch(Exception e){
//		    		e.printStackTrace();
//		    	}
//				
//			}
			else if(command.equals("/ReservationList.re")){					
				action = new ReservationListAction();
		    	try{
		    		forward = action.execute(request, response);
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
			}
			else if(command.equals("/ReservationUpdateForm.re")){
				action = new ReservationUpdateForm();
				try{
		    		forward = action.execute(request, response);
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
			}
			else if(command.equals("/ReservationUpdateAction.re")) {
				action = new ReservationUpdateAction();
				try{
					forward = action.execute(request, response);
				} catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(command.equals("/ReservationDeleteAction.re")) {
				action = new ReservationDeleteAction();
				try{
		    		forward = action.execute(request, response);
		    	} catch(Exception e){
		    		e.printStackTrace();
		    	}
			}
		

		
// ----------------- URI에 따른 if(command.equals(""))-else 문 생성 자리 시작----------------
		
		
		
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
				response.sendRedirect(forward.getPath());
				
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
