<%@page import="com.pcc.member.db.MemberDAO"%>
<%@page import="com.pcc.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/mypage/mypageUpdate.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

     <%
       // 로그인 여부 체크
       String mem_num = (String) session.getAttribute("mem_num");
//     if(mem_num == null){
//         response.sendRedirect("loginForm.jsp");
//     }
     %>
     
     
     <img class="img3" src="./img/mypageUpdate.jpg">
     
     
     
     <form action="./mypageUpdateAction.me" method="post" id="update" onsubmit="return checkData()" name="fr">
     <fieldset>
     <legend>회원수정</legend>
     <hr>
     <ul>
        <li><input type="hidden" name="mem_num" value="${dto.mem_num }" readonly="readonly"></li>
        <li><label>휴대폰 번호</label>
          <input type="text" name="phone" id="phone" value="${dto.phone }" readonly="readonly"></li>
        <li><label>비밀번호</label>
          <input type="password" name="password" id="password" value="${dto.password }"></li>
        <li><label>이름</label>
          <input type="text" name="name" id="name" value="${dto.name }"></li>
     </ul>
          <hr>
             <input type="submit" class="update_btn" value="개인정보수정"> 
     </fieldset>
     </form>
     
     <script type="text/javascript">
        // alert("document.fr.pw.value : "+document.fr.pw.value);
        function checkData(){
        	var password = document.fr.password.value;
        	var name = document.fr.name.value;
        	
        	if(password == "" || password.length<1){
        		alert("비밀번호를 입력하세요.");
        		document.fr.password.focus();
        		return false;
        	}
        	if(name == "" || name.length<1){
        		alert("이름을 입력하세요.");
        		document.fr.name.focus();
        		return false;
        	}
        }
     </script>
     
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp"  />
<!-- 푸터들어가는 곳 -->     
</body>
</html>