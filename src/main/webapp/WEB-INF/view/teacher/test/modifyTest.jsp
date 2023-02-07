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
	<h1>회차 수정</h1>
	<form action="${pageContext.request.contextPath}/teacher/test/modifyTest" method="post">
		<input type="hidden" name="testNo" value="${testNo}">
		<table>
			<tr>
				<td>testTitle</td>
				<td><input type="text" name="testTitle"></td>
			</tr>
			<tr>
				<td>testDate</td>
				<td><input type="date" name="testDate"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>