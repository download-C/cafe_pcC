<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 비밀번호 확인</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/qnapassword.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script src="./script/jquery-3.6.0.js"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<h3></h3>
	
	<%
		String button = request.getParameter("button");
		String qna_num = request.getParameter("qna_num");

		if(button.equals("delete")){
	%>
	
	<fieldset class="field1">
	삭제하려는 글의 비밀번호를 입력하세요. <br>
	<form action = "./QnAPasswordCheck.qna?qna_num=<%=qna_num %>" method="post">
	<div>
		<input type="password" id="password" name="qna_password" maxlength="4" placeholder="숫자 4자리">
<!-- 		<input type="button" name="password_match" id="password_btn" value="확인"> <br>	 -->
<!-- 		<div id="password_div"></div> -->
		<input type="submit" value="삭제" name="delete_qna">
		<input type="submit" value="취소" name="cancle_qna">
	</div>	
	</form>
	</fieldset>
	<%
		} else if (button.equals("update")) {	
	%>
	<fieldset class="field2">
	수정하려는 글의 비밀번호를 입력하세요. <br>
	<form action="./QnAPasswordCheck.qna?qna_num=<%=qna_num %>&button=update" method="post">
	<div>
		<input type="password" id="qna_password" name="qna_password" maxlength="4" placeholder="숫자 4자리">
		<input type="submit" value="수정" name="update_qna">
		<input type="button" value="취소" name="cancel_qna">
	</div>
	</form>
	</fieldset>
	<%
	}
	%>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>