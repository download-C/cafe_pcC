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
      // 로그인 정보 체크     
      String id = (String)session.getAttribute("loginID");
      if(id == null){
    	  response.sendRedirect("");
      }
      // 전달된 정보 저장(pw)
       String password = request.getParameter("password");
     
      // 회원정보 탈퇴 - 디비에 저장된 정보 삭제
       MemberDAO dao = new MemberDAO();
       
    
       
     // 사용자 비밀번호를 입력 전달
     %>
      <form action="deletePro.jsp" method="POST">
         
        비밀번호 : <input type="password" name="password">
       
        <input type="submit" value="탈퇴하기">
 
      </form>
      
     <% 
       // 회원탈퇴 메서드 호출
       MemberDTO dto = new MemberDTO();
      
       int result = dao.deleteMember(dto);
       
       if(result == 1){
    	   // 탈퇴시 로그인 정보 삭제(세션값 삭제, 초기화)
    	   session.invalidate();
    	   %>
    	   <script type="text/javascript">
    	       alert("회원 탈퇴 성공");
    	       loction.href="";
    	   </script>
    	   <% 
       }else if(result ==0){
    	   %>
    	   <script type="text/javascript">
    	       alert("탈퇴 실패 : 비밀번호 오류");
    	       history.back();
    	   </script>
    	   <%
       }else{
    	   // result = -1
    	   %>
    	   <script type="text/javascript">
    	       alert("탈퇴 실패 : 회원정보 에러");
    	       history.back();
    	   </script>
    	   <%
       }
     %>
</body>
</html>