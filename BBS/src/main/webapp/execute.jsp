<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat, java.util.Date" %>
<%@ page import="infra.MemberDAO" %>
<%@ page import="infra.TeamDAO" %>
<%@ page import="infra.PostDAO" %>
<%@ page import="infra.RegionDAO" %>
<%@ page import="infra.ImageDAO" %>
<%@ page import="infra.Image" %>
<%@ page import="common.Common" %>
<%
request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="member" class="infra.Member" scope="page"/>
<jsp:useBean id="team" class="infra.Team" scope="page"/>
<jsp:useBean id="post" class="infra.Post" scope="page"/>
<jsp:useBean id="region" class="infra.Region" scope="page"/>
<jsp:useBean id="image" class="infra.Image" scope="page"/>

<jsp:setProperty name="member" property="*"></jsp:setProperty> <%-- member Bean에 입력받은 데이터를 모두 넣음 --%>
<jsp:setProperty name="team" property="*"></jsp:setProperty> <%-- team Bean에 입력받은 데이터를 모두 넣음 --%>
<jsp:setProperty name="post" property="*"></jsp:setProperty> <%-- post Bean에 입력받은 데이터를 모두 넣음 --%>
<jsp:setProperty name="region" property="*"></jsp:setProperty> <%-- post Bean에 입력받은 데이터를 모두 넣음 --%>
<jsp:setProperty name="image" property="*"></jsp:setProperty> <%-- image Bean에 입력받은 데이터를 모두 넣음 --%>

<%-- 데이터 생성 시 공통적으로 ip와 divceCd를 입력 --%>
<jsp:setProperty name="member" property="ifmbRegIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="member" property="ifmbModIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="member" property="ifmbRegDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>
<jsp:setProperty name="member" property="ifmbModDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>
<jsp:setProperty name="team" property="iftmRegIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="team" property="iftmModIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="team" property="iftmRegDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>
<jsp:setProperty name="team" property="iftmModDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>
<jsp:setProperty name="post" property="ifptRegIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="post" property="ifptModIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="post" property="ifptRegDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>
<jsp:setProperty name="post" property="ifptModDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>
<jsp:setProperty name="region" property="ifrgRegIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="region" property="ifrgModIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="region" property="ifrgRegDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>
<jsp:setProperty name="region" property="ifrgModDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>
<jsp:setProperty name="image" property="ifimRegIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="image" property="ifimModIp" value="<%=Common.getClientIp(request) %>"></jsp:setProperty>
<jsp:setProperty name="image" property="ifimRegDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>
<jsp:setProperty name="image" property="ifimModDeviceCd" value="<%=Common.getDeviceCd(request) %>"></jsp:setProperty>

<%
	infra.MemberDAO memberDAO = new MemberDAO();
	infra.TeamDAO teamDAO = new TeamDAO();
	infra.PostDAO postDAO = new PostDAO();
	infra.RegionDAO regionDAO = new RegionDAO();
	infra.ImageDAO imageDAO = new ImageDAO();
	String process = request.getParameter("process");
	
	ArrayList<Image> imgs = new ArrayList<>();

	if(process.equals("register")) { 							// 회원가입 처리
		String ifmbPassword = request.getParameter("ifmbPassword");
		String ifmbPasswordCheck = request.getParameter("ifmbPasswordCheck");
		
		if(ifmbPassword.equals(ifmbPasswordCheck)) {			//패스워드 일치 검사
			ifmbPassword = Common.encrypt(ifmbPassword);
		} else {
			Common.alert("비밀번호가 일치하지 않습니다", response);
			Common.moveBack(response);
		}
%>
<jsp:setProperty name="member" property="ifmbPassword" value="<%=ifmbPassword %>"></jsp:setProperty>
<% 
		int result = memberDAO.register(member);
		if(result == -1) {	//db 에러
			Common.alert("알 수 없는 에러",response);
			Common.moveBack(response);
		} else {			//정상 작동
			Common.alert("회원가입이 정상적으로 처리되었습니다.",response);
			Common.moveTo("index.jsp",1,response);
		}
	} else if (process.equals("login")) {				//로그인 처리
		int result = memberDAO.login(member);
		switch(result) {
			case -1 :
				Common.alert("비밀번호가 일치하지 않습니다.",response);
				Common.moveBack(response);
				break;
			case -2 :
				Common.alert("DB Error.",response);
				Common.moveBack(response);
				break;
			case -3 :
				Common.alert("존재하지 않는 아이디입니다.",response);
				Common.moveBack(response);
				break;
			default :
				session.setAttribute("ifmbId", member.getIfmbId());
				session.setAttribute("iftmAdminNy", result);
				System.out.println(result);
				Common.alert("로그인 성공", response);
				Common.moveTo("index.jsp",1,response);
				break;
		}
		
		
	} else if (process.equals("logout")) {					//로그아웃
		session.invalidate(); 		// 세션 소멸
		Common.moveTo("index.jsp",1,response);
		
		
		
	} else if (process.equals("createTeam")) { 				// 팀 생성
		int result = teamDAO.createTeam(team, (String) session.getAttribute("ifmbId"));
		if(result != -1) {
			out.print("<script>alert('팀이 정상적으로 생성되었습니다.')</script>");
			Common.moveTo("team.jsp", 1, response);
		}
	} else if(process.equals("post")) {
		int ifrgSeq = regionDAO.posting(region, (String) session.getAttribute("ifmbId"));
		if(ifrgSeq < 1) {
			Common.alert("지역 생성에 실패하였습니다.", response);
			Common.moveBack(response);
			return;
		} else {
			int lastInsertId = postDAO.posting(post, (String) session.getAttribute("ifmbId"), ifrgSeq);
			if(lastInsertId > 0) {
				imgs = (ArrayList<Image>)session.getAttribute("imgs");
				if(imgs == null) {
					session.removeAttribute("imgs");
					Common.alert("게시글이 정상적으로 작성되었습니다.",response);
					Common.moveTo("team.jsp",1,response);
					return;
				}
				for (Image img : imgs) {
					int result = imageDAO.imageUpload(img,(String) session.getAttribute("ifmbId"), lastInsertId);
					if(result < 1) {
						Common.alert("이미지 업로드 중 에러가 발생했습니다.",response);
						Common.moveTo("team.jsp", 1, response);
						break;
					}
				}
				session.removeAttribute("imgs");
				Common.alert("게시글이 정상적으로 작성되었습니다.", response);
				Common.moveTo("team.jsp",1,response);
				
			} else {
				session.removeAttribute("imgs");
				Common.alert("게시글 작성을 실패했습니다.",response);
				Common.moveTo("team.jsp",1,response);
			}	
		}
		
	} else if(process.equals("upload")) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String path = application.getRealPath("/images");
		String realPath = request.getServletContext().getRealPath("/images");
		int max = 1024 * 1024 * 10;

		MultipartRequest mr = new MultipartRequest(request, realPath, max, "utf-8", new DefaultFileRenamePolicy());

		String original = mr.getOriginalFileName("upload");
		String fileName = mr.getFilesystemName("upload");
		File file = new File(path+fileName);
		
		int size = (int)file.length();
		String[] tmp = fileName.split("\\.");		
		String type = tmp[1];
		
		Image img = new Image();
		
		img.setIfimName(fileName);
		img.setIfimType(type);
		img.setIfimSize(size);
		img.setIfimPath(".\\images\\");
		img.setIfimRegIp(Common.getClientIp(request));
		img.setIfimRegDeviceCd(Common.getDeviceCd(request));
		
		if(session.getAttribute("imgs") != null) {
			imgs = (ArrayList<Image>) session.getAttribute("imgs");
		}
		
		imgs.add(img);
		session.setAttribute("imgs", imgs);
		

		String fileUrl = ".\\\\images\\\\"+fileName;
		PrintWriter printWriter = null;
		printWriter = response.getWriter();


		printWriter.print("{\"fileName\" : \""+fileName+"\", \"uploaded\" : 1, \"url\":\""+fileUrl+"\"}");
		
	} else if(process.equals("getList")) {
		int iftmSeq = Integer.parseInt(request.getParameter("iftmSeq"));
		String category = (String) request.getParameter("category");
		out.print(postDAO.getList(iftmSeq,category));
	} else if(process.equals("getCardList")) {
		out.print(postDAO.getCardList());
	} else if(process.equals("getOne")) {
		int ifptSeq = Integer.parseInt(request.getParameter("ifptSeq"));
		out.print(postDAO.getOne(ifptSeq));
	} else if(process.equals("getImageList")) {
		int iftmSeq = Integer.parseInt(request.getParameter("iftmSeq"));
		out.print(imageDAO.getImageList(iftmSeq));
	} else if(process.equals("getRegionList")) {
		int iftmSeq = Integer.parseInt(request.getParameter("iftmSeq"));
		out.print(regionDAO.getRegionList(iftmSeq));
	} else if(process.equals("update")) {
		int ifptSeq = Integer.parseInt(request.getParameter("ifptSeq"));
		post.setIfptSeq(ifptSeq);
		post.setIfptModSeq(ifptSeq);
		if(postDAO.update(post, (String) session.getAttribute("ifmbId")) == 1) {
			if(regionDAO.update(region, ifptSeq, (String) session.getAttribute("ifmbId"))==1) {
				Common.alert("성공적으로 글을 수정하였습니다.", response);
				Common.moveTo("team.jsp",1, response);
			}
		} else {
			Common.alert("글을 수정하는데 오류가 발생했습니다.", response);
			Common.moveTo("team.jsp",1, response);
		}
	} else if(process.equals("deleteByUpdate")) {
		int ifptSeq = Integer.parseInt(request.getParameter("ifptSeq"));
		post.setIfptSeq(ifptSeq);
		if(postDAO.deleteByUpdate(post, (String) session.getAttribute("ifmbId")) == 1) {
			if(regionDAO.deleteByUpdate(region ,ifptSeq, (String) session.getAttribute("ifmbId"))==1) {
				if(imageDAO.deleteByUpdate(image, ifptSeq, (String) session.getAttribute("ifmbId")) == 1) {
					Common.alert("성공적으로 글을 삭제하였습니다.", response);
					Common.moveTo("team.jsp",1, response);	
				} else {
					//by pass
				}
			} else {
				Common.alert("지역 삭제 실패.", response);
				Common.moveTo("team.jsp",1, response);	
			}
		} else {
			Common.alert("글을 삭제하는데 오류가 삭제했습니다.", response);
			Common.moveTo("team.jsp",1, response);
		}
		
	} else if(process.equals("updateTeam")) {
		if(teamDAO.update(team, (String) session.getAttribute("ifmbId"))==1) {
			Common.alert("팀 정보가 수정되었습니다.", response);
			Common.moveTo("team.jsp",1, response);
		} else {
			Common.alert("팀 정보 수정을 실패하였습니다.", response);
			Common.moveTo("team.jsp",1, response);
		}
	} else if(process.equals("updateInviteCode")) {
		out.print(teamDAO.updateInviteCode(team,(String) session.getAttribute("ifmbId")));
	} else if(process.equals("teamDeleteByUpdate")) {
		int iftmSeq = Integer.parseInt(request.getParameter("iftmSeq"));
		team.setIftmSeq(iftmSeq);
		if(teamDAO.deleteByUpdate(team, (String) session.getAttribute("ifmbId"))==1){
			Common.alert("팀이 삭제되었습니다.", response);
			Common.moveTo("index.jsp",1, response);
		} else {
			Common.alert("팀 삭제 중 오류가 발생되었습니다.", response);
			Common.moveTo("index.jsp",1, response);
		}
	} else if (process.equals("joinTeam")){
		String ifmbId = (String) session.getAttribute("ifmbId");
		String code = request.getParameter("iftmInviteCd");
		member.setIfmbId(ifmbId);
		if(memberDAO.joinTeam(member, code)==1) {
			Common.alert("팀에 정상적으로 가입되었습니다.", response);
			Common.moveTo("index.jsp",1, response);
		} else {
			Common.alert("초대 코드를 다시 확인해주세요.", response);
			Common.moveTo("index.jsp",1, response);
		}
	} else if(process.equals("leaveTeam")) {
		String ifmbId = (String) session.getAttribute("ifmbId");
		member.setIfmbId(ifmbId);
		if(memberDAO.leaveTeam(member)==1) {
			Common.alert("팀을 성공적으로 탈퇴했습니다.", response);
			Common.moveTo("index.jsp",1, response);
		} else {
			Common.alert("팀을 탈퇴를 실패했습니다.", response);
			Common.moveTo("index.jsp",1, response);
		}
	} else if(process.equals("getTeamMemberList")) {
		int iftmSeq = Integer.parseInt(request.getParameter("iftmSeq"));
		String ifmbId = (String) session.getAttribute("ifmbId");
		out.print(memberDAO.getTeamMemberList(iftmSeq, ifmbId));
	} else if(process.equals("kickMember")) {
		String ifmbId = (String) request.getParameter("ifmbId");
		member.setIfmbId(ifmbId);
		out.print(memberDAO.leaveTeam(member));
	}else if(process.equals("updateMember")) {
		String ifmbId = (String) session.getAttribute("ifmbId");
		if(memberDAO.update(member, ifmbId) == 1) {
			Common.alert("회원 정보를 성공적으로 수정했습니다.", response);
			Common.moveTo("index.jsp",1, response);
		} else {
			Common.alert("회원 정보 수정을 실패했습니다.", response);
			Common.moveTo("index.jsp",1, response);
		}
		
	} else if(process.equals("getRecommendList")) {
		String ifmbId = (String) request.getParameter("ifmbId");
		System.out.print(ifmbId);
		out.print(postDAO.getRecommendList(ifmbId));
	} else if(process.equals("getSearchList")) {
		int iftmSeq = Integer.parseInt(request.getParameter("iftmSeq"));
		String category = (String) request.getParameter("category");
		String keyword = request.getParameter("keyword");
		out.print(postDAO.getList(iftmSeq,category,keyword));
	}
%> 
