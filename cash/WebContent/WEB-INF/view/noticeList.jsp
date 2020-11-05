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
	<a href="/admin/addNotice">공지 추가</a>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>notice_id</th>
					<th>notice_title</th>
					<th>notice_date</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="n" items="${noticeListByPage}">
					<tr>
						<td>${n.noticeId}</td>
						<td><a href="/admin/noticeOne?noticeId=${n.noticeId}">${n.noticeTitle}</a></td>
						<td>${n.noticeDate}</td>
						<td><a href="/admin/updateNotice?noticeId=${n.noticeId}">수정</a></td>
						<td><a href="/admin/removeNotice?noticeId=${n.noticeId}">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<c:if test="${currentPage == 1 }">
		<a href="/admin/noticeList?currentPage=${currentPage+1}">다음</a>
	</c:if>
	<c:if test="${currentPage == lastPage }">
		<a href="/admin/noticeList?currentPage=${currentPage-1}">이전</a>
	</c:if>
	<c:if test="${currentPage > 1 && currentPage < lastPage}">
		<a href="/admin/noticeList?currentPage=${currentPage-1}">이전</a>
		<a href="/admin/noticeList?currentPage=${currentPage+1}">다음</a>
	</c:if>
	
	
</body>
</html>