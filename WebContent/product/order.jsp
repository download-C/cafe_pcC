<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	int order = (Integer)request.getAttribute("order");
// 	HttpSession session = new HttpSession();
// 	int number = session.getAttribute("number");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주문하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/product/order.css" rel="stylesheet" type="text/css">
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./JavaScript/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//alert("test1");
	IMP.init("imp73101414");
	
	$("#order").on("click", function() {
 		var date = new Date();
 		var now = date.getTime();
		alert("pcc_"+now);

		//결제하기
		IMP.request_pay({
			pg: "html5_inicis",
			pay_method: "card",//결제방식 그대로
			merchant_uid: "pcc_"+now, //주문번호
			name: "cafe_pcc",//상호명
			amount: "${order}",//결제 금액
			buyer_name: "${sessionScope.name}",
// 			buyer_tel: "${sessionScope.phone}",
		}, function(rsp) {
			if(rsp.success) {
				alert("결제가 정상적으로 완료되었습니다.");
				
			} else {
				alert("결제에 실패하였습니다.");
				alert(rsp.error_msg);
			}
		});
	});
	
	$('#order_test').click(function(){
		var blank = $('input:radio[name=pickup_time]').is(":checked");
		if(blank == false ){
			alert("픽업 시간을 체크하세요.");
				return false;
		}
	});
});//jQuery
</script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<div style="position: relative; height: 100px"></div>
	
	<div class="container1">
	
		<div class="title">
			<h1 class="title_text">결제하기</h1>
			<div class="title_text2">주문 정보</div>
		</div>
		
	<form action="./Order.pr">
	
	<div class="order_box">
		<div class="title_box">
			<span class="box1">상품 정보</span>
			<span class="box1">수량/옵션</span>
			<span class="box1">주문금액</span>
		</div>

		<!-- content_box -->
		<div class="content_box">
			<c:forEach var="dto" items="${requestScope.cartList }">
			<input type="hidden" name="cart_num" value="${dto.cart_num}">
			
			<!-- content_box1 -->
			<div class="content_box1">
				<!-- 상품 정보 -->
				<div class="box2">
					<div class="content_inner">
						<a href="./ProductContent.pr?prod_num=${dto.prod_num }">
				
							<div class="content_img">
								<img src="img/product/${dto.prod_img}"></div>
							</div>
							
							<div class="content_info">
								<div class="content_title">${dto.prod_name }</div>
								<div class="content_price"><span>${dto.price}</span>원</div>							
							</div>
						</a>
					</div>
					
		      		<!--  수량/옵션 -->
		        	<div class="box2">
						<div>	
							<div class="count">${dto.prod_count}</div>
							<div class="requirements">${dto.requirements}</div>
		       			</div>
	       			</div>
       			
	      			<!-- 상품수량에 따른 total_price -->
					<div class="box2">
						<div>
							<div class="total_price"><span class="total_price">${dto.total_price}</span>원</div>
						</div>
					</div>
			</div>
			<!-- content_box1 -->
			</c:forEach>
		</div>
		<!-- content_box -->
			
	</div>
	<!-- order_box -->
	
	<!-- container2 -->
	<div class="container2">
	
		<div class="order_info">
			<div class="label"> 주 문 자 명 : </div>
			<div class="text">${sessionScope.name}</div>
		</div>
		
		<div class="order_info">
			<div class="label">총 주문 금액 :</div>
			<div class="text">${order}원</div>
		</div>
		
		<div class="order_info">
			<div class="label">수령 예정 시간 : </div>
			<div>
		        <input class="text" type="radio" name="pickup_time" id="pickup_time" value="5">5분 뒤
				<input class="text" type="radio" name="pickup_time" id="pickup_time" value="10">10분 뒤
			 	<input class="text" type="radio" name="pickup_time" id="pickup_time" value="15">15분 뒤<br>
			</div>
		</div>
 	
 		<div class="order_info button_area">
			<input type="submit" value="결제하기" id="order_test">
			<input type="button" value="상품 목록 돌아가기" class="return_product" onclick="location.href='./ProductList.pr';">
			<input type="hidden" name="order_price" value="${order}">
			
 		</div>
	</div>
	<!-- container2 -->
		
		
	</form>
	</div>
			<input type="button" value="결제 테스트" id="order">
	<!-- container1 -->
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>