<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>매니저 로그인 페이지</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/loginForm.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

	<br><br>
	<div class="wrapper">
			<div class="logindiv">
		<br><br>
			<div class="logodiv">
			<img src="./img/logo.jpg" id="logo"><br>
			</div>
			<h1>매니저 로그인</h1>
			<div class="loginform">
			<form action="./LoginManagerAction.mgr" method="post" >
				<input type="text" name="phone" class="input" placeholder="아이디/휴대폰 번호"> <br>  
				<input type="password" name="password" class="input" placeholder="비밀번호"> <br>
				<br><br>
				<input type="submit" value="로그인" class="btn">
			</form>
			</div>
		</div>
	</div>	
	<br>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>

