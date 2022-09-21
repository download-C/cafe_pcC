<%@page import="com.pcc.product.db.ProductDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품 목록</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/productList.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

<script type="text/javascript" src="jQuery/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('button').click(function() {
		
			$('.' + $(this).attr('data-text')).show();
			$('.category').not("."+$(this).attr('data-text')).hide();
			
		});
	});
</script>

<%
String mem_num = (String)session.getAttribute("mem_num");
String mgr_num = (String)session.getAttribute("mgr_num");
%>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 	<h1>productList.jsp</h1> -->
	
	<h2>상품 목록</h2>
	
	<input type="button" value="장바구니로 이동" onclick="location.href='./Cart.pr';">
	<!-- 관리자 계정(name : admin) 으로 로그인 시 보이도록 구현 -->
	<%if(mgr_num != null) { %>
	<h3><a href="./ProductWrite.pr">상품등록하기</a></h3>
	<%} %>
	
	<!-- category 클릭 시 카테고리별 상품 리스트만 뜨도록 구현 -->
	
	<h2>category</h2>
	<div>
		<button data-text="all">all</button>
		<button data-text="coffee">coffee</button>
		<button data-text="noncoffee">non coffee</button>
		<button data-text="brunch">brunch</button>
	</div>
	<br>

	
	
	
	<div class="product">
		<c:forEach var="dto" items="${requestScope.productList }">
			<div class="${dto.category} category all">
				<a href="./ProductContent.pr?prod_num=${dto.prod_num }">
				<img src="img/product/${dto.prod_img}"><br>
				${dto.prod_name }<br>
				</a>
			</div>
		</c:forEach>
	</div>

<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>