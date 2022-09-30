<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>public class Cafe - cafe pcC</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main_main.css" rel="stylesheet" type="text/css">
<link href="./css/mainPage.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./JavaScript/jquery-3.6.0.js"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top_main.jsp" />
<!-- 헤더들어가는 곳 -->

<!-- 	<h1>mainPage.jsp</h1> -->
	<%
		String mgr_num = (String)session.getAttribute("mgr_num");
		String mem_num = (String)session.getAttribute("mem_num");
		System.out.println("MEM_NUM: "+mem_num);
		if(mgr_num != null) {
			%>
			
<%-- 			매니저번호 : ${sessionScope.mgr_num } <br> --%>
<%-- 			${sessionScope.message } <br> --%>
		

			<%
			
		} else if(mem_num != null) {
			%>
<%-- 			${sessionScope.message } <br> --%>

			<%
		} else {}		
	%>
	
		<!-- 메인 이미지 시작 -->
	
	<div class="container_main">
	
			<input type="radio" name="tab" id="tab1" checked="checked">
			<input type="radio" name="tab" id="tab2" >
			<input type="radio" name="tab" id="tab3" >
			
			
			<div class="slide">
				<div class="inner_slide">
				
					<div class="bgc"></div>

					<a href="./ProductList.pr">
						<img alt="메인 이미지1" src="./img/slide1.jpg">
						<span>MENU</span>
					</a>
					
					<a href="./ReservationList.re">
						<img alt="메인 이미지2" src="./img/slide2.jpg">
						<span>RESERVATION</span>
					</a>
					
					<a href="ReviewList.rv">
						<img alt="메인 이미지3" src="./img/slide3.jpg">
						<span>REVIEW</span>
					</a>
					
				</div>
			</div>
	
			<div class="main_btn">
				<label for="tab1"></label>
				<label for="tab2"></label>
				<label for="tab3"></label>
			</div>
	
	</div> 
	
	
	<!-- 메인 이미지 종료 -->
	
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 -->
</body>
</html>