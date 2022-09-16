<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 글 삭제하기</title>

<h1>QnADelete.jsp</h1>

</head>
<body>
<fieldset>

	<h3>문의사항 글 삭제하기</h3>
		<form action="./QnADeleteAction.qna?qna_num=${dto.qna_num }&" method="get">
		<div>
			<table>
				<tr>
					<td>
						<input type="hidden" name="qna_num" id="qna_num"
							value="${dto.qna_num }" readonly="readonly">
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
			<input type="submit" value="삭제" >
		</div>
		</form>

</body>
</html>