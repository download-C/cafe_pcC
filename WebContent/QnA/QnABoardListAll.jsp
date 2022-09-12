<%@page import="com.pcc.QnAboard.db.QnABoardDTO"%>
<%@page import="java.util.ArrayList"%>
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
	
	String pageNum = (String)request.getAttribute("pageNum");
	
	int cnt = (Integer)request.getAttribute("cnt");
	int pageCount = (Integer)request.getAttribute("pageCount");
	int pageBlock = (Integer)request.getAttribute("pageBlock");
	int startPage = (Integer)request.getAttribute("startPage");
	int endPage = (Integer)request.getAttribute("endPage");
	
	
	%>
	
	<h3><a href="./QnABoardWrite.bo">글쓰기 (new)</a></h3>
	
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
		<!--<td>글쓴이</td> -->
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
			<td><%=dto.getQnA_readcount() %></td>
			<td><%=dto.getQnA_readcount() %></td>
			<td><%=dto.getQnA_date() %></td>
			<td><%=dto.getQnA_ip() %></td>
		</tr>			
		<% } %>
		
			
	</table>
	
	<%
	
	// 페이징 처리
	if(cnt != 0) {
		if(startPage > pageBlock) {
			%>
			<a href=""[이전]></a>
			<%
		}
		
		for(int i = startPage; i<=endPage; i++) {
			%>
			<a href="">[<%=i %>]</a>
			
			<% 
		}
		
		if(endPage < pageCount) {
			%>
			<a href="">[다음]</a>
			
			<% 
		}
	}
		
	
	%>

</body>
</html>