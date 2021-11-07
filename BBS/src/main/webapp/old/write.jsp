<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>jsp 게시판 웹 사이트</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
</head>
<body>
	<%
		String userId = null;
		if(session.getAttribute("userId") != null) {
			userId = (String) session.getAttribute("userId");
		}
		
	%>
	<nav>
		<ul>
			<li><a href="main.jsp">메인</a></li>
			<li><a href="bbs.jsp">게시판</a></li>
			<% if(userId == null) { %>			
			<li><a href="login.jsp">로그인</a></li>
			<li><a href="register.jsp">회원가입</a></li>
			<% } else { %>
			<li><a href="#"><%= userId %> 님</a></li>
			<li><a href="logoutAction.jsp">로그아웃</a></li>
			<% } %>
		</ul>
	</nav>
	<div>
		<h3>글쓰기</h3>
		<form method="post" action="writeAction.jsp">
			글 제목 :<input type="text" name="postTitle"><br>
			작성자 :<input type="text" name="userId" value="<%=userId %>" readonly><br><br>
			글 내용 <textarea name="postContent" rows="6" ></textarea>
			<input type="submit" value="작성하기">
		</form>
	</div>
	
</body>
</html>