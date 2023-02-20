<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		.container {
			margin-top: 20px;
		}
		h1 {
			text-align: center;
			margin-bottom: 30px;
		}
		table {
			width: 100%;
			border-collapse: collapse;
			box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
			margin: auto;
		}
		th, td {
			text-align: center;
			padding: 15px;
			border-bottom: 1px solid #ddd;
		}
		tr:nth-child(even) {
			background-color: #f2f2f2;
		}
		tr:hover {
			background-color: #f5f5f5;
		}
		th {
			background-color: #007bff;
			color: white;
			border-bottom: none;
		}
		td a {
			color: #007bff;
			text-decoration: none;
			font-weight: bold;
		}
		td a:hover {
			color: #0056b3;
		}
	</style>
</head>
<body>
	<!-- studentMenu include -->
	<div>
		<c:import url="/WEB-INF/view/student/inc/studentMenu.jsp"></c:import>
	</div>
	<div class="container">
		<h1>Test List</h1>
		<table>
			<thead>
				<tr>
					<th>시험회차</th>
					<th>시험이름</th>
					<th>응시날짜</th>
					<th>시험응시</th>
					<th>답안지</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${list}">
					<tr>
						<td>${s.testNo}</td>
						<td>${s.testTitle}</td>
						<td>${s.testDate}</td>
						<td>
							<a href="${pageContext.request.contextPath}/student/test/question/studentExampleList?testNo=${s.testNo}&testTitle=${s.testTitle}&studentNo=${loginStudent.studentNo}">응시하기</a>
						</td>
						<c:set var="testPaperList" value="${testPaperService.getPaperList(loginStudent.studentNo, s.testNo)}"/>
						<!-- 시험을 풀었을때만 보이게 해야됨 -->
						<td><a href="${pageContext.request.contextPath}/student/test/paper/testPaperList?testNo=${s.testNo}&studentNo=${loginStudent.studentNo}">답안지</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>