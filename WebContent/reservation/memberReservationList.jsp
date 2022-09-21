<%@page import="com.pcc.reservation.db.ReservationDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>memberReservationList.jsp</h1>

	
	<% 
	List<ReservationDTO> memberReservationList = (List<ReservationDTO>)request.getAttribute("memberReservationList");
	
	String pageNum = (String) request.getAttribute("pageNum");
    int cnt = (int) request.getAttribute("cnt");
    int pageCount = (int) request.getAttribute("pageCount");
    int pageBlock = (int) request.getAttribute("pageBlock");
    int startPage = (int) request.getAttribute("startPage");
    int endPage = (int) request.getAttribute("endPage");
    
	%>
	
	<table border="1">
		<tr>
			<td>예약 번호</td>
			<td>예약 날짜 및 시간</td>
			<td>예약 인원</td>
		</tr>
		<%
			for(int i = 0; i<memberReservationList.size(); i++){
			ReservationDTO dto = memberReservationList.get(i);
			%>
		<tr>
		
		
			<td><%=dto.getRes_num()%></td>
			<td><%=dto.getRes_date()%></td>
			<td><%=dto.getRes_persons()%></td>
		<%} %>
		</tr>
	</table>
	
	<%
   		//하단 페이징 처리
   		if(cnt != 0){
   			
   			 
   			// 이전
   			if(startPage > pageBlock){
   					%>
   					<a href ="./MemberReservationList.re?pageNum=<%=startPage - pageBlock%>">[이전]</a>
   					<% 
   				
   			}
   			
   		// 1,2,3,4,5
   		for(int i = startPage; i<=endPage; i++){
   			%>
   			
   			<a href="./MemberReservationList.re?pageNum =<%= i%>">[<%=i %>]</a>
   			
   			<% 		
   			
   				} 
   
   			// 다음
   			if(endPage < pageCount){
   				%>
   					<a href ="./MemberReservationList.re?pageNum=<%=startPage + pageBlock %>">[다음]</a>	
   				
   				<% 
   							
   					}
   			
   			}
   			%>

</body>
</html>