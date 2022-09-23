<%@page import="java.util.ArrayList"%>
<%@page import="com.pcc.board.qna.db.QnABoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 게시판 목록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/qnaboardlist.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
	<h2>문의사항</h2>
	<%
 	ArrayList<QnABoardDTO> qnaboardlist = (ArrayList<QnABoardDTO>)request.getAttribute("qnaboardlist");
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	%>
	<%if(mem_num != null) { %>
	<input type="button" name="qnaWrite" class="writebtn" value="새 글 쓰기(new)"
	  onclick="location.href='./QnAWrite.qna';"> 
 	<%} %>
	<fieldset>
		<table>
			<tr>
				<td><span class="boardlist">번호</span></td>
				<td><span class="boardlist">제목</span></td>
		  		<td><span class="boardlist">작성자</span></td>
				<td><span class="boardlist">조회수</span></td>
				<td><span class="boardlist">작성일</span></td>
				<td><span class="boardlist">IP</span></td>	
				<!-- ▲ IP는 숨길 예정 -->
			</tr>
		<c:forEach var="dto" items="${requestScope.qnaboardlist}">
			<tr>
				<td><span class="boardlist">${dto.qna_num }</span></td>
				<td><span class="boardlist">
					<a href="./QnAContent.qna?qna_num=${dto.qna_num }&pageNum=${requestScope.pageNum}">${dto.qna_subject }</a></span>
				<td><span class="boardlist">${dto.name }</span></td>
				<td><span class="boardlist">${dto.qna_readcount }</span></td>
				<td><span class="boardlist">${dto.qna_date }</span></td>
				<td><span class="boardlist">${dto.qna_ip }</span></td>
			</tr>
		</c:forEach>
		</table>
	</fieldset>
	
	<c:if test="${cnt !=0 }">
		<c:if test="${startPage > pageBlock }">
        	<a href="./QnABoardList.qna?pageNum=${startPage-pageBlock }">[이전]</a>
    	</c:if>
    	<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
        	<a href="./QnABoardList.qna?pageNum=${i }">[${i }]</a>
    	</c:forEach>
		<c:if test="${endPage < pageCount }">
        	<a href="./QnABoardList.qna?pageNum=${startPage + pageBlock }">[다음]</a>
      	</c:if>	
	</c:if>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>