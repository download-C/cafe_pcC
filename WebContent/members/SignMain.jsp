<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/member/signmain.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" 	crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<fieldset id="f">
		<form action="./Reg.me" method="post">
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>

<div id="i">
	 <a href="javascript:void(0)">
	 <img src="./img/kakao_login.jpg" onclick="kakaoLogin();" >
            </a>
            </div>
     
<script>
Kakao.init('69921ac902c9cf695117dd2eae28be69'); //발급받은 키 중 javascript키를 사용해준다.
console.log(Kakao.isInitialized()); // sdk초기화여부판단
//카카오로그인
function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (response) {
        	  console.log(response)
          },
          fail: function (error) {
            console.log(error)
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }

</script>
			<hr>
			<input type="submit" value="ID/PW 회원가입">
		</form>
	</fieldset><br>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>