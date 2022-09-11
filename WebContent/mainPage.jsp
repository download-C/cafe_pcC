<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>mainPage.jsp</h1>
	<%
		if(session.getAttribute("mgr_num") != null) {
			%>
			로그인 성공
			세션 아이디 : ${sessionScope.mgr_num }
			<%
			
		} else {
			%>
			로그인해주세요
			<input type="button" name="button" 
			value="로그인 페이지로 이동" onclick="loaction.href='./LoginManager.mgr'">
			<%
		}
	%>
</body>
</html>