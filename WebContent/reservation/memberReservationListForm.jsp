<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberReservationListForm.jsp</h1>
	
	
	<form action="./MemberReservationListAction.re" method = "post">
	
	회원번호 <input type="text" name="mem_num" placeholder="회원번호 1자리를 입력해주세요.">
	
	<br><br>
	<input type="submit" value="예약내역 조회"> 
	</form>

</body>
</html>