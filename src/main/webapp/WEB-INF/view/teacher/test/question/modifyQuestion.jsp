<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>문제 수정</h1>
	<form action="${pageContext.request.contextPath}/teacher/test/question/modifyQuestion">
		<table>
			<tr>
				<td>
					<input type="hidden" name="questionNo" value="${questionNo}">
					<input type="text" name="questionTitle" value="${questionNo}">
				</td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>