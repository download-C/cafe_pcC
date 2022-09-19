<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>매니저 로그인 페이지</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<h1>LoginManager.jsp</h1>
	
	<form action="./LoginManagerAction.mgr" method="post">
		<fieldset>
			<ul>
				<li>
					 <input type="text" name="mgr_id"  placeholder="아이디를 입력하세요">
				</li>
				<li>
					<input type="password" name="mgr_password" placeholder="비밀번호를 입력하세요">
				</li>
			 </ul>
			 	<input type="submit" name="submit" value="로그인">
		</fieldset>
	</form>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>