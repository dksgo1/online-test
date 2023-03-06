<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	table {
	  border-collapse: collapse;
	  margin: 20px;
	  width: 100%;
	}
	
	th {
	  background-color: #f2f2f2;
	  color: #333;
	  font-weight: bold;
	  padding: 10px;
	  text-align: center;
	  text-transform: uppercase;
	}
	
	td {
	  background-color: #fff;
	  color: #333;
	  padding: 10px;
	  text-align: center;
	  vertical-align: middle;
	}
	
	tr:nth-child(even) {
	  background-color: #f9f9f9;
	}
	
	tr:hover {
	  background-color: #f2f2f2;
	}
	
	td a {
	  color: #333;
	  text-decoration: none;
	}
	
	td a:hover {
	  color: #666;
	  font-weight: bold;
	}
	
	td:nth-child(1) {
	  background-color: #ffc107;
	  color: #fff;
	  font-weight: bold;
	  width: 50px;
	}
	
	td:nth-child(2) {
	  text-align: left;
	}
	
	td:nth-child(3),
	td:nth-child(4) {
	  width: 100px;
	}
</style>
</head>
<body>
	<!-- teacherMenu include -->
	<div>
		<c:import url="/WEB-INF/view/teacher/inc/teacherMenu.jsp"></c:import>
	</div>
	<h1>${testTitle}</h1>
	<a href="${pageContext.request.contextPath}/teacher/test/question/addQuestion?testNo=${testNo}">문제 추가</a>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>문제</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="q" items="${list}">		
			<tr>
				<td>${q.questionIdx}</td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/question/example/teacherExampleList?questionNo=${q.questionNo}">${q.questionTitle}</a></td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/question/modifyQuestion?questionNo=${q.questionNo}&testNo=${q.testNo}">수정</a></td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/Question/deleteQuestion?questionNo=${q.questionNo}&testNo=${q.testNo}">삭제</a></td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>