<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/boards/boardcontent.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

<title>공지사항 보기</title>
<% 
// 매니저로 로그인했을 때만 글 쓰기 버튼이 보이게
	String mem_num = (String)session.getAttribute("mem_num");
	String mgr_num = (String)session.getAttribute("mgr_num");
%>

 
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<h1>공지사항</h1>
	
	<br>
	<div class="wrapper" style="margin-left: 15%; margin-right: 15%; font-size: 50px;">
		<div class="title_img">
	      <img src="./img/images/img (13).jpg">
	      <h1 class="title">NOTICE LIST</h1>
	      <div class="img_box"></div>
	    </div>
	 <div class="container">
		<table>
			<tr>
				<td class="ss" style="width: 25%;">글번호</td>
				<td style="width: 25%;">${dto.notice_num }</td>
				<td class="ss" style="width: 20%;">조회수</td>
				<td style="width: 30%;">${dto.notice_readcount }</td>
			</tr>
			
			
			<tr>
				<td class="ss" style="width: 25%;">작성자</td>
				<td style="width: 25%;">관리자</td>

				<td class="ss" style="width: 20%;">작성일</td>
				<td style="width: 30%;">${dto.notice_date }</td>
			</tr>

			
			<tr>
				<td class="ss" style="width: 20%;">제목</td>
				<td colspan="3" style="width: 80%;">${dto.notice_subject }</td>
			</tr>


			<tr>
				<td class="ss" style="width: 20%;">내용</td>
				<td colspan="3" style="width: 80%;">${dto.notice_content }</td>
			</tr>
			
			<tr>
				<td>첨부파일</td>
					<td colspan="4">${dto.notice_file }
				</td>
			</tr>


	     </table>
		</div>
		<div class="btndiv">
		
	<%
		// 매니저 로그인 시 수정, 삭제버튼 보이게 함
 		if(mgr_num != null) {
	 %>
	 <div class="btndiv" style="margin:auto;">		
		<input type="button" class="btn" name="notice_update" id="update" value="수정"
	     onclick="location.href='./NoticeUpdate.no?notice_num=${dto.notice_num}';">
	
		<input type="button" class="btn" name="notice_delete" id="delete" value="삭제"
	    onclick="location.href='./NoticeDelete.no?notice_num=${dto.notice_num}';">
			 
    <%
 		}
	%>
		<input type="button" class="btn" name="notice_list" value="목록" 
	     onclick="location.href='./NoticeList.no?pageNum=${pageNum}';">
	     <br>
	     </div>
	     </div>
	     </div>
	     <br>
	     
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>