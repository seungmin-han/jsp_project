<%@page import="common.Common"%>
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
  <script type="text/javascript" src="externalLib/ckeditor/ckeditor.js"></script>
  <script src="./script/script.js"></script>
  <script src="./script/map.js"></script>
</head>
<body>
	<%
		boolean isSet = false;
		String ifptSeq = request.getParameter("ifptSeq");
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie c : cookies) {	
				if(c.getName().equals(ifptSeq)) {
					isSet = true;		
				}
			}
		}
		if(isSet == false) {
			Cookie cookie = new Cookie(ifptSeq, "read");
			cookie.setMaxAge(1*24*60*60);
			response.addCookie(cookie);
			
			
			PostDAO postDAO = new PostDAO();
			int result = postDAO.updateViewer(Integer.parseInt(ifptSeq));
			
			
			if(result != 1) {
				Common.alert("조회수 업데이트 중 오류가 발생했습니다.", response);
			} 

		}
	%>


	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrap postWrap">
	
		<div class="postTextWrap">
			<p id="title">제목:</p>
			<p id="writer">작성자:</p>
			<p id="datetime">작성시간:</p>
			<p id="viewer">조회수: </p>
		</div>
		<jsp:include page="map.jsp"></jsp:include>
		<textarea id="content" name="content" ></textarea>
		<a href="index.jsp">돌아가기</a>
	</div>
	<br><br><br><br>
	<script>
		let ifptSeq = <%=request.getParameter("ifptSeq")%>;
		let data = JSON.parse(getOne(ifptSeq));
		let updateBtn = "<a href=\"postForm.jsp?process=update&ifptSeq="+ifptSeq+"\">수정하기</a>";
		let deleteBtn = "<a href=\"execute.jsp?process=deleteByUpdate&ifptSeq="+ifptSeq+"\">삭제하기</a>";
		console.log(data);
		if(data) {
			$("#title").text("제목: ["+data['ifrgSido']+"]"+data['ifptTitle']);
			$("#writer").text("작성자: "+data['ifmbId']);
			$("#datetime").text("작성시간: "+data['ifptRegDatetime']);
			$("#viewer").text("조회수: "+data['ifptViewer']);
			let editor = CKEDITOR.replace( 
		            'content'
		            ,{ 
		                width : "100%"
		                , height : "500px"
		                , enterMode : 2
		                , readOnly: true
		            }
		        );
			
			editor.setData(data['ifptContent']);
			if(data['ifmbId']=="<%=session.getAttribute("ifmbId")%>") {
				$(".wrap").append(updateBtn);
				$(".wrap").append(deleteBtn);
			}

			fill(data['ifrgSido'],data['ifrgSigungu']);
		}
		
	
		
	</script>
	
</body>
</html>