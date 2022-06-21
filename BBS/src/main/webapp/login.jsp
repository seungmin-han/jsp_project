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
	<jsp:include page="header.jsp" flush="false"></jsp:include>
	<div class="wrap">
		<h2>로그인</h2>
		<div class="loginWrap">
			<form method="post" action="execute.jsp?process=login">
				<div class="formBox">
					<label id="ifmbId">아이디</label>
					<input type="text" name="ifmbId" />
				</div>
				<div class="formBox">
					<label id="ifmbPassword">비밀번호</label>
					<input type="password" name="ifmbPassword" />
				</div>
				<div class="formBox">
					<input type="submit" value="로그인" />
					<a href="register.jsp">회원가입</a>
				</div>
			</form>
			
		</div>
	</div>
</body>
</html>