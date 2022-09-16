<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>NoticeList.jsp</title>
</head>
<body>
<header>
	<jsp:include page="../main/top2.jsp" />
</header>
<input type="button" name="noticeWrite" value="새 글 쓰기(new)"
 onclick="location.href='./NoticeWrite.no';">
	<fieldset>
		<table>
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
				<td>작성일</td>
			</tr>
			<c:forEach var="dto" items="${requestScope.noticeList}">
				<tr>
					<td>${dto.notice_num }</td>
					<td><a
						href="./NoticeContent.no?notice_num=${dto.notice_num }&pageNum=${requestScope.pageNum}">${dto.notice_subject }</a>
					<td>관리자</td>
					<td>${dto.notice_readcount }</td>
					<td>${dto.notice_date }</td>
				</tr>
			</c:forEach>
		</table>
	</fieldset>
	<c:if test="${cnt != 0 }">
		<c:if test="${startPage > pageBlock }">
			<a href="./NoticeList.no?pageNum=${startPage-pageBlock }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<a href="./NoticeList.no?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="./NoticeList.no?pageNum=${startPage + pageBlock }">[다음]</a>
		</c:if>
	</c:if>
</body>
</html>