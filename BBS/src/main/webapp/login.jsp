<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="false"></jsp:include>
	<form method="post" action="execute.jsp?process=login">
		<input type="text" name="ifmbId" />
		<input type="password" name="ifmbPassword" />
		<input type="submit" value="로그인" />
	</form>
	<a href="register.jsp">회원가입</a>
</body>
</html>