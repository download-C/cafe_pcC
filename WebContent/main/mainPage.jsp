<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

<script type="text/javascript" uri="./jQuery/jquery-3.6.0.js"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

	<h1>mainPage.jsp</h1>
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
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>