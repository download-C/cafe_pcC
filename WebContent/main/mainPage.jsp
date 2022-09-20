<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
		if(mgr_num != null) {
			%>
			
			매니저번호 : ${sessionScope.mgr_num } <br>
			${sessionScope.message } <br>
		

			<%
			
		} else if(mem_num != null) {
			%>
			${sessionScope.message } <br>

			<%
		} else {
			%>
			로그인이 필요합니다. <br>
			<%
		}
	
		
	%>
	
	<!-- 메인 이미지 시작 -->
	
	<div class="slide_area">
		<input type="radio" name="slide" id="slide1" checked> 
		<input type="radio" name="slide" id="slide2"> 
		<input type="radio" name="slide" id="slide3"> 
		<input type="radio" name="slide"id="slide4">
		
		<ul class="slide_list">
			<li class="slide_item">
				<div>
					<label for="slide4" class="left"></label>
					<label for="slide2" class="right"></label>
					<a><img src="./img/slide1.jpg"></a>
				</div>
			</li>
			<li class="slide_item">
				<div>
					<label for="slide1" class="left"></label>
					<label for="slide3" class="right"></label>
					<a><img src="./img/slide2.jpg"></a>
				</div>
			</li>
			<li class="slide_item">
				<div>
					<label for="slide2" class="left"></label>
					<label for="slide4" class="right"></label>
					<a><img src="./img/slide3.jpg"></a>
				</div>
			</li>
			<li class="slide_item">
				<div>
					<label for="slide3" class="left"></label>
					<label for="slide1" class="right"></label>
					<a><img src="./img/slide4.jpg"></a>
				</div>
			</li>
		</ul>
		
	</div>
	<!-- 메인 이미지 종료 -->
	
	
	
	<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>