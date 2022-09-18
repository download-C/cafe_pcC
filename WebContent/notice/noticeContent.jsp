<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 확인하기</title>
<% 
// 매니저로 로그인했을 때만 글 쓰기 버튼이 보이게
	String mem_num = (String)session.getAttribute("mem_num");
	String mgr_num = (String)session.getAttribute("mgr_num");
%>

 
</head>
<body>
<jsp:include page="../main/top2.jsp" />
	 <fieldset>
		<table>
			<tr>
				<td>글번호</td>
				<td>${dto.notice_num }</td>
				<td>조회수</td>
				<td>${dto.notice_readcount }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>관리자</td>
				<td>작성일</td>
				<td>${dto.notice_date }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td colspan="3">${dto.notice_subject }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${dto.notice_content }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3">${dto.notice_file }</td>
			</tr>
	
	     </table>
	</fieldset>
	<%
		// 매니저 로그인 시 수정, 삭제버튼 보이게 함
 		if(mgr_num != null) {
	 %>		
		<input type="button" name="notice_update" value="수정"
	     onclick="location.href='./NoticeUpdate.no?notice_num=${dto.notice_num}';">
	
		<input type="button" name="notice_delete" value="삭제"
	    onclick="location.href='./NoticeDelete.no?notice_num=${dto.notice_num}';">
			 
    <%
		} else {}
	%>
		<input type="button" name="notice_list" value="목록" 
	     onclick="location.href='./NoticeList.no?pageNum=${pageNum}';">
</body>
</html>