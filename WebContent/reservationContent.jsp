<%@page import="com.pcc.reservation.db.ReservationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> </title>
</head>
<body>
	<h1>reservationContent.jsp</h1>
	
	<table border="1">
	
	
	
      <tr>
        <td>예약 날짜 및 시간</td>
        <td>예약 인원</td>
      </tr>
	       <tr>
	        <td><%=session.getAttribute("res_date") %></td>
	        <td><%=session.getAttribute("res_num")%></td>
	        
	      </tr>
 
     </table>
	

</body>
</html>