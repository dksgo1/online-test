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
	header {
		background-color: #333;
		color: #fff;
		padding: 10px;
		text-align: center;
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
	a:hover
	
	.pagination {
	  display: flex;
	  justify-content: center;
	}
	.pagination {
		margin-top: 20px;
	}
	.pagination a {
		display: inline-block;
		margin: 0 5px;
		padding: 5px 10px;
		background-color: #f2f2f2;
		border: 1px solid #ddd;
		color: black;
		text-decoration: none;
	}
	.pagination a.active {
		background-color: dodgerblue;
		color: white;
	}
	.pagination a.disabled {
		color: #ddd;
		pointer-events: none;
	}
	.addStudent {
		background-color: #4CAF50;
		border: none;
		color: white;
		padding: 10px 20px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin-top: 10px;
		margin-bottom: 5px;
		margin-left: 140px;
		cursor: pointer;
	}
</style>
</head>
<body>
	<!-- empMenu include -->
	<div>
		<c:import url="/WEB-INF/view/employee/inc/empMenu.jsp"></c:import>
	</div>
	<h1>Student List</h1>
	<a href="${pageContext.request.contextPath}/employee/student/addStudent" class="addStudent">학생등록</a>
	<table>
		<tr>
			<th>studentId</th>
			<th>studentName</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="s" items="${list}">
			<tr>
				<td>${s.studentId}</td>
				<td>${s.studentName }</td>
				<td><a href="${pageContext.request.contextPath}/employee/student/deleteStudent?studentNo=${s.studentNo}">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align: center;">
		<form method="get" action="${pageContext.request.contextPath}/employee/student/studentList">
			<input type="text" name="searchWord">
			<button type="submit">이름검색</button> 
		</form>
		<div class="pagination">
			<a href="${pageContext.request.contextPath}/employee/student/studentList?currentPage=1&searchWord=${searchWord}">처음으로</a>		
			<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/employee/student/studentList?currentPage=${currentPage-1}&searchWord=${searchWord}">이전</a>
			</c:if>
			<c:forEach var="i" begin="${currentPage}" end="${endPage}" step="1">
				<a href="${pageContext.request.contextPath}/employee/student/studentList?currentPage=${i}&searchWord=${searchWord}">${i}</a>
			</c:forEach>
			<c:if test="${currentPage < lastPage}">
				<a href="${pageContext.request.contextPath}/employee/student/studentList?currentPage=${currentPage+1}&searchWord=${searchWord}">다음</a>
			</c:if>
			<a href="${pageContext.request.contextPath}/employee/student/studentList?currentPage=${lastPage}&searchWord=${searchWord}">끝으로</a>	
		</div>
	</div>	
</body>
</html>