<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	
</body>
</html>