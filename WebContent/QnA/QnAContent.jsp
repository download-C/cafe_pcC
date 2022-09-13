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
				<td><%=request.getAttribute("QnA_num") %></td>
				<td>조회수</td>
				<td><%=request.getAttribute("QnA_readcount") %></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><%=request.getAttribute("mem_num") %></td>
				<td>작성일</td>
				<td><%=request.getAttribute("QnA_date") %></td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3"><%=request.getAttribute("QnA_subject") %></td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3"><%=request.getAttribute("QnA_content") %></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3"><%=request.getAttribute("QnA_file") %></td>
			</tr>
			<tr>
<!-- 				<td> -->
<!-- 					<input type="button" name="QnA_update" value="수정" -->
<%-- 				     onclick="location.href='./QnAUpdate.bo?QnA_num=${dto.QnA_num}';"> --%>
<!-- 				</td> -->
<!-- 				<td> -->
<!-- 					<input type="button" name="QnA_delete" value="삭제" -->
<%-- 					onclick="location.href='./QnADelete.bo?QnA_num=${dto.QnA_num}';"> --%>
<!-- 				</td> -->
<!-- 				<td> -->
<!-- 					<input type="button" name="QnA_list" value="목록"  -->
<%-- 				     onclick="location.href='./QnABoardListAll.bo?pageNum=${pageNum}';"> --%>
<!-- 				 </td> -->
					<td>
					</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>