<%@page import="common.Common"%>
<%@ page import="infra.TeamDAO" %>
<%@ page import="infra.PostDAO" %>
<%@ page import="java.util.*" %>
<%@ page import="infra.Team" %>
<%@ page import="infra.Post" %>
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
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script> 
<link rel="stylesheet" type="text/css" href="./externalLib/jqgrid/css/ui.jqgrid.css" /> 
<script src="./externalLib/jqgrid/js/i18n/grid.locale-kr.js" type="text/javascript"></script> 
<script src="./externalLib/jqgrid/js/minified/jquery.jqGrid.min.js" type="text/javascript"></script>
<script src="./script/map.js"></script>  
<script src="./script/script.js"></script>
<link rel="stylesheet" href="./style/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrap teamWrap">
	<%
		if(session.getAttribute("ifmbId") == null) {
			out.print("<script>alert('로그인 후 이용 가능합니다.'); location.replace('index.jsp'); </script>");
			return;
		} 
	
		TeamDAO teamDAO = new TeamDAO();
		int iftmSeq = teamDAO.getTeamSeq((String) session.getAttribute("ifmbId"));
		
		if(iftmSeq < 1) { 
		%>
			<h2>소속된 팀이 없습니다.</h2>
			<a href="joinTeam.jsp">초대코드 입력</a>
			<a href="createTeam.jsp">팀 생성하기</a>
		<%
			return;
		}
	%>
	
	<%-- 팀 검사후 팀이 있으면 밑에 코드 실행 --%>
	
	<%
		
		Team team = teamDAO.getTeamData(iftmSeq);
		
		if(team == null) {
			out.print("<script>alert('팀 정보를 불러오지 못했습니다.'); history.back(); </script>");
			return;
		}
	
		if(Integer.parseInt(String.valueOf(session.getAttribute("iftmAdminNy")))==1) {
	%>
	<a href="teamSetting.jsp" style="float:right;">팀 설정</a>
	<% } else { %>
	<a href="execute.jsp?process=leaveTeam" style="float:right;">팀 탈퇴</a>
	<% } %>
	<div id="imageBox">
		<div class="teamInfo">
			<p class="an"><%=team.getIftmAnniversary() %></p>
			<p class="startDay">D+<%=Common.calcDate(team.getIftmStartDay()) %></p>
		</div>
	</div>
	<jsp:include page="map.jsp"></jsp:include>
	
	<table id="t" border=1 align="center" width=100% style="border-collapse : collapse;"></table>
	<div id="gridPager"></div>
	<button onclick="location.href='postForm.jsp'" style="float:right; margin-right:100px; padding:5px 30px">글쓰기</button>
	<br><br>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		let postDatas = JSON.parse(getList(<%=iftmSeq%>));
		let imageDatas = JSON.parse(getImageList(<%=iftmSeq%>));
		let regionDatas = JSON.parse(getRegionList(<%=iftmSeq%>));

		
		
		if(imageDatas) {
			let imgBox = document.querySelector("#imageBox");
			let br = document.createElement("br");
			for(idx in imageDatas) {
				if(idx == 4) imgBox.appendChild(br);
				let image = document.createElement("img");
				image.setAttribute("src", (imageDatas[idx]['ifimPath']+imageDatas[idx]['ifimName']));
				image.setAttribute("width", 135);
				image.setAttribute("height", 135);
				image.setAttribute("data-ifptSeq", imageDatas[idx]['ifptSeq']);
				image.style.border = "1px solid #000";
				imgBox.appendChild(image);
			} 			
		}
		
		window.onload = function() {
			for(idx in regionDatas) {
				fill(regionDatas[idx]['ifrgSido'], regionDatas[idx]['ifrgSigungu'],0,0);
			}
			
			$("tr").on("click", function() {
				console.log(1);
				location.href="./postView.jsp?ifptSeq="+$(this).children().eq(0).text();
			});
			
			$("img").on("click", function() {
				location.href = "./postView.jsp?ifptSeq="+$(this).data("ifptseq");
			});
		}
		
		
		
		$("#t").jqGrid({
			datatype: "local",
			data: postDatas,
			width: 1000,
			colNames: ['번호','시/도','제목','작성자','조회','작성일'],
			colModel:[ 
				{
					name:"ifptSeq", 
					index:"ifptSeq",  
					align:'center',
					resizable : true,
					formatter: "numberStr",
					sorttype: "number",
				},
				{
					name:"ifrgSido", 
					index:"ifrgSido",  
					align:'center',
					resizable : true
				},
				{
					name:"ifptTitle", 
					index:"ifptTitle",  
					align:'center',
					resizable : true
				},
				{
					name:"ifmbId", 
					index:"ifmbId",  
					align:'center',
					resizable : true
				},
				{
					name:"ifptViewer", 
					index:"ifptViewer",  
					align:'center',
					resizable : true,
					formatter: "numberStr",
					sorttype: "number",
				},
				{
					name:"ifptRegDatetime", 
					index:"ifptRegDatetime",  
					align:'center',
					resizable : true
				}
				],
			loadtext: "로딩중일때 표시되는 텍스트", 
			caption: "팀 내 게시글 목록",
			pager:"#gridPager",
			rowNum:5,
			sortable: true,
			pgbuttons:true,
		});
	</script>
</body>
</html>
