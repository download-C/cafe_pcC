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
	
	<% 
// 매니저로 로그인했을 때만 글 쓰기 버튼이 보이게
	String mem_num = (String)session.getAttribute("mem_num");
	String mgr_num = (String)session.getAttribute("mgr_num");

	%>
	

	<div class="wrapper" style="margin-left: 15%; margin-right: 15%;">
		<div class="title_img">
	      <img src="./img/images/img (13).jpg">
	      <h1 class="title">NOTICE LIST</h1>
	      <div class="img_box"></div>
	    </div>
	<% 
	if(mgr_num != null) {
	%>
		<div>
		<input type="button" name="noticeWrite" class="writebtn" value="새 글 쓰기(new)"
	 	onclick="location.href='./NoticeWrite.no';">
		</div>	

	<br><br>
	
 <%
 // 회원 로그인 시 글쓰기 버튼 안 보임
 } 
 %>
		<div class="container">
				<div class="ss">글번호</div>
				<div class="ss">제목</div>
				<div class="ss">작성자</div>
				<div class="ss">조회수</div>
				<div class="ss">작성일</div>

			<c:forEach var="dto" items="${requestScope.noticeList}">
				
					<div>${dto.notice_num }</div>
					<div class="subdiv"><a
						href="./NoticeContent.no?notice_num=${dto.notice_num }&pageNum=${requestScope.pageNum}">${dto.notice_subject }</a>
					</div>
					<div>관리자</div>
					<div>${dto.notice_readcount }</div>
					<div>${dto.notice_date }</div>
				
			</c:forEach>
	<br>

	</div>
	<br><br>
	
	<c:if test="${cnt != 0 }">
		<c:if test="${startPage > pageBlock }">
			<a href="./Noticelist.no?pageNum=${startPage-pageBlock }">이전</a>
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			&nbsp;
			<span style="font-size: 20px; background-color:#adc2a9; border-radius: 5px; ">&nbsp;<a href="./Noticelist.no?pageNum=${i }">${i }&nbsp;</a></span>
			&nbsp;
		</c:forEach>
		<c:if test="${endPage < pageCount }">
			<a href="./Noticelist.no?pageNum=${startPage + pageBlock }">다음</a>
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