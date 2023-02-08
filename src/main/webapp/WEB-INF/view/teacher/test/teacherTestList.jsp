<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- teacherMenu include -->
	<div>
		<c:import url="/WEB-INF/view/teacher/inc/teacherMenu.jsp"></c:import>
	</div>
	<h1>Test List</h1>
	<a href="${pageContext.request.contextPath}/teacher/test/addTest">시험추가</a>
	<table border="1">
		<tr>
			<th>시험회차</th>
			<th>시험이름</th>
			<th>응시날짜</th>
			<th>수정</th>
		</tr>
		<c:forEach var="t" items="${list}">
			<tr>
				<td>${t.testNo}</td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/question/teacherQuestionList?testNo=${t.testNo}&testTitle=${t.testTitle}">${t.testTitle}</a></td>
				<td>${t.testDate}</td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/modifyTest?testNo=${t.testNo}">수정</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>