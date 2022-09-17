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
<header>
<jsp:include page="top2.jsp" />
</header>

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
	
<footer>
<jsp:include page="bottom.jsp" />
</footer>
</body>
</html>