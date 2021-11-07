<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userId"/>
<jsp:setProperty name="user" property="userPasswd"/>
<jsp:setProperty name="user" property="userName"/>
<jsp:setProperty name="user" property="userGender"/>
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
		
			if(userId != null) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 로그인이 되어있습니다.')");
		script.println("location.href='main.jsp'");
		script.println("</script>");
			}
		
			user.UserDAO userDAO = new user.UserDAO(); 
			int result = userDAO.register(user);
			PrintWriter script = response.getWriter();
			if(result == -1) {
		script.println("<script>");
		script.println("alert('이미 사용 중인 아이디.')");
		script.println("history.back()");
		script.println("</script>");
			} else {
		script.println("<script>");
		script.println("location.href='login.jsp'");
		script.println("</script>");
			}
	%>
	
</body>
</html>