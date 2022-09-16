<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
	<jsp:include page="top2.jsp" />
</header>
	<form action = "./Login.pcc" method="post">
		아이디 <input type="text" name="id"> <br>
		비밀번호 <input type="password" name="password"> <br>
		<input type="submit" name="sbumit" value="로그인">
	</form>
	
	<a href="./LoginManager.mgr">매니저 로그인하기</a>
</body>
</html>