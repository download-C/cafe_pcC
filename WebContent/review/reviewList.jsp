<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ReviewList.jsp</title>
</head>
<body>
<input type="button" name="reviewWrite" value="새 글 쓰기(new)"
 onclick="location.href='./ReviewWrite.rv';">
	<fieldset>
		<table>
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>글쓴이</td>
				<td>조회수</td>
				<td>작성일</td>
			</tr>
		<c:forEach var="dto" items="${requestScope.reviewList}">
			<tr>
				<td>${dto.review_num }</td>
				<td>
					<a href="./ReviewContent.rv?review_num=${dto.review_num }&pageNum=${requestScope.pageNum}">${dto.review_subject }</a>
				<td>관리자</td>
				<td>${dto.review_readcount }</td>
				<td>${dto.review_date }</td>
			</tr>
		</c:forEach>
		</table>
	</fieldset>
	<c:if test="${cnt != 0 }">
		<c:if test="${startPage > pageBlock }">
			<a href="./ReviewList.rv?pageNum=${startPage-pageBlock }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<a href="./ReviewList.rv?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="./ReviewList.rv?pageNum=${startPage + pageBlock }">[다음]</a>
		</c:if>
	</c:if>
</body>
</html>