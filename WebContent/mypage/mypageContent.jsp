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
    <h1>mypageContent.jsp</h1>
     
     <%
       // 로그인 여부 체크
//        String mem_num = (String) session.getAttribute("loginMem_num");
//        if(mem_num == null){
//     	   response.sendRedirect("loginForm.jsp");
//        }
     
     
     %>
     
     <h2>개인정보 조회</h2>
     
     <%
       // DB에 접근해서 해당유저(로그인한 유저)의 정보만 가져오기
       
       //MemberDAO 객체
       // MemberDAO dao = new MemberDAO();
     
       // 정보조회 메서드 호출
       // MemberDTO dto = new MemberDTO();
       
       // dao.memberContent(dto);
       
     %>
      <hr>
      <h4> 아이디 : ${dto.mem_num }</h4>
      <h4> 비밀번호 : ${dto.password }</h4>
      <h4> 이름 : ${dto.name }</h4>
      <h4> 휴대폰 번호 : ${dto.phone }</h4>
      <h4> 회원가입일 : ${dto.reg_date }</h4>
      
      <form action="./mypageUpdate.me?mem_num=${dto.mem_num }" method="post">
          <input type="submit" value="회원수정">
       </form>
      
      <form action="./mypageDelete.me?mem_num=${dto.mem_num }" method="post">
          <input type="submit" value="회원탈퇴">
      </form>
      
      
</body>
</html>