<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장바구니</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/product/cart.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./JavaScript/jquery-3.6.0.js"></script>
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
			
			//==================================================

			
			//데이터 정보 넘기기
// 			alert($(this).attr('data-text'));
			$.ajax({
				type: "post",
				url: "./CartUpdate.pr",
				data: {
					cart_num: $(this).attr('data-text'),
					prod_count: count,
					total_price: total_price,
				},
				dataType: "text",
				success: function() {
					alelrt("update 성공");
				}
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
			
			//==================================================

			
			//데이터 정보 넘기기
// 			alert($(this).attr('data-text'));
			$.ajax({
				type: "post",
				url: "./CartUpdate.pr",
				data: {
					cart_num: $(this).attr('data-text'),
					prod_count: count,
					total_price: total_price,
				},
				dataType: "text",
				success: function() {
					alelrt("update 성공");
				}
			});
			
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
			
			//==================================================

			
			//데이터 정보 넘기기
// 			alert($(this).attr('data-text'));
			$.ajax({
				type: "post",
				url: "./CartUpdate.pr",
				data: {
					cart_num: $(this).attr('data-text'),
					prod_count: count,
					total_price: total_price,
				},
				dataType: "text",
				success: function() {
					alelrt("update 성공");
				}
			});
			
		});
			//==================================================

// 		$('.delete').click(function(){
// 			alert($(this).attr('data-text'));
// 			$.ajax({
// 				type: "post",
// 				url: "./CartDelete.pr",
// 				data: {
// 					cart_num: $(this).attr('data-text'),
// 				},
// 				dataType: "text",
// 				success: function(response) {
// 					alert("성공");
// // 					opener.location.href='Cart.pr';
// 				}
// 			});
// 		});		
				
		
				
		
	});
</script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<div style="position: relative; height: 100px"></div>

	<div class="container1">
		
		<!-- 제목 -->
		<div class="title">
			<h1 class="title_text">장바구니</h1>
		</div>
			
		<!-- 장바구니가 비었을 때 안내 -->
		<div class="empty_box">
			<c:if test="${empty cartList}">
				<div class="empty">장바구니에 담긴 상품이 없습니다.</div>
				<input class="empty" type="button" value="상품 목록으로 가기" class="return_product" onclick="location.href='./ProductList.pr';">
			</c:if>
		</div>
		
		<!-- 장바구니에 상품이 있을 때 -->
			<c:if test="${not empty cartList}">
			<form action="./OrderWrite.pr" method="post">
			<div class="cart_box">
			
				<div class="title_box">
					<span class="box1">상품 정보</span>
					<span class="box1">수량/옵션</span>
					<span class="box1">주문금액</span>
				</div>
				
				<div class="content_box">
					<c:forEach var="dto" items="${requestScope.cartList }">
					<input type="hidden" name="cart_num" id="cart_num" value="${dto.cart_num}">
					
					
					<div class="content_box1">
					
						<!-- 상품 정보 -->
						<div class="box2">
							<div class="content_inner">
								<a class="content_inner_a" href="./ProductContent.pr?prod_num=${dto.prod_num }">
								
							    	<div class="content_img">
								    	<img src="img/product/${dto.prod_img}">
							    	</div>
							    	
							    	<div class="content_info">
									    <div class="content_title">${dto.prod_name}</div>    	
								        <div class="content_price"><span class="price${dto.cart_num}">${dto.price}</span>원</div>
							    	</div>
							    	
							    </a>
							    <a class="content_inner_a" href="./CartDelete.pr?cart_num=${dto.cart_num}">X</a>
							</div>
						</div>
							     
			        	<!--  수량/옵션 -->
			        	<div class="box2">
							<div>
								<input type='button' class="count minus" data-text="${dto.cart_num}" value='-'/>
								<input type='text' class='count prod_count prod_count${dto.cart_num}' data-text="${dto.cart_num}" name='prod_count' value="${dto.prod_count}" >
				      			<input type='button' class="count plus" data-text="${dto.cart_num}" value='+'/>
				      			<div id="requirements_div"><span id="requirements_val">${dto.requirements}</span></div>
							</div>
						</div>
									
						<!-- 상품수량에 따른 total_price -->
						<div class="box2">
							<div>
					        	<span class="total_price total_price${dto.cart_num}">${dto.total_price}</span>원
					        	<input type="hidden" class="total_price_hidden${dto.cart_num}" value="${dto.total_price}">
							</div>
						</div>
					
					</div>
					</c:forEach>
				</div>
			</div>
		
			
		<div class="container2">	
			<!-- 주문 금액 -->
			<div class="total_area">
				<div class="total_area_title">총 주문 금액  </div>
				<div class="total_area_box"><span class="order_price"></span><span>원</span></div>
				<input type="hidden" class="order_price" name="order_price" val="">
			</div>
			
			<!-- 버튼 -->
			<div class="button_area">
				<input type="submit" value="주문하기">
				<input type="button" value="상품 목록 돌아가기" class="return_product" onclick="location.href='./ProductList.pr';">
			</div>
		</div>
				
		</form>
		</c:if>
	</div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>