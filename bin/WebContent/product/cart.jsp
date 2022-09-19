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
		
		//==================================================
		
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
		
		
		//==================================================
		
			
		$('.minus').click(function() {

			//마이너스 버튼 
			var count = $('.prod_count' + $(this).attr('data-text')).val();
			if(count > 1 ){
				Number(count--);				
			}
			
			//수량
			$('.prod_count' + $(this).attr('data-text')).val(count);
			
			//원가격
			var price = $('.price' + $(this).attr('data-text')).html();
			
			//주문 금액
			var total_price = count * price
			$('.total_price' + $(this).attr('data-text')).html(total_price);
			$('.total_price_hidden' + $(this).attr('data-text')).val(total_price);

			
			//==================================================
			
				
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
		});
		
		
		//==================================================
		
		
		$('.plus').click(function() {
			var count = $('.prod_count' + $('.plus').attr('data-text')).val()
			//플러스 버튼 
			var count = $('.prod_count' + $(this).attr('data-text')).val();
			if(count != null){
				Number(count++);			
			}
			
			//수량
			$('.prod_count' + $(this).attr('data-text')).val(count);
			
			//원가격
			var price = $('.price' + $(this).attr('data-text')).html();
			
			//주문 금액
			var total_price = count * price
			$('.total_price' + $(this).attr('data-text')).html(total_price);
			$('.total_price_hidden' + $(this).attr('data-text')).val(total_price);
			
			
			//==================================================
			
				
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
			
//데이터 정보 넘기기
			
// 			$.ajax({
// 				type: "post",
// 				url: "./CartUpdate.pr",
// 				data: {
// 					cart_num: $(this).attr('data-text'),
// 					prod_count: count,
// 					total_price: total_price,
// 				},
// 				dataType: "text",
// 				success: function() {
// 					alelrt("update 성공");
// 				}
// 			});
			
		});
		
		
		//==================================================
		
		
		//직접 작성으로 값이 바뀌었을 때
		$('.prod_count').on('change',function(){
			
			//텍스트 창
			var count = $('.prod_count' + $(this).attr('data-text')).val();
			
			//원가격
			var price = $('.price' + $(this).attr('data-text')).html();
			
			//주문 금액
			var total_price = count * price
			$('.total_price' + $(this).attr('data-text')).html(total_price);
			$('.total_price_hidden' + $(this).attr('data-text')).val(total_price);

			
			//==================================================

				
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
			
			
			
		});
			//==================================================
				
				
				
		
				
		
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
			<input type="hidden" name="cart_num" id="cart_num" value="${dto.cart_num}">
		     <tr>
		     	<!-- 상품 정보 -->
		        <td>
		        	<a href="./ProductContent.pr?prod_num=${dto.prod_num }">
		        	<img width="200px" src="img/product/${dto.prod_img}"><br>
		        	${dto.prod_name}
		        	<div class="price${dto.cart_num}">${dto.price}</div>
		        	</a>
		        </td>
	        	
	        	<!--  수량/옵션 -->
		        <td>
					<input type='button' class="minus" data-text="${dto.cart_num}" value='-'/>
					<input type='text' class='prod_count prod_count${dto.cart_num}' data-text="${dto.cart_num}" name='prod_count' value="${dto.prod_count}" >
	      			<input type='button' class="plus" data-text="${dto.cart_num}" value='+'/>
	      			<div id="requirements_div"><span id="requirements_val">${dto.requirements}</span></div>
							
				</td>
				
				<!-- 상품수량에 따른 total_price -->
		        <td>
		        	<span class="total_price total_price${dto.cart_num}">${dto.total_price}</span>원<br>
		        	<input type="hidden" class="total_price_hidden${dto.cart_num}" value="${dto.total_price}">
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