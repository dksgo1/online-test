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
			<th>응시날짜</th>
			<th>답안지</th>
		</tr>
		<c:forEach var="s" items="${list}">
			<tr>
				<td>${s.testNo}</td>
				<td><a href="${pageContext.request.contextPath}/student/test/question/studentExampleList?testNo=${s.testNo}&testTitle=${s.testTitle}&studentNo=${loginStudent.studentNo}">${s.testTitle}</a></td>
				<td>${s.testDate}</td>
				<!-- 시험을 풀었을때만 보이게 해야됨 -->
				<td><a href="${pageContext.request.contextPath}/student/test/paper/testPaperList?testNo=${s.testNo}">답안지</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>