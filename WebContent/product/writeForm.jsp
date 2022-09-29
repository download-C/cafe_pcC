<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 등록</title>
<script src="./JavaScript/main.js" defer></script>
<link href="./css/main.css" rel="stylesheet" type="text/css">
<link href="./css/writeForm.css" rel="stylesheet" type="text/css">
<script src="https://kit.fontawesome.com/1e92182c7c.js" crossorigin="anonymous"></script>
</head>
<body>
<!-- 헤더들어가는 곳 -->
<jsp:include page="../inc/top.jsp" />
<!-- 헤더들어가는 곳 -->

<!-- 	<div style="position: relative; height: 100px"></div> -->

	<h1>New 상품 등록</h1>
<!-- 	  <h2> 상품 등록 페이지 </h2> -->
   
   <fieldset>
      <form action="./ProductSave.pr" method="post" enctype="multipart/form-data">
      	<label for="prod_name">상품명 : </label>
        <input type="text"  name="prod_name" id="prod_name"><br>
        
      	<label for="category">카테고리 : </label>
        <input type="radio" name="category" id="category" value="coffee">coffee
		<input type="radio" name="category" id="category" value="noncoffee">non coffee
	 	<input type="radio" name="category" id="category" value="brunch">brunch<br>
	 	
	 	<label for="price">가격 : </label>
        <input type="text" name="price" id="price"><br>
        
	 	<label for="prod_img">상품 사진 : </label>
        <input type="file" name="prod_img" id="prod_img"><br>
        
        <input type="submit" value="상품 등록하기">
      </form>  
   </fieldset>
<!-- 푸터들어가는 곳 -->
<jsp:include page="../inc/bottom.jsp" />
<!-- 푸터들어가는 곳 -->	
</body>
</html>