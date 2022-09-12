<%@page import="com.pcc.product.db.ProductDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/productList.css" type="text/css">
</head>
<body>
	<h1>productList.jsp</h1>
	
	<h2>상품 목록</h2>
	
	<!-- 관리자 계정(name : admin) 으로 로그인 시 보이도록 구현 -->
	
	<h3><a href="./ProductWrite.pr">상품등록하기</a></h3>
	
	<!-- category 클릭 시 카테고리별 상품 리스트만 뜨도록 구현 -->
	
	<h2>category</h2>
	<div>
		<div id="cate_coffee"><a>coffee</a></div>
		<div id="cate_noncoffee"><a>non coffee</a></div>
		<div id="cate_brunch"><a>brunch</a></div>
	</div>
	<br>
	
	<div class="product">
	<c:forEach var="dto" items="${requestScope.productList }">
	<div>
		<!-- 상품 클릭 시, 상품 개별 페이지로 이동하도록 구현 -->
		<a href="./ProductContent.pr?prod_num=${dto.prod_num }">
		
		<img src="img/product/${dto.prod_img}">
		<br>
		${dto.prod_name }<br>
		
		</a>
	</div>
	<br>
	</c:forEach>
	</div>
	
</body>
</html>