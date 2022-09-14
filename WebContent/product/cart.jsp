<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$('#order_price').html(function(){
			var order_price =0;
			for(var i = 0; i < ${requestScope.cartList.size()}; i++ ){
				var cart = $('.total_price').eq(i).html();
				order_price += Number(cart);
			}
			$(this).html(order_price);
		});
	});
</script>
</head>
<body>
	<h1>cart.jsp</h1>
	
	<h2>카트 목록</h2>
	<div class="cart">
	<c:forEach var="dto" items="${requestScope.cartList }">
	<div>
		<!-- 상품 클릭 시, 상품 개별 페이지로 이동하도록 구현 -->
		<a href="./ProductContent.pr?prod_num=${dto.prod_num }">
		상품 정보
		<div>
		<img src="img/product/${dto.prod_img}"><br>
		${dto.prod_name } ${dto.price }<br>
		</div>
		<div>수량/옵션 ****수량 변경 기능****
		${dto.prod_count}/${dto.requirements }<br>
		</div>
		<div class="total_price">${dto.total_price}</div><br>
<%-- 		<input type="hidden" class="cart_num" value="${dto.cart_num}"> --%>
		</a>
	</div>
	<br>
	</c:forEach>
	</div>
	
	<form action="">
	주문 금액 <span id="order_price"></span>원
	<input type="button" value="주문하기" onclick="location.href='./OrderWrite.pr';">
	</form>
	
	
</body>
</html>