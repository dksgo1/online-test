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
	<h1>보기</h1>
	<a href="${pageContext.request.contextPath}/teacher/test/question/example/addExample?questionNo=${questionNo}">보기 추가</a>
	<c:forEach var="e" items="${list}">
		<table border="1">
			<tr>
				<td>${e.exampleIdx}번</td>
				<td>${e.exampleTitle}</td>
				<td>${e.exampleOx}</td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/question/example/modifyExample?questionNo=${questionNo}&exampleNo=${e.exampleNo}">수정</a></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>