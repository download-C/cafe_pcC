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
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- <h1>reservationList.jsp</h1> -->

<%
	String mem_num = (String)session.getAttribute("mem_num");
	String mgr_num = (String)session.getAttribute("mgr_num");

%>

	
<% 
	if(mem_num != null) {
%>		
	<div class="wrapper" style="margin-left: 15%; margin-right: 15%;">

	<div>
		<input type="button" name="res_btn" class="writebtn" id="res_btn" value="예약하기" 
		onclick="location.href='./Reservation.re';"> <br><br>
	</div>
<%
	}  else if(mgr_num != null){
		%>		<input type="button" name="res_btn" id="res_btn" value="예약하기" 
				onclick="location.href='./Reservation.re';"> <br><br>
		<% 				
			}
		%>



	<fieldset>
		<table id="res_tr1">
			<tr>
				<td><h3>예약 번호</h3></td>
				<td><h3>예약자</h3></td>
				<td><h3>예약 날짜 및 시간</h3></td>
				<td><h3>예약 인원</h3></td>
				<td><h3>수정/삭제</h3></td>
			</tr>
		<c:forEach var="dto" items="${reservationList }"> 
			<tr>
				<td>${dto.res_num }</td>
				<td>${dto.name }</td>
				<td>${dto.res_date } / ${dto.res_time }시</td>
				<td>${dto.res_persons }명</td>	
				<td>
					<input type="button" value="예약 수정" name="res_update" 
					onclick="location.href='./ReservationUpdateForm.re?res_num=${dto.res_num }';">  
					<input type="button" value="예약 삭제" name="res_delete" 
					onclick="location.href='./ReservationDeleteAction.re?res_num=${dto.res_num}';">
				</td>			
			</tr>	
		</c:forEach>
		
		</table>
		
	</fieldset>
		<br><br>		
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
		<br>
		<br>	
	</div>		
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>