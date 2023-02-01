<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- empMenu include -->
	<div>
		<c:import url="/WEB-INF/view/employee/inc/empMenu.jsp"></c:import>
	</div>
	<h1>Student List</h1>
	<a href="${pageContext.request.contextPath}/student/addStudent">학생등록</a>
	<table border="1">
		<tr>
			<th>studentId</th>
			<th>studentName</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="s" items="${list}">
			<tr>
				<td>${s.studentId}</td>
				<td>${s.studentName }</td>
				<td><a href="${pageContext.request.contextPath}/student/deleteStudent?studentNo=${s.studentNo}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${currentPage > 1}">
			<a href="${pageContext.request.contextPath}/teacher/teacherList?currentPage=${currentPage-1}">이전</a>
		</c:if>
		<a href="${pageContext.request.contextPath}/teacher/teacherList?currentPage=${currentPage+1}">다음</a>
	</div>
</body>
</html>