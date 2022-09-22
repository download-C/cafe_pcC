<%@page import="com.pcc.member.db.MemberDAO"%>
<%@page import="com.pcc.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/mypageContent.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
     
     <div class="mp_container">
         <img src="mypagecontent.jsp">
     </div>
     <%
       // 로그인 여부 체크
//       if(session != null){
//           String mem_num = (String) session.getAttribute("loginMem_num");
//     	  response.sendRedirect("loginForm.jsp");
//        }

     %>
     
     <h2>개인정보 조회</h2>
     
     <table border="1">
        <tr><td><div id="co_mem_num">회원번호</div></td><td>${dto.mem_num }</td></tr>
        <tr><td>휴대폰 번호</td><td>${dto.phone }</td></tr>
        <tr><td>비밀번호</td><td>${dto.password }</td></tr>
        <tr><td>이름</td><td>${dto.name }</td></tr>
        <tr><td>회원가입일</td><td>${dto.reg_date }</td></tr>
        <tr><td colspan="2">
          <input type="button" value="회원수정" class="content_btn1" onclick="location.href='./mypageUpdate.me?mem_num=${dto.mem_num }';">
          <input type="button" value="회원탈퇴" class="content_btn2" onclick="location.href='./mypageDelete.me?mem_num=${dto.mem_num }';">
        </td>
        </tr>
      </table>
      
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 -->      
</body>
</html>