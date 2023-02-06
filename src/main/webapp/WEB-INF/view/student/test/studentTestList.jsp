<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- studentMenu include -->
	<div>
		<c:import url="/WEB-INF/view/student/inc/studentMenu.jsp"></c:import>
	</div>
	<div>Test List</div>
	<table border="1">
		<tr>
			<th>시험회차</th>
			<th>시험이름</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="s" items="${list}">
			<tr>
				<td>${s.testNo}</td>
				<td><a href="${pageContext.request.contextPath}/">${s.testTitle}</a></td>
				<td>${s.testDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>