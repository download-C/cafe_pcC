<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>QnAWriteForm.jsp</h1>
	<h2> 문의사항 작성페이지</h2>	
	
	<br>
	
	<fieldset>
	<form action="./QnAWriteAction.qna" method="post">
	
	회원번호 : <input type="text" name="mem_num" readonly="readonly" value="${dto.mem_num}"> <br>
	비밀번호 : <input type="password" name="QnA_password" placeholder="11자 미만 숫자 입력"> <br>
	제목 : <input type="text" name="QnA_subject"> <br>
	내용 : <textarea rows="10" cols="20" name="QnA_content"></textarea> <br>
	첨부파일 : <input type="text" name="QnA_file"> <br>

	<input type="submit" value="작성하기">
	
	
	</form>
	</fieldset>


</body>
</html>