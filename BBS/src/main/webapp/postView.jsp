<%@ page import="infra.PostDAO" %>
<%@ page import="infra.Post" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style/style.css">
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
  <script src="./script/script.js"></script>
  <script src="./script/map.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="map.jsp"></jsp:include>
	<p id="title">제목:</p>
	<p id="writer">작성자:</p>
	<p id="datetime">작성시간:</p>
	<p id="viewer">조회수: </p>
	<div id="content"></div>
	<script>
		let ifptSeq = <%=request.getParameter("ifptSeq")%>;
		let data = JSON.parse(getOne(ifptSeq));
		let updateBtn = "<a href=\"postForm.jsp?process=update&ifptSeq="+ifptSeq+"\">수정하기</a>";
		console.log(data);
		if(data) {
			$("#title").text("제목: ["+data['ifrgSido']+"]"+data['ifptTitle']);
			$("#title").text(`제목: [\${data['ifrgSido']}]\${data['ifptTitle']}`);
			$("#writer").text("작성자: "+data['ifmbId']);
			$("#datetime").text("작성시간: "+data['ifptRegDatetime']);
			$("#viewer").text("조회수: "+data['ifptViewer']);
			$("#content").html(data['ifptContent']);
			if(data['ifmbId']=="<%=session.getAttribute("ifmbId")%>") {
				$("body").append(updateBtn);
			}

			fill(data['ifrgSido'],data['ifrgSigungu']);
		}
		
	
		
	</script>
</body>
</html>