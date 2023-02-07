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
	<h1>문제 수정</h1>
	<form action="${pageContext.request.contextPath}/teacher/test/question/example/modifyExample" method="post">
		<input type="hidden" name="questionNo" value="${questionNo}">
		<input type="hidden" name="exampleNo" value="${exampleNo}">
		<table>
			<tr>
				<td>번호</td>
				<td><input type="text" name="exampleIdx"></td>
			</tr>
			<tr>
				<td>보기</td>
				<td><input type="text" name="exampleTitle"></td>
			</tr>
			<tr>
				<td>정답여부</td>
				<td>
					<select name="exampleOx">
						<option value="정답">정답</option>
						<option value="오답">오답</option>
					</select>
				</td>
			</tr>
		</table>
		<button type="submit">수정</button>
	</form>
</body>
</html>