<%@page import="javax.websocket.SendResult"%>
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
    <h1>mypageContent.jsp</h1>
     
     <%
       // 로그인 여부 체크
       if(session != null){
          String mem_num = (String) session.getAttribute("mem_num");
          System.out.println("회원번호 : "+mem_num);
          if(mem_num == null) {
        	  response.sendRedirect("./Login.pcc");
          }
       }

     %>
     
     <h2>개인정보 조회</h2>
     <table border="1">
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
        <td>회원가입일</td><td>${dto.regdate }</td>
        </tr>
        <tr>
        <td colspan="2">
          <input type="button" value="회원수정" onclick="location.href='./mypageUpdate.me?mem_num=${dto.mem_num }';">
          <input type="button" value="회원탈퇴" onclick="location.href='./mypageDelete.me?mem_num=${dto.mem_num }';">
        </td>
        </tr>
      </table>
      
      
</body>
</html>