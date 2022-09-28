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

	<h2>문의사항</h2>
	
	<%
 	ArrayList<QnADTO> qnaboardlist = (ArrayList<QnADTO>)request.getAttribute("qnaboardlist");
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	%>
	
	<div class="wrapper" style="margin-left: 15%; margin-right: 15%;">
		<%if(mem_num != null) { %>
	
	
		<div>
		<input type="button" name="qnaWrite" class="writebtn" value="새 글 쓰기(new)"
		  onclick="location.href='./QnAWrite.qna';" > 
		</div>
	
	<br><br>
	
	
 		<%} %>
 
 	
	<div class="container">

<!-- 		<table class="qna_list" style="text-align: center; margin: auto;"> -->
<!-- 			<tr> -->
				<div class="ss">번호</div>
				<div class="ss">제목</div>
		  		<div class="ss">작성자</div>
				<div class="ss">조회수</div>
				<div class="ss">작성일</div>
<%-- 			<% if(mgr_num != null) { %> --%>
<!-- 				<div>IP</div> -->
<%-- 			<% } %> --%>
			
		<c:forEach var="dto" items="${requestScope.qnaboardlist}">
<!-- 			<tr> -->
				<div>${dto.qna_num }</div>
				<div class="subdiv">
					<a 
					href="./QnAContent.qna?qna_num=${dto.qna_num }&pageNum=${requestScope.pageNum}">${dto.qna_subject }</a>
				</div>
				<div>${dto.name }</div>
				<div>${dto.qna_readcount }</div>
				<div>${dto.qna_date }</div>
<%-- 			<% if(mgr_num != null) { %> --%>
<%-- 				<div>${dto.qna_ip }</div> --%>
<%-- 			<% } %> --%>
				
			</c:forEach>
	<br>
	
	</div>
	<br><br>
	<c:if test="${cnt != 0 }">
		<c:if test="${startPage > pageBlock }">
			<a href="./Reviewdivst.rv?pageNum=${startPage-pageBlock }">이전</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			&nbsp;
			<span style="font-size: 20px; background-color:#adc2a9; border-radius: 5px; ">&nbsp;<a href="./Reviewdivst.rv?pageNum=${i }">${i }&nbsp;</a></span>
			&nbsp;
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="./Reviewdivst.rv?pageNum=${startPage + pageBlock }">다음</a>
			</c:if>
		</c:if>
		<br>
		<br>
	</div>
	
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>