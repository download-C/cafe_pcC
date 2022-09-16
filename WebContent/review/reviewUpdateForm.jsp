<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰 수정하기</title>
</head>
<body>
<header><jsp:include page="../main/top.jsp"></jsp:include></header>
	<h1>reviewUpdateForm.jsp</h1>
	<!-- 리뷰 글 수정하기 -->
	<fieldset>
		<h3>리뷰 글 수정하기</h3>
		<form action="./ReviewUpdateAction.no?review_num=${dto.review_num }&pageNum=${pageNum}" method="post">
			<div>
				<table>
					<tr>
						<td><input type="hidden" name="review_num" id="review_num"
							value="${dto.review_num }"></td>
					</tr>
					<tr>
						<td><input type="password" name="review_password"
							id="review_password" value="${dto.review_password }"></td>
					</tr>
					<tr>
						<td><input type="text" name="review_subject"
							id="review_subject" value="${dto.review_subject }"></td>
					</tr>
					<tr>
						<td><textarea rows="30" cols="100" name="review_content"
								id="review_contnet">
							${dto.review_content }
						</textarea></td>
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
	
</body>
</html>