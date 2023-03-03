<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
   		<meta charset="UTF-8">
   		<title></title>
   		<style>
      	/* 해더 스타일 */
	      .header {
	        background-color: #222;
	        color: #fff;
	        font-family: Arial, sans-serif;
	        text-align: center;
	        box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
	        padding: 20px;
	        position: fixed;
	        top: 0;
	        width: 100%;
          	position: relative;
  			z-index: 1;
	      }
	      
	      /* 로고 스타일 */
	      .logo {
	        font-size: 40px;
	        font-weight: bold;
	        text-transform: uppercase;
	        letter-spacing: 4px;
	        margin-bottom: 10px;
	      }
	      
	      /* 네비게이션 스타일 */
	      .nav {
	        display: flex;
	        justify-content: center;
	        margin-bottom: 10px;
	      }
	      
	      .nav a {
	        color: #fff;
	        text-decoration: none;
	        font-size: 20px;
	        margin-right: 20px;
	      }
	      
	      .nav a:hover {
	        color: #f00;
	        text-decoration: underline;
	      }
	    </style>
	</head>
</html> 
<div>	
	<!-- 
		지나간 시험 리스트+점수 - 점수확인버튼 - 제출답안지확인((table : paper))
		오늘날짜 시험 리스트는 응시버튼을 누루면 시험지 출력(table : question x example) - 답안지제출(table : paper)
	--> 
	<div class="header">
   		<div class="nav">
			<a href="${pageContext.request.contextPath}/student/studentTestList"></a>
			<a href="${pageContext.request.contextPath}/student/modifyStudentPw">비밀번호수정</a>
			<a href="${pageContext.request.contextPath}/student/logout">로그아웃</a>
		</div>	
	</div>
</div>