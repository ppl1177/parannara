<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 파란나라 글작성!</title>
<style type="text/css">
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
</style>
<script type="text/javascript">
	
	function formCheck() {
		var t = document.getElementById("title");
		var c = document.getElementById("content");
		var f = document.getElementById("fileName");
		var pf = document.getElementById("picFileName");
		
		if (t.value == "") {
			alert("제목이 공백입니다!");
			return false;
		}
		if (c.value == "") {
			alert("내용이 공백입니다!");
			return false;
		}
		if (f.value == "") {
			alert("동영상 파일을 반드시 첨부해 주세요!")
			return false;
		}
		if (pf.value == "") {
			alert("동영상 커버 파일을 반드시 첨부해 주세요!")
			return false;
		}
		return true;
	}
	
	function cancle() {
		location.href = "musicBoard";
	}
	
</script>
</head>
<body>
	
	<form action="mBoardWrite" method="post" enctype="multipart/form-data" onsubmit="return formCheck();">
	
	<h2>VIDEO UPLOAD</h2>
	
		<p>제목</p>
		<p><input type="text" id="title" name="title" value="제목을 입력해 주세요" onfocus="this.value=''" ></p><br>
		<textarea rows="20" cols="50" id="content" name="content" onfocus="this.value=''">내용을 입력해 주세요</textarea>
		<p>동영상 파일 첨부</p> 
		<input type="file" id="fileName" name="upload" accept="video/*">
		<p>커버 사진 파일 첨부</p>
		<input type="file" id="picFileName" name="uploadPic" accept="image/*">
	
	<br>
	
	<input type="hidden" name="id" id="id" value="${sessionScope.sessionId}"><br>
	<input type="button" value="취소" onclick="cancle()">
	<input type="submit" value="저장">
	
	</form>
	
	
</body>
</html>