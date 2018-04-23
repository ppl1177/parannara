<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 파란나라 비디오튜브!</title>
<style type="text/css">
	#mainLogo{
		width: 330px;
		height: 100px;
		}
	#imgSize{
		width: 220px;
		height: 150px;
	}
	div{
		float:left;
		width:230px;
		-moz-column-count: 2;
		-moz-columns: 2;
		-webkit-columns: 2;
		columns: 1;
	}
</style>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jwplayer.js"/>"></script>
<script type="text/javascript">
	function musicWriteForm() {
		location.href = "musicWriteForm";
	}
	function toMain() {
		location.href = "returnHome";
	}
	function pagingFormSubmit(currentPage) {
		var form = document.getElementById("pagingForm");
		var page = document.getElementById("page");
		page.value = currentPage;
		
		form.submit();
	}

</script>

</head>
<body>

<img src="resources/img/BGM.jpg" id="mainLogo">
<br><input type="button" value="WRITE" onclick="musicWriteForm()"> <input type="button" value="MAIN" onclick="toMain()">
<br>
<hr>
<div id="col">
	<c:forEach var="list" items="${list}">
			<a href="oneMusicBoard?boardNum=${list.boardNum}">
			<img src="imgDownload?boardNum=${list.boardNum}"id="imgSize">
			</a><br><br>
			TITLE : <a href="oneMusicBoard?boardNum=${list.boardNum}">${list.title}</a><br>
			UPLOADER : ${list.id}<br>
			UPLOADDATE : ${list.inputDate}<br>
			PLAY ${list.hits} TIMES...<br><br>

	</c:forEach>
</div>
	<br>
	<div id="searchTestNav">
		<a href="javascript:pagingFormSubmit(${navi.currentPage-5})" style="color: red;">◁◁</a>
		<a href="javascript:pagingFormSubmit(${navi.currentPage-1})" style="color: red;">◀</a>
			<c:forEach begin="${navi.startPageGroup}" end="${navi.endPageGroup}" var="counter">
				<c:if test="${counter == navi.currentPage}">
					<b >
				</c:if>
					<a href="javascript:pagingFormSubmit(${counter})" style="color: red;">${counter}</a>
				<c:if test="${counter == navi.currentPage}">
					</b>
				</c:if>
			</c:forEach>
		<a href="javascript:pagingFormSubmit(${navi.currentPage+1})" style="color: red;">>▶</a>
		<a href="javascript:pagingFormSubmit(${navi.currentPage+5})" style="color: red;">▷▷</a>
	</div>
<br>
<form action="musicBoard" method="get" id="pagingForm">
	<input type="hidden" name="page" id="page">
	<p style="color: white;">SEARCH TITLE</p> 
	<input type="text" name="searchText" value="${searchText}">
	<input type="button" onclick="pagingFormSubmit(1)" value="SEARCH">
</form>
</body>
</html>