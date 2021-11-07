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
<script src="./script/script.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<%
		if(session.getAttribute("ifmbId") == null) {
			out.print("<script>alert('로그인 후 이용 가능합니다.'); history.back(); </script>");
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
	%>
	
	<p><%=team.getIftmAnniversary() %></p>
	<p><%=team.getIftmStartDay() %></p>
	<a href="teamSetting.jsp">팀 설정</a>
	<table id="t" border=1 align="center" width=100% style="border-collapse : collapse;"></table>
	<div id="gridPager"></div>
	<a href="postForm.jsp">글쓰기</a>
	<script>
		let datas = JSON.parse(getList(<%=iftmSeq%>));
		console.log(datas);	
		
		$("#t").jqGrid({
			datatype: "local",
			data: datas,
			height: 500,
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
