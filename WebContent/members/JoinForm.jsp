<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
            if ($('.password2').val() != $('.password2').val()) {
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
		})
   	});//
</script>
</head>

<body>
<!-- 헤더 시작 -->
	<header>
	<jsp:include page="../main/top2.jsp" />
	</header>
<!-- 헤더 끝 -->
<!-- 메인 시작 -->
	<main>
	<fieldset>
		<form action="./JoinAction.me" id="join" method="post">
			핸드폰번호:<input type="text" name="phone" class="phone"> 
			<input type="button" value="중복확인" class="dup"><br> <label></label>
			<div class="phonediv"></div> <br> 
			비밀번호:<input type="password" name="password" class="password"><br> 
			<div class="passdiv"></div> <br> 
			비밀번호 확인:<input type="password" name="password2" class="password2"><br> 
			<div class="pass2div"></div> <br> 
			이름: <input type="text" name="name" class="name"><br>
			<div class="namediv"></div> <br> 
			<input type="submit" value="가입하기"> <input type="reset" value="다시작성">
		</form>
	</fieldset>
	</main>
<!-- 메인 끝 -->
<!-- 푸터 시작 -->
	<footer>
	
	</footer>
<!-- 푸터 끝 -->
	
</body>
</html>