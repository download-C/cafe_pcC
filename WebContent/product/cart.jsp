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
		
		//총 주문 금액
		$('.order_price').html(function(){
			var order_price = 0;
			for(var i = 0; i < ${requestScope.cartList.size()};i++){
				var cart = $('.total_price').eq(i).html();
				order_price += Number(cart);
			}
			$(this).html(order_price);
			$(this).val(order_price);
		});
// 		for(var i = 0; i < ${requestScope.cartList.size()};i++){
// 			//상품별 수량 변경 기능
// 			$('.prod_count').eq(i).on('change',function(){
// 				alert($('.prod_count').eq(i));
	// 			var count = $(this).eq(i).val();
	// 			var price = $('.price').eq(i).html();
	// 			price = price * count
	// 			$('.total_price').eq(i).html(price)
	// 			$('.total_price_hidden').eq(i).val(price)
				
// 			});
			
	// 		//상품별 수량 변경 기능 - 마이너스 버튼 클릭
	// 		$('.minus').click(function(){
	// 			var count = $('.prod_count').val();
	// 			//prod_count의 html 태그 내의 값을 가져와서 변수 삽입
	// 			var price = $('.price').html();
	// 			//상품 원가(price)의 값을 price 변수에 삽입
	// 			if(count > 1){
	// 				count--
	// 			}
	// 			price = price * count
	// 			$('.prod_count').val(count)
	// 			$('.total_price').html(price)
	// 			$('.total_price_hidden').val(price)
				
	// 		});
			
	// 		//상품별 수량 변경 기능 - 플러스 버튼 클릭
	// 		$('.plus').click(function(){
	// 			var count = $('.prod_count').val();
	// 			var price = $('.price').html();
	// 			if(count != null){
	// 				count++				
	// 			}
	// 			price = price * count
	// 			$('.prod_count').val(count)
	// 			$('.total_price').html(price)
	// 			$('.total_price_hidden').val(price)
	// 		});
			
	// 		//옵션값이 null일 경우 보이지 않게 처리
	// 		$('#requirements_val').html(function(){
	// 			var value = $(this).html();
	// 			//alert(value);
	// 			if(value == null){
	// 				$('#requirements_div').hide();
	// 			}
	// 		});
// 		}
	});
</script>
</head>
<body>
	<h1>cart.jsp</h1>
	
	<h2>카트 목록</h2>
	<form action="./OrderWrite.pr">
		<table border="1">
	     	<tr>
		       <td>상품 정보</td>
		       <td>수량/옵션</td>
		       <td>주문금액</td>
		     </tr>
			<c:forEach var="dto" items="${requestScope.cartList }">
			<input type="hidden" name="cart_num" value="${dto.cart_num}">
		     <tr>
		     	<!-- 상품 정보 -->
		        <td>
		        	<a href="./ProductContent.pr?prod_num=${dto.prod_num }">
		        	<img width="200px" src="img/product/${dto.prod_img}"><br>
		        	${dto.prod_name}
		        	<div class="price">${dto.price}</div>
		        	</a>
		        </td>
	        	
	        	<!--  수량/옵션 -->
		        <td>
<!-- 					<input type='button' class="minus" value='-'/> -->
					<input type='text' class='prod_count' name='prod_count' value="${dto.prod_count}" >
<!-- 	      			<input type='button' class="plus" value='+'/> -->
	      			<div id="requirements_div"><span id="requirements_val">${dto.requirements}</span></div>
							
				</td>
				
				<!-- 주문금액 -->
		        <td>
		        	<span class="total_price">${dto.total_price}</span>원<br>
		        	<input type="hidden" class="total_price_hidden" value="${dto.total_price}">
	        	</td>
		      </tr>
	     </c:forEach>
	</table>			

		주문 금액 
		<span class="order_price"></span>원
		<input type="hidden" class="order_price" name="order_price" val="">
		<input type="submit" value="주문하기">
		<input type="button" value="상품 목록 돌아가기" onclick="location.href='./ProductList.pr';">
		
	</form>
	
	
</body>
</html>