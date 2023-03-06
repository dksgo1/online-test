<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	.header {
		display: flex;
		justify-content: space-between;
		align-items: center;
		background-color: #333;
		padding: 10px;
	}
	.header a {
		color: #fff;
		text-decoration: none;
		margin-right: 20px;
	}
	.header a:hover {
		color: #f2f2f2;
	}
</style>
<div class="header">
	<!-- 등록시 ID체크(employee + teacher + student) -->
	<a href="${pageContext.request.contextPath}/employee/empList">사원관리</a>
	
	<!-- 강사목록, 강사삭제 -->
	<a href="${pageContext.request.contextPath}/employee/teacher/teacherList">강사관리</a>
	
	<!-- 학생목록, 학생삭제 -->
	<a href="${pageContext.request.contextPath}/employee/student/studentList">학생관리</a>

	<a href="${pageContext.request.contextPath}/employee/modifyEmpPw">비밀번호수정</a>
	<a href="${pageContext.request.contextPath}/employee/logout">로그아웃</a>	
</div>