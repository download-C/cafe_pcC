<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주문 목록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<h1>orderList.jsp</h1>
	
<!-- 	request.setAttribute("cartList", cartList); -->
<!-- 	request.setAttribute("order_dto", order_dto); -->
		<c:set var="date" value="<%= new Date() %>"></c:set>
	
	픽업 예정 시간 : order_date + pickup_time<br>
	---<br>
<%-- 	<fmt:formatDate value="${order_dto.order_date}" dateStyle="medium"/> --%>
		<fmt:formatDate value="${date }" dateStyle="medium"/><br>
	
<%-- 	 결제일자 : ${order_dto.order_date} / 결제 금액 : {$request.order_price} --%>
	
	상품 사진 /상품명 /원가 /수량
	
<%-- 	${date } --%>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>