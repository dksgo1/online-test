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
<!-- 
지나간 시험 리스트+점수 - 점수확인버튼 - 제출답안지확인((table : paper))
오늘날짜 시험 리스트는 응시버튼을 누루면 시험지 출력(table : question x example) - 답안지제출(table : paper)
--> 
<div class="header">
	<a href="${pageContext.request.contextPath}/student/studentTestList"></a>
	<a href="${pageContext.request.contextPath}/student/modifyStudentPw">비밀번호수정</a>
	<a href="${pageContext.request.contextPath}/student/logout">로그아웃</a>
</div>
