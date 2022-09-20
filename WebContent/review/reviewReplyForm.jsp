<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<title>리뷰 답글 달기</title>
<%
	System.out.println(request.getAttribute("rmn"));
// 	session = request.getSession();
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	String rmn = (String)request.getAttribute("rmn");
	
%>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

	<h1>${dto.review_num }번 리뷰 답글 달기</h1>
	<fieldset>
	<% if(mem_num != null) {
	%>
	<input type="hidden" value="${dto.mem_num }">
	<%
	} else if(mgr_num != null) {
	%>
	<input type="hidden" value="${dto.mgr_num }">
	<%
	}
	%>
		<table>
			<tr>
				<td>글번호</td>
				<td>${dto.review_num }</td>
				<td>조회수</td>
				<td>${dto.review_readcount }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${dto.name }</td>
				<td>작성일</td>
				<td>${dto.review_date }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.review_subject }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${dto.review_content }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3"><a href="./upload/${dto.review_file }" download>
				<img src="./upload/${dto.review_file }"></a>
				</td>
			</tr>
		</table>
	</fieldset>
	<hr>
		<fieldset>
		<legend>리뷰 답글 작성하기</legend>
		<form action="./ReviewReply.rv?review_num=${dto.review_num }" method="post" enctype="multipart/form-data"> <!-- 파일 삽입하는 페이지에 enctype 필수 -->
		<div>
		
	 	<input type="hidden" name="name" id="review_name" 
	 			value="관리자" readonly="readonly">
		비밀번호 <input type="password" name="review_password" 
					maxlength="4" placeholder="4자리 숫자로 적으세요"> <br>
		제목 <input type="text" name="review_subject" value="   Re: ${dto.review_subject }"> <br>
		내용 <textarea rows="30" cols="80 " name="review_content"></textarea> <br>
		</div>
		<div>
		<input type="submit" value="작성"> &nbsp;&nbsp;
		<input type="button" value="취소">
		</div>
		</form>
	</fieldset>
<!-- 푸터 시작 -->
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>