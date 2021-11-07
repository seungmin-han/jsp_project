<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>jsp 게시판 웹 사이트</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<nav>
		<ul>
			<li><a href="main.jsp">메인</a></li>
			<li><a href="bbs.jsp">게시판</a></li>
			<li><a href="login.jsp">로그인</a></li>
			<li><a href="register.jsp">회원가입</a></li>
		</ul>
	</nav>
	<div>
		<h3>로그인</h3>
		<form method="post" action="loginAction.jsp">
			아이디<input type="text" name="userId"><br>
			비밀번호<input type="password" name="userPasswd"><br>
			<input type="submit" value="로그인">
		</form>
	</div>
	
</body>
</html>