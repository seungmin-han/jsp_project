/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2021-11-23 15:57:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import infra.Team;
import infra.TeamDAO;

public final class teamSetting_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("infra.Team");
    _jspx_imports_classes.add("infra.TeamDAO");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./style/style.css\">\r\n");
      out.write("<script\r\n");
      out.write("  src=\"https://code.jquery.com/jquery-3.6.0.js\"\r\n");
      out.write("  integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\"\r\n");
      out.write("  crossorigin=\"anonymous\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"./script/script.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("	<div class=\"wrap\">\r\n");
      out.write("		\r\n");
      out.write("		");

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
		
      out.write("\r\n");
      out.write("		\r\n");
      out.write("		<h2>팀 설정</h2>\r\n");
      out.write("		<a href=\"execute.jsp?process=teamDeleteByUpdate&iftmSeq=");
      out.print(iftmSeq);
      out.write("\">팀 삭제</a>\r\n");
      out.write("		<form method=\"post\" action=\"execute.jsp?process=updateTeam\">\r\n");
      out.write("			<label>팀 이름 </label> \r\n");
      out.write("			<input type=\"text\" name=\"iftmName\" value=\"");
      out.print( team.getIftmName() );
      out.write("\" readOnly><br>\r\n");
      out.write("			\r\n");
      out.write("			<label>팀 유형 </label> \r\n");
      out.write("				<select id=\"iftmTypeCd\" name=\"iftmTypeCd\">\r\n");
      out.write("					<option>옵션을 선택하세요</option>\r\n");
      out.write("					<option value=\"1\">개인</option>\r\n");
      out.write("					<option value=\"2\">커플</option>\r\n");
      out.write("					<option value=\"3\">단체</option>\r\n");
      out.write("				</select><br>\r\n");
      out.write("			\r\n");
      out.write("			<label>문구 </label><input name=\"iftmAnniversary\" value=\"");
      out.print( team.getIftmAnniversary() );
      out.write("\" ><br>\r\n");
      out.write("			<label>시작일</label> <input type=\"date\" name=\"iftmStartDay\" value=\"");
      out.print( team.getIftmStartDay() );
      out.write("\" ><br>\r\n");
      out.write("			<label>초대코드</label><input type=\"text\" id=\"iftmInviteCd\" name=\"iftmInviteCd\" value=\"");
      out.print(team.getIftmInviteCd() );
      out.write("\" readonly><button id=\"updateCode\" type=\"button\">초대코드생성</button><br>\r\n");
      out.write("			\r\n");
      out.write("			<table border=\"1\">\r\n");
      out.write("				<thead>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<td colspan=\"2\">회원 목록</td>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</thead>\r\n");
      out.write("				<tbody>\r\n");
      out.write("					<tr><td colspan=\"2\">회원이 없습니다.</td></tr>\r\n");
      out.write("				</tbody>\r\n");
      out.write("			</table>\r\n");
      out.write("			\r\n");
      out.write("			<input type=\"hidden\" name=\"iftmSeq\" value=\"");
      out.print(iftmSeq);
      out.write("\">\r\n");
      out.write("			<input type=\"submit\" value=\"수정하기\">\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		let selectedOption = document.querySelectorAll(\"#iftmTypeCd > option\");\r\n");
      out.write("		for(idx in selectedOption) {\r\n");
      out.write("			if(selectedOption[idx].value == \"");
      out.print(team.getIftmTypeCd());
      out.write("\") {\r\n");
      out.write("				selectedOption[idx].selected = true;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		window.onload = function () {\r\n");
      out.write("			\r\n");
      out.write("			refreshList();\r\n");
      out.write("			\r\n");
      out.write("			$(\"#updateCode\").on(\"click\", function() {\r\n");
      out.write("				let code = updateInviteCode(");
      out.print(iftmSeq);
      out.write(");\r\n");
      out.write("				console.log(code);\r\n");
      out.write("				if(code != null) {\r\n");
      out.write("					$(\"#iftmInviteCd\").val(code);\r\n");
      out.write("				}\r\n");
      out.write("			});	\r\n");
      out.write("			\r\n");
      out.write("			$(document).on(\"click\", \".kickBtn\", function() {\r\n");
      out.write("				let deleteNy = window.confirm(\"정말 추방하시겠습니까?\");\r\n");
      out.write("				if(deleteNy == true) {\r\n");
      out.write("					let ifmbId = $(this).parent().prev().text();\r\n");
      out.write("					kickMember(ifmbId);\r\n");
      out.write("					refreshList();	\r\n");
      out.write("				}\r\n");
      out.write("			});\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		function refreshList() {\r\n");
      out.write("			let memberList = JSON.parse(getTeamMemberList(");
      out.print(iftmSeq);
      out.write(',');
      out.write(' ');
      out.write('"');
      out.print(ifmbId);
      out.write("\"));\r\n");
      out.write("			\r\n");
      out.write("			if(memberList.length > 0) {\r\n");
      out.write("				$(\"tbody\").html(\"\");\r\n");
      out.write("				for(idx in memberList) {\r\n");
      out.write("					let data = memberList[idx];\r\n");
      out.write("					let tr = \"<tr>\";\r\n");
      out.write("					tr += \"<td>\"+data['ifmbId']+\"</td>\";\r\n");
      out.write("					tr += \"<td><button class='kickBtn' type='button'>추방</button></td>\";\r\n");
      out.write("					tr += \"</tr>\";\r\n");
      out.write("					$(\"tbody\").append(tr);\r\n");
      out.write("				}	\r\n");
      out.write("			} else {\r\n");
      out.write("				$(\"tbody\").html(\"<tr><td colspan='2'>회원이 없습니다.</td></tr>\");\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("	</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
