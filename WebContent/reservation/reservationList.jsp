<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 예약 목록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/reservation/reservationlist.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script  src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- <h1>reservationList.jsp</h1> -->
	<div style="position: relative; height: 100px"></div>

<%
	String mem_num = (String)session.getAttribute("mem_num");
	String mgr_num = (String)session.getAttribute("mgr_num");

%>

	
<% 
	if(mem_num != null) {
%>		
	<div class="wrapper">
	<h1> RESERVATION LIST</h1>
	<div>
		<input type="button" name="res_btn" class="writebtn" id="res_btn" value="예약하기" 
		onclick="location.href='./Reservation.re';"> <br><br>
	</div>
<%
	} 
%>
	<br>
		<div class="container">
			<div class="ss">예약 번호</div>
			<div class="ss">예약자</div>
			<div class="ss">예약 날짜 및 시간</div>
			<div class="ss">예약 인원</div>
			<div class="ss">수정/삭제</div>
			<c:forEach var="dto" items="${reservationList }"> 
				<div>${dto.res_num }</div>
				<div class="subdiv">${dto.name }</div>
				<div>${dto.res_date } / ${dto.res_time }시</div>
				<div>${dto.res_persons }명</div>	
				<div class="btndiv">
					<input type="button" value="예약 수정" name="res_update" class="btn"
					onclick="location.href='./ReservationUpdateForm.re?res_num=${dto.res_num }';">
					<input  type="button" value="예약 삭제" name="res_delete" class="btn" 
					onclick="location.href='./ReservationDeleteAction.re?res_num=${dto.res_num}';">
				</div>
			</c:forEach>
			<br>
		</div>
		<br><br>
		<div class="pagediv">		
		<c:if test="${cnt != 0 }">
			<c:if test="${startPage > pageBlock }">
				<a href="./ReservationList.re?pageNum=${startPage-pageBlock }">이전</a>
			</c:if>
			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			&nbsp;
			<span style="font-size: 20px; background-color:#adc2a9; border-radius: 5px; ">&nbsp;<a href="./ReservationList.re?pageNum=${i }">${i }&nbsp;</a></span>
			&nbsp;
			</c:forEach>
			<c:if test="${endPage < pageCount }">
				<a href="./ReservationList.re?pageNum=${startPage + pageBlock }">다음</a>
			</c:if>
		</c:if>
		</div>
		<br>
		<br>	
	</div>		
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>