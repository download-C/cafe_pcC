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
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./script/jquery-3.6.0.js"></script>
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

	<h1>결제하기</h1>
	
	<form action="./Order.pr">
	<div>주문 정보</div>
		<table border="1">
	     	<tr>
		       <td>상품 정보</td>
		       <td>수량/옵션</td>
		       <td>주문금액</td>
		     </tr>
		     
			<c:forEach var="dto" items="${requestScope.cartList }">
			<input type="hidden" name="cart_num" value="${dto.cart_num}">
				<tr>
	      			<td>
						<a href="./ProductContent.pr?prod_num=${dto.prod_num }">
							<div><img src="img/product/${dto.prod_img}"></div>
							<div>${dto.prod_name }</div>
							<div>${dto.price}</div>							
						</a>
	      			</td>
	      			
	       			<td>
						<div>${dto.prod_count}</div>
						<div>${dto.requirements}</div>
	       			</td>
	       			
	       			<td>
						<div>${dto.total_price}원</div>
	       			</td>
	    	 	</tr>
			</c:forEach>
		</table>
		
		<div>주문자명 : ${sessionScope.name}</div>
		
		<div>총 주문 금액 : ${order} 원</div>
		
		<div>
			<label for="pickup_time">수령 예정 시간 : </label>
	        <input type="radio" name="pickup_time" id="pickup_time" value="5">5분 뒤
			<input type="radio" name="pickup_time" id="pickup_time" value="10">10분 뒤
		 	<input type="radio" name="pickup_time" id="pickup_time" value="15">15분 뒤<br>
		</div>
	 	
		<input type="hidden" name="order_price" value="${order}">
		<input type="submit" value="결제하기" id="order_test">
		<input type="button" value="결제 테스트" id="order">
	</form>	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>