<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 수정하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>

<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

	<h1> noticeUpdateForm.jsp </h1>
	
	<!-- 공지사항 게시판 등록 -->
	<fieldset>
		<h3>공지사항 글 수정하기</h3>
		<form action="./NoticeUpdateAction.no?notice_num=${dto.notice_num }&pageNum=${pageNum }" method="get">
		<div>
			<table>
				<tr>
					<td>작성자 <input type="text" value="관리자"  readonly="readonly"></td>
				</tr>
				<tr>
					<td>
						<input type="hidden" name="notice_num" id="notice_num" 
					    	   value="${dto.notice_num }">
					</td>
				</tr>
				<tr><td>
					제목 <input type="text" name="notice_subject"  id="notice_subject"
					 value="${dto.notice_subject }">
				</td></tr>
				<tr><td>
					내용 <textarea rows="30" cols="100" name="notice_content" id="notice_content">${dto.notice_content }</textarea>
				</td></tr>
				<tr><td>
					<input type="file" name="notice_file" id="notice_file" >
				</td></tr>
			</table>
		</div>
		<div id="commandCell">
			<input type="submit" value="수정" > 
		</div>
		</form>	
	</fieldset>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>