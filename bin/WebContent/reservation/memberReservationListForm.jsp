<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberReservationListForm.jsp</h1>
	
	
	<form action="./MemberReservationListAction.re" method = "post">
	
	회원번호 <input type="text" name="mem_num" placeholder="회원번호를 입력해주세요.">
	
<!-- 	이건 임시로 MemberResrvationList작동 test용  -->
<!-- 	나중에 merge하면 로그인 한 아이디나 비밀번호로 조회 예정 -->

	<br><br>
	<input type="submit" value="예약내역 조회"> 
	</form>

</body>
</html>