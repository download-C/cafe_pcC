<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 글 수정하기</title>

	<h1>QnAUpdateForm.jsp</h1>
	
	<fieldset>
		<h3>문의사항 글 수정하기</h3>
		<form action="./QnAUpdateAction.qna?qna_num=${dto.qna_num }&" method="get">
		<div>
			<table>
				<tr>
					<td>
						<input type="hidden" name="qna_num" id="qna_num"
							values="${dto.qna_num }" readonly="readonly">
					</td>
				</tr>
				<tr><td>제목
					<input type="text" name="qna_subject" id="qna_subject"
						value="${dto.qna_subject }">
				</td></tr>
				<tr><td>내용
					<textarea rows="30" cols="100" name="qna_content" id="qna_content">${dto.qna_content }</textarea>
				</td></tr>
				<tr><td>첨부파일
					<input type="file" name="qna_file" id="qna_file">
				</td></tr>
			</table>
		</div>
		<div id="commanCell">
			<input type="button" value="임시저장"> &nbsp;&nbsp;
			<input type="submit" value="수정" >
		</div>
		</form>
	</fieldset>






</head>
<body>

</body>
</html>