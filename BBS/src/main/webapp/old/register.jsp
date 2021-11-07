<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>jsp 게시판 웹 사이트</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
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
		<h3>회원가입</h3>
		<form method="post" action="registerAction.jsp">
			아이디<input type="text" name="userId"><br>
			비밀번호<input type="password" name="userPasswd"><br>
			이름<input type="text" name="userName"><br>
			성별 <br> 남성<input type="radio" name="userGender" value="1" required>
			여성<input type="radio" name="userGender" value="2" required><br>
			<input type="submit" value="회원가입">
		</form>
	</div>
	
</body>
</html>