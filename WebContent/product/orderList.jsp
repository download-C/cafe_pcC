<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/product/orderList.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js"	crossorigin="anonymous"></script>
<title>주문목록</title>
<script type="text/javascript" src="./JavaScript/jquery-3.6.0.js"></script>
</head>
<body>
	<!-- 헤더들어가는 곳 -->
	<jsp:include page="../inc/top.jsp" />
	<!-- 헤더들어가는 곳 -->
	<div style="position: relative; height: 100px"></div>



	<!-- container1 -->
	<div class="container1">
	
	<c:if test="${empty orderList}">
		<div class="empty_area">
			<div>주문한 상품이 없습니다.</div>
			<input type="button" value="상품 목록으로 가기" class="return_product" onclick="location.href='./ProductList.pr';">
		</div>
	</c:if>


	<c:if test="${not empty orderList}">
		
		<h1>주문 목록</h1>
		
		<!-- container2 -->
		<div class="container2" >
		<!-- 오더 리스트 시작 -->
		<c:forEach var="list2" items="${orderList }">
			
		<div class="order_area">
			<!-- 일시 -->
			<div class="order_info">
				<div>
					<fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${list2.order_time}" />
				</div>
				<div>
					결제 금액 : <span>${list2.order_price}</span>원
				</div>
			</div>
				<c:set var="order" value="${list2.order_time}"/>

			<div class="list_area">
			
				<div class="title_area">
					<div class="title_img"></div>
					<div class="title_text_info">상품 정보</div>
					<div class="title_text_price">주문금액</div>
				</div>
			<!-- 상품 리스트 시작 -->
			<c:forEach var="list1" items="${orderProductList }">
			<c:set var="cart" value="${list1.checked}"/>
			
			<c:if test="${cart eq order}">
				<div class="list_area_outer">
					<a href="./ProductContent.pr?prod_num=${list1.prod_num }">
						<div class="list_area_inner">
							<div class="list_img">
								<img src="img/product/${list1.prod_img}">
							</div>
							
							<div class="list_name">${list1.prod_name }</div>
							
							<div class="list_price">
								<span>${list1.price}원</span>
								<span> X ${list1.prod_count} = </span>
								<span>${list1.total_price}원</span>
							</div>
						</div>
					</a>
				</div>
				<!-- list_area -->
			</c:if>
			</c:forEach>
			<!-- 상품 리스트 종료 -->
			</div>
			
		</div>
		<!-- order_area -->
		</c:forEach>
		<!-- 오더 리스트 종료 -->
		
		</div>
		<!-- container2 -->
		
	</c:if>
	
	</div>
	<!-- container1 -->

	<!-- 푸터들어가는 곳 -->
	<jsp:include page="../inc/bottom.jsp" />
	<!-- 푸터들어가는 곳 -->
</body>
</html>