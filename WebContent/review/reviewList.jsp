<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 목록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardlist.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->


	<h1>Review</h1>
	
	<%
	
	System.out.println("MGR_NUM: "+session.getAttribute("mgr_num"));
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
%>
	<div class="wrapper" style="margin-left: 15%; margin-right: 15%;">
<%
	if(session != null && mem_num != null){
	%>

	
	<div>
	<input type="button" name="reviewWrite" class="writebtn" value="새 글 쓰기(new)"
		onclick="location.href='./ReviewWriteForm.rv';">
	</div>
	<br>
	<br>
	<br>
	<% } %>
	
	
	<div class="container">
		<div class="numdiv ss" style="width: 60px;" class="board_underbar">글번호</div>
		<div class="subdiv ss" style="width: 100px;" class="board_underbar">제목</div>
		<div class="wridiv ss" style="width: 60px;" class="board_underbar">글쓴이</div>
		<div class="readdiv ss" style="width: 60px;" class="board_underbar">조회수</div>
		<div class="datediv ss" style="width: 60px;" class="board_underbar">작성일</div>
		
		<c:forEach var="dto" items="${reviewList}">
			
				<div class="numdiv">${dto.review_num }</div>
				<div class="subdiv"><a
					href="./ReviewContent.rv?review_num=${dto.review_num }&pageNum=${requestScope.pageNum}">${dto.review_subject }</a>
				</div>	
				<div class="wridiv">${dto.name }</div>
				<div class="readdiv">${dto.review_readcount }</div>
				<div class="datediv">${dto.review_date }</div>
			
			
		</c:forEach>
			
		<br>
	
	</div>
	<br><br>
	<c:if test="${cnt != 0 }">
		<c:if test="${startPage > pageBlock }">
			<a href="./Reviewlist.rv?pageNum=${startPage-pageBlock }">이전</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			&nbsp;
			<span style="font-size: 20px; background-color:#adc2a9; border-radius: 5px; ">&nbsp;<a href="./ReviewList.rv?pageNum=${i }">${i }&nbsp;</a></span>
			&nbsp;
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="./Reviewlist.rv?pageNum=${startPage + pageBlock }">다음</a>
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