<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 파란나라 자유게시판</title>
<style type="text/css">
	body{
		color: white;
		text-align: center;
	}
	#contentD{
		width: 500px;
		height: 400px;
		background-color: white;
		color: black;
		margin-left: auto;
		margin-right: auto;
		text-align: left;
	}
	hr{
		color: white;
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
 	function toFreeBoard(){
		location.href="freeBoard";
	}
 	function updateDeleteInfo(boardNum){
 		if (confirm("정말로 삭제 하시겠습니까?")) {
 			location.href="deleteFreeBoard?boardNum="+boardNum;
 		}
 	}
 	function modify(boardNum) {
		location.href="freeBoardUpdate?boardNum="+boardNum;
	}
</script>

</head>
<body>

<div id="titleD">
	<h1>FREE BOARD</h1><br>
	
	<p><h4>TITLE  ${title}<br>
	ID ${id} | HITS ${hits}</h4></p>
</div>
<div id="contentD">
	${content}<br>
</div>
ATTACHEMENT<br> 
			<a href="download?boardNum=${boardNum}">
			<c:if test="${originalFile == null}"></a><h3>The file does not exist.</h3></c:if>
				<h3>${originalFile}</h3></a>
<br>

<c:if test="${sessionScope.sessionId == id}">
	<input type="button" onclick="updateDeleteInfo(${boardNum})" value="DELETE">
	<input type="button" onclick="modify(${boardNum})" value="MODIFY">
</c:if>
<input type="button" onclick="toFreeBoard()" value="TO LIST">

<br>



</body>
</html>