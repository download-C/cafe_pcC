<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 확인하기</title>
</head>
<body>
	<fieldset>
		<table>
			<tr>
				<td>글번호</td>
				<td>${dto.notice_num }</td>
				<td>조회수</td>
				<td>${dto.notice_readcount }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>관리자</td>
				<td>작성일</td>
				<td>${dto.notice_date }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.notice_subject }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${dto.notice_content }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3">${dto.notice_file }</td>
			</tr>
			<tr>
				<td>
					<input type="button" name="notice_update" value="수정"
				     onclick="location.href='./NoticeUpdate.no?notice_num=${dto.notice_num}';">
			    </td>
				<td>
					<input type="button" name="notice_delete" value="삭제"
				    onclick="location.href='./NoticeDelete.no?notice_num=${dto.notice_num}';">
			    </td>
				<td>
					<input type="button" name="notice_list" value="목록" 
				     onclick="location.href='./NoticeList.no?pageNum=${pageNum}';">
			    </td>
				<td>
				</td>
			</tr>
		</table>
	</fieldset>

</body>
</html>