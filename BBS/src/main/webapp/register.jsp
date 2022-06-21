<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="common.Common" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style/style.css">
</head>
<body>
	<jsp:include page="header.jsp" flush="false"></jsp:include>
	<div class="wrap loginWrap">
		<h2>회원가입</h2>
		<form method="post" action="execute.jsp?process=register">
			<div class="formBox">
				<label>아이디</label>
				<input type="text" name="ifmbId" required/>
			</div>
			<div class="formBox">
				<label>비밀번호</label>			
				<input type="password" name="ifmbPassword" required/>
			</div>
			<div class="formBox">
				<label>비밀번호 확인</label>
				<input type="password" name="ifmbPasswordCheck" required/>
			</div>
			<div class="formBox">
				<label>성</label>
				<input type="text" name="ifmbLastName" required/>
			</div>
			<div class="formBox">
				<label>이름</label>
				<input type="text" name="ifmbFirstName" required/>
			</div>
			<div class="formBox">
				<label>닉네임</label>
				<input type="text" name="ifmbNickName" required/>
			</div>
			<div class="formBox">
				<label>성별</label>
				남성<input type="radio" name="ifmbGenderCd" value="1" required>
				여성<input type="radio" name="ifmbGenderCd" value="2" required>
			</div>
			<div class="formBox">
				<label>생년월일</label>
				<input type="date" name="ifmbDob" min="1900-01-01" max="<%=Common.getToday() %>"  required/>
			</div>
			<div class="formBox">
				<input type="submit" value="회원가입" />
			</div>
			
		</form>
	</div>
</body>
</html>
