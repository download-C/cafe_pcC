<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QnAContent</title>
<title>문의사항 확인하기</title>
</head>
<body>

	<h1>문의사항 확인</h1>


<fieldset>
		<table>
			<tr>
				<td>글번호</td>
				<td>${dto.QnA_num }</td>
				<td>조회수</td>
				<td>${dto.QnA_readcount }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>관리자</td>
				<td>작성일</td>
				<td>${dto.QnA_date }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.QnA_subject }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${dto.QnA_content }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3">${dto.QnA_file }</td>
			</tr>
			<tr>
				<td>
					<input type="button" name="QnA_update" value="수정"
				     onclick="location.href='./QnAUpdateAction.no?notice_num=${dto.notice_num}';">
				</td>
				<td>
					<input type="button" name="QnA_delete" value="삭제"
					onclick="">
				</td>
				<td>
					<input type="button" name="QnA_list" value="목록" 
				     onclick="location.href='./QnAList.no?pageNum=${pageNum}';">
				 </td>
				<td>
					</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>