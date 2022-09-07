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
	<h1>productList.jsp</h1>
	
	<h2>상품 목록</h2>
	
	<h3><a href="./ProductWrite.pr">상품등록하기</a></h3>
	
	<c:forEach var="dto" items="${requestScope.productList }">
	<div>
		<a href="./ProductContent.bo?prod_num=${dto.prod_num }"><!-- 상품 클릭 시, 상품 개별 페이지로 이동하도록 구현 -->
		상품 사진<br>
		${dto.prod_name }<br>
		${dto.price }
		</a>
	</div>
	</c:forEach>
	
</body>
</html>