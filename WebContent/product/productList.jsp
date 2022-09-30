<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품 목록</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/product/productList.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./JavaScript/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('button').click(function(){
			//alert("테스트");
			
			$('.' + $(this).attr('data-text')).show();
			//class 값이 coffee인 상품을 보여주라
			
			$('.category').not("."+$(this).attr('data-text')).hide();
			//class가 category인 상품의 class 값이 coffee가 아닌 상품은 가려라
		});
		
		
	});
</script>

<%
	//String mem_num = (String)session.getAttribute("mem_num");
	String mgr_num = (String)session.getAttribute("mgr_num"); 
 %>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 	<h1>productList.jsp</h1> -->
		
	<div style="position: relative; height: 100px"></div>
	
	<div class="container">
	
	<div class="title_img">
		<img src="./img/images/img (18).jpg">
		<h1 class="title">MENU</h1>
		<div class="img_box"></div>
	</div>
	
	<div class="category_div">
	
<%-- 		<c:if test="${not empty sessionScope.mem_num}"> --%>
<!-- 		<a class="button_menu" href="./Cart.pr">장바구니</a> -->
<%-- 		</c:if> --%>
	
		<!-- 관리자 계정(name : admin) 으로 로그인 시 보이도록 구현  -->
	 	<%if(mgr_num != null) { %>
	 	<a class="button_menu" href="./ProductWrite.pr">상품등록하기</a>
	 	<%} %>
	 	
		<!-- category 클릭 시 카테고리별 상품 리스트만 뜨도록 구현 -->
	 	<div class="category_list">
			<button data-text="all">all</button>
			<button data-text="coffee">coffee</button>
			<button data-text="noncoffee">non coffee</button>
			<button data-text="brunch">brunch</button>
		</div>
		
 	</div>
	
	
<!-- 	<h2>category</h2> -->
	
	<br>

	
	<div class="product">
		<c:forEach var="dto" items="${requestScope.productList }">
			<div class="${dto.category} category all">
				<a href="./ProductContent.pr?prod_num=${dto.prod_num }">
				<img src="img/product/${dto.prod_img}"><br>
				<div class="product_name">${dto.prod_name }</div>
				<div class="product_box"></div>
				</a>
			</div>
		</c:forEach>
	</div>
	</div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>