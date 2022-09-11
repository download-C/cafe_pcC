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
	
	예약날짜 <input type="text" name="res_date" placeholder="0000-00-00(년-월-일)로 입력해주세요">

	예약시간<input type="text" name="res_hour" placeholder="00:00(시-분)으로 입력해주세요">
	<hr>
	예약 최대 가능 인원은 8명 이며, 예약 가능 시간은 13:00~21:00시 까지 입니다.
	<br><br>
	<input type="submit" value="예약하기"> 
	</form>
	
</body>
</html>