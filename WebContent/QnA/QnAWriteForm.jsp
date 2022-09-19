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
	
	<%
	
// 매니저 로그인시
// 	if (session.getAttribute("Mgr_num")) {
// 		name = ""
// 	}
	
// 	 회원 로그인시
// 	else {
		
// 	}
	
	%>	
	
	<br>
	
	<fieldset>
	<legend>문의사항 작성하기</legend>
	<form action="./QnAWriteAction.qna" method="post">
	<div>
	작성자 : <input type="text" name="mem_num" readonly="readonly" value="${dto.Mem_num}"> <br>
	비밀번호 : <input type="password" name="qna_password" placeholder="4자리 숫자로 입력하세요."> <br>
	제목 : <input type="text" name="qna_subject"> <br>
	내용 : <textarea rows="10" cols="20" name="qna_content"></textarea> <br>
	첨부파일 : <input type="text" name="qna_file"> <br>
	</div>	
	<div>
	<input type="submit" value="작성" onclick="location.href='./QnAContent.qna?qna_num='"> &nbsp;&nbsp;
	<input type="button" value="취소">
	</div>
	</form>
	</fieldset>


</body>
</html>