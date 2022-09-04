<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 게시판 글쓰기</title>
<!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->

</head>
<body>
	<h1> noticeWriteForm.jsp </h1>
	
	<!-- 공지사항 게시판 등록 -->
	<fieldset id="noticeWriteForm">
		<h3>공지사항 글쓰기</h3>
		<form action="./NoticeWriteAction.no" method="post">
		<div>
			<table>
				<tr><td>
					<input type="text" name="notice_subject"  id="notice_subject"
					       placeholder="제목을 입력하세요." >
				</td></tr>
				<tr><td>
					<textarea rows="30" cols="100" name="notice_content" id="notice_content"
						   placeholder="내용을 입력하세요." ></textarea>
				</td></tr>
				<tr><td>
					<input type="file" name="notice_file" id="notice_file">
				</td></tr>
			</table>
		</div>
		<div id="commandCell">
			<input type="button" value="임시 등록"> &nbsp;&nbsp;
			<input type="submit" value="등록"> 
		</div>
		</form>
	</fieldset>
	
</body>
</html>