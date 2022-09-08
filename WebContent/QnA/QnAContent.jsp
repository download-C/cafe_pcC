<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QnAContent</title>
<title>문의사항 확인하기</title>
</head>
<body>


<fieldset>
		<table>
			<tr>
				<td>글번호</td>
				<td>${dto.board_num }</td>
				<td>조회수</td>
				<td>${dto.readcount }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>관리자</td>
				<td>작성일</td>
				<td>${dto.board_datetime }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.subject }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${dto.content }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3">${dto.file }</td>
			</tr>
			<tr>
				<td><input type="button" name="notice_update" value="수정"
				     onclick="location.href='./QnAUpdateAction.no?notice_num=${dto.notice_num}';"></td>
	<%-- onclick="location.href='./QnAUpdate.no?notice_num=${dto.notice_num}';"></td> --%> 
				<td><input type="button" name="notice_delete" value="삭제"
				onclick=""></td>
				<td><input type="button" name="qna_list" value="목록" 
				     onclick="location.href='./QnAList.no?pageNum=${pageNum}';"></td>
				<td></td>
			</tr>
		</table>
	</fieldset>
</body>
</html>