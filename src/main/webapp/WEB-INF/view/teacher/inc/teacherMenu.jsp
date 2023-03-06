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
	<!-- 
		시험회차(table : test) 관리(시험회차 CRUD)
		개별시험회차를 클릭하면 그 회차의 문제리스트 출력(문제 CRUD)
		개별문제를 클릭하면 그 문제의 보기 리스트 출력(문제 CRUD)
	 -->	
	<a href="${pageContext.request.contextPath}/teacher/test/teacherTestList">시험관리</a>
	
	

	<a href="${pageContext.request.contextPath}/teacher/modifyTeacherPw">비밀번호수정</a>
	<a href="${pageContext.request.contextPath}/teacher/logout">로그아웃</a>
</div>