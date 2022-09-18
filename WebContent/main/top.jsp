<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	
		String mgr_num = (String)session.getAttribute("mgr_num");
		String mem_num = (String)session.getAttribute("mem_num");
		
		if(mgr_num != null ) {
			%>
			<a href="./LogoutManager.mgr">로그아웃</a> 
			<% 
			
		} else if(mem_num != null) {
			%>
			<a href="./Logout.me">로그아웃</a> | <a href="#" >마이페이지</a>
			<%
		} else {
			%>
			<a href="./Login.pcc">로그인</a>  |  <a href="#">회원가입</a>
			<%
		}
	%>
	<hr>
</body>
</html>