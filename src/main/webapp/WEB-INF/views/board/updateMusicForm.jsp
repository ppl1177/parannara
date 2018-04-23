<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 파란나라 글수정</title>
<style type="text/css">
		body{
 			 color: white;
 	 		 text-align: center;
			}
		table{
			margin-left: auto;
			margin-right: auto;
			border-bottom-width: 3px;
			border-color: white;
		}
		th{
			width: 150px;
		}
		#title{
			width: 340px;
		}
		html 
		{ 
		background: url(resources/img/main2.jpg) no-repeat center center fixed; 
		-webkit-background-size: cover; 
		-moz-background-size: cover; 
		-o-background-size: cover; 
		background-size: cover; 
		}
</style>
<script type="text/javascript">
	
	function formCheck() {
		var t = document.getElementById("title");
		var c = document.getElementById("content");
	
		if (t.value == "") {
			alert("제목이 공백입니다!");
			return false;
		}
		if (c.value == "") {
			alert("내용이 공백입니다!");
			return false;
		}
		return true;
	}
	
	function cancle() {
		location.href = "musicBoard";
	}
	function save(){
		location.href = "updateMusicBoard";
	}
</script>
</head>
<body>

	<form action="modifyMusic" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
	
	<h1>BGM STORAGE</h1>
		<p>TITLE</p>
		<p><input type="text" id="title" name="title" value="${title}"></p><br>
		<textarea rows="20" cols="50" id="content" name="content">${content}</textarea>
		<br>
		ATTACHEMENT VIDEO
					<br><c:if test="${originalFile == null}">
					<h3>The file does not exist.</h3></c:if>
				<c:if test="${originalFile != null}">
				<h3>${originalFile}</h3></c:if>
				<br>
		ATTACHEMENT IMAGE
					<br><c:if test="${screenShot == null}">
					<h3>The file does not exist.</h3></c:if>
				<c:if test="${screenShot != null}">
				<h3>${screenShot}</h3></c:if>

	<br>
	
	<input type="hidden" name="id" id="id" value="${sessionScope.sessionId}"><br>
	<input type="hidden" name="boardNum" id="boardNum" value="${boardNum}"><br>
	<input type="button" value="취소" onclick="cancle()">
	<input type="submit" value="저장" onclick="save()">
	
	</form>
	
	
</body>
</html>