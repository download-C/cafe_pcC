<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="./script/jquery-3.6.0.js"></script>
<script >
$(document).ready(function(){

	//아이디 중복체크
	$('.dup').click(function(){
	
		$.ajax({
			url:'./IdCheck.me',
			data:{'phone':$('.phone').val()},
			success:function(rdata){
				$('.phonediv').html(rdata);
			}
		});
	});
	
});//
</script>
</head>

<body>
<fieldset>
<form action="./JoinAction.me" id="join" method="post">
핸드폰번호:<input type="text" name="phone" class="phone">
<input type="button" value="중복확인" class="dup"><br>
<label></label><div class="phonediv"></div><br>
비밀번호:<input type="password" name="password" class="password"><br>
비밀번호 확인:<input type="password" name="password2" class="password2"><br>
이름: <input type="text" name="name" class="name"><br>
<input type="submit" value="가입하기"> <input type="reset" value="다시작성"> 


</form>
</fieldset>
</body>
</html>