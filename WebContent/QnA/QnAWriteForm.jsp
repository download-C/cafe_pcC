<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<form action="./QnAWriteAction.bo" method="post">
	
	비밀번호 : <input type="password" name="QnA_password"> <br>
	제목 : <input type="text" name="QnA_subject"> <br>
	내용 : <textarea rows="10" cols="20" name="QnA_content"></textarea> <br>
	첨부파일 : <input type="text" name="QnA_file"> <br>

	<input type="submit" value="작성하기">
	
	</form>
	</fieldset>

</body>
</html>