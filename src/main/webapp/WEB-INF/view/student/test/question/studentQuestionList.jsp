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
	<table>	
		<c:forEach var="q" items="list">
			<tr>
				<th>번호</th>
				<th>문제</th>
			</tr>	
			<tr>
				<td></td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>