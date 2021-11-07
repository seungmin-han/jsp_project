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
		<table border=1 align=center width=90%>
			<thead>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>글 제목</td>
					<td>작성자</td>
					<td>0000-00-00</td>
				</tr>
			</tbody>
		</table>
		
		<a href="write.jsp">글쓰기</a>
	</div>
</body>
</html>