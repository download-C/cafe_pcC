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
     
     <h2>회원수정 페이지</h2>
     <%
       // 로그인 체크
       String id = (String)session.getAttribute("loginID");
       if(id == null){
    	   response.sendRedirect("");
       }
       // 기존의 회원정보 화면 출력
       // MemberDAO 객체 생성
       MemberDAO dao = new MemberDAO();
       
       // 회원정보 조회메서드
       MemberDTO dto = new MemberDTO();
     %>
     
     <fieldset>
       <form action="updatePro.jsp" method="post" name="fr">
          아이디 : <input type="text" name="id" value="<%=dto.getMem_num()%>" readonly="readonly"> <br>
          비밀번호 : <input type="password" name="password"> <br>
          이름 : <input type="text" name="name" value="<%=dto.getName()%>"> <br>
          휴대폰 번호 : <input type="text" name="phone" value="<%=dto.getPhone()%>">
          <hr>
             <input type="submit" value="개인정보수정"> 
       </form>
     </fieldset>
     
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
     
     <%
     // 정보 수정메서드(비밀번호, 이름)
      int result = dao.updateMember(dto);
      
      // 페이지 이동
      if(result == 1){
    	  // 정보수정을 성공
          %>
    	   <script type="text/javascript">
    	       alert("정보 수정 완료~!");
    	       location.href="";
    	   </script>
    	   <%
      }else if(result == 0){
    	  // 수정 실패-비밀번호 오류
    	   %>
    	   <script type="text/javascript">
    	       alert("수정실패 : 비밀번호 오류");
    	       history.back();
    	   </script>
    	   <%
      }else{//result == -1
    	  // 수정 실패-아이디 정보 없음
    	   %>
    	   <script type="text/javascript">
    	       alert("수정실패 : 아이디 정보 없음");
    	       history.back();
    	   </script>
    	   <%
      }
      
    %>
     
</body>
</html>