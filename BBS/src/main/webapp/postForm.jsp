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
	<div class="wrap postWrap">
		<form action='execute.jsp?process=post' method='post' >
			<div class="postTextWrap">
				<div class="formBox">
					<label>작성자</label><input type="text" name="ifptWirter" readOnly value='<%=session.getAttribute("ifmbId")%>'>
				</div>
				<div class="formBox">
					<label>제목</label><input type="text" name="ifptTitle" >
				</div>
				<div class="formBox"> 
					<label>지역 설정</label> 
					<select id="ifptSido" name="ifrgSido">
						<option value="">시/도</option>
					</select>
					<select id="ifptSigungu" name="ifrgSigungu">
						<option value="">시/군/구</option>
					</select>
				</div>
				<div class="formBox radioBox">
					<label>공개여부</label>
					공개 <input type="radio" name="ifptPublicNy" value="1" checked>
					비공개 <input type="radio" name="ifptPublicNy" value="0">
				</div>
			</div>
			<jsp:include page="map.jsp"></jsp:include><br><br><br>
			<textarea name="ifptContent" id="ifptContent" rows="10" cols="100" ></textarea>
			<div class="btnBox">
				<button type="submit">글작성</button>
				<button type="button" onclick="history.go(-1)">돌아가기</button>
				<div class="clear"></div>
			</div>
			
		</form>
		<br><br><br>
	</div>
	
	<script>
		createSidoOption();
	
		CKEDITOR.replace( 
            'ifptContent'
            ,{ 
                width : "100%"
                ,height : "500px"
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
			let publicNy = post['ifptPublicNy'];
			form.setAttribute("action","execute.jsp?process=update&ifptSeq="+post['ifptSeq']);
			$("input[name='ifptTitle']").val(post['ifptTitle']);
			CKEDITOR.instances.ifptContent.setData(post['ifptContent']);
			$("input[value="+publicNy+"]").prop("checked", true);
			fill(post['ifrgSido'],post['ifrgSigungu'],1);
			
		}
		
		
	</script>
</body>
</html>