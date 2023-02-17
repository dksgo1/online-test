<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title></title>
 	<style>
   		body {
     		font-family: Arial, sans-serif;
     		font-size: 14px;
     		color: #333;
     		background-color: #f2f2f2;
     		padding: 20px;
   		}

   		h1 {
    		text-align: center;
    		margin-bottom: 20px;
   		}

   		table {
     		border-collapse: collapse;
     		margin: 0 auto;
     		width: 100%;
     		max-width: 800px;
     		background-color: #fff;
     		box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
   		}

   		th,
   		td {
   			padding: 10px;
     		text-align: left;
   		}

   		th {
     		background-color: #f2f2f2;
   		}

   		tr:nth-child(even) {
     		background-color: #f2f2f2;
   		}

   		tr:hover {
     		background-color: #ddd;
   		}

   		td input[type="radio"] {
     		margin-right: 10px;
   		}
 	</style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
	<script>
	$(document).ready(function() {
		let question = ${list.size()}
		let answer = document.querySelectorAll('.answer');
		
		$("#addPaperBtn").on("click", function(){
			for(let i = 0; i<question; i++){
				let answerNo = $("input[name=answer" + (i+1) + "]:checked").val();
				$(answer[i]).val(answerNo);
			}
			
			$("#addPaperForm").submit();
		});			
	});
	</script>
</head>
<body>
	<h1>${testTitle}</h1>
	<form id="addPaperForm" action="${pageContext.request.contextPath}/student/test/paper/addPaper" method="post">
		<table border="1">	
			<c:forEach var="q" items="${list}" varStatus="a">
				<c:set var="questionNo" value="${q.questionNo}"></c:set>
				<input type="hidden" name="studentNo" value="${studentNo}">
				<input type="hidden" name="questionNo" value="${questionNo}">
				<input type="hidden" class="answer" name="answer" value="">			
				<tr>
					<th>${q.questionIdx}번문제</th>
					<th>${q.questionTitle}</th>
				</tr>		
			
				<c:forEach var="e" items="${list2}">	
					<c:if test="${q.questionNo == e.questionNo}">
						<tr>
							<td>${e.exampleIdx}</td>
							<td>
								<input type="radio" id="answer${a.count}" name="answer${a.count}" value="${e.exampleIdx}">${e.exampleTitle}		
							</td>	
						</tr>	
					</c:if>	
				</c:forEach>
			</c:forEach>		
		</table>
		<button type="submit" id="addPaperBtn">답안 제출</button>
	</form>	
</body>
</html>