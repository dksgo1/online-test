<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<!-- teacherMenu include -->
	<div>
		<c:import url="/WEB-INF/view/teacher/inc/teacherMenu.jsp"></c:import>
	</div>
	<h1>보기 추가</h1>
	<form method="post" action="${pageContext.request.contextPath}/teacher/test/question/example/addExample">
		<input type="hidden" name="questionNo" value="${questionNo}">
		<div>
			번호 : <input type="text" name="exampleIdx">
		</div>
		<div>
			보기  
		</div>
		<div>
			<textarea cols="100" rows="3" name="exampleTitle"></textarea>
		</div>
		<div>
			정답여부
		 	<select name="exampleOx">
		 		<option value="정답">정답</option>
		 		<option value="오답">오답</option>
			</select>
		</div>
		<button type="submit">보기 추가</button>
	</form>
</body>
</html>