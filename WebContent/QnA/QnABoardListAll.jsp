<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.pcc.QnAboard.db.QnABoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>QnABoardListAll.jsp</h1>
	
	<h2>게시판 목록</h2>
	
	<%
	
	ArrayList<QnABoardDTO> qnaboardlist = (ArrayList<QnABoardDTO>)request.getAttribute("qnaboardlist");
	
// 	String pageNum = (String)request.getAttribute("pageNum");
	
// 	int cnt = (Integer)request.getAttribute("cnt");
// 	int pageCount = (Integer)request.getAttribute("pageCount");
// 	int pageBlock = (Integer)request.getAttribute("pageBlock");
// 	int startPage = (Integer)request.getAttribute("startPage");
// 	int endPage = (Integer)request.getAttribute("endPage");
	
	
	%>
	
<!-- <h3><a href="./QnABoardWrite.bo">글쓰기 (new)</a></h3> -->
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
<!-- 		<td>글쓴이</td> 추후 Members 테이블에서 조인해서 출력해야함~~! -->
			<td>조회수</td>
			<td>작성일</td>
			<td>IP</td>
		</tr>
		
		<%
		
		for (int i = 0; i < qnaboardlist.size(); i++) {
			QnABoardDTO dto = qnaboardlist.get(i);
			
		%>
	
		<tr>
			<td><%=dto.getQnA_num() %></td>
			<td><%=dto.getQnA_subject() %></td>
		<%-- <td><%=dto.getmem_num() %></td> 추후 Members 테이블에서 조인해서 출력해야함~~! --%>
			<td><%=dto.getQnA_readcount() %></td>
			<td><%=dto.getQnA_date() %></td>
			<td><%=dto.getQnA_ip() %></td>
		</tr>			
		<% } %>
		</table>
	
	<c:if test="${cnt!=0 }">
	<c:if test="${startPage > pageBlock }">
         <a href="./QnABoardList.bo?pageNum=${startPage-pageBlock }">[이전]</a>
      </c:if>
      <c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
         <a href="./QnABoardList.bo?pageNum=${i }">[${i }]</a>
      </c:forEach>
      <c:if test="${endPage < pageCount }">
         <a href="./QnABoardList.bo?pageNum=${startPage + pageBlock }">[다음]</a>
      </c:if>
	</c:if>

</body>
</html>