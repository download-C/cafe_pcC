<%@page import="com.pcc.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 작성하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<h1>reviewForm.jsp</h1>
	
	<% 
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	String name = "";
	if(mem_num != null) {
		MemberDAO dao = new MemberDAO();
		name = dao.getName(Integer.parseInt(mem_num));  
	} else if (mgr_num != null) {
		name = "관리자";
	}
	
	%>
	<fieldset>
		<legend>리뷰 작성하기</legend>
		<form action="./ReviewWriteAction.rv" method="post">
		<div>
		
	 	<input type="hidden" name="review_name" id="review_name" value="${review_name }" readonly="readonly">
		비밀번호 <input type="password" name="review_password" maxlength="4" placeholder="4자리 숫자로 적으세요"> <br>
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
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>