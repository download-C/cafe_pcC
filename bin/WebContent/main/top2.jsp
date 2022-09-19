<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="kor">

<head>
    <!-- 구글폰트 link -->
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="./css/mainStyle.css">
    
    <%
    	String mem_num = (String)session.getAttribute("mem_num");
    	String mgr_num = (String)session.getAttribute("mgr_num");
    %>
</head>

<body>
	<%
		if(mem_num != null) {
	%>
    <div class="wrap">
        <div class="intro_bg">
            <div class="header">
<!--                 <div class="searchArea"> -->
<!--                     <form> -->
<!--                         <inpu	t type="search" placeholer="Search"> -->
<!--                         <span>검색</span> -->
<!--                     </form> -->
<!--                 </div> -->
                <ul class="nav">
                    <li><a href="#">ABOUT</a></li>
                    <li><a href="./NoticeList.no">NOTICE</a></li>
                    <li><a href="./ReservationList.re">RESERVATION</a></li>
                    <li><a href="#">TAKEOUT</a></li>
                    <li><a href="./ReviewList.rv">REVIEW</a></li>
                </ul>
				<ul class="util">
					<li><a href="./Logout.me">LOGOUT</a></li>
					<li><a href="./MyPage.me">MY PAGE</a></li>
				</ul>
			<%
		} else if(mgr_num != null) {
			%>
				<ul class="nav">
                    <li><a href="#">ABOUT</a></li>
                    <li><a href="./NoticeList.no">NOTICE</a></li>
                    <li><a href="./ReservationList.re">RESERVATION</a></li>
                    <li><a href="#">TAKEOUT</a></li>
                    <li><a href="./ReviewList.rv">REVIEW</a></li>
                </ul>
				<ul class="util">
					<li><a href="./ManagerLogout.mgr">LOGOUT</a></li>
				</ul>	
			<%
		} else {
			%>
			 <ul class="nav">
                   <li><a href="#">ABOUT</a></li>
                   <li><a href="./NoticeList.no">NOTICE</a></li>
                   <li><a href="./MemberReservationList.re">RESERVATION</a></li>
                   <li><a href="#">TAKEOUT</a></li>
                   <li><a href="./ReviewList.rv">REVIEW</a></li>
            </ul>
			<ul class="util">
				<li><a href="./Login.pcc">LOGIN</a></li>
				<li><a href="./JoinForm.me">SIGN IN</a></li>
			</ul>
			<%
		}
			%>
            </div>
        </div>
    </div>
</body>	
</html>