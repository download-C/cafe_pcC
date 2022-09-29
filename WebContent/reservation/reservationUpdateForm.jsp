<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>예약 수정</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/reservation/reservationUpdateForm.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->
<!-- 	<h1>reservationUpdateForm.jsp</h1> -->
	
<div class="wrapper">
	<div class="title_img">
      <img src="./img/images/img (12).jpg">
      <h1 class="title">RESERVATION</h1>
      <div class="img_box"></div>
    </div>
	<div class="container">
		<form action="./ReservationUpdateAction.re" method="post">	
			<div class="resformdiv">
				<div class="resdiv">
					<div>예약 인원 &nbsp;&nbsp;&nbsp;
						 <input type="number" name="res_persons" min="1" max="8"
							placeholder="숫자만 입력하세요." value="${dto.res_persons }">명
					</div>
					<div class="ressub">예약 가능한 최대 인원은 8명입니다.</div>
				</div>
				<div class="resdiv">
					<div>예약날짜 &nbsp;&nbsp;&nbsp;
						<input type="date" name="res_date" id="res_date" value="${dto.res_date }">
					</div>
				<script>
					let dateElement = document.getElementById('res_date');
			        let mindate = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000).toISOString().slice(0, 10);
			        dateElement.value = mindate;
			        dateElement.setAttribute("min", mindate);
			        
			        function setMinValue() {
			            if(dateElement.value < mindate) {
			                alert('현재 시간보다 이전의 날짜는 설정할 수 없습니다.');
			                dateElement.value = mindate;
			                dateElement.setAttribute("min", mindate);
			            }
			        }
			        
			        let dateElement2 = document.getElementById('res_date');
			        let maxdate = new Date(new Date().getTime() - new Date().getTimezoneOffset() * 60000*20).toISOString().slice(0, 10);
			        dateElement2.value = maxdate;
			        dateElement2.setAttribute("max", maxdate);
			        
			        function setMaxValue() {
			            if(dateElement2.value > maxdate) {
			                alert('오늘로부터 7일 뒤까지만 선택 가능합니다.');
			                dateElement2.value = maxdate;
			                dateElement2.setAttribute("max", maxdate);
			            }
			        }
				</script>
			<div class="ressub">오늘로부터 일주일 안으로만 예약 가능합니다.</div>
				</div>
				<div class="resdiv">
					<div>예약시간 &nbsp;&nbsp;&nbsp;
						 <input type="number" min="10" max="17" name="res_time" value="${dto.res_time }">시
					</div>
					<div class="ressub">예약 가능 시간은 10시부터 17시까지입니다.</div>
				</div>
			</div>
			<div class="btndiv">
				<input type="submit" class="btn" value="수정하기">
			</div>
		</form>
	</div>
</div>
		
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->
</body>
</html>