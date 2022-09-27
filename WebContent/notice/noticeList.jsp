<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 목록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardlist.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<h2>공지사항</h2>
	<% 
// 매니저로 로그인했을 때만 글 쓰기 버튼이 보이게
	String mem_num = (String)session.getAttribute("mem_num");
	String mgr_num = (String)session.getAttribute("mgr_num");
if(mgr_num != null) {
	%>
	
	<div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" name="noticeWrite" class="writebtn" value="새 글 쓰기(new)"
 	onclick="location.href='./NoticeWrite.no';">
	</div>	

 <%
 // 회원 로그인 시 글쓰기 버튼 안 보임
 } else {}
 %>
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
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>