<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	.addExample {
		display: inline-block;
		background-color: #007bff;
		color: #fff;
		padding: 10px 20px;
		border-radius: 5px;
		text-decoration: none;
		margin-bottom: 20px;
	}
	
	table {
		border-collapse: collapse;
		margin-bottom: 20px;
		width: 100%;
		box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	}

	th {
		background-color: #f2f2f2;
		color: #333;
		font-weight: bold;
		padding: 10px;
		text-align: center;
		text-transform: uppercase;
		border: 1px solid #ccc;
	}

	tr {
		background-color: #fff;
		color: #333;
		border: 1px solid #ccc;
	}

	td:first-child {
		background-color: #ffc107;
		color: #fff;
		font-weight: bold;
		width: 50px;
		border-right: 1px solid #ccc;
	}


	td:nth-child(4) a,
	td:nth-child(5) a {
		display: inline-block;
		background-color: #dc3545;
		color: #fff;
		padding: 5px 10px;
		border-radius: 5px;
		text-decoration: none;
		margin: 0 5px;
	}

	td:nth-child(4) a:hover,
	td:nth-child(5) a:hover {
		background-color: #c82333;
	}
    td:nth-child(2) {
        min-width: 100px;
    }
  
    td:nth-child(2) {
        max-width: 300px;
        word-wrap: break-word;
    }
</style>
</head>
<body>
	<!-- teacherMenu include -->
	<div>
		<c:import url="/WEB-INF/view/teacher/inc/teacherMenu.jsp"></c:import>
	</div>
	<h1>보기</h1>
	<a href="${pageContext.request.contextPath}/teacher/test/question/example/addExample?questionNo=${questionNo}" class="addExample">보기 추가</a>
	<c:forEach var="e" items="${list}">
		<table border="1">
			<tr>
				<td>${e.exampleIdx}번</td>
				<td>${e.exampleTitle}</td>
				<td>${e.exampleOx}</td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/question/example/modifyExample?questionNo=${questionNo}&exampleNo=${e.exampleNo}">수정</a></td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/question/example/deleteExample?questionNo=${questionNo}&exampleNo=${e.exampleNo}">삭제</a></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>