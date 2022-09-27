<%@page import="java.util.ArrayList"%>
<%@page import="com.pcc.board.qna.db.QnADTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 게시판 목록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardlist.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<br>
	<h2>문의사항</h2>
	<%
 	ArrayList<QnADTO> qnaboardlist = (ArrayList<QnADTO>)request.getAttribute("qnaboardlist");
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	%>
	<%if(mem_num != null) { %>

	<div class="btn">
	<input type="button" name="qnaWrite" class="writebtn" value="새 글 쓰기(new)"
	  onclick="location.href='./QnAWrite.qna';" > 
	</div>

 	<%} %>
 	
	<fieldset>
		<table class="boardlist" style="margin:auto;">
			<tr>
				<td>번호</td>
				<td>제목</td>
		  		<td>작성자</td>
				<td>조회수</td>
				<td>작성일</td>
			<% if(mgr_num != null) { %>
				<td>IP</td>
			<% } %>
			</tr>
		<c:forEach var="dto" items="${requestScope.qnaboardlist}">
			<tr>
				<td>${dto.qna_num }</td>
				<td>
					<a href="./QnAContent.qna?qna_num=${dto.qna_num }&pageNum=${requestScope.pageNum}">${dto.qna_subject }</a>
				<td>${dto.name }</td>
				<td>${dto.qna_readcount }</td>
				<td>${dto.qna_date }</td>
			<% if(mgr_num != null) { %>
				<td>${dto.qna_ip }</td>
			<% } %>
			</tr>
		</c:forEach>
		</table>
	</fieldset>
	
	<div style="text-align: center;">
	<c:if test="${cnt != 0 }">
		<c:if test="${startPage > pageBlock }">
			<a href="./QnAList.qna?pageNum=${startPage-pageBlock }">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<a href="./QnAList.qna?pageNum=${i }">[${i }]</a>
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="./QnAList.qna?pageNum=${startPage + pageBlock }">[다음]</a>
		</c:if>
	</c:if>
	</div>
	<br>

<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>