<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 수정하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardupdateform.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 	<h1>QnAUpdateForm.jsp</h1> -->
		<br>
		<br>
		<br>
		<div>
			<hr>
		</div>
	<fieldset style="margin:auto;">
		<legend>문의사항 수정하기</legend>
		<form action="./QnAUpdateAction.qna?qna_num=${dto.qna_num }" method="post" >
		<div>
			<table>
				<tr>
					<td>
						<input type="hidden" name="qna_num" id="qna_num"
							value="${dto.qna_num }" readonly="readonly">
					</td>
				</tr>
				
				<tr><td class="td">제목
					<input type="text" name="qna_subject" id="qna_subject"
						value="${dto.qna_subject }">
				</td></tr>

				<tr><td class="td">내용
					<textarea rows="3" cols="60" name="qna_content" id="qna_content"
					placeholder="수정하실 내용을 입력하세요.">${dto.qna_content }</textarea>
				</td></tr>
				
				<tr>
				</tr>
				<tr>
				</tr>
				
				<tr><td class="td">첨부파일
					<input type="file" name="qna_file" id="qna_file">
				</td></tr>
				
				<tr>
				</tr>
				<tr>
				</tr>
				
			</table>
		</div>
		<div id="commanCell">
			<input type="submit" value="수정" >
		</div>
		</form>
	</fieldset>
	<hr>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>