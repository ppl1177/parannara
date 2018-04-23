<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 파란나라 회원가입</title>
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
	function returnHome() {
		location.href = "returnHome";
	}
	function checkId() {
		window.open("idCheck","newWindow","top=200,left=400,height=300,width=400,resizable=no");
	}
	
	function formCheck() {
		
		var id = document.getElementById("memberId");
		var pw = document.getElementById("password");
		var pw2 = document.getElementById("password2");
		var name = document.getElementById("name");
		var email = document.getElementById("email");
		var phone = document.getElementById("phoneNum");
		
		if (id.value == "") {
			alert("아이디를 입력해 주세요");
			return false;
		}
		if (pw.value == "") {
			alert("비밀번호를 입력해 주세요");
			pw.focus();
			return false;
		}
		if (pw2.value == "") {
			alert("비밀번호 확인을 입력해 주세요");
			pw2.focus();
			return false;
		}
		if (pw.value != pw2.value) {
			alert("비밀번호를 확인해 주세요!");
			return false;
		}
		if (name.value == "") {
			alert("이름을 입력해 주세요");
			return false;
		}
		if (email.value == "") {
			alert("이메일을 입력해 주세요");
			return false;
		}
		if (phone.value == "") {
			alert("휴대전화 번호를 입력해 주세요");
			return false;
		}
		
		return true;
	}

</script>
</head>
<body>
	<h1 id="title">JOIN</h1>
<form action="joinMember" method="post" onsubmit="return formCheck()">
			<br><br>
			아이디<br>
			<input type="text" name="memberId" id="memberId" readonly="readonly" value="${memberId }"><br>
			<input type="button" value="아이디 중복 확인" onclick="checkId()" ><br>
			비밀번호 <br>
			<input type="password" name="password" id="password"><br>
			비밀번호 확인<br>
			<input type="password" id="password2"><br>
			성명<br>
			<input type="text" name="name" id="name"><br>
			이메일주소<br>
			<input type="text" name="email" id="email"><br>
			휴대전화 번호<br>
			<input type="text" name="phoneNum" id="phoneNum"><br>
			주소<br>
			<input type="text" name="address" id="address"><br>
	<br><br>
	<input type="submit" value="회원가입"><br><br>
	<input type="button" onclick="returnHome()" value="메뉴로 돌아가기">
</form>
</body>
</html>