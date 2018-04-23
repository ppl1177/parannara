<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 파란나라 음악게시판</title>
<style type="text/css">
	body{
		width: 500px;
		height: 400px;
		background-color: white;
		color: black;
		margin-left: auto;
		margin-right: auto;
		text-align: left;
	}
	td{
		width: 500px;
	}
	
</style>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.1.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jwplayer.js"/>"></script>

</head>
	<div id="playerDiv">Loading the player ...</div>

<script type="text/javascript">
	function deleteMusicBoard(boardNum) {
		if (confirm("정말로 삭제 하시겠습니까?")) {
			location.href="deleteMusic?boardNum="+boardNum;
		}
		return false;
	}
	function toMusicList(){
		location.href="musicBoard";
	}
	function toUpdateMusicBoard(boardNum){
		location.href="updateMusicBoard?boardNum="+boardNum;
	}
	
	$(function(){
  	var vplayer = jwplayer("playerDiv").setup({
    	'width': '400',
    	'height': '360',
   		'autostart':'viewable',
    	'volume': '100',
    	'file': 'loadVideoFile',
    	'controlbar': 'bottom',
    	'provider': 'video'
  		});
	});
	
</script>
<body>

<H3>${title}</H3> 
<table >	
	<tr>
		<th>
			HITS
		</th>
		<td>
			PLAY ${hits} TIMES
		</td>
	</tr>
	<tr>
		<th>
			UPLOADER
		</th>
		<td>
			${id}
		</td>
	</tr>
	<tr>
		<th>
			DATE
		</th>
		<td>
			${inputDate}
		</td>
	</tr>
	
	
	<tr>
		<th>
			CONTENT
		</th>
		<td >
			${content}
		</td>
	</tr>
	<tr>
		<th>
			DOWNLOAD
		</th>
		<td>
			<a href="mDownload?boardNum=${boardNum}">
				${originalFile}
			</a>
		</td>
	</tr>

</table>
<c:if test="${sessionScope.sessionId == id }">
	<input type="button" value="DELETE" onclick="deleteMusicBoard(${boardNum})">
	<input type="button" value="MODIFY" onclick="toUpdateMusicBoard(${boardNum})">
</c:if>
<input type="button" value="TO LIST" onclick="toMusicList()">
<br>



</body>
</html>