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
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function () {
		$('#write').submit(function () {
		    if ($('#qna_password').val() == "") {
		        alert("비밀번호를를 입력하세요");
		        $('#qna_password').focus();
		        return false;
		    }
		    if($.isNumeric($('#qna_password').val()) == false) {
  			    alert('비밀번호는 숫자 4자리만 가능합니다.');
		  		$("#review_password").focus();
		  	    return false;
		  	} 
		    if($('#qna_subject').val() == "") {
		        alert("제목을 입력하세요");
		        $('#qna_subject').focus();
		        return false;
		    }
		    
		    if ($("#qna_content").val() == "") {
			    alert("내용을 입력하세요");
			    $("#qna_content").focus();
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
	<div class="wrapper" style="margin: auto;">
	<div class="title_img">
	      <img src="./img/images/img (19).jpg">
	      <h1 class="title">Q&A WRITE</h1>
	      <div class="img_box"></div>
	    </div>	

	<form action="./QnAWriteAction.qna" method="post" id="write" enctype="multipart/form-data" >
	
		<div class="container">
		<br>
			<table>
			<!-- <div class="div" style="text-align:center;"> -->
				<tr><td class="ss">
				<%
					String mem_num = (String)session.getAttribute("mem_num");
					String mgr_num = (String)session.getAttribute("mgr_num");
					String name = (String)request.getAttribute("name");
				if(	mgr_num != null ) {%>
				작성자 &nbsp;&nbsp;&nbsp;&nbsp; <input class="conbox" type="text" name="name" id="center" readonly="readonly" value="관리자">
				</td></tr>
				<tr><td class="ss">
				<%} else if(mem_num != null) {%>
				작성자 &nbsp;&nbsp;&nbsp;&nbsp; <input class="conbox" type="text" name="name" id="center" readonly="readonly" value="${name }">	
				</td></tr>
				<%} 
				if(mem_num != null) {
				%>
				<tr><td class="ss0">비밀번호 &nbsp;&nbsp; <input class="conbox0" type="password" name="qna_password" id="qna_password" maxlength="4"
												placeholder="4자리 숫자로 입력하세요.">
				</td></tr>
				<tr><td class="ss">
				<%} %> 
				제목 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="conbox" type="text" name="qna_subject" id="qna_subject">
				</td></tr>
				<tr><td class="ss1">
				내용 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <textarea class="conbox1" rows="3" cols="60" name="qna_content" id="qna_content"></textarea>
				</td></tr>
				<tr><td class="ss2">
				첨부파일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="conbox2" type="file" name="qna_file" id="file">
				</td></tr>		
			</table>
		<br>
		</div>
		<br>

		<div class="divbtn">
			<input class="btn" type="submit" id="write" value="작성" >
			<input class="btn" type="button" id="btn" value="취소">
		</div>
	<br>
	</form>
	</div>

<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>