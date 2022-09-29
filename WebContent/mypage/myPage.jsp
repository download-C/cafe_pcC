<%@page import="com.pcc.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>마이 페이지</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css" />
<link href="./css/mypage/myPage.css" rel="stylesheet" type="text/css" />
<script src="https://kit.fontawesome.com/1e92182c7c.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<!-- 헤더들어가는 곳 -->
	<jsp:include page="../inc/top.jsp" />
	<!-- 헤더들어가는 곳 -->


	<%
		// 로그인 여부 체크 
		if (session != null) {
			String mem_num = (String) session.getAttribute("mem_num");
			System.out.println("회원번호 : " + mem_num);
			if (mem_num == null) {
				response.sendRedirect("./Login.pcc");
			}
		}
	%>

<div class="wrapper">
	<div class="title_img">
      <img src="./img/images/img (20).jpg">
      <h1 class="title">MY PAGE</h1>
      <div class="img_box"></div>
    </div>
	<div class="container">			
		<div class="mydiv"><div id="co_phone">휴대폰 번호</div>
			 <div><input type="text" value="${dto.phone }" readonly="readonly" ></div>
		 </div>
		<div class="mydiv">
			<div id="co_password">비밀번호</div>
			<div><input type="password" value="${dto.password }"></div>
		</div>
		<div class="mydiv">
			<div id="co_name">이름</div>
			<div><input type="text" value="${dto.name }" readonly="readonly"></div>
		</div>
		<div class="mydiv">
			<div id="co_regate">회원가입일</div>
			<div>${dto.regdate }</div>
		</div>
		<div class="btndiv">
			<input type="button" value="정보 수정"
			class="btn"
			onclick="location.href='./mypageUpdate.me?mem_num=${dto.mem_num }';" />
			<input type="button" value="회원 탈퇴" class="btn"
			onclick="location.href='./mypageDelete.me?mem_num=${dto.mem_num }';" />
			<input type="button" value="주문 내역" class="btn"
			onclick="location.href='./OrderList.pr';" />
		</div>
	</div>
</div>
	<!-- 푸터들어가는 곳 -->
	<jsp:include page="../inc/bottom.jsp" />
	<!-- 푸터들어가는 곳 -->
</body>
</html>
