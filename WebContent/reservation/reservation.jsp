<%@page import="com.pcc.reservation.db.ReservationDTO"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.pcc.reservation.db.ReservationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<h1>reservation.jsp</h1>

	<jsp:useBean id = "dto" class="com.pcc.reservation.db.ReservationDTO"/>
	<jsp:setProperty property = "*"  name = "dto"/>

	
	
	<% 
	
		request.setCharacterEncoding("UTF-8");
	
	
		String res_date = request.getParameter("res_date");
		String res_hour = request.getParameter("res_hour");
		String res_num = request.getParameter("res_num_of_persons");
		
		session.setAttribute("res_date", res_date);
		session.setAttribute("res_hour", res_hour);
		session.setAttribute("res_num", res_num);
	
		ReservationDAO dao = new ReservationDAO();
		
	
	int result = dao.reservation(dto);
	
	if(result == 1){
		%>
		<script type="text/javascript">
		alert("예약이 완료되었습니다.");
		location.href = "reservationContent.jsp";	
		</script>
		
<% 		
	}
	else if(result == 2){
	%>
		<script type="text/javascript">
		alert("예약이 완료되었습니다.");
		location.href = "reservationContent.jsp";	
		</script>
	
<%
	} else if(result == 3){
		%>
		<script type="text/javascript">
		alert("예약이 불가능합니다.");
		location.href = "reservationForm.jsp";	
		</script>
		
<% 	
	}

	%>
	   
	   
	   
	   
	   
	
	
  


	

	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>