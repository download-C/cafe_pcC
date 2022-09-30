<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 비밀번호 확인</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardpassword.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script  src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
// var review_num = '<c:out value="${review_num }" />';
	
// 	$(document).ready(function() {

// 		$("#password_btn").click(function(){
// 			$.ajax({
// 				url:"./ReviewPasswordCheck.rv",
// 				data:{'review_password':$('#password').val(), 'review_num':$('#')},
// 				success:function(rdata){
// 					$('#password_div').html(rdata);
// 				}
// 			});
// 		});
// 	});
</script>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<div style="position: relative; height: 100px"></div>

<!-- <h1>reviewPassword.jsp</h1> -->

	<% 
		String button = request.getParameter("button");
		String review_num = request.getParameter("review_num");
	
	if(button.equals("delete")) {
	%>
	
	<div class="wrapper" style="margin: auto;">
	<div class="title_img">
	      <img src="./img/images/img (2).jpg">
	      <h1 class="title">PASSWORD CHECK</h1>
	      <div class="img_box"></div>
	    </div>
	<br>
	<h1>삭제하려는 글의 비밀번호를 입력하세요.</h1>
	<br>
	
	<form action = "./ReviewDelete.rv?review_num=<%=review_num %>" method="post">
	<div class="btndiv" style="margin:auto;">	
		<input class="btn1" type="password" id="password" name="review_password" maxlength="4" placeholder="숫자 4자리">
		<br>
		<br>
<!-- 		<input type="button" name="password_match" id="password_btn" value="확인"> <br> -->
<!-- 		<div id="password_div"> </div> -->
		<input class="btn2" type="submit" value="삭제" name="delete_review">
		<input class="btn2" type="button" value="취소" name="cancel_review">
	<br>
	</div>
	</form>
	</div>
	<br>
	
	<%
	} else if(button.equals("update")){
	%>
	
	<div class="wrapper" style="margin: auto;">
	<div class="title_img">
	      <img src="./img/images/img (2).jpg">
	      <h1 class="title">PASSWORD CHECK</h1>
	      <div class="img_box"></div>
	    </div>
	<br>
	<h1>수정하려는 글의 비밀번호를 입력하세요. </h1>
	<br>	
	
	<form action = "./ReviewPasswordCheck.rv?review_num=<%=review_num %>&button=update" method="post">
	<div class="btndiv" style="margin:auto;">	
		<input class="btn1" type="password" id="review_password" name="review_password" maxlength="4" placeholder="숫자 4자리">
		<br>
		<br>
<!-- 		<input type="button" name="password_btn" id="password_btn" value="확인"> <br> -->
<!-- 		<div id="password_div"> </div> -->
		<input class="btn2" type="submit" value="수정" name="delete_review">
		<input class="btn2" type="button" value="취소" name="cancel_review">
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