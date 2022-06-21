<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<nav>
		<ul>
			<li><a href="index.jsp"><img src="" alt="logo" title="logo"></a></li>
			<li><a href="index.jsp">메인</a></li>
			<li><a href="team.jsp">팀</a></li>
			<li>
				<a href="community.jsp">커뮤니티</a>
				<ul id="communityMenu">
					<li><a href="community.jsp?c=notice">공지사항</a></li>
					<li><a href="community.jsp">게시판</a></li>
				</ul>
			</li>
			<div id="loginBox">
				<%  
					if(session.getAttribute("ifmbId") != null){
						%>
						<a href="memberModForm.jsp">정보수정</a>
						<a href="execute.jsp?process=logout">로그아웃</a>	
						<% 
					} else {
				%>
				<a href="login.jsp">로그인</a>
				<% } %>
			</div>
		</ul>
	</nav>
</header>


