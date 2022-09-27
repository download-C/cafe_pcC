<%@page import="com.pcc.member.db.MemberDTO"%>
<%@page import="com.pcc.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/mypage/mypageDelete.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

     
     <img class="img2" src="./img/mypageDelete.jpg">
     

     <%
       // 로그인 여부 체크
       String mem_num = (String) session.getAttribute("mem_num");
//     if(mem_num == null){
//     	   response.sendRedirect("loginForm.jsp");
//     }
     %>
     
     <% 
     // 사용자 비밀번호를 입력 전달
     %>
     <form action="./mypageDeleteAction.me" method="POST" id="delete" onsubmit="return checkData()" name="fr"> 
     <fieldset>
     <legend>회원탈퇴</legend>
     <hr>
      <ul>
        <li><input type="hidden" name="mem_num" value="${dto.mem_num }" readonly="readonly"></li>
        <li><label>비밀번호를 한 번 더 입력하세요</label><br>
        <input type="password" name="password"></li>
      </ul>
         <hr>
         <input type="submit" class="delete_btn" value="탈퇴하기">
     </fieldset> 
     </form>
      <script type="text/javascript">
        // alert("document.fr.pw.value : "+document.fr.pw.value);
        function checkData(){
        	var password = document.fr.password.value;
        
        	if(password == "" || password.length<1){
        		alert("비밀번호를 입력하세요.");
        		document.fr.password.focus();
        		return false;
        	}
        	
        }
     </script>

<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 --> 
</body>
</html>
