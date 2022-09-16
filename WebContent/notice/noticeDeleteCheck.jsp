<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ tablib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>알림창</title>
</head>
<body>
<header>
	<jsp:include page="../main/top2.jsp" />
</header>
	<script>
		alert("${msg}");
		location.href=:"<c:out value='${pageContext.request.contextPath}'/>${url}";
	</script>
</body>
</html>