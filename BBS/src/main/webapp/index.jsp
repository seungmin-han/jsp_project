<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
<script src="./script/map.js"></script>  
<script src="./script/script.js"></script>
<link rel="stylesheet" href="./style/style.css">
</head>
<body>
	<%
		String ifmbId = (session.getAttribute("ifmbId")==null) ? "guest" : (String) session.getAttribute("ifmbId");
		String recommendText;
		if(ifmbId.equals("guest")) {
			recommendText = "조회수가 많은 게시물";
		} else {
			recommendText = ifmbId+"님의 미방문 지역 게시글";
		}
	%>
	<jsp:include page="header.jsp" flush="false"></jsp:include>
	<div class="wrap">
		<div id="mainWrap">
			<div id="recommendWrap">
				<h2><%=recommendText %></h2>
				<br>
				<hr>
			</div>
			<jsp:include page="map.jsp"></jsp:include>
			<div class="clear"></div>
		</div>
		<br><br>
		<h2>최근 게시글</h2>
		<br>
		<hr>
		<br>
		<div id="postView"></div>
		<br>
		<hr>
		<br>
		<br>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		//let postDatas = JSON.parse(getList(0));
		let ifmbId ="<%=ifmbId%>";
		
		let cardDatas = JSON.parse(getCardList());
		let regionDatas = JSON.parse(getRegionList(0));
		let recommendDatas = JSON.parse(getRecommendList(ifmbId));
	
		window.onload = function() {
			for(idx in regionDatas) {
				fill(regionDatas[idx]['ifrgSido'], regionDatas[idx]['ifrgSigungu'],0,0,regionDatas[idx]['count']);
			}
		}
		
		for(idx in cardDatas) {
			let data = cardDatas[idx];
			let imgPath = data['ifimPath']+data['ifimName'];
			let title = data['ifptTitle'];
			let writer = data['ifmbId'];

			let card = "<div class='postCard' onclick=location.href='postView.jsp?ifptSeq="+data['ifptSeq']+"'>";
				card += "<div class='postImgWrap'>";
				card += "<img src='"+imgPath+"' width='150'>";
				card += "</div>";
				card += "<p class='cardWriter'>작성자: "+writer+"</p>";
				card += "<p class='cardTitle'>"+title+"</p>";
				card += "</div>";
			$("#postView").append(card);
		}
		
		for(idx in recommendDatas) {
			let data = recommendDatas[idx];
			let imgPath = data['ifimPath']+data['ifimName'];
			let title = data['ifptTitle'];
			let writer = data['ifmbId'];
			let writerDate = data['ifptRegDatetime'];
			let sido = data['ifrgSido'];
			let sigungu = data['ifrgSigungu'];

			let card = "<div class='recommendContent' onclick=location.href='postView.jsp?ifptSeq="+data['ifptSeq']+"'>";
				card += "<div class='recommendImgWrap'>";
				card += "<img src='"+imgPath+"' width='150'>";
				card += "</div>";
				card += "<div class='recommendTextWrap'>";
				card += "<p class='recommendWriter'><b>작성자:</b> "+writer+"</p>";
				card += "<p class='recommendWriter'><b>작성일:</b> "+writerDate.slice(0,10)+"</p>";
				card += "<p class='recommendWriter'><b>지&nbsp;&nbsp;&nbsp;역:</b> "+sido+" "+sigungu+"</p>";
				card += "<p class='recommendTitle'><b>제&nbsp;&nbsp;&nbsp;목:</b> "+title+"</p>";
				card += "</div>";
				card += "</div>";
			$("#recommendWrap").append(card);
		}
		
	</script>
</body>
</html>
