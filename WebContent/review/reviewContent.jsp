<%@page import="com.pcc.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 확인하기</title>
<%
	System.out.println(request.getAttribute("rmn"));

	session = request.getSession();
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	String rmn = (String)request.getAttribute("rmn");
	System.out.println(rmn);
	
	if(mgr_num == null && mem_num == null) {
		%>
		<script>
			alert("로그인 후 확인 가능합니다. 로그인 페이지로 이동합니다.");
			location.href="./Login.pcc";
		</script>
		<%
	}else {

		System.out.println("로그인한 회원의 회원번호: "+mem_num);
		System.out.println("작성 글의 회원 번호 : "+rmn);
%>
</head>
<body>
<header><jsp:include page="../main/top2.jsp"></jsp:include></header>

	<h1>reviewContent.jsp</h1>
	<fieldset>
	<% if(mem_num != null) {
	%>
	<input type="hidden" value="${dto.mem_num }">
	<%
	} else if(mgr_num != null) {
	%>
	<input type="hidden" value="${dto.mgr_num }">
	<%
	}
	%>
		<table>
			<tr>
				<td>글번호</td>
				<td>${dto.review_num }</td>
				<td>조회수</td>
				<td>${dto.review_readcount }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${dto.review_name }</td>
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
		</table>
	</fieldset>
	<%
	if(mem_num != null) {
		if(mem_num.equals(rmn)) {
	%>
		<input type="button" name="review_update" id="update" value="수정"
	     onclick="location.href='./ReviewPasswordForm.rv?review_num=${dto.review_num}&button=update';">
	
		<input type="button" name="review_delete" id="delete" value="삭제" 
		onclick="location.href='./ReviewPasswordForm.rv?review_num=${dto.review_num}&button=delete';">
	<%
		}
	}
		
	if(mgr_num != null) {
	%>
	<input type="button" name="riview_reply" id="reply" value="답글 달기"
	 onclick="location.href='./ReviewReplyForm.rv?review_num=${dto.review_num}';">
    <%
	}
%>
	<input type="button" name="review_list" id="list" value="목록" 
     onclick="location.href='./ReviewList.rv?pageNum=${pageNum}';">
<%
}
%>
<!-- 푸터 시작 -->
<footer>
<jsp:include page="../main/bottom.jsp" />
</footer>
<!-- 푸터 끝 -->
</body>
</html>