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
	<jsp:include page="header.jsp"></jsp:include>
	
	<div class="wrap">
		<div class="fWrap">
			<h2>팀 생성</h2>
			<form method="post" action="execute.jsp?process=createTeam">
				<div class="formBox">
					<label>팀 이름</label>
					<input type="text" name="iftmName" required/>
					<div class="clear"></div>
				</div>
				<div class="radioBox">
					<label>팀 유형</label>	
					<div>
					개인 <input type="radio" name="iftmTypeCd" value="1" required checked>
					커플 <input type="radio" name="iftmTypeCd" value="2" required>
					단체 <input type="radio" name="iftmTypeCd" value="3" required>
					</div>
					<div class="clear"></div>
				</div>
				<div class="formBox">
					<label>팀 문구(또는 기념일)</label>
					<input type="text" name="iftmAnniversary" />
					<div class="clear"></div>
				</div>
				<div class="formBox">
					<label>시작일</label>
					<input type="date" name="iftmStartDay" value="<%=Common.getToday()%>" min="1900-01-01" max="<%=Common.getToday()%>" required/>
					<div class="clear"></div>
				</div>
				<input class="btn" type="submit" value="팀 생성" />
			</form>
		</div>
		
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

