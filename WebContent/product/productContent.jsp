<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>productContent.jsp</h1>
	
	<h2>상품 상세 페이지</h2>
	
	<!-- 상품 정보 & 장바구니 담기 버튼 -->
	<div>
		<!-- 상품 정보 -->
		<div>
			<div>상품 사진</div>
			<div>
			${dto.category }<br>
			${dto.prod_name }<br>
			${dto.price }<br>
			</div>
		</div>
		
		<!-- 장바구니 담기 버튼 -->
		<div>
			 수량 추가하기 구현
        	 <input type="button" value="상품 목록" onclick="location.href='./ProductList.pr';">
		</div>
	</div>
	
	
	
</body>
</html>