<%@page import="infra.Team"%>
<%@ page import="infra.TeamDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./style/style.css">
<script
  src="https://code.jquery.com/jquery-3.6.0.js"
  integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
  crossorigin="anonymous"></script>
  <script type="text/javascript" src="./script/script.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrap">
		
		<%
		Team team = null;
		int iftmSeq;
		String ifmbId;
		if(session.getAttribute("ifmbId") == null) {
			out.print("<script>alert('로그인 후 이용 가능합니다.'); location.replace('index.jsp'); </script>");
			return;
		} else {
			TeamDAO teamDAO = new TeamDAO();
			ifmbId = (String) session.getAttribute("ifmbId");
			iftmSeq = teamDAO.getTeamSeq(ifmbId);
			team = teamDAO.getTeamData(iftmSeq);
		}
		
		if(team == null || iftmSeq == 0) return;
		%>
		
		<h2>팀 설정</h2>
		<a href="execute.jsp?process=teamDeleteByUpdate&iftmSeq=<%=iftmSeq%>">팀 삭제</a>
		<form method="post" action="execute.jsp?process=updateTeam">
			<label>팀 이름 </label> 
			<input type="text" name="iftmName" value="<%= team.getIftmName() %>" readOnly><br>
			
			<label>팀 유형 </label> 
				<select id="iftmTypeCd" name="iftmTypeCd">
					<option>옵션을 선택하세요</option>
					<option value="1">개인</option>
					<option value="2">커플</option>
					<option value="3">단체</option>
				</select><br>
			
			<label>문구 </label><input name="iftmAnniversary" value="<%= team.getIftmAnniversary() %>" ><br>
			<label>시작일</label> <input type="date" name="iftmStartDay" value="<%= team.getIftmStartDay() %>" ><br>
			<label>초대코드</label><input type="text" id="iftmInviteCd" name="iftmInviteCd" value="<%=team.getIftmInviteCd() %>" readonly><button id="updateCode" type="button">초대코드생성</button><br>
			
			<table border="1">
				<thead>
					<tr>
						<td colspan="2">회원 목록</td>
					</tr>
				</thead>
				<tbody>
					<tr><td colspan="2">회원이 없습니다.</td></tr>
				</tbody>
			</table>
			
			<input type="hidden" name="iftmSeq" value="<%=iftmSeq%>">
			<input type="submit" value="수정하기">
		</form>
	</div>
	<script type="text/javascript">
		let selectedOption = document.querySelectorAll("#iftmTypeCd > option");
		for(idx in selectedOption) {
			if(selectedOption[idx].value == "<%=team.getIftmTypeCd()%>") {
				selectedOption[idx].selected = true;
			}
		}
		window.onload = function () {
			
			refreshList();
			
			$("#updateCode").on("click", function() {
				let code = updateInviteCode(<%=iftmSeq%>);
				console.log(code);
				if(code != null) {
					$("#iftmInviteCd").val(code);
				}
			});	
			
			$(document).on("click", ".kickBtn", function() {
				let deleteNy = window.confirm("정말 추방하시겠습니까?");
				if(deleteNy == true) {
					let ifmbId = $(this).parent().prev().text();
					kickMember(ifmbId);
					refreshList();	
				}
			});
		}
		
		function refreshList() {
			let memberList = JSON.parse(getTeamMemberList(<%=iftmSeq%>, "<%=ifmbId%>"));
			
			if(memberList.length > 0) {
				$("tbody").html("");
				for(idx in memberList) {
					let data = memberList[idx];
					let tr = "<tr>";
					tr += "<td>"+data['ifmbId']+"</td>";
					tr += "<td><button class='kickBtn' type='button'>추방</button></td>";
					tr += "</tr>";
					$("tbody").append(tr);
				}	
			} else {
				$("tbody").html("<tr><td colspan='2'>회원이 없습니다.</td></tr>");
			}
		}
		
	</script>
</body>
</html>