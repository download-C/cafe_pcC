<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품 상세 내용</title>
<script type="text/javascript" src="./script/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//alert("시험");
		
		//prod_count의 값을 click이 아니라 기입으로 변경했을 때 이벤트 처리 해야 함
		$('.prod_count').on('change',function(){
			//alert("시험");
			var count = $(this).val();
			var price = $('#price').html();
			price = price * count
			$('.total_price').html(price)
			$('.total_price_hidden').val(price)
			
		});
		
		
		$('#minus').click(function(){
			var count = $('.prod_count').val();
			//prod_count의 html 태그 내의 값을 가져와서 변수 삽입
			var price = $('#price').html();
			//상품 원가(price)의 값을 price 변수에 삽입
			if(count > 1){
				count--
			}
			price = price * count
			$('.prod_count').val(count)
			$('.total_price').html(price)
			$('.total_price_hidden').val(price)
			
		});
		
		$('#plus').click(function(){
			var count = $('.prod_count').val();
			var price = $('#price').html();
			if(count != null){
				count++				
			}
			price = price * count
			$('.prod_count').val(count)
			$('.total_price').html(price)
			$('.total_price_hidden').val(price)
		});
		
	});
	
</script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
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
		
		<form action="./CartWrite.pr" method="post">
			<input type='hidden' name='prod_num' value="${dto.prod_num }" >
			<input type="hidden" name="mem_num" value="${sessionScope.mem_num }">
<%-- 			회원 번호 : ${sessionScope.mem_num } --%>
			
<%-- 			<input type='hidden' name='prod_name' value="${dto.prod_name }" > --%>
<%-- 			<input type='hidden' name='prod_img' value="${dto.prod_img }" > --%>
<%-- 			<input type='hidden' name='prod_real_img' value="${dto.prod_real_img }" > --%>
<%-- 			<input type='hidden' name='prod_price' value="${dto.price }" > --%>
			<!-- 수량 추가하기 구현 -->
			<div>
				수량
				<input type='button' id="minus" value='-'/>
				<input type='text' class='prod_count' name='prod_count' value="1" >
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
				<input type="submit" value="담기" onclick="location.href='./CartWrite.pr?skip_cart=false';">
<!-- 				<input type="submit" value="주문하기" onclick="location.href='./CartWrite.pr?skip_cart=true';"> -->
	        	<input type="button" value="상품 목록" onclick="location.href='./ProductList.pr';">
			</div>
		</form>
		
	</div>
	
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>