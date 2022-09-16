<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="../main/top2.jsp" />
</header>
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
</body>
</html>