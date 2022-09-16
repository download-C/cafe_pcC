<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>reservationForm.jsp</h1>



	<form action="./ReservationAction.re" method = "post">
	
	인원 <input type="number" name="res_num_of_persons" placeholder="숫자만 입력하세요.">
	
	<br><br>
	
	예약날짜 <input type="datetime-local" name="res_date">
	
	<hr>
	예약 최대 가능 인원은 8명 이며, 예약 가능 시간은 오후 1시 ~ 9시까지 입니다.
	<br><br>
	<input type="submit" value="예약하기"> 
	</form>
	
	
	
</body>
</html>