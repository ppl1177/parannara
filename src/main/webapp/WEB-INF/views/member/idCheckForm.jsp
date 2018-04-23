<!-- 파란나라 아이디 중복검사 폼 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ParanNara | 파란나라 아이디 중복검사</title>
<style type="text/css">
	body{
		background-color: DodgerBlue;
	}
	#title{
		color: white;
	}
</style>
<script type="text/javascript">
	var id = document.getElementById('memberId');
	
	function formCheck() {
		if (id.value == '') {
			alert('아이디를 입력해 주세요!');
			return false;
		}
		return true;
	}
	function useId(memberId) {
		opener.document.getElementById("memberId").value = memberId;
		this.close();
	}
</script>
</head>
<body>
<h2 id="title"> ID 중복 확인  </h2>
<br><br>
<form action="searchId" method="post" onsubmit="return formCheck();">
	<input type="text" name="memberId" id="memberId" value="${memberId}">
	<input type="submit" value="아이디 중복 확인">
</form>
<hr>
<br>
	<c:if test="${search}">
		<c:if test="${member.memberId != null }">
			${member.memberId} 아이디를 사용할 수 없습니다<br>
				다른 아이디를 입력해 주세요!
		</c:if>
		<c:if test="${member.memberId == null }">
			해당 아이디를 사용할수 있습니다!<br>
			<input type="button" value="아이디 사용하기" onclick="useId('${memberId}')">	
		</c:if>
	</c:if>
		


</body>
</html>