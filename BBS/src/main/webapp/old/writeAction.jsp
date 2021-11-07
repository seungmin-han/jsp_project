<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="post.PostDAO" %>
<%@ page import="java.io.PrintWriter" %>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="post" class="post.Post" scope="page"/>
<jsp:setProperty name="post" property="postTitle"/>
<jsp:setProperty name="post" property="userId"/>
<jsp:setProperty name="post" property="postContent"/>
<!DOCTYPE html>
<html>
<head>
<title>jsp 게시판 웹 사이트</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
</head>
<body>
	<%
	PrintWriter script = response.getWriter();
	String userId = null;
		
	if(session.getAttribute("userId") != null) {
		userId = (String) session.getAttribute("userId");
	} else {
		
		script.println("<script>");
		script.println("alert('로그인 후 이용 가능합니다.')");
		script.println("history.back()");
		script.println("</script>");
	}
			
			
		
	PostDAO postDAO = new post.PostDAO(); 
	int result = postDAO.write(post);
			
	if(result == -1) {
		script.println("<script>");
		script.println("alert('DB 오류.')");
		script.println("history.back()");
		script.println("</script>");
	} else {
		script.println("<script>");
		script.println("location.href='main.jsp'");
		script.println("</script>");
	}
	%>
	
</body>
</html>