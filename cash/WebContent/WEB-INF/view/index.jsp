<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HOME</h1>
	<!-- 공지 -->
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>notice_id</td>
					<td>notice_title</td>
					<td>notice_content</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${noticeList }">
					<tr>
						<td>${n.noticeId }</td>
						<td>${n.noticeTitle }</td>
						<td>${n.noticeContent }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</div>
	<!-- 수익 지출 -->
	<div>
		<table border="1">
			<thead>
				<tr>
					<td>날짜</td>
					<td>수입</td>
					<td>지출</td>
					<td>합계</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="io" items="${inOutList }">
					<tr>
						<td>${io["날짜"]}</td>
						<td>${io["수입"]}</td>
						<td>${io["지출"]}</td>
						<td>${io["합계"]}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</div>
</body>
</html>