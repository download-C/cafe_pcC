<%@page import="com.pcc.reservation.db.ReservationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약 상세 페이지</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<h1>reservationContent.jsp</h1>
	
	<%
	session = request.getSession();
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	%>
	
	<table border="1">
      <tr>
      	<td>예약 번호</td>
      	<td>${dto.res_num}</td>
      	<td>예약자</td>
      	<td>${dto.name }</td>
     </tr>
     <tr>
        <td>예약 날짜 및 시간</td>
        <td></td>
        <td>예약 인원</td>
        <td></td>
      </tr>
	       <tr>
	        <td><%=request.getAttribute("res_date") %> <%=request.getAttribute("res_time")시 %> </td>
	        <td><%=request.getAttribute("res_num")%></td>
	        
	      </tr>
 
     </table>
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>