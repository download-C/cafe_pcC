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

	
	<% 
	List<ReservationDTO> reservationList = (List<ReservationDTO>)request.getAttribute("reservationList");
	
	String pageNum = (String) request.getAttribute("pageNum");
    int cnt = (int) request.getAttribute("cnt");
    int pageCount = (int) request.getAttribute("pageCount");
    int pageBlock = (int) request.getAttribute("pageBlock");
    int startPage = (int) request.getAttribute("startPage");
    int endPage = (int) request.getAttribute("endPage");
    
	%>
	<input type="button" name="res_btn" id="res_btn" value="예약하기" 
	onclick="location.href='./Reservation.re';"> <br><br>
	<table border="1">
		<tr>
			<td>예약 번호</td>
			<td>예약 날짜 및 시간</td>
			<td>예약 인원</td>
		</tr>
		<%
			for(int i = 0; i<reservationList.size(); i++){
			ReservationDTO dto = reservationList.get(i);
		%>
		<tr>
			<td><%=dto.getRes_num()%></td>
			<td><%=dto.getRes_date()%></td>
			<td><%=dto.getRes_persons()%></td>
		</tr>
		<%} %>
	</table>
	<%if(cnt != 0){
		if(startPage > pageBlock){%>
			<a href ="./ReservationList.re?pageNum=<%=startPage - pageBlock%>">[이전]</a>
	<%}
    	for(int i = startPage; i<=endPage; i++){%>
 			<a href="./ReservationList.re?pageNum =<%= i%>">[<%=i %>]</a>
	<%} 
		if(endPage < pageCount){%>
			<a href ="./ReservationList.re?pageNum=<%=startPage + pageBlock %>">[다음]</a>	
	<% 	}

 	  }%>
</body>
</html>