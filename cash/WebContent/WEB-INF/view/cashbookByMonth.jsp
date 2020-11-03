<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	.sunday{
		color : #FF0000;
	}
	.etcday{
		color : gray;
		opacity:0.5;
	}
</style>
</head>
<body>
	<h1>Index</h1>
	<h3>공지사항</h3>
	<table border="1">
		<thead>
			<tr>
				<th>notice_id</th>
				<th>notice_title</th>
				<th>notice_date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="notice" items="${list }">
				<tr>
					<td>${notice.noticeId }</td>
					<td>${notice.noticeTitle }</td>
					<td>${notice.noticeDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!-- 다이어리 -->
	<div>
		이번달 수입 합계 : ${income}
	</div>
	<div>
		이번달 지출 합계 : ${expense}
	</div>
	<div>
		<h3>
			<a href="/cashbookByMonth?currentYear=${currentYear}&currentMonth=${currentMonth-1}">[이전달]</a>
			${currentYear } 년 ${currentMonth } 월
			<a href="/cashbookByMonth?currentYear=${currentYear}&currentMonth=${currentMonth+1}">[다음달]</a>
		</h3>
	</div>
	<table border="1" width="100%">
		<thead>
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<c:forEach var="i" begin="1" end="${lastDay+(firstDay-1) }" step="1">
					<c:if test = "${i - (firstDay-1) < 1}">
						<td>&nbsp;</td>
					</c:if>
					<c:if test = "${i - (firstDay-1) > 0}">
						<c:if test= "${ i % 7 == 1}">
							<td class="sunday">${i - (firstDay-1) }</td>
						</c:if>
						<c:if test="${i % 7 != 1 }">
							<td>${i - (firstDay-1) }</td>
						</c:if>
					</c:if>
					<c:if test="${i%7==0 }">
						</tr><tr>
					</c:if>
				</c:forEach>
				<c:if test="${(lastDay+(firstDay-1)) % 7 != 0}">
					<c:forEach var="j" begin="1" end="${7-((lastDay+(firstDay-1))%7) }" step="1">
							<td class="etcday">${j}</td>
					</c:forEach>
				</c:if>
			</tr>
		</tbody>
	</table>
</body>
</html>