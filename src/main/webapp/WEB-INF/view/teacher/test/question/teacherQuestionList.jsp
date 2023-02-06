<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>문제 리스트</h1>
	<a href="${pageContext.request.contextPath}/teacher/test/question/addQuestion?testNo=${testNo}">문제 추가</a>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>문제</th>
			<th>수정</th>
		</tr>
		<c:forEach var="q" items="${list}">		
			<tr>
				<td>${q.questionIdx}</td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/question/example/teacherExampleList?questionNo=${q.questionNo}">${q.questionTitle}</a></td>
				<td><a href="${pageContext.request.contextPath}/teacher/test/question/modifyQuestion">문제 수정</a></td>
			</tr>
		</c:forEach>	
	</table>
</body>
</html>