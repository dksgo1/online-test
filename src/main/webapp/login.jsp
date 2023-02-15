<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- 모달 트리거 버튼 생성 -->
	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal1">
  		사원 로그인
	</button>

	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal2">
		선생님 로그인
	</button>

	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#loginModal3">
		학생로그인
	</button>

	<!-- 사원 로그인 폼 모달 -->
	<div class="modal fade" id="loginModal1" tabindex="-1" role="dialog" aria-labelledby="loginModal1Label" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="loginModal1Label">사원 로그인</h5>        	
					<form method="post" action="${pageContext.request.contextPath}/loginEmp">
						<table border="1">
							<tr>
				          		<td>empId</td>
					          	<td><input type="text" name="empId"></td>
				       		</tr>
				       		<tr>
				       		 	<td>empPw</td>
				          		<td><input type="password" name="empPw"></td>
							</tr>
					    </table>
					    <button type="submit">로그인</button>
					</form>
        		</div>	
			</div>
		</div>		
	</div>

	<div class="modal fade" id="loginModal2" tabindex="-1" role="dialog" aria-labelledby="loginModal1Label" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="loginModal1Label">선생님 로그인</h5>        		
					<form method="post" action="${pageContext.request.contextPath}/loginTeacher">
						<table border="1">
							<tr>
				          		<td>teacherId</td>
					          	<td><input type="text" name="teacherId"></td>
				       		</tr>
				       		<tr>
				       		 	<td>teacherPw</td>
				          		<td><input type="password" name="teacherPw"></td>
							</tr>
					    </table>
					    <button type="submit">로그인</button>
					</form>
        		</div>	
			</div>
		</div>		
	</div>
	
	<div class="modal fade" id="loginModal3" tabindex="-1" role="dialog" aria-labelledby="loginModal1Label" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="loginModal1Label">학생 로그인</h5>
					<form method="post" action="${pageContext.request.contextPath}/loginStudent">
						<table border="1">
							<tr>
				          		<td>studentId</td>
					          	<td><input type="text" name="studentId"></td>
				       		</tr>
				       		<tr>
				       		 	<td>studentPw</td>
				          		<td><input type="password" name="studentPw"></td>
							</tr>
					    </table>
					    <button type="submit">로그인</button>
					</form>
        		</div>	
			</div>
		</div>		
	</div>	
</body>
</html>