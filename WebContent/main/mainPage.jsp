<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>public class Cafe - cafe pcC</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/mainPage.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

<script type="text/javascript" uri="./jQuery/jquery-3.6.0.js"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

<!-- 	<h1>mainPage.jsp</h1> -->
	<%
		String mgr_num = (String)session.getAttribute("mgr_num");
		String mem_num = (String)session.getAttribute("mem_num");
		System.out.println("MEM_NUM: "+mem_num);
		if(mgr_num != null) {
			%>
			
			매니저번호 : ${sessionScope.mgr_num } <br>
			${sessionScope.message } <br>
		

			<%
			
		} else if(mem_num != null) {
			%>
			${sessionScope.message } <br>

			<%
		} else {}		
	%>
	
	<!-- 메인 이미지 시작 -->
	<div class="container">
		<div class="slide_area">
			<div class="slide">
				<img src="./img/slide1.jpg">
			</div>
			
			<div class="slide">
				<img src="./img/slide2.jpg">
			</div>
			
			<div class="slide">
				<img src="./img/slide3.jpg">
			</div>
			
			<div class="slide">
				<img src="./img/slide4.jpg">
			</div>
		</div>
	</div>
	
	<button class="slide_btn1">1</button>
	<button class="slide_btn2">2</button>
	<button class="slide_btn3">3</button>
	<button class="slide_btn4">4</button>
	<!-- 메인 이미지 종료 -->
	
	
	
	<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 -->
</body>
</html>