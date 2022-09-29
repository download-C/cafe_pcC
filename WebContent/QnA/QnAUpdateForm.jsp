<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문의사항 수정하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardupdateform.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>

<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 	<h1>QnAUpdateForm.jsp</h1> -->

		<br>
		<div class="wrapper" style="margin: auto;">
		<div class="title_img">
	      <img src="./img/images/img (19).jpg">
	      <h1 class="title">Q&A UPDATE</h1>
	      <div class="img_box"></div>
	    </div>
		<form action="./QnAUpdateAction.qna?qna_num=${dto.qna_num }" method="post" >
		
		<div class="container">
			<table>
			
				<tr><td class="ss"><input type="hidden" class="conbox" name="qna_num" id="qna_num" value="${dto.qna_num }" readonly="readonly">
				</td></tr>
				
				<tr><td class="ss">제목 &nbsp;&nbsp; <input type="text" class="conbox" name="qna_subject" id="qna_subject" value="${dto.qna_subject }">
				</td></tr>

				<tr><td class="ss1">내용 &nbsp;&nbsp; <textarea class="conbox1" rows="3" cols="60" name="qna_content" id="qna_content"
					placeholder="수정하실 내용을 입력하세요.">${dto.qna_content }</textarea>
				</td></tr>

				<tr><td class="ss2">첨부파일 <input class="conbox2" type="file" name="qna_file" id="qna_file">
				</td></tr>
				
			</table>
			<br>
		</div>
			<br>	
		
		<div class="divbtn">
			<input class="btn" type="submit" value="수정" >
		</div>
		
		</form>
		</div>
		
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>