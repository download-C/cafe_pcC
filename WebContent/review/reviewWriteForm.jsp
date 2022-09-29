<%@page import="com.pcc.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 작성하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardwriteform.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script  src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        $('#write').submit(function(){
  			if($('#review_password').val()=="") { 
				alert('비밀번호를 입력하세요');  				
  				$("#review_password").focus();
  				return false;
  			}
  			if($.isNumeric($('#review_password').val()) == false) {
  			    alert('비밀번호는 숫자 4자리만 가능합니다.');
		  		$("#review_password").focus();
		  	    return false;
		  	} 
            if($("#review_subject").val()=="") {
				alert('제목을 입력하세요');
				$(".pass").focus();
				return false;
			}
            if ($('#review_content').val()=="") {
                alert('내용을 입력하세요');
                $('.pass2div').focus();
                return false;
            }
        });
   	});//
</script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 	<h1>reviewForm.jsp</h1> -->
	
	<% 
	String mgr_num = (String)session.getAttribute("mgr_num");
	String mem_num = (String)session.getAttribute("mem_num");
	String name = (String)request.getAttribute("name");
	if(mem_num != null) {
		MemberDAO dao = new MemberDAO();
		name = dao.getName(Integer.parseInt(mem_num));  
	} else if (mgr_num != null) {
		name = "관리자";
	}
	
	%>
		<br>
		<div class="wrapper" style="margin: auto;">
		
		<h1>리뷰 작성하기</h1>
		<form action="./ReviewWriteAction.rv" method="post" id="write" enctype="multipart/form-data"> <!-- 파일 삽입하는 페이지에 enctype 필수 -->
		
		<div class="container">
			<table>
			
	
		<tr><td class="ss"><input type="hidden" name="name" id="review_name" 
	 			value="${name }" readonly="readonly">
	 	</td></tr>		
	 	
	 	<tr><td class="ss0">비밀번호 <input class="conbox0" type="password" name="review_password" id="review_password" 
				maxlength="4" placeholder="4자리 숫자로 입력하세요." > 
		</td></tr>
		
		<tr><td class="ss">제목 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="conbox" type="text" name="review_subject" id="review_subject"> 
		</td></tr>
		
		<tr><td class="ss1">
		내용 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <textarea class="conbox1" rows="4" cols="60 " name="review_content" id="review_content"></textarea> 
		</td></tr>
		
		<tr><td class="ss2">
		첨부파일 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="conbox2"  type="file" name="review_file" id="review_file"> 
		</td></tr>
		
			</table>
			<br>
		</div>
			<br>
			
			<div class="divbtn">
				<input class="btn" type="submit" value="작성" > 
				<input class="btn" type="button" value="취소">
			</div>
		<br>
		</form>
		</div>
	
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>