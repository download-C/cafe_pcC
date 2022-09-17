<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="./script/jquery-3.6.0.js"></script>
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
<header><jsp:include page="../main/top.jsp"></jsp:include></header>
	<h1>reviewPassword.jsp</h1>
	<% 
		String button = request.getParameter("button");
		String review_num = request.getParameter("review_num");
	
	if(button.equals("delete")) {
		%>
	<fieldset>
	삭제하려는 글의 비밀번호를 입력하세요. <br>
	<form action = "./ReviewDelete.rv?review_num=<%=review_num %>" method="post">
	<div>	
		<input type="password" id="password" name="review_password" maxlength="4" placeholder="숫자 4자리">
<!-- 		<input type="button" name="password_match" id="password_btn" value="확인"> <br> -->
<!-- 		<div id="password_div"> </div> -->
		<input type="submit" value="삭제" name="delete_review">
		<input type="button" value="취소" name="cancel_review">
	</div>
	</form>
	</fieldset>
	<%
	} else if(button.equals("update")){
	%>
	<fieldset>
	수정하려는 글의 비밀번호를 입력하세요. <br>
	<form action = "./ReviewPasswordCheck.rv?review_num=<%=review_num %>&button=update" method="post">
	<div>	
		<input type="password" id="review_password" name="review_password" maxlength="4" placeholder="숫자 4자리">
<!-- 		<input type="button" name="password_btn" id="password_btn" value="확인"> <br> -->
<!-- 		<div id="password_div"> </div> -->
		<input type="submit" value="수정" name="delete_review">
		<input type="button" value="취소" name="cancel_review">
	</div>
	</form>
	</fieldset>
	<%
	}
	%>
<!-- 푸터 시작 -->
<footer>
<jsp:include page="../main/bottom.jsp" />
</footer>
<!-- 푸터 끝 -->
</body>
</html>