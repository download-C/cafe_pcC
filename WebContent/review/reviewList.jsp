<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 목록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

<%-- 	회원번호 :${sessionScope.mem_num } --%>
	<input type="button" name="reviewWrite" value="리뷰 남기기(new)"
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
			<c:forEach var="dto" items="${reviewList}">
				<tr>
					<td>${dto.review_num }</td>
					<td><a
						href="./ReviewContent.rv?review_num=${dto.review_num }&pageNum=${requestScope.pageNum}">${dto.review_subject }</a>
					<td>${dto.review_name }</td>
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
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>