<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="jQuery/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//alert("시험");
		$('#minus').click(function(){
			var count = $('.prod_count').html();
			//prod_count의 html 태그 내의 값을 가져와서 변수 삽입
			var price = $('#price').html();
			//상품 원가(price)의 값을 price 변수에 삽입
			if(count > 1){
				count--
			}
			price = price * count
			$('.prod_count').html(count)
			$('.prod_count_hidden').val(count)
			$('.total_price').html(price)
			$('.total_price_hidden').val(price)
			
		});
		
		$('#plus').click(function(){
			var count = $('.prod_count').html();
			var price = $('#price').html();
			if(count != null){
				count++				
			}
			price = price * count
			$('.prod_count').html(count)
			$('.prod_count_hidden').val(count)
			$('.total_price').html(price)
			$('.total_price_hidden').val(price)
		});
		
	});
	
</script>
</head>
<body>
	<h1>productContent.jsp</h1>
	
	<h2>상품 상세 페이지</h2>
	
	<!-- 상품 정보 & 장바구니 담기 버튼 -->
	<div>
		
		<!-- 상품 정보 -->
		<div>
			
			<div>
			<img src="img/product/${dto.prod_img}"><br>
			<%-- ${dto.category }<br> --%>
			${dto.prod_name }<br>
			<div id="price">${dto.price }</div><br>
			</div>
		</div>
		
		
		
		
		<form action="./CartWriteAction.pr" method="post">
			<input type='hidden' name='prod_num' value="${dto.prod_num }" >
			<!-- 수량 추가하기 구현 -->
			<div>
				수량
				<input type='button' id="minus" value='-'/>
				<span class='prod_count'>1</span>
				<input type='hidden' class='prod_count_hidden' name='prod_count' value="1" >
	        	<input type='button' id="plus" value='+'/>
			</div>
			<!-- 요청사항 작성란 -->
			<div>
				옵션
				<textarea rows="1" cols="30" placeholder="샷 2번 추가" name="requirements" ></textarea>
			</div>
			
			<!-- 수량에 따른 실시간 가격 -->
			<div>
				금액<span class="total_price">${dto.price }</span>원
				<input type="hidden" class="total_price_hidden" name="total_price" value="${dto.price }">
			</div>
			
			<!-- 장바구니 담기 버튼 -->
			<div>
				<input type="submit" value="담기" onclick="location.href='./CartWriteAction.pr?skip_cart=false';">
<!-- 				<input type="submit" value="주문하기" onclick="location.href='./CartWriteAction.pr?skip_cart=true';"> -->
	        	<input type="button" value="상품 목록" onclick="location.href='./ProductList.pr';">
			</div>
		</form>
		
	</div>
	
	
	
</body>
</html>