<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>제품 상세 내용</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/product/productContent.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

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

<div style="position: relative; height: 100px"></div>
		
	<div class="container1">
	
	<!-- 상품 사진 -->
	<div class="img_box">
		<img src="img/product/${dto.prod_img}">
	</div>
	
	
	<div class="info_box">	
	<!-- 상품 정보 & 장바구니 담기 버튼 -->
	<form action="./CartWrite.pr" method="post">
	
	
			<div class="info name">${dto.prod_name}</div>
			<div class="info price"><span id="price">${dto.price}</span>원</div>
			
			<input type='hidden' name='prod_num' value="${dto.prod_num }" >
			<input type="hidden" name="mem_num" value="${sessionScope.mem_num }">
					
			<!-- 수량 추가하기 구현 -->
			<div class="info count_box">
				<div class="count_title">수량</div>
				<div class="count_input">
					<input class="count" type='button' id="minus" value='-'/>
					<input type='text' class='prod_count' name='prod_count' value="1" >
	    	    	<input class="count" type='button' id="plus" value='+'/>
				</div>
			</div>
			
			<!-- 요청사항 작성란 -->
			<div class="info option">
				<div class="option_title">옵션</div>
				<div class="option_text">
					<textarea rows="1" cols="30" placeholder="샷 2번 추가" name="requirements" ></textarea>
				</div>
			</div>
			
			<!-- 수량에 따른 실시간 가격 -->
			<div class="info total_price_box">
				<div class="total_price_title">총 금액</div>
				<div class="total_price_value"><span class="total_price">${dto.price }</span>원	</div>
				<input type="hidden" class="total_price_hidden" name="total_price" value="${dto.price }">
			</div>
				
			<!-- 장바구니 담기 버튼 -->
			<div class="info button">
				<input class="button1" type="submit" value="담기">
	        	<input class="button2" type="button" value="상품 목록" onclick="location.href='./ProductList.pr';">
			</div>
			
	</form>
	</div>
	</div>
	
	<div class="container2">
		<span><a href="./ReviewList.rv">구매 후기</a></span>
		<span class="line">/</span>
		<span><a href="./QnAList.qna">Q&A</a></span>
	</div>
	
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>