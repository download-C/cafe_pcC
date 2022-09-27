<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 게시판 글쓰기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardwriteform.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

<!-- 	<h1> noticeWriteForm.jsp </h1> -->
	
	<!-- 공지사항 게시판 등록 -->
	<fieldset id="noticeWriteForm">
		<legend>공지사항 작성하기</legend>
		<form action="./NoticeWriteAction.no" method="post">
		<div class="div">
			<table>
				<tr><td class="td">
					제목 <input type="text" name="notice_subject"  id="notice_subject"
					       placeholder="제목을 입력하세요." >
				</td></tr>
				<tr><td class="td">
					내용 <textarea rows="3" cols="60" name="notice_content" id="notice_content"
						   placeholder="내용을 입력하세요." ></textarea>
				</td></tr>
				<tr><td class="td">
					첨부파일 <input type="file" name="notice_file" id="notice_file" >
				</td></tr>
			</table>
		</div>
		<div id="commandCell">
			<input type="button" value="임시 등록"> &nbsp;&nbsp;
			<input type="submit" value="등록"> 
		</div>
		</form>
	</fieldset>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>