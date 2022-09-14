<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QnAContent</title>
<title>문의사항 확인하기</title>
</head>
<body>

	<h1>문의사항 확인</h1>


<fieldset>
		<table>
			<tr>
				<td>글번호</td>
				<td>${dto.qna_num }</td>
<%-- 				<td><%=request.getAttribute("qna_num") %></td> --%>
				<td>조회수</td>
				<td>${dto.qna_readcount }</td>
<%-- 				<td><%=request.getAttribute("qna_readcount") %></td> --%>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${dto.mem_num }</td>
<%-- 			<td><%=request.getAttribute("mem_num") %></td> --%>
				<td>작성일</td>
				<td>${dto.qna_date }</td>
<%-- 			<td><%=request.getAttribute("qna_date") %></td> --%>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.qna_subject}</td>
<%-- 			<td colspan="3"><%=request.getAttribute("qna_subject") %></td> --%>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${dto.qna_content }</td>
<%-- 			<td colspan="3"><%=request.getAttribute("qna_content") %></td> --%>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3">${dto.qna_file}</td>
<%-- 			<td colspan="3"><%=request.getAttribute("qna_file") %></td> --%>
			</tr>
			<tr>

					<td>
 					<input type="button" name="qna_update" value="수정" 
 				     onclick="location.href='./QnAUpdate.qna?qna_num=${dto.qna_num}&qna_num=${pageNum }';"> 
 				</td> 
 				<td> 
 					<input type="button" name="qna_delete" value="삭제" 
 					onclick="location.href='./QnADelete.qna?qna_num=${dto.qna_num}';"> 
 				</td> 
 				<td> 
 					<input type="button" name="qna_list" value="목록"  
 				     onclick="location.href='./QnABoardList.qna?pageNum=${pageNum}';"> 
 				 </td> 
					<td>
					</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>