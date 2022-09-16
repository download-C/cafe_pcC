<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>writeForm.jsp</h1>
	  <h2> 상품 등록 페이지 </h2>
   
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
	
</body>
</html>