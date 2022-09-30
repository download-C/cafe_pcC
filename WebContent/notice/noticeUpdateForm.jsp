<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 수정하기</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardupdateform.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>

<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 	<h1> noticeUpdateForm.jsp </h1> -->

		<br>
		<div class="wrapper" style="margin: auto;">
		<div class="title_img">
	      <img src="./img/images/img (13).jpg">
	      <h1 class="title">NOTICE LIST</h1>
	      <div class="img_box"></div>
	    </div>
		
		<h1>공지사항 수정하기</h1>
		<form action="./NoticeUpdateAction.no?notice_num=${dto.notice_num }&pageNum=${pageNum }" method="get">
		
		<div class="container">
			<table>	
				<tr>
					<td class="ss">작성자 <input class="conbox" type="text" value="관리자"  readonly="readonly">
				</td></tr>
				
				<tr>
					<td class="ss"><input class="conbox" type="hidden" name="notice_num" id="notice_num" value="${dto.notice_num }">
				</td></tr>
				
				<tr>
				<td class="ss">제목 &nbsp;&nbsp; <input class="conbox" type="text" name="notice_subject"  id="notice_subject" value="${dto.notice_subject }">
				</td></tr>
				
				<tr>
				<td class="ss1">내용 &nbsp;&nbsp; <textarea class="conbox1" rows="3" cols="60"  name="notice_content" id="notice_content"
					placeholder="수정하실 내용을 입력하세요.">${dto.notice_content }</textarea>
				</td></tr>
				
				<tr>
				<td class="ss2"> 첨부파일 <input class="conbox2" type="file" name="notice_file" id="notice_file" >
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