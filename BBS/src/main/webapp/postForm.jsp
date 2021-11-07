<%@ page import="infra.PostDAO" %>
<%@ page import="infra.Post" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="externalLib/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="./script/map.js"></script>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
  <script src="./script/script.js"></script>
<link rel="stylesheet" href="style/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		if(session.getAttribute("ifmbId") == null) {
			out.print("<script>alert('로그인 후 이용 가능합니다.'); history.back(); </script>");
			return;
		}	
			
	%>
	<form action='execute.jsp?process=post' method='post' >
		<jsp:include page="map.jsp"></jsp:include>
		작성자: <input type="text" name="ifptWirter" readOnly value='<%=session.getAttribute("ifmbId")%>'><br>
		제목: <input type="text" name="ifptTitle" ><br> 
		지역 설정: 
		<select id="ifptSido" name="ifrgSido">
			<option value="">시/도</option>
		</select>
		<select id="ifptSigungu" name="ifrgSigungu">
			<option value="">시/군/구</option>
		</select>
		<select name="ifrgEupmyeondong">
			<option value="">읍/면/동</option>
		</select>
		<br>
		공개여부: <br>
		<input type="radio" name="ifptPublicNy" value="1" selected>공개
		<input type="radio" name="ifptPublicNy" value="0">비공개
		<br>
		<textarea name="ifptContent" id="ifptContent" rows="10" cols="100" ></textarea>
		<input type="submit" value="글작성">
	</form>
	
	<script>
		createSidoOption();
	
		CKEDITOR.replace( 
            'ifptContent'
            ,{ 
                width : "100%"
                ,height : "auto"
                ,enterMode : 2
                , extraPlugins: 'image2,uploadimage'
                , filebrowserImageUploadUrl: 'execute.jsp?process=upload'
                , uploadUrl: "execute.jsp?process=upload"
               	//,extraPlugins: 'easyimage'
            }
   			
        );
		let process = "<%=request.getParameter("process")%>";
		let post;
		if(process == "update") {
			let form = document.querySelector("form");
			post = JSON.parse(getOne(<%=request.getParameter("ifptSeq")%>));
			form.setAttribute("action","execute.jsp?process=upadte&ifptSeq="+post['ifptSeq']);
			CKEDITOR.instances.ifptContent.setData(post['ifptContent']);
			fill(post['ifrgSido'],post['ifrgSigungu'],1);
			
		}
		
		
	</script>
</body>
</html>