<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="./script/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function() {
		$("#password_btn").click(function(){
			$.ajax({
				url:"./ReviewPasswordCheck.rv",
				data:{'review_password':$('#password').val()},
				success:function(rdata){
					$('#password_div').html(rdata);
				}
			});
		});
	});
</script>

</head>
<body>
	<h1>reviewPassword.jsp</h1>
	<fieldset>
	삭제하려는 글의 비밀번호를 입력하세요. <br>
	<form action = "./ReviewDelete.rv?review_num=" method="post">
	<div>	
		<input type="password" id="password" name="review_password" maxlength="4" placeholder="숫자 4자리">
		<input type="button" name="password_match" id="password_btn"> <br>
		<div id="password_div"> </div>
		<input type="submit" value="삭제" name="delete_review">
		<input type="button" value="취소" name="cancel_review">
	</div>
	</form>
	</fieldset>
</body>
</html>