<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 등록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/product/writeForm.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="./JavaScript/jquery-3.6.0.js"></script>

</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

	<div style="position: relative; height: 100px"></div>
<div class="container_write">
<!-- 	  <h2> 상품 등록 페이지 </h2> -->
   <div class="container2">
   <h1>New 상품 등록</h1>
   
	      <form action="./ProductSave.pr" method="post" enctype="multipart/form-data">
	  		<div class="border1">
	  			
		      	<div>
			      	<span>상품명</span> 
			        <input type="text"  name="prod_name" id="prod_name">
		        </div>
		        
		        <div>
			      	<span>카테고리</span> 
			        <input type="radio" name="category" id="category" value="coffee">coffee
					<input type="radio" name="category" id="category" value="noncoffee">non coffee
				 	<input type="radio" name="category" id="category" value="brunch">brunch<br>
			 	</div>
			 	
		        <div>
			      	<span>가격</span> 
			        <input type="text" name="price" id="price"><br>
		        </div>
		        
		        <div>
			      	<span>상품사진</span> 
			        <input type="file" name="prod_img" id="prod_img"><br>
		        </div>
		        
			   </div>
		        
		        <div class="btn">
		        	<input type="submit" value="상품 등록하기">
	     		</div>
	     		
	     </form>  
	   
	</div>

</div>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>