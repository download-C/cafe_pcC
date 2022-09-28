<%@page import="com.pcc.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardcontent.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

<title>리뷰 확인하기</title>
<%
	System.out.println(request.getAttribute("rmn"));
	session = request.getSession();
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	String rmn = (String)request.getAttribute("rmn");
	String review_file = (String)request.getAttribute("review_file");
	
	System.out.println("review_file : "+review_file);
%>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<h2>고객리뷰</h2>

	<div class="wrapper" style="margin-left: 15%; margin-right: 15%; font-size: 50px;">

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
	<div class="container">
		<table>
			<tr>
				<td class="ss" style="width: 25%;">글번호</td>
				<td style="width: 25%;">${dto.review_num }</td>
				<td class="ss" style="width: 20%;">조회수</td>
				<td style="width: 30%;">${dto.review_readcount }</td>
			</tr>
			
	
		
			<tr>
				<td class="ss" style="width: 25%;">작성자</td>
				<td style="width: 25%;">${dto.name }</td>
				<td class="ss" style="width: 20%;">작성일</td>
				<td style="width: 30%;">${dto.review_date }</td>
			</tr>
			

			
			<tr>
				<td class="ss" style="width: 20%;">제목</td>
				<td colspan="3" style="width: 80%;">${dto.review_subject }</td>
			</tr>

			<tr>
				<td class="ss" style="width: 20%;">내용</td>
				<td colspan="3" style="width: 80%;">${dto.review_content }</td>
			</tr>

			<tr>
				<td class="ss" style="width: 20%;">첨부파일</td>
				<td colspan="2" style="width: 80%;"><a href="./upload/${dto.review_file }" download>
				<img src="./upload/${dto.review_file }"></a>
				</td>
			</tr>
			
		</table>
		</div>
		<div class="btndiv">
	<%
	if(mem_num != null) {
		if(mem_num.equals(rmn)) {
	%>s
	<div class="btndiv" style="margin:auto;">
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
	 
	<input type="button" name="review_update" id="update" value="수정"
	     onclick="location.href='./ReviewPasswordForm.rv?review_num=${dto.review_num}&button=update';">
	
	<input type="button" name="review_delete" id="delete" value="삭제" 
	onclick="location.href='./ReviewPasswordForm.rv?review_num=${dto.review_num}&button=delete';">
	
    <%
	}
%>

	<input type="button" name="review_list" id="list" value="목록" 
     onclick="location.href='./ReviewList.rv?pageNum=${pageNum}';">
	</div>
	</div>
	</div>
			

<!-- 푸터 시작 -->
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>