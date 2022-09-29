<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardpassword.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	<title>문의사항 비밀번호 확인</title>
<script>
    $(document).ready(function() {
        $('.form').submit(function(){
  			if($('#qna_password').val()=="") { 
				alert('비밀번호를 입력하세요');  				
  				$("#qna_password").focus();
  				return false;
  			}
  			if($.isNumeric($('#qna_password').val()) != true) {
  			    alert('비밀번호는 숫자 4자리만 가능합니다.');
		  		$("#qna_password").focus();
		  	    return false;
		  	} 
        });
   	});//
</script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 	<h1>QnAPassword.jsp</h1> -->	

	<%
		String button = request.getParameter("button");
		String qna_num = request.getParameter("qna_num");

		if(button.equals("delete")){
	%>
	
	<div class="wrapper" style="margin: auto;">

	<br>
	<h1>삭제하려는 글의 비밀번호를 입력하세요.</h1> 
	<br>
	
	<form action = "./QnADelete.qna?qna_num=<%=qna_num %>" method="post" class="form">
	<div class="btndiv" style="margin:auto;">
		<input class="btn1" type="password" id="qna_password" name="qna_password" maxlength="4" placeholder="숫자 4자리">
		<br>
		<br>
<!-- 		<input type="button" name="password_match" id="password_btn" value="확인"> <br>	 -->
<!-- 		<div id="password_div"></div> -->
			<input class="btn2" type="submit" value="삭제" name="delete_qna">
			<input class="btn2" type="button" value="취소" name="cancle_qna">
	<br>
	</div>	
	</form>
	</div>
	<br>

	<%
		} else if (button.equals("update")) {	
	%>
	
	<div class="wrapper" style="margin: auto;">
	
	<br>
	<h1>수정하려는 글의 비밀번호를 입력하세요. </h1>
	<br>
	
	<form action="./QnAPasswordCheck.qna?qna_num=<%=qna_num %>&button=update" method="post" class="form">
	<div class="btndiv">
		<input class="btn1" type="password" id="qna_password" name="qna_password" maxlength="4" placeholder="숫자 4자리">
		<br>
		<br>
			<input class="btn2" id="update" type="submit" value="수정" name="update_qna">
			<input class="btn2" type="button" value="취소" name="cancel_qna">
	<br>
	</div>
	</form>
	</div>
	<br>
	<%
	}
	%>
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>