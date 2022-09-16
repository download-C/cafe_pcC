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
		System.out.println("");
		System.out.println("==============================");
		System.out.println("1. ProductFrontController");
			
			// 1-1. URI 불러오기
			String requestURI = request.getRequestURI();
//			System.out.println(" Controller : requestUIR = "+requestURI);
			// 1-2. context Path 불러오기
			String ctxPath = request.getContextPath();
//			System.out.println(" Controller : ctxPath = "+ctxPath);
			// 1-3. URI를 context Path 길이만큼 자르기
			String command = requestURI.substring(ctxPath.length());
//			System.out.println(" Controller : command = "+command);
		
		System.out.println("2. 입력받은 주소 : " + command);
		
		
 //2. 가상주소 매핑 (web.xml에 적혀있는 대로 .pr로 끝나는 주소 사용) -------------
		// 서블릿 주소를 판별하여 이동하는 if문
		// 2-1. 페이지 이동 정보를 담을 Action과 ActionForward 객체 생성
		Action action = null; 	
		ActionForward forward = null;
		
// ----------------- URI에 따른 if(command.equals(""))-else 문 생성 자리 시작----------------
		//관리자계정 - 상품 등록 페이지
		if(command.equals("/ProductWrite.pr")){
			// 글쓰기 페이지 보여주기 (DB정보 필요없음)
			// 글쓰기 폼 표시를 위한 View 페이지(*.jsp) 로 포워딩
			// 별도의 비즈니스 로직(= DB 작업)이 없이 뷰페이지로 바로 연결
			// => 이 때, JSP 페이지의 URL(qwriteForm.js)이 주소표시줄에 노출되지 않고
			//    이전의 요청 주소인 서블릿 주소("/ProductWrite.pr")를 그대로 유지해야하므로
			//    Dispatcher 방식으로 포워딩을 수행해야한다!
			// => 파라미터로 현재 위치(= Root)에서 하위 디렉토리의 writeForm.js 페이지 지정
//			System.out.println(" C : /ProductWrite.pr 호출 ");
//			System.out.println(" C : DB정보가 필요없음-view페이지로 이동 ");
			
			forward = new ActionForward();
			forward.setPath("./product/writeForm.jsp");
			forward.setRedirect(false);//디스패치 방식 -> 가상주소가 유지
		}
		
		//상품 등록 넘기기
		else if(command.equals("/ProductSave.pr")){
//			System.out.println(" C : /ProductWriteAction.pr 호출 ");

			// ProductWriteAction() 객체 생성
			//ProductWriteAction pwAction = new ProductWriteAction();
			action = new ProductWriteAction();
//			System.out.println(" C : DB작업 o, 페이지 이동");
			try {
//			    forward = pwAction.execute(request, response);
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//상품 리스트 보는 페이지
		else if(command.equals("/ProductList.pr")){
//			System.out.println(" C : /ProductList.pr 호출");
//			System.out.println(" C : DB정보가 필요, 페이지 이동 X, 페이지 출력");
			
			//ProductListAction() 객체 생성
			//ProductListAction listAction = new ProductListAction();
			action = new ProductListAction();
			try{
//				System.out.println(" C : 해당 Model 객체 호출");
				forward = action.execute(request, response);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		//상품 상세 페이지 
		else if (command.equals("/ProductContent.pr")) {
//			System.out.println(" C : /ProductContent.pr 호출 ");
//			System.out.println(" C : DB정보 사용, 출력");
			
			// ProductContentAction 객체
			action = new ProductContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//상품 주문 옵션 정보 작성 -> DB 필요
		else if(command.equals("/CartWrite.pr")){
//			System.out.println(" C : /CartWriteAction.pr 호출");
//			System.out.println(" C : DB 정보 사용, 출력");
			
			//CartWriteAction 객체
			action = new CartWriteAction();
			try{
				forward = action.execute(request, response);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		//카트에 담은 상품 리스트 보는 페이지
		else if(command.equals("/Cart.pr")){
			
			//CartListAction() 객체 생성
			action = new CartListAction();
			try{
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		//결제 정보를 담는 페이지
		else if(command.equals("/OrderWrite.pr")){
			
			//OrderWriteAction
			action = new OrderWriteAction();
			try{
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			//orderWrite.jsp로 이동
//			forward = new ActionForward();
//			forward.setPath("./product/orderWrite.jsp");
//			forward.setRedirect(false);//디스패치 방식 -> 가상주소가 유지
			
		}

		//결제 정보를 DB로 넘기는 페이지
		else if(command.equals("/Order.pr")){
			//OrderAction()객체 생성
			action = new OrderAction();
			try{
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		//결제 후 최종 내역을 확인하는 페이지
		else if(command.equals("/OrderList.pr")){
			forward = new ActionForward();
			forward.setPath("./product/orderList.jsp");
			forward.setRedirect(true);
		}
		
		
		
		
//		
//// ----------------- URI에 따른 if(command.equals(""))-else 문 생성 자리 끝----------------
//		System.out.println("--------- 2. 가상 주소 매핑 완료 ---------");
//		System.out.println();
		
		
		
//		System.out.println("--------- 3. 가상 주소 이동 시작 ---------");
// 3. 가상주소 이동 (페이지 정보에 따라 이동 방법을 sendRedirect(true), forward(false)로 정해줌
		if(forward != null) {
//	         System.out.println("forward는 null이 아닙니다");
	         // 3-1. sendRedirect 방식 (DB 연동으로 이동정보를 보낼 때)
	         if(forward.isRedirect()) {
//	            System.out.println(" Controller : true");
//	            System.out.println(forward.getPath()+" 이동");
	        	 response.sendRedirect(forward.getPath());
	            System.out.println("6. Redirect 방식 포워딩");
	    		System.out.println("==============================");
	    		System.out.println("");
	         
	         // 3-2. forward 방식 (DB 연동 없이 페이지만 전환할 때)
	         } else {
//	            System.out.println(" Controller : false");
//	            System.out.println(forward.getPath()+" 이동");

	            RequestDispatcher dis 
	            = request.getRequestDispatcher(forward.getPath());
//	            System.out.println("dis 성공!");
	            dis.forward(request, response);
//	            System.out.println("forward 성공!");
	            System.out.println("6. Dispatcher 방식 포워딩");
	    		System.out.println("==============================");
	    		System.out.println("");
	         }
	         
//		System.out.println("--------- 3. 가상 주소 이동 완료 ---------");
//		System.out.println();
		}
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
