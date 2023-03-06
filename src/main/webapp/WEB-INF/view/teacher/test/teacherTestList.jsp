<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
	<style>
		body {
			font-family: Arial, sans-serif;
			margin: 0;
			padding: 0;
			background-color: #f4f4f4;
		}
		h1 {
			margin-top: 40px;
			text-align: center;
			color: #333;
		}
		table {
			width: 80%;
			margin: 30px auto;
			border-collapse: collapse;
			background-color: #fff;
			box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
		}
		th,
		td {
			padding: 15px;
			text-align: center;
		}
		th {
			background-color: #333;
			color: #fff;
		}
		tr:nth-child(even) {
			background-color: #f2f2f2;
		}
		a {
			color: #333;
			text-decoration: none;
		}
		a:hover {
			color: dodgerblue;
			text-decoration: underline;
		}
		.addTest {
			background-color: #4CAF50;
			border: none;
			color: white;
			padding: 10px 20px;
			text-decoration: none;
			display: inline-block;
			font-size: 16px;
			margin-top: 10px;
			margin-bottom: 20px;
			margin-left: 140px;
			cursor: pointer;
		}
	</style>
</head>
<body>
	<!-- teacherMenu include -->
	<div>
		<c:import url="/WEB-INF/view/teacher/inc/teacherMenu.jsp"></c:import>
	</div>
	<h1>Test List</h1>
	<a href="${pageContext.request.contextPath}/teacher/test/addTest" class="addTest">시험추가</a>
	<table>
		<tr>
			<th>시험회차</th>
			<th>시험이름</th>
			<th>응시날짜</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="t" items="${list}">
			<tr>
				<td>${t.testNo}</td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/question/teacherQuestionList?testNo=${t.testNo}&testTitle=${t.testTitle}">${t.testTitle}</a></td>
				<td>${t.testDate}</td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/modifyTest?testNo=${t.testNo}">수정</a></td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/deleteTest?testNo=${t.testNo}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>