<%@page import="com.pcc.member.db.MemberDAO"%>
<%@page import="com.pcc.member.db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>myPageUpdate.jsp</h1>
     
     <%
       // 로그인 여부 체크
       String mem_num = (String) session.getAttribute("loginMem_num");
//     if(mem_num == null){
//         response.sendRedirect("loginForm.jsp");
//     }
     
     
     %>
     
     <h2>회원수정 페이지</h2>
 
     <form action="./mypageUpdateAction.me" method="post" onsubmit="return checkData()" name="fr">
          <fieldset>
          <legend>Basic Info</legend>
          <label>회원 번호</label>
          <input type="hidden" name="mem_num" value="${dto.mem_num }" readonly="readonly"> <br>
          <label>휴대폰 번호</label> 
          <input type="text" name="phone" value="${dto.phone }" readonly="readonly"> <br>
          <label>비밀번호</label>
          <input type="password" name="password"> <br>
          <label>이름</label>
          <input type="text" name="name" value="${dto.name }"> <br>
          <hr>
             <input type="submit" value="개인정보수정"> 
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
     
     
</body>
</html>