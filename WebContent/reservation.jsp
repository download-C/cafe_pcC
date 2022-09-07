<%@page import="com.pcc.reservation.db.ReservationDTO"%>
<%@page import="com.pcc.reservation.db.ReservationDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>reservation.jsp</h1>

	
	<% 
	
		request.setCharacterEncoding("UTF-8");
	
	
	
		ReservationDAO dao = new ReservationDAO();
		ReservationDTO dto = new ReservationDTO();
	
	int result = dao.reservation(dto);
	
	if(result == 0){
		%>
		<script type="text/javascript">
		alert("잘못입력하셨거나, 예약 가능 인원이 초과되었습니다.");
		location.href("reservationForm.jsp");	
		</script>
		
<% 		
	}
	else if(result == 1){
	%>
		<script type="text/javascript">
		alert("예약이 완료되었습니다.");
		location.href("reservationForm.jsp");	
		</script>
	
	
<% 		
	}
	else if(result == 2){
		
	%>
		<script type="text/javascript">
		alert("예약이 불가능합니다.");
		location.href("reservationForm.jsp");	
		</script>
<%
	} else if(result == 3){
		%>
		<script type="text/javascript">
		alert("예약이 완료되었습니다.");
		location.href("reservationForm.jsp");	
		</script>
	<% 	
	}
	else if(result == 4){
	%>
		<script type="text/javascript">
		alert("예약이 불가능합니다.");
		location.href("reservationForm.jsp");	
		</script>
<% 		
	}
	%>
	
	   
	   
	   
	   
	   
	   
	
	
  


	

	
	
</body>
</html>