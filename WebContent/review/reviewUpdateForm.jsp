<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 수정하기</title>
</head>
<body>
<header>
	<jsp:include page="../main/top.jsp" />
</header>
	<h1>reviewUpdateForm.jsp</h1>
	
	<fieldset>
		<h3>리뷰 글 수정하기</h3>
		<form action="./ReviewUpdateAction.rv?review_num=${review_num }" method="post">
			<div>
				<table>
					<tr>
						<td>
						<input type="hidden" name="review_num" id="review_num"
							value="${review_num }"></td>
					</tr>
					<tr>
						<td>
						비밀번호
						<input type="password" name="review_password"
							id="review_password" value="${dto.review_password }"></td>
					</tr>
					<tr>
						<td>
						제목
						<input type="text" name="review_subject"
							id="review_subject" value="${dto.review_subject }"></td>
					</tr>
					<tr>
						<td><textarea rows="30" cols="100" name="review_content"
								id="review_contnet">${dto.review_content }</textarea></td>
					</tr>
					<tr>
						<td><input type="file" name="review_file"
							id="review_file"></td>
					</tr>
				</table></div>
		<div>
			<input type="submit" value="수정">
		</div>
		</form>
	</fieldset>
<!-- 푸터 시작 -->
<jsp:include page="../main/bottom.jsp" />
<!-- 푸터 끝 -->
</body>
</html>