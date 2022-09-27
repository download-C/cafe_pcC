<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 작성하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardwriteform.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./script/jquery-3.6.0.js"></script>
<script type="text/javascript">
$(document).ready(function () {
	$('#btn').click(function () {
// 		alert("click submit");
		
	    // 입력한 아이디 없을 때 처리
	    if ($("#password").val() == "") {
					// 알림창 띄우기
	        alert("비밀번호를를 입력하세요");
	        $("#password").focus();
					// submit 실행 X
	        return false;
	    }
	    // 입력한 비밀번호 없을 때 처리
	    if ($("#subject").val() == "") {
			// 알림창 띄우기
	        alert("제목을 입력하세요");
	        // 해당 부분에 커서 깜빡이기
	        $("#subject").focus();
					// submit 실행 X
	        return false;
	    }
	    
	    if ($("#content").val() == "") {
			// 알림창 띄우기
		    alert("내용을 입력하세요");
		    // 해당 부분에 커서 깜빡이기
		    $("#content").focus();
					// submit 실행 X
		    return false; 
		}
	});
});
</script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

<br>
<fieldset>
	<legend>문의사항 작성하기</legend>
	<br>
	<form action="./QnAWriteAction.qna" method="post" enctype="multipart/form-data">
<!-- 		<div class="div"> -->
			<table style="margin:auto;">
				<tr><td class="center">
		<%
			String mem_num = (String)session.getAttribute("mem_num");
			String mgr_num = (String)session.getAttribute("mgr_num");
			String name = (String)request.getAttribute("name");
		if(	mgr_num != null ) {%>
		작성자 <input type="text" name="name" readonly="readonly" value="관리자"> <br> </td></tr>
		
			<tr><td class="center">
		<hr>
		<%} else if(mem_num != null) {%>
		작성자 <input type="text" name="name" readonly="readonly" value="${name }"> <br> </td></tr>
		
			<tr><td class="center">
		<hr>		
		<%} 
		if(mem_num != null) {
		%>
		비밀번호 <input type="password" name="qna_password" maxlength="4" id="password"
		placeholder="4자리 숫자로 입력하세요."> <br> </td></tr>
		
			
		<%} %> 
<!-- 		<div id="passdiv"></div> -->
			<tr><td class="center">
		<hr>
		제목 <input type="text" name="qna_subject" id="subject"> <br> </td></tr>
		
			<tr><td class="center">
		<hr>
<!-- 		<div id="subdiv"></div> -->
		내용 <textarea rows="3" cols="40" name="qna_content" id="content"></textarea> <br> </td></tr>
		
			<tr><td class="center">
		<hr>
<!-- 		<div id="contdiv"></div> -->
		첨부파일 <input type="text" name="qna_file"  id="file"> <hr> </td></tr>
		
		
		</table>
<!-- 		<div id="filediv"></div> -->
<!-- 		</div>	 -->

		<div style="text-align: center;">
			<input type="submit" id="btn" value="작성" >
			<input type="button" value="취소">
		</div>
		
	</form>
</fieldset>

<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>