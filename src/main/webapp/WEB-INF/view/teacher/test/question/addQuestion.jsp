<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h1>문제추가</h1>
	<form method="post" action="${pageContext.request.contextPath}/teacher/test/question/addQuestion">
		<input type="hidden" name="testNo" value="${testNo}">
		<div>
			번호 : <input type="text" name="questionIdx">
		</div>
		<div>
			문제  
		</div>
		<div>
			<textarea cols="100" rows="5" name="questionTitle"></textarea>
		</div>
		
		<button type="submit">시험 추가</button>
	</form>
</body>
</html>