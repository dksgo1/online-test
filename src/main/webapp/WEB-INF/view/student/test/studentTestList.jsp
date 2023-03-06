<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<style>
		.container {
			margin-top: 20px;
		}
		h1 {
			text-align: center;
			margin-bottom: 30px;
		}
		table {
			width: 100%;
			border-collapse: collapse;
			box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
			margin: auto;
		}
		th, td {
			text-align: center;
			padding: 15px;
			border-bottom: 1px solid #ddd;
		}
		tr:nth-child(even) {
			background-color: #f2f2f2;
		}
		tr:hover {
			background-color: #f5f5f5;
		}
		th {
			background-color: #add8e6;
			color: white;
			border-bottom: none;
		}
		td a {
			color: #007bff;
			text-decoration: none;
			font-weight: bold;
		}
		td a:hover {
			color: #0056b3;
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			let testBtn = document.querySelectorAll('.testBtn');
			let testDate = document.querySelectorAll('.testDate');
			let testNo = document.querySelectorAll('.testNo');
			let today = new Date();
			// console.log(today);
			console.log(testDate);
			let year = today.getFullYear();
			let month = ('0' + (today.getMonth() + 1)).slice(-2);
			let day = ('0' + today.getDate()).slice(-2);
			let date = year + '-' + month  + '-' + day;
			// console.log(dateString);
			for(let i = 0; i < testNo.length; i++) {
				testBtn[i].addEventListener('click',function(){
					let examDate = testDate[i].innerHTML;
					let examLimitDate = new Date(examDate);
		            examLimitDate.setDate(examLimitDate.getDate() + 7); // 응시 가능한 기간을 1주일로 제한
		            if (today < examDate || today > examLimitDate) {
		                alert('지금은 시험응시 가능기간이 아닙니다.');
		                event.preventDefault();
		            }
				});
			}
		});
	</script>
</head>
<body>
	<!-- studentMenu include -->
	<div>
		<c:import url="/WEB-INF/view/student/inc/studentMenu.jsp"></c:import>
	</div>
	<div class="container">
		<h1>Test List</h1>
		<table>
			<thead>
				<tr>
					<th>시험회차</th>
					<th>시험이름</th>
					<th>응시날짜</th>
					<th>시험응시/답안지</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${list}">
				    <c:set var="answered" value="false"></c:set>
				    <c:forEach var="p" items="${paperList}">
				        <c:if test="${p.testNo == s.testNo}">
				            <c:set var="answered" value="true"></c:set>
				        </c:if>
				    </c:forEach>
					<tr>
						<td><span class="testNo">${s.testNo}</span></td>
						<td>${s.testTitle}</td>
						<td><span class="testDate">${s.testDate}</span>~ ${java.time.LocalDate.parse(s.testDate).plusDays(7)}</td>
						<c:choose>		
							<c:when test="${answered}">
								<td><a href="${pageContext.request.contextPath}/student/test/paper/testPaperList?testNo=${s.testNo}&studentNo=${loginStudent.studentNo}">답안지</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="${pageContext.request.contextPath}/student/test/question/studentExampleList?testNo=${s.testNo}&testTitle=${s.testTitle}&studentNo=${loginStudent.studentNo}" class="testBtn">응시하기</a></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>