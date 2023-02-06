<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>시험추가</h1>
	<form method="post" action="${pageContext.request.contextPath}/teacher/test/addTest">
		<div>
			시험 이름 : <input type="text" name="testTitle">
		</div>
		<div>
			응시 날짜 : <input type="date" name="testDate">
		</div>
		<button type="submit">시험 추가</button>
	</form>
</body>
</html>