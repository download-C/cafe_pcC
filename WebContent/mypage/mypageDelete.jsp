<%@page import="com.pcc.member.db.MemberDTO"%>
<%@page import="com.pcc.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MY PAGE DELETE</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/mypage/mypageDelete.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script  src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
   // alert("document.fr.pw.value : "+document.fr.pw.value);
   function checkData(){
   	var password = document.fr.password.value;
   
   	if(password == "" || password.length<1){
   		alert("비밀번호를 입력하세요.");
   		document.fr.password.focus();
   		return false;
   	  }
   }
</script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<div style="position: relative; height: 100px"></div>

<%
       // 로그인 여부 체크
       String mem_num = (String) session.getAttribute("mem_num");
//     if(mem_num == null){
//     	   response.sendRedirect("loginForm.jsp");
//     }
%>

<% 
// 사용자 비밀번호를 입력 전달
%>
     
<div class="wrapper">
	<div class="title_img">
		<img src="./img/images/img (3).jpg">
		<h1 class="title" style="font-size: 28px;">MY PAGE DELETE</h1>
		<div class="img_box"></div>
	</div>
	<div class="container">
    	<form action="./mypageDeleteAction.me" method="POST" id="delete" onsubmit="return checkData()" name="fr"> 
	       	<div class="mydiv">
	        	<div>비밀번호를 한 번 더 입력하세요.</div>
	        	<div><input type="password" name="password"></div>
	       	</div>
	        <div class="btndiv">
	        	<input type="submit" class="btn" value="탈퇴하기">
	         </div>
       </form>
    </div><br>
</div>

<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 --> 
</body>
</html>
