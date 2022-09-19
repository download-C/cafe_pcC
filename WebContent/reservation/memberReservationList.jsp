<%@page import="com.pcc.reservation.db.ReservationDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 예약 내역</title>
<%
	String mem_num = (String)session.getAttribute("mem_num");
	String mgr_num = (String)session.getAttribute("mgr_num");
%>
</head>
<body>
	<h1>memberReservationList.jsp</h1>

	<input type="button" value="예약하기" onclick="location.href='./Reservation.re';">
	<% 
	List<ReservationDTO> memberReservationList = (List<ReservationDTO>)request.getAttribute("memberReservationList");
	%>
	
	<table border="1">
		<tr>
			<td>예약 날짜 및 시간</td>
			<td>예약 번호</td>
<!-- 			<td>멤버 번호</td> -->
			<td>예약자</td>
			<td>예약 인원</td>
		</tr>
		<%
			for(int i = 0; i<memberReservationList.size(); i++){
			ReservationDTO dto = memberReservationList.get(i);

			%>

		<tr>
			<td><%=dto.getRes_date()%></td>
			<td><%=dto.getRes_num()%></td>
<%-- 			<td><%=dto.getMem_num()%></td> --%>
			<td><%=dto.getName() %>
			<td><%=dto.getRes_num_of_persons()%></td>
		</tr>
		<%} %>
	</table>

</body>
</html>