<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	table {
  		margin: 50px auto;
 		border-collapse: collapse;
 		border: 1px solid black;
	}
	
	th, td {
 		padding: 10px;
 		text-align: center;
 		border: 1px solid black;
	}
	
	th {
		background-color: #eee;
	}
	
	tr:nth-child(even) {
  		background-color: #f2f2f2;
	}
	
	span {
  		margin-top: 50px;
  		font-size: 20px;
  		font-weight: bold;
	}
	
	div {
 		margin-top: 10px;
 		font-size: 16px;
	}
</style>
</head>
<body>
	<h1>답안지</h1>
	<table border="1">
		<c:forEach var="q" items="${list}">
			<tr>
				<th>${q.questionIdx}</th>
				<th>${q.questionTitle}</th>	
				<th>정답여부</th>
			</tr>
			<c:forEach var="p" items="${list2}">
				<c:if test="${q.questionNo == p.questionNo3}">
					<tr>
						<td>${p.exampleIdx}</td>
						<td>${p.exampleTitle}</td>
						<td>${p.exampleOx}</td>
					</tr>	
				</c:if>
			</c:forEach>
		</c:forEach>
	</table>
	<span>내가 선택한 답</span>
	<c:forEach var="a" items="${list3}">
		<div>
			${a.questionIdx}번문제 ${a.answer} 
		</div>
	</c:forEach>
	<div>
		<h2>내점수 :${score} 점</h2>
	</div>
</body>
</html>