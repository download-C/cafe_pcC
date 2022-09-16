<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 확인하기</title>
<%
	session = request.getSession();
	String mgr_num = (String)session.getAttribute("mgr_num");
	if(mgr_num != null) {
		String name = "관리자";
	}
%>
<script src="./script/jquery-3.6.0.js"></script>
</head>
<body>
<header><jsp:include page="../main/top2.jsp"></jsp:include></header>
	<h1>reviewContent.jsp</h1>
	<fieldset>
	<form action = "./ReviewDelete.rv?review_num=${dto.review_num }" method="post">
		<table>
			<tr>
				<td>글번호</td>
				<td>${dto.review_num }</td>
				<td>조회수</td>
				<td>${dto.review_readcount }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${name }</td>
				<td>작성일</td>
				<td>${dto.review_date }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.review_subject }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${dto.review_content }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3">${dto.review_file }</td>
			</tr>
			<tr>
				<td>
					<input type="button" name="review_update" id="update"value="수정"
				     onclick="location.href='./ReviewUpdate.rv?review_num=${dto.review_num}';">
			    </td>
				<td>
					<input type="button" name="review_delete" id="delete" value="삭제" 
					onclick="location.href='./ReviewPasswordForm.rv?notice_num=${dto.review_num}';">
			    </td>
				<td>
					<input type="button" name="review_list" id="list" value="목록" 
				     onclick="location.href='./ReviewList.rv?pageNum=${pageNum}';">
			    </td>
				<td>
				</td>
			</tr>
		</table>
		</form>
	</fieldset>
	
</body>
</html>