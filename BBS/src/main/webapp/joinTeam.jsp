<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrap fWrap joinTeamWrap">
		<h2>초대코드 입력</h2>
		<form action="execute.jsp?process=joinTeam" method="post">
			<input type="text" name="iftmInviteCd" placeholder="초대 코드를 입력해주세요">
			<input type="submit" value="입력하기">
	
		</form>
	</div>
</body>
</html>