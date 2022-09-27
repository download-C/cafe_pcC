<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

String mem_num = (String)session.getAttribute("mem_num");
String mgr_num = (String)session.getAttribute("mgr_num");
%>
<script type="text/javascript">
	$(document).ready(function(){
		   //스크롤 이벤트
	       var lastScrollTop = 0; 
	       var delta = 15;
	       
	       $(window).scroll(function(event){
	          
	          var st = $(this).scrollTop();
	          
	          if(Math.abs(lastScrollTop - st) <= delta)
	             return; // 스크롤값을 받아서 리턴한다.
	          
	             
	            // 내릴때
	         if ((st > lastScrollTop) && (lastScrollTop>0)) {
// 	             alert("안녕");
	              $("header").css({
	                 "position" : "fixed ",
	                 "transition-duration" : "0.5s",
	                 "background-color" : "white",
// 		             "color": "gray"

	              });
	              
	              $(".navbar a").css({
	            	  "color": "gray",
	                  "transition-duration" : "0.5s"
	              });
	             
	              $(".menu_area_ul li a:hover").css({
	            	  "color": "#adc2a9",
	                  "transition-duration" : "0.5s"
	              });
	              
	         // 올릴때
	         } else {
// 	        	 alert("하이");
	        	 $("header").css({
	                 "background-color":"",
	                 "position" : "fixed",
	                 "transition-duration" : "0.5s"

	              });
	        	 
	        	 $(".navbar a").css({
	            	  "color": "",
	                  "transition-duration" : "0.5s"
	              });
	              
	              

	         }
	             lastScrollTop = st;
	       });
	       
	       
	   });
	   


</script>
  <header>
    <!-- 헤더 전체 영역 -->
    <div class="header_area">
    <nav class="navbar">
      <!-- 로고 영역 시작 -->
      <div class="logo_area">
        <a href="./MainPage.pcc" >
<!--         <img id="logo_top" src="./css/logo.png"> -->
        public class Cafe</a>
      </div>
      <!-- 로고 영역 끝 -->
      
      <!-- 메뉴영역 시작 -->
      <div class="menu_area">
          <ul class="menu_area_ul">
              <li><a href="./About.pcc">ABOUT</a></li>
              <li><a href="./NoticeList.no">NOTICE</a></li>
              <li><a href="./ProductList.pr">MENU</a></li>
              <li><a href="./ReservationList.re">RESERVATION</a></li>
<!--               <li><a href="./Order">TAKEOUT</a></li> -->
              <li><a href="./ReviewList.rv">REVIEW</a></li>
              <li><a href="./QnAList.qna">Q&A</a></li>
          </ul>
      </div>
      <!-- 메뉴영역 끝 -->
      
      <!-- 로그인 영역 시작 -->
<%if(mem_num != null)  {%>
      <div class="login_area">
      <ul class="login_area_ul">
        <li><a href="./MyPage.me">${name }님</a></li>
        <li><a href="./Logout.me">LOGOUT</a></li>
        <li><a href="./Cart.pr">CART</a></li>
      </ul>
      </div>
<%} else if(mgr_num != null) { %>      
      <div class="login_area">
      <ul class="login_area_ul">
        <li><a href="./Logout.mgr">LOGOUT</a></li>
        <li><a href="./main/admin.jsp">ADMIN</a></li>
      </ul>
      </div>
<%} else {%>
      <div class="login_area">
      <ul class="login_area_ul">
        <li><a href="./Login.pcc">LOGIN</a></li>
        <li><a href="./SignMain.me">SIGN</a></li>
      </ul>
      </div>
<%} %>
      <!-- 로그인 영역 끝 -->

      <!-- 토글버튼 -->	
    <div class="togglebtn">
      <a href="#" class="togglebtn_a">
            <i class="fa-regular fa-bars"></i>
      </a>
    </div>
    </nav>
    </div>
    <!-- 헤더 전체 영역 -->
  </header>
</body>
</html>