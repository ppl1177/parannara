<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>ParanNara | 파란나라에 오신걸 환영합니다!</title>
<style type="text/css">
#title {
  color : white;
}
html 
	{ 
		background: url(resources/img/main2.jpg) no-repeat center center fixed; 
		-webkit-background-size: cover; 
		-moz-background-size: cover; 
		-o-background-size: cover; 
		background-size: cover; 
	}
body{
  color: white;
  text-align: center;
}
h1{font-size:24px; font-weight:normal; margin:0.4em 0;}

.container { width: 100%; margin: 0 auto; }
.container .row { float: left; clear: both; width: 100%; }
.container .col { float: left; margin: 0 0 1.2em; padding-right: 1.2em; padding-left: 1.2em; }
.container .col.one, .container .col.two, .container .col.three, .container .col.four, .container .col.five, .container .col.six, .container .col.seven, .container .col.eight, .container .col.nine, .container .col.ten, .container .col.eleven, .container .col.twelve { width: 100%; }

@media screen and (min-width: 767px) {
  .container{width: 100%; max-width: 1080px; margin: 0 auto;}
  .container .row{width:100%; float:left; clear:both;}
  .container .col{float: left; margin: 0 0 1em; padding-right: .5em; padding-left: .5em;}
  .container .col.one { width: 8.33%; }
  .container .col.two { width: 16.66%; }
  .container .col.three { width: 24.99%; }
  .container .col.four { width: 50%; }
  .container .col.five { width: 41.65%; }
  .container .col.six { width: 49.98%; }
  .container .col.seven { width: 58.31%; }
  .container .col.eight { width: 66.64%; }
  .container .col.nine { width: 74.97%; }
  .container .col.ten { width: 83.3%; }
  .container .col.eleven { width: 91.65%; }
  .container .col.tweleve { width: 100%; }
}

/*All the button styles*/
* {-moz-box-sizing: border-box; -webkit-box-sizing: border-box; box-sizing: border-box;}
a{text-decoration:none;}

.btn {font-size: 18px; white-space:nowrap; width:100%; padding:.8em 1.5em; line-height:18px; display: inline-block;zoom: 1; color: #fff; text-align: center; position:relative; -webkit-transition: border .25s linear, color .25s linear, background-color .25s linear; transition: border .25s linear, color .25s linear, background-color .25s linear;}

/*CONCRETE BUTTON STYLES*/      
.btn.btn-concrete{background-color: #7e8c8d; border-color: #7e8c8d; -webkit-box-shadow: 0 3px 0 #4e5b5c; box-shadow: 0 3px 0 #4e5b5c;}
.btn.btn-concrete:hover{background-color:#6a7879;}
.btn.btn-concrete:active{top: 3px; outline: none; -webkit-box-shadow: none; box-shadow: none;}
	
</style>
<script type="text/javascript">
	function start() {
		location.href = "login";
	}
	function join() {
		location.href = "join";
	}
	function logout() {
		location.href = "logout";
	}
	function freeBoard() {
		location.href = "freeBoard";
	}
	function musicBoard() {
		location.href = "musicBoard";
	}
	function updateInfo() {
		location.href = "updateForm";
	}
</script>
</head>
<body>

<h1 id="title">
	PARAN NARA.com
</h1>
<br><br>	
	<div class="col three">
                      
    </div>

<c:choose >
	<c:when test="${sessionScope.sessionId == null }">
			<a href="#" class="btn btn-concrete" onclick="start()">START</a><br><br>
			<a href="#" class="btn btn-concrete" onclick="join()">JOIN</a> 
	</c:when>
	<c:otherwise>
	WELCOME TO! <br>
	${sessionScope.sessionId }(${sessionScope.sessionName})<br><br>
		<a href="#" class="btn btn-concrete" onclick="logout()">LOGOUT</a><br><br>
		<a href="#" class="btn btn-concrete" onclick="updateInfo()">CHANGE INFO</a><br><br>
		<a href="#" class="btn btn-concrete" onclick="freeBoard()">FREE BOARD</a><br><br>
		<a href="#" class="btn btn-concrete" onclick="musicBoard()">MUSIC BOARD</a><br><br>
	</c:otherwise>
</c:choose>
	
</body>
</html>
