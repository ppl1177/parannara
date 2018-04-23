<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 회원정보 변경</title>
<style type="text/css">
	body{
	 color : white;
 	 text-align: center;
	}
	input[type=text],input[type=password], select{
    width: 200px;
    padding: 8px 13px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
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

	function formCheck(){
		var password1 = document.getElementById("password");
		var password2 = document.getElementById("password2");
		
		if(password1.value == ""){
			alert("비밀번호를 입력해 주세요");
			password1.focus();
			return false;
		}else if(password1.value != password2.value){
			alert("동일한 비밀번호를 입력해 주세요");
			password2.focus();
			return false;
		}
		
		return true;
	}
	function returnHome(){
		location.href = "returnHome";
	}
</script>

</head>
<body>

<h1>CHANGE INFO</h1>

<form action="update" method="post" onsubmit="return formCheck();">
			<div id="divId">
				<p>ID</p>${memberId}<br>
				<input type="hidden" name="memberId" value="${memberId}">
			</div>
			<div id="divPassword">
				<p>PASSWORD</p>
				<input type="password" name="password" id="password" ><br>
				<p>CONFIRM PASSWORD</p>
				<input type="password" id="password2"><br>
			</div>
			<div id="divName">
				<p>NAME</p>
				<input type="text" name="name" id="name" value="${name}"><br>
			</div>
			<div id="divEmail">
				<p>EMAIL</p>
				<input type="text" name="email" id="email" value="${email}"><br>
			</div>
			<div id="divPhone">
				<p>PHONE NUMBER</p>
				<input type="text" name="phoneNum" value="${phoneNum}"><br>
			</div>
			<div id="divAddress">
				<p>ADDRESS</p>
				<input type="text" name="address" value="${address}"><br>
			</div>
	<input type="submit" value="수정"><br><br>
	<input type="reset" value="다시쓰기"><br><br>
	<input type="button" value="메인메뉴로 돌아가기" onclick="returnHome()">
</form>













</body>
</html>