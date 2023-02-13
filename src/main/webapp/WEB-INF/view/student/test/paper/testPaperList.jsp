<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>답안지</h1>
	<table border="1">
		<c:forEach var="q" items="${list}">
			<tr>
				<th>${q.questionIdx}</th>
				<th>${q.questionTitle}</th>	
				<th>정답여부</th>
			</tr>
			<c:forEach var="p" items="${list2}">
				<c:if test="${q.questionNo == p.questionNo3}">
					<tr>
						<td>${p.exampleIdx}</td>
						<td>${p.exampleTitle}</td>
						<td>${p.exampleOx}</td>
					</tr>	
				</c:if>
			</c:forEach>
		</c:forEach>
	</table>
	<h2>내점수 :</h2>
</body>
</html>