<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div>
	
	<!-- 
		지나간 시험 리스트+점수 - 점수확인버튼 - 제출답안지확인((table : paper))
		오늘날짜 시험 리스트는 응시버튼을 누루면 시험지 출력(table : question x example) - 답안지제출(table : paper)
	--> 
	<a href="${pageContext.request.contextPath}/student/studentTestList"></a>

	<a href="${pageContext.request.contextPath}/student/modifyStudentPw">비밀번호수정</a>
	<a href="${pageContext.request.contextPath}/student/logout">로그아웃</a>	
</div>