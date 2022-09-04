<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 글 수정하기</title>
</head>
<body>
	<h1> noticeModifyForm.jsp </h1>
	
	<!-- 공지사항 게시판 등록 -->
	<fieldset id="noticeModifyForm">
		<h3>공지사항 글 수정하기</h3>
		<form action="./NoticeModifyAction.no" method="post">
		<div>
			<table>
				<tr><td>
					<input type="text" name="notice_subject"  id="notice_subject"
					 value="${dto.notice_subject }">
				</td></tr>
				<tr><td>
					<textarea rows="30" cols="100" name="notice_content" id="notice_content"
				      ></textarea>
				</td></tr>
				<tr><td>
					<input type="file" name="notice_file" id="notice_file" value="${dto.file }">
				</td></tr>
			</table>
		</div>
		<div id="commandCell">
			<input type="button" value="임시 수정"> &nbsp;&nbsp;
			<input type="submit" value="수정"> 
		</div>
		</form>
	</fieldset>
</body>
</html>