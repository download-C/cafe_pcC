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
		if(mgr_num != null) {
			session = request.getSession();
			session.setAttribute("mgr_num", mgr_num);

			%>
			
			매니저번호 : ${sessionScope.mgr_num } <br>
			${sessionScope.message } <br>
		
			<a href="./NoticeList.no">공지사항</a> <br>
			
			<a href="./ReviewList.rv">리뷰 게시판</a> <br>
			<%
			
		} else {
			%>
			로그인해주세요 <br>
		
			<%
		}
	
		
	%>
	
</main>
<footer>
</footer>
</body>
</html>