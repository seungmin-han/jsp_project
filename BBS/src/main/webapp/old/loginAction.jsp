<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.UserDAO" %>
<%@ page import="java.io.PrintWriter" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="user" class="user.User" scope="page"/>
<jsp:setProperty name="user" property="userId"/>
<jsp:setProperty name="user" property="userPasswd"/>
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
			
		UserDAO userDAO = new UserDAO(); 
		int result = userDAO.login(user.getUserId(),user.getUserPasswd());
		PrintWriter script = response.getWriter();
		
		if(result == 1) {
			session.setAttribute("userId", user.getUserId());
			script.println("<script>");
			script.println("location.href='main.jsp'");
			script.println("</script>");
		} else if (result == 0) {
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		} else if (result == -1) {
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디.')");
			script.println("history.back()");
			script.println("</script>");
		} else if (result == -2) {
			script.println("<script>");
			script.println("alert('DB 오류.')");
			script.println("history.back()");
			script.println("</script>");
		}
	%>
	
</body>
</html>