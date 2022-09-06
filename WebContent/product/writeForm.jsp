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
      <form action="./ProductWriteAction.pr" method="post">
         상품명 : <input type="text" name="prod_name"><br>
         카테고리 :<input type="radio" name="category" value="coffee">coffee
		<input type="radio" name="category" value="noncoffee">non coffee
		<input type="radio" name="category" value="brunch">brunch<br>
         가격 : <input type="text" name="price"><br>
         
      
        <input type="submit" value="등록하기">
      </form>  
   </fieldset>
	
</body>
</html>