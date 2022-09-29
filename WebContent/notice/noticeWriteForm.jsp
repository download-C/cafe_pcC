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
	
		<br>
		<div class="wrapper" style="margin: auto;">
	
		<h1>공지사항 작성하기</h1>
		<form action="./NoticeWriteAction.no" method="post">
		
		<div class="container">
			<table style="margin:auto; margin-top: 30px; padding-left: 80px;">
			
				<tr><td class="ss">제목 &nbsp;&nbsp; <input class="conbox" type="text" name="notice_subject"  id="notice_subject" placeholder="제목을 입력하세요." >
				</td></tr>
				
				<tr><td class="ss1">내용 &nbsp;&nbsp; <textarea class="conbox1" rows="3" cols="60" name="notice_content" id="notice_content"
						placeholder="내용을 입력하세요." ></textarea>
				</td></tr>
				
				<tr><td class="ss2">첨부파일 <input class="conbox2" type="file" name="notice_file" id="notice_file" >
				</td></tr>
				
			</table>
			<br>
		</div>
			<br>
			
		<div class="divbtn">
		<!-- <input class="btn" type="button" value="임시 등록"> -->
			<input class="btn" type="submit" value="등록"> 
		</div>
		
	</form>
	</div>
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>