<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 파란나라 자유게시판!</title>

<style type="text/css">
	body{
		text-align: center;
	}
	#title{
		text-align: center;
		color: white;
	}
	#divTable{
		color: white;
		text-align: center;
	}
	#divTable{
		color: white;
		text-align: center;
	}
	table{
		margin-left: auto;
		margin-right: auto;
		border-bottom-width: 3px;
		border-color: white;
	}
	#titleTh{
		width:400px; 
	}
	#dateTh{
		width:100px;
	}
	#listTitle{
		text-align: left;
	}
	#divBtn,#searchTestNav{
		text-align: center;
	}
	a{
		color: white;
	}
	a:link { color: red; text-decoration: none;}
 	a:visited { color: black; text-decoration: none;}
	a:hover { color: blue; text-decoration: underline;}
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
	function writeForm() {
		location.href = "writeForm";
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

<div id="title">
	<h1>FREE BOARD</h1>
</div>

<div id="divBtn">
	<br><input type="button" value="WRITE" onclick="writeForm()"> <input type="button" value="MAIN PAGE" onclick="toMain()">
</div>

<br>

<div id="divTable">
<table border="1">
	<tr>
		<th>NUM</th>
		<th id="titleTh">TITLE</th>
		<th>ID</th>
		<th id="dateTh">DATE</th>
		<th>HITS</th>
	</tr>
	<c:forEach var="list" items="${list}" >
		<tr>
			<td>${list.boardNum}</td>
			<td id="listTitle"><a href="oneFreeBoard?boardNum=${list.boardNum}" style="color : white">
				${list.title }</a></td>
			<td>${list.id }</td>
			<td>${list.inputDate }</td>
			<td>${list.hits}</td>
		</tr>
	</c:forEach>
</table>
</div>

<br>
	<div id="searchTestNav">
		<a href="javascript:pagingFormSubmit(${navi.currentPage-5})" style="color: white;">◁◁</a>
		<a href="javascript:pagingFormSubmit(${navi.currentPage-1})" style="color: white;">◀</a>
			<c:forEach begin="${navi.startPageGroup}" end="${navi.endPageGroup}" var="counter">
				<c:if test="${counter == navi.currentPage}">
					<b >
				</c:if>
					<a href="javascript:pagingFormSubmit(${counter})" style="color: white;">${counter}</a>
				<c:if test="${counter == navi.currentPage}">
					</b>
				</c:if>
				
			</c:forEach>
		<a href="javascript:pagingFormSubmit(${navi.currentPage+1})" style="color: white;">>▶</a>
		<a href="javascript:pagingFormSubmit(${navi.currentPage+5})" style="color: white;">▷▷</a>
	</div>
<br>


<form action="freeBoard" method="get" id="pagingForm">
	<input type="hidden" name="page" id="page">
	<p style="color: white;">SEARCH TITLE</p> 
	<input type="text" name="searchText" value="${searchText}">
	<input type="button" onclick="pagingFormSubmit(1)" value="SEARCH">
</form>

</body>
</html>