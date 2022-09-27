import="com.pcc.member.db.MemberDAO"%> <%@page
import="com.pcc.member.db.MemberDTO"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>마이 페이지</title>
    <script src="./JavaScript/main.js" defer></script>
    <link href="./css/main.css" rel="stylesheet" type="text/css" />
    <link href="./css/mypage/myPage.css" rel="stylesheet" type="text/css" />
    <script
      src="https://kit.fontawesome.com/1e92182c7c.js"
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <!-- 헤더들어가는 곳 -->
    <jsp:include page="../inc/top.jsp" />
    <!-- 헤더들어가는 곳 -->
    <h1>mypageContent.jsp</h1>

    <% 
    // 로그인 여부 체크 
    if(session != null){ String mem_num = (String)
	    session.getAttribute("mem_num"); 
	    System.out.println("회원번호 : "+mem_num);
	    if(mem_num == null) { 
	    	response.sendRedirect("./Login.pcc"); 
    	} 
    } 
    %>
    

    <img class="img1" src="./img/mypage.jpg" />

    <fieldset>
      <legend>마이페이지</legend>
      <hr />

      <table border="1">
        <tr>
          <td><div id="co_phone">휴대폰 번호</div></td>
          <td>${dto.phone }</td>
        </tr>
        <tr>
          <td><div id="co_password">비밀번호</div></td>
          <td>${dto.password }</td>
        </tr>
        <tr>
          <td><div id="co_name">이름</div></td>
          <td>${dto.name }</td>
        </tr>
        <tr>
          <td><div id="co_regate">회원가입일</div></td>
          <td>${dto.regdate }</td>
        </tr>
        <tr>
          <td colspan="2">
            <input
              type="button"
              value="회원수정"
              class="content_btn1"
              onclick="location.href='./mypageUpdate.me?mem_num=${dto.mem_num }';"
            />
            <input
              type="button"
              value="회원탈퇴"
              class="content_btn2"
              onclick="location.href='./mypageDelete.me?mem_num=${dto.mem_num }';"
            />
            <input
              type="button"
              value="주문내역"
              onclick="location.href='./OrderList.pr';"
            />
          </td>
        </tr>
      </table>
    </fieldset>
    <!-- 푸터들어가는 곳 -->
    <jsp:include page="../inc/bottom.jsp" />
    <!-- 푸터들어가는 곳 -->
  </body>
</html>
