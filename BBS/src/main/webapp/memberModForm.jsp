<%@page import="infra.MemberDAO"%>
<%@page import="infra.Member"%>
<%@page import="common.Common"%>
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
	<%
		Member member = new MemberDAO().getOne((String) session.getAttribute("ifmbId")); 
	%>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrap">
		<h2>회원 정보 수정</h2>
		<form action="execute.jsp" method="post" name="frm">
			<div class="formBox">
				<label>성</label>
				<input type="text" name="ifmbLastName" value="<%=member.getIfmbLastName() %>" required/>
			</div>
			<div class="formBox">
				<label>이름</label>
				<input type="text" name="ifmbFirstName" value="<%=member.getIfmbFirstName() %>" required/>
			</div>
			<div class="formBox">
				<label>닉네임</label>
				<input type="text" name="ifmbNickName" value="<%=member.getIfmbNickName() %>" required/>
			</div>
			<div class="formBox">
				<label>성별</label>
				남성<input type="radio" name="ifmbGenderCd" value="1" required>
				여성<input type="radio" name="ifmbGenderCd" value="2" required>
			</div>
			<div class="formBox">
				<label>생년월일</label>
				<input type="date" name="ifmbDob" min="1900-01-01" max="<%=Common.getToday() %>" value="<%=member.getIfmbDob() %>" required/>
			</div>
			<input type="hidden" name="process" value="updateMember">
			<input type="submit" value="정보 수정" />
		</form>
	</div>
	
	<script type="text/javascript">
		frm.ifmbGenderCd[<%=member.getIfmbGenderCd()-1 %>].checked = true;
	</script>
</body>
</html>