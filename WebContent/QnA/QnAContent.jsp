<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardcontent.css" rel="stylesheet" type="text/css">
<link href="./css/span_css.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

<title>문의사항 확인하기</title>
<%
	System.out.println(request.getAttribute("qmn"));

	session = request.getSession();
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	String qmn = (String)request.getAttribute("qmn");
	System.out.println(qmn);
	
	if(mgr_num == null && mem_num == null) {
		%>
		<script>
			alert("로그인 후 확인 가능합니다. 로그인 페이지로 이동합니다.");
			location.href="./Login.pcc";
		</script>
		<%
	}else {
		System.out.println("로그인한 회원의 회원번호: "+mem_num);
		System.out.println("작성 글의 회원 번호 : "+qmn);
%>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<h1>문의사항</h1>

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
			<table style="margin: auto;">
				<tr>
					<td class="ss" style="width: 25%;">글번호</td>
					<td style="width: 25%;">${dto.qna_num }</td>
					<td>조회수</td>
					<td>${dto.qna_readcount }</td>
				</tr>
	
	
				<tr>
					<td>작성자</td>
					<td>${dto.name}</td>
					<td>작성일</td>
					<td>${dto.qna_date }</td>
				</tr>
			
			
				<tr>
					<td>제목</td>
					<td colspan="3">${dto.qna_subject}</td>
				</tr>


				<tr>
					<td>내용</td>
					<td colspan="3">${dto.qna_content }</td>
				</tr>

				
				<tr>
					<td>첨부파일</td>
					<td colspan="4">${dto.qna_file}</td>
				</tr>
			
			
		</table>
		</div>

	<br>
	
	<div class="btndiv">
<%
	if(mem_num != null) {
		if(mem_num.equals(qmn)) {
	%>
	<div class="btndiv" style="margin:auto;">
		<input type="button" class="btn" name="qna_update" id="update" value="수정"
	     onclick="location.href='./QnAPasswordForm.qna?qna_num=${dto.qna_num}&button=update';">
	
		<input type="button" class="btn" name="qna_delete" id="delete" value="삭제" 
		onclick="location.href='./QnAPasswordForm.qna?qna_num=${dto.qna_num}&button=delete';">

	<%
		}
	}
		
	if(mgr_num != null) {
	%>
	<input type="button" class="btn" name="riview_reply" id="reply" value="답글"
	 onclick="location.href='./QnAReplyForm.qna?qna_num=${dto.qna_num}';">
	<div class="btndiv" style="margin:auto;">
		<input type="button" class="btn" name="qna_update" id="update" value="수정"
	     onclick="location.href='./QnAPasswordForm.qna?qna_num=${dto.qna_num}&button=update';">
	
		<input type="button" class="btn" name="qna_delete" id="delete" value="삭제" 
		onclick="location.href='./QnAPasswordForm.qna?qna_num=${dto.qna_num}&button=delete';">
   
    <%
	}
%>
     
	<input type="button" class="btn" name="qna_list" id="list" value="목록" 
    onclick="location.href='./QnAList.qna?pageNum=${pageNum}';">
     
     <br>
	</div>
	</div>
	</div>
	<br>
	<br>
	
<%
}
%><!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>