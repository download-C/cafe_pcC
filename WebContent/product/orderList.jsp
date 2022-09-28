<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js"
	crossorigin="anonymous"></script>
<title>주문목록</title>
<script type="text/javascript" src="./script/jquery-3.6.0.js"></script>


<script type="text/javascript">
// 	$(document).ready(function(){
// 			alert(${requestScope.orderProductList.size()});


			
			
			
// 			for(var i = 0; i < ${requestScope.orderList.size()};i++){
// 				alert("하이");
				
// 				for(var i = 0; i < ${requestScope.orderProductList.size()};i++){
					
// 					var h = $('.orderList').eq(i).attr('data-text');
// 					var hide = $('.cartList').eq(i).attr('data-text');
					
// // 			var hide = $('.cartList').eq(i).attr('data-text');
			
			
// 					if(hide == h){
						
// 						alert("같을 때");
						
// 						alert("h : " + h + ", hide : " + hide);
// // 						alert($(h).html());
// 	// 					$(hide).html().hide();
// 						$(h).html().hide();
						
// 					}
// 					else{
// 							alert("다름");
// 					}
// 							break;
	
// 				}
			
// 			}//for문
			
			
// 			}//for문
// 			var hide = $('.2022-09-27 16:37:27.0').html();
// 			var hide = $('.' + $('.orderProductList').attr('data-text')).html();
// 			alert(hide);
// 			alert(h);
// 			}
// 			$('.' + $(this).attr('data-text')).hide();
			//.cart리스트의 일시를 보여주라
			
// 			$('.orderProductList').not("."+$(this).attr('data-text')).hide();
			//.cart리스트가 아니면 가려라
// 	});
</script>


</head>

<body>
${time }
	<!-- 헤더들어가는 곳 -->
	<jsp:include page="../inc/top.jsp" />
	<!-- 헤더들어가는 곳 -->
	<div style="position: relative; height: 100px"></div>
	
	<%-- ${requestScope.orderList}<br> --%>
	<%-- ${requestScope.orderProductList}<br> --%>
<%-- 	${order_time}<br> --%>
	<%-- ${orderProductList.checked}<br> --%>
<%-- 	${checked } --%>


	<c:if test="${empty orderList}">
		<div>주문한 상품이 없습니다.</div>
		<input type="button" value="상품 목록으로 가기" class="return_product"
			onclick="location.href='./ProductList.pr';">
	</c:if>


	<c:if test="${not empty orderList}">
		<h1>주문 목록</h1>

		<!-- 금액은 fmt 반영하기 -->
		<%-- 	<fmt:formatNumber value="${money }"></fmt:formatNumber> --%>
		<%-- 		<c:set var="date" value="${orderList.order_time}"></c:set> --%>
		<%-- 		<fmt:formatDate value="${date }" dateStyle="medium"/><br> --%>

		
		
		<!-- 오더 리스트 시작 -->
		<c:forEach var="list2" items="${orderList }">
			주문일시 : <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list2.order_time}" />
			<c:set var="order" value="${list2.order_time}"/>


			<!-- 상품 리스트 시작 -->
			<c:forEach var="list1" items="${orderProductList }">
				<c:set var="cart" value="${list1.checked}"/>
				
			
				<c:if test="${cart eq order}">
					<a href="./ProductContent.pr?prod_num=${list1.prod_num }">
						<div>
							<img src="img/product/${list1.prod_img}">
						</div>
						<div>${list1.prod_name }</div>
						<div>
							<span>${list1.price}원</span>
							<span> X ${list1.prod_count} = </span>
							<span>${list1.total_price}원</span>
						</div>
					</a>
					<br>
				</c:if>
				
<%-- 				<c:if test="${list2.checked ne list1.order_time}"> --%>
<!-- 				일시가 같지 않은 구매 상품<br> -->
<%-- 				</c:if> --%>

			</c:forEach><br><br>
			<!-- 상품 리스트 종료 -->
			
		</div>
		</c:forEach>
		<!-- 오더 리스트 종료 -->
		

	</c:if>

	<!-- 푸터들어가는 곳 -->
	<jsp:include page="../inc/bottom.jsp" />
	<!-- 푸터들어가는 곳 -->
</body>
</html>