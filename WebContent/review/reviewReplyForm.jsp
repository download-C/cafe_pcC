<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardreplyform.css" rel="stylesheet" type="text/css">
<script  src="http://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>리뷰 답글 달기</title>
<%
	System.out.println(request.getAttribute("rmn"));
// 	session = request.getSession();
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	String rmn = (String)request.getAttribute("rmn");
	
%>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->	
	<div style="position: relative; height: 100px"></div>

	<br>
	<div class="wrapper" style="margin: auto;">
	<div class="title_img">
	      <img src="./img/images/img (14).jpg">
	      <h1 class="title">REVIEW REPLY</h1>
	      <div class="img_box"></div>
	    </div>
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
				<td class="ss">글번호</td><td class="ss3">${dto.review_num }</td>
				<td class="ss">조회수</td><td class="ss3">${dto.review_readcount }</td>
			</tr>
			<tr>
				<td class="ss">작성자</td><td class="ss3">${dto.name }</td>
				<td class="ss">작성일</td><td class="ss3">${dto.review_date }</td>
			</tr>
			<tr>
				<td class="ss">제목</td>
				<td colsapn="3" class="ss3">${dto.review_subject }</td>
			</tr>
	
			<tr>
				<td class="ss1">내용</td>
				<td colsapn="3" class="ss3 content">${dto.review_content }</td>
			</tr>
			<tr>
				<td class="ss2">첨부파일<a href="./upload/${dto.review_file }" download>
				<img src="./upload/${dto.review_file }"></a>
			</td></tr>
			
		</table>
		<br>
	</div>
		</div>
			<br>
	
	
		<h2>리뷰 답글 작성하기</h2>
		
		<div class="wrapper" style="margin: auto;">
		<form action="./ReviewReply.rv?review_num=${dto.review_num }" method="post" enctype="multipart/form-data"> <!-- 파일 삽입하는 페이지에 enctype 필수 -->
		
		<div class="container">
		
		<table>
			<tr>
				<td class="ss"><input class="ss" type="hidden" name="name" id="review_name" value="관리자" readonly="readonly">
			</td></tr>
			
			<tr>
				<td class="ss0">비밀번호 <input class="conbox0" type="password" name="review_password" 
					maxlength="4" placeholder="비밀번호는 9090으로 자동 입력됩니다." value="9090"> 
			</td></tr>
			
			<tr>
				<td class="ss">제목 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="conbox" type="text" name="review_subject" value=" Re: ${dto.review_subject }"> <br>
			</td></tr>
			
			<tr>
			<td class="ss1">내용 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <textarea class="conbox1" rows="4" cols="60 " name="review_content"></textarea> <br>
			</td></tr>
		
				</table>
			<br>
		</div>
			<br>
		
		<div class="divbtn">
			<input type="submit" value="작성">
			<input type="button" value="취소">
		</div>
		
		<br>
		</form>
		</div>
	
<!-- 푸터 시작 -->
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>