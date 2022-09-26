<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 페이지</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/loginForm.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

</head>
<body>

<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<br>
<div >
	<form action="./LoginAction.me" method="post" id="lg">
		<input type="text" name="phone" placeholder="아이디/휴대폰 번호"> <br> 
		<input type="password" name="password" placeholder="비밀번호"> <br>
		<br>
		<input type="submit" value="로그인">
		<input type="button" value="회원가입" onclick= "location.href='./Reg.me';"><br>
			<a href="./LoginManager.mgr">매니저 로그인하기</a>
	</form>

</div>	

<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>