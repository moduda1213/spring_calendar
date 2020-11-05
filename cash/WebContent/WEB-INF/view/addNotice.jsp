<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/inc/menu.jsp"></jsp:include>
	<h1>noticeList</h1>
	<div>
		<form method="post" action="/admin/addNotice">
			<table border="1">
				<tr>
					<th>notice_title</th>
					<td><input type="text" name ="noticeTitle"></td>
				</tr>
				<tr>
					<th>notice_content</th>
					<td><textarea cols="60" rows="10" name="noticeContent"></textarea></td>
				</tr>
			</table>
			<button type="submit">공지 추가</button>
		</form>
	</div>
</body>
</html>