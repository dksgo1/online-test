<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#ckBtn').click(function(){
			$.ajax({
				url:'empIdck'
				, type:'get'
				, data : {empId:$('#id').val()}
				, success:function(model){ // model : 'YES' / 'NO'
					if(model=='YES') {
						// 사용가능한 아이디
						$('#empId').val($('#id').val());
					} else {
						// 사용중인 아이디
						alert($('#id').val()+'는 사용중인 아이디입니다');
					}
				}
			});
		});
	});	
</script>
</head>
<body>
	<h1>사원추가</h1>
	<div>
		<input type="text" id=id>
		<button type="button" id="ckBtn">중복검사</button>
	</div>
	<div>${errorMsg}</div>
	<form method="post" action="${pageContext.request.contextPath}/employee/addEmp">
		<table border="1">
			<tr>
          		<td>empId</td>
	          	<td><input type="text" id="empId" name="empId" readonly="readonly"></td>
       		</tr>
       		<tr>
       		 	<td>empPw</td>
          		<td><input type="password" id="empPw" name="empPw"></td>
			</tr>
       		<tr>
				<td>empName</td>
	          	<td><input type="text" id="empName" name="empName"></td>
			</tr>   
	    </table>
	    <button type="submit" id="addBtn">사원추가</button>
	</form>
</body>
</html>