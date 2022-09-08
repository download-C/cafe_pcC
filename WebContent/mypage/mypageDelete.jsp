<%@page import="com.pcc.member.db.MemberDTO"%>
<%@page import="com.pcc.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>mypageDelete.jsp</h1>
     <h2> 회원정보 탈퇴(삭제) </h2>
     
     <%
       // 로그인 여부 체크
       String mem_num = (String) session.getAttribute("loginMem_num");
//     if(mem_num == null){
//     	   response.sendRedirect("loginForm.jsp");
//     }
     %>
     
     <% 
     // 사용자 비밀번호를 입력 전달
     %>
      <form action="./mypageDeleteAction.me" method="POST" onsubmit="return checkData()" name="fr"> 
        회원 번호 : <input type="text" name="mem_num" value="${dto.mem_num }" readonly="readonly"> <br>
        비밀번호 : <input type="password" name="password"> <br>
         <input type="submit" value="탈퇴하기">
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

</body>
</html>