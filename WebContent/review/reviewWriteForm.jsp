<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 작성하기</title>
</head>
<body>
	<h1>reviewForm.jsp</h1>
	
	<% 
// 	HttpSession session = request.getSession();
// 	//매니저 로그인 했을 때
// 	if(session.getAttribute("mgr_num")) {
// 		name=""
// 	} 
// 	// 회원 로그인했을 때 
// 	else {
		
// 	}
	%>
	<fieldset>
		<legend>리뷰 작성하기</legend>
		<form action="./ReviewWriteAction.rv" method="post">
		<div>
		작성자 <input type="text" name="name" id="name" readonly="readonly"> 
		비밀번호 <input type="password" name="review_password" placeholder="4자리 숫자로 적으세요"> <br>
		제목 <input type="text" name="review_subject"> <br>
		내용 <textarea rows="30" cols="80 " name="review_content"></textarea> <br>
		첨부파일 <input type="file" name="review_file" id="review_file"> <br>
		</div>
		<div>
		<input type="submit" value="작성"> &nbsp;&nbsp;
		<input type="button" value="취소">
		</div>
		</form>
	</fieldset>
	
	
</body>
</html>