<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// index.jps
		
		//상품 등록 페이지로 이동
  		//response.sendRedirect("./ProductWrite.pr");
	
		//상품 리스트(Menu) 페이지 이동
  		response.sendRedirect("./ProductList.pr");
  		//response.sendRedirect("./Cart.pr");
  		//response.sendRedirect("./OrderWrite.pr");
	
	%>

	
</body>
</html>