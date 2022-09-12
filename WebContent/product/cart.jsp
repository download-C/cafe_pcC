<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>cart.jsp</h1>
	
	<h2>카트 목록</h2>
	<div class="cart">
	<c:forEach var="dto" items="${requestScope.cartList }">
	<div>
		<!-- 상품 클릭 시, 상품 개별 페이지로 이동하도록 구현 -->
		<a href="./ProductContent.pr?prod_num=${dto.prod_num }">
		
<%-- 		<img src="img/product/${dto.prod_img}"><br> --%>
		
<%-- 		${dto.prod_name }<br> --%>
		${dto.requirements }<br>
		${dto.total_price }<br>
		
		</a>
	</div>
	<br>
	</c:forEach>
	</div>
	
	
</body>
</html>