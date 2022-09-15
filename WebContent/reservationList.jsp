<%@page import="com.pcc.reservation.db.ReservationDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>reservationList.jsp</h1>

	<table border="1">
	<% 
	List<ReservationDTO> reservationList = (List<ReservationDTO>)request.getAttribute("reservationList");
	%>
		<tr>
			<td>예약 번호</td>
			<td>멤버 번호</td>
			<td>예약 날짜</td>
			<td>예약 시간</td>
			<td>예약 인원</td>
			<td>전체 테이블 개수</td>
			<td>현재 예약된 테이블 개수</td>
		</tr>
		<%
			for(int i = 0; i<reservationList.size(); i++){
			ReservationDTO dto = reservationList.get(i);
		%>
		
		
		<tr>
			<td><%=dto.getRes_num()%></td>
			<td><%=dto.getMem_num()%></td>
			<td><%=dto.getRes_date()%></td>
			<td><%=dto.getRes_hour()%></td>
			<td><%=dto.getRes_num_of_persons()%></td>
			<td><%=dto.getTable_total()%></td>
			<td><%=dto.getTable_occupied()%></td>
		</tr>
		<%} %>
	</table>

</body>
</html>