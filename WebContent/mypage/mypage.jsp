<%@page import="com.pcc.member.db.MemberDAO"%>
<%@page import="com.pcc.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이 페이지</title>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/qnaboardlist.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
    <h1>mypageContent.jsp</h1>
     
     <%
       // 로그인 여부 체크
       if(session != null){
          String mem_num = (String) session.getAttribute("mem_num");
    	  
       }

     %>
     
     <h2>개인정보 조회</h2>
     http://localhost:8088/cafe_pcc/img/slide1.jpg
     <table border="1">
        <tr>
        <td>회원번호</td><td>${dto.mem_num }</td>
        </tr>
        <tr>
        <td>휴대폰 번호</td><td>${dto.phone }</td>
        </tr>
        <tr>
        <td>비밀번호</td><td>${dto.password }</td>
        </tr>
        <tr>
        <td>이름</td><td>${dto.name }</td>
        </tr>
        <tr>
        <td>회원가입일</td><td>${dto.reg_date }</td>
        </tr>
        <tr>
        <td colspan="2">
          <input type="button" value="회원수정" onclick="location.href='./mypageUpdate.me?mem_num=${dto.mem_num }';">
          <input type="button" value="회원탈퇴" onclick="location.href='./mypageDelete.me?mem_num=${dto.mem_num }';">
        </td>
        </tr>
      </table>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->      
      
</body>
</html>
