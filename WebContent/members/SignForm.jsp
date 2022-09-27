<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/member/signform.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script src="./script/jquery-3.6.0.js"></script>
<script>
    $(document).ready(function () {

        $('#join').submit(function(){
//             alert("전송");

  			if($(".phone").val()=="") {
  				$('.phonediv').html("아이디를 입력하세요.");
  				$(".phone").focus();
  				return false;
  			}
            if($(".password").val()=="") {
				$('.passdiv').html("비밀번호를 입력하세요.");
				$(".pass").focus();
				return false;
			}
            if ($('.password2').val()!=$('.password').val()) {
                $('.pass2div').html("비밀번호가 다릅니다.");
                $('.pass2div').focus();
                return false;
            }
            if ($('.name').val() == "") {
                $('.namediv').html("이름을 입력하세요.")
                $('.namediv').focus();
                return false;
            }
        });

        //아이디 중복체크
	
		$('.dup').click(function() {
		//alert("중복");
			if($(".phone").val()=="") {
				$('.phonediv').html("아이디를 입력하세요");
				$(".phone").focus();
				return;
			}
			// DB 연동을 위한 jsp 파일 연결
// 				alert($(".phone").val());
			$.ajax({
			// id 체크 기능을 실행하는 idcheck.jsp 연결하기
// 				request.setAttribute("phone");
			
				url:'./IdCheck.me',
				data: {'phone':$('.phone').val()},
				success: function(rdata) {
					$('.phonediv').html(rdata);
				}
			});
		});
   	});//
</script>
</head>

<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 메인 시작 -->

	<fieldset id="field">
		<form action="./JoinAction.me" id="join" method="post" >
		<br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="phone" class="phone" placeholder="휴대폰 번호">
			<input type="button" value="중복확인" class="dup"><br> 
			<div class="phonediv"></div> <br> 
			<input type="password" name="password" class="password" placeholder="비밀번호"><br> 
			<div class="passdiv"></div> <br> 
			<input type="password" name="password2" class="password2" placeholder="비밀번호 확인"><br> 
			<div class="pass2div"></div> <br> 
			<input type="text" name="name" class="name" placeholder="이름"><br>
			<div class="namediv"></div> <br> 
		
			<input type="submit" value="가입하기"> <input type="reset" value="다시작성">
			
		</form>
	</fieldset>

<!-- 메인 끝 -->
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>