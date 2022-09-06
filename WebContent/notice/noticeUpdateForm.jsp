<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 글 수정하기</title>
</head>
<body>
	<h1> noticeUpdateForm.jsp </h1>
	
	<!-- 공지사항 게시판 등록 -->
	<fieldset>
		<h3>공지사항 글 수정하기</h3>
		<form action="./NoticeUpdateAction.no?notice_num=${dto.notice_num }" method="get">
		<div>
			<table>
				<tr>
					<td>
						<input type="text" name="notice_num" id="notice_num" 
					    	   value="${dto.notice_num }" readonly="readonly">
					</td>
				</tr>
				<tr><td>
					<input type="text" name="notice_subject"  id="notice_subject"
					 value="${dto.notice_subject }">
				</td></tr>
				<tr><td>
					<textarea rows="30" cols="100" name="notice_content" id="notice_content">${dto.notice_content }</textarea>
				</td></tr>
				<tr><td>
					<input type="file" name="notice_file" id="notice_file" >
				</td></tr>
			</table>
		</div>
		<div id="commandCell">
			<input type="button" value="임시 저장"> &nbsp;&nbsp;
			<input type="submit" value="수정" > 
		</div>
		</form>	
	</fieldset>
</body>
</html>