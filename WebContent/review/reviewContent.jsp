<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 확인하기</title>
<%
	session = request.getSession();
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	
	if(mgr_num != null) {
		String name = "관리자";
	} else if(mem_num != null ) {
		
		
	}
%>
</head>
<body>
<header><jsp:include page="../main/top2.jsp"></jsp:include></header>
	<h1>reviewContent.jsp</h1>
	<fieldset>
		<table>
			<tr>
				<td>글번호</td>
				<td>${dto.review_num }</td>
				<td>조회수</td>
				<td>${dto.review_readcount }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${name }</td>
				<td>작성일</td>
				<td>${dto.review_date }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.review_subject }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${dto.review_content }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3">${dto.review_file }</td>
			</tr>
			<tr>
				<td>
					<input type="button" name="review_update" id="update" value="수정"
				     onclick="location.href='./ReviewPasswordForm.rv?review_num=${dto.review_num}&button=update';">
			    </td>
				<td>
					<input type="button" name="review_delete" id="delete" value="삭제" 
					onclick="location.href='./ReviewPasswordForm.rv?review_num=${dto.review_num}&button=delete';">
			    </td>
				<td>
					<input type="button" name="review_list" id="list" value="목록" 
				     onclick="location.href='./ReviewList.rv?pageNum=${pageNum}';">
			    </td>
				<td>
				</td>
			</tr>
		</table>
	</fieldset>
<!-- 푸터 시작 -->
<footer>
<jsp:include page="../main/bottom.jsp" />
</footer>
<!-- 푸터 끝 -->
</body>
</html>