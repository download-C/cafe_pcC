<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" uri="./jQuery/jquery-3.6.0.js"></script>
<script type="text/javascript">


</script>
</head>
<body>
	<h1>mainPage.jsp</h1>
	<%
		String mgr_num = (String)session.getAttribute("mgr_num");
		if(mgr_num != null) {
			session = request.getSession();
			session.setAttribute("mgr_num", mgr_num);

			%>
			로그인 성공 <br>
			${sessionScope.mgr_num } <br>
			${sessionScope.message } <br>
			<a href="./LogoutManager.mgr">로그아웃</a>
			<a href="./NoticeList.no">공지사항</a> <br>
			<%
			
		} else {
			%>
			로그인해주세요 <br>
			<input type="button" name="button" 
			value="로그인 페이지로 이동" onclick="location.href='./Login.pcc'"> <br>
			<%
		}
	
		
	%>
	
	
</body>
</html>