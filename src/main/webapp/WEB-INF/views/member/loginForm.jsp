<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 파란나라 로그인</title>
<style type="text/css">
	body{
 	 color: white;
 	 text-align: center;
	}

	#title{
		color: white;
	}
	html { 
			background: url(resources/img/main2.jpg) no-repeat center center fixed; 
			-webkit-background-size: cover; 
			-moz-background-size: cover; 
			-o-background-size: cover; 
			background-size: cover; 
		}

</style>
<script type="text/javascript">
function formCheck() {
	var memberId = document.getElementById("memberId");
	var password = document.getElementById("password");
	
	if (memberId.value == '' || password.value == '') {
		alert('ID와 비밀번호를 입력하세요.');
		return false;
	}
	return true;
}
</script>
</head>
<body>
<h1>LOGIN</h1><br><br>
<form action="loginMember" method="post" onsubmit="return formCheck();">
	ID<br>
	<input type="text" name="memberId" id="memberId"><br>
	PW<br>
	<input type="password" name="password" id="password"><br>
	<input type="submit" value="로그인">
	<div class="errorMsg">${errorMsg}</div>
</form>
</body>
</html>