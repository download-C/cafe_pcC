<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 수정하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardupdateform.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 	<h1>reviewUpdateForm.jsp</h1> -->
	
		<br>
		<div class="wrapper" style="margin: auto;">
		
		<h1>리뷰 수정하기</h1>
		<form action="./ReviewUpdateAction.rv?review_num=${review_num }" method="post" enctype="multipart/form-data">
			
			<div class="container">
				<table>
					<tr>
						<td class="ss"><input type="hidden" class="conbox" name="name" id="name"value="${name }"></td>
						</tr>
					
					<tr>
						<td class="ss"> 비밀번호 <input class="conbox" type="password" name="review_password" id="review_password" value="${dto.review_password }">
						</td></tr>
					
					<tr>
						<td class="ss"> 제목 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input class="conbox" type="text" name="review_subject" id="review_subject" value="${dto.review_subject }">
						</td></tr>
					
					<tr><td class="ss1">내용 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <textarea class="conbox1" rows="3" cols="60" name="review_content" id="review_contnet"
						placeholder="수정하실 내용을 입력하세요." >${dto.review_content }</textarea>
					</td></tr>
				
					<tr>
					<td class="ss2">첨부파일
							<img src="./upload/${dto.review_file }"> <br>
							<input class="conbox2" type="file" name="review_file" id="review_file">
							<input type="hidden" name="oldfile" value="${dto.review_file }">
						</td></tr>

				</table>
				<br>
			</div>
				<br>
		
		<div class="divbtn">
			<input class="btn" type="submit" value="수정">
		</div>
		
		</form>
		</div>
		
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>