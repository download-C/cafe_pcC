<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 확인하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/qnacontent.css" rel="stylesheet" type="text/css">
<link href="./css/span_css.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
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
<h2>문의사항</h2>

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
				<td>${dto.qna_num }</td>
			</tr>
			
			<tr>
			</tr>
<!-- 			<span> -->
<!-- 			</span> -->
			<tr>
			</tr>
			
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.qna_subject}</td>
			</tr>
			

			<tr>
			</tr>
			<tr>
			</tr>
			
			<tr>
				<td>작성자</td>
				<td>${dto.name}</td>
			</tr>
			
			<tr>
			</tr>
			<tr>
			</tr>
			
			<tr>	
				<td>조회수</td>
				<td>${dto.qna_readcount }</td>
			</tr>
			
			<tr>
			</tr>
			<tr>
			</tr>
			
			<tr>	
				<td>작성일</td>
				<td>${dto.qna_date }</td>
			</tr>
			
			<tr>
			</tr>
			<tr>
			</tr>
			
			<tr>
				<td>내용</td>
				<td colspan="3">${dto.qna_content }</td>
			</tr>
			
			<tr>
			</tr>
			<tr>
			</tr>
			
			<tr>
				<td>첨부파일</td>
				<td colspan="3">${dto.qna_file}</td>
			</tr>
			
			
		</table>
	</fieldset>
<%
	if(mem_num != null) {
		if(mem_num.equals(qmn)) {
	%>
		<input type="button" name="qna_update" id="update" value="수정"
	     onclick="location.href='./QnAPasswordForm.qna?qna_num=${dto.qna_num}&button=update';">
	
		<input type="button" name="qna_delete" id="delete" value="삭제" 
		onclick="location.href='./QnAPasswordForm.qna?qna_num=${dto.qna_num}&button=delete';">
	<%
		}
	}
		
	if(mgr_num != null) {
	%>
	<input type="button" name="riview_reply" id="reply" value="답글 달기"
	 onclick="location.href='./QnAReplyForm.qna?qna_num=${dto.qna_num}';">
    <%
	}
%>
	<input type="button" name="qna_list" id="list" value="목록" 
     onclick="location.href='./QnAList.qna?pageNum=${pageNum}';">
<%
}
%><!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>