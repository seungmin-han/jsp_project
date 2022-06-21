/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.70
 * Generated at: 2022-01-06 20:05:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class community_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script\r\n");
      out.write("  src=\"https://code.jquery.com/jquery-3.6.0.js\"\r\n");
      out.write("  integrity=\"sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=\"\r\n");
      out.write("  crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"./script/script.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"./style/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("	<div class=\"wrap\">\r\n");
      out.write("		<div id=\"communityWrap\">\r\n");
      out.write("			<h2>전체 게시글</h2>\r\n");
      out.write("			<p id=\"postCount\"></p>\r\n");
      out.write("			<form method=\"post\" name=\"searchForm\">\r\n");
      out.write("				<input type=\"text\" name=\"keyword\">\r\n");
      out.write("				<input type=\"button\" onclick=\"search()\" value=\"검색\">\r\n");
      out.write("			</form>\r\n");
      out.write("			<table id=\"communityTable\">\r\n");
      out.write("				<thead>\r\n");
      out.write("					<tr>\r\n");
      out.write("						<th>번호</th>\r\n");
      out.write("						<th>제목</th>\r\n");
      out.write("						<th>작성자</th>\r\n");
      out.write("						<th>작성일</th>\r\n");
      out.write("						<th>조회수</th>\r\n");
      out.write("					</tr>\r\n");
      out.write("				</thead>\r\n");
      out.write("				<tbody>\r\n");
      out.write("			\r\n");
      out.write("				</tbody>\r\n");
      out.write("			</table>\r\n");
      out.write("			<ul id=\"pager\"></ul>\r\n");
      out.write("			<div class=\"clear\"></div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<script type=\"text/javascript\">\r\n");
      out.write("		let category = (\"");
      out.print( request.getParameter("c") );
      out.write("\"==\"null\") ? \"\" : \"notice\";\r\n");
      out.write("		let postDatas = JSON.parse(getList(0,category));\r\n");
      out.write("		let currentPage = 1;\r\n");
      out.write("		let limit = 10;\r\n");
      out.write("		let max;\r\n");
      out.write("		let pageNum;\r\n");
      out.write("		window.onload = function() {\r\n");
      out.write("			createPost(currentPage);\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		function search() {\r\n");
      out.write("			let keyword = searchForm.keyword.value;\r\n");
      out.write("			console.log(keyword);\r\n");
      out.write("			postDatas = JSON.parse(getList(0,category,keyword));\r\n");
      out.write("			createPost(1);\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		function createPost(page) {\r\n");
      out.write("			currentPage = page;\r\n");
      out.write("			max = postDatas.length;\r\n");
      out.write("			pageNum = Math.ceil(max / limit);\r\n");
      out.write("			if(pageNum < 1) pageNum = 1;\r\n");
      out.write("			console.log(max, pageNum);\r\n");
      out.write("			$(\"tbody\").empty();\r\n");
      out.write("			createPages();	\r\n");
      out.write("			if(postDatas.length < 1) {\r\n");
      out.write("				let post = \"<tr>\";\r\n");
      out.write("				post += \"<td colspan='5'> 검색된 게시물이 없습니다. </td>\";\r\n");
      out.write("				post += \"</tr>\";\r\n");
      out.write("				$(\"tbody\").append(post);	\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			for (let idx=(page-1)*limit; idx < page*limit; idx++) {\r\n");
      out.write("				let data = postDatas[idx]; \r\n");
      out.write("				let post = \"<tr>\";\r\n");
      out.write("				post += \"<td>\"+(max - idx)+\"</td>\";\r\n");
      out.write("				post += \"<td><a href='postView.jsp?ifptSeq=\"+data['ifptSeq']+\"'>[\"+data['ifrgSido']+\"]\"+data['ifptTitle']+\"</a></td>\";\r\n");
      out.write("				post += \"<td>\"+data['ifmbId']+\"</td>\";\r\n");
      out.write("				post += \"<td>\"+data['ifptRegDatetime'].slice(0,10)+\"</td>\";\r\n");
      out.write("				post += \"<td>\"+data['ifptViewer']+\"</td>\";\r\n");
      out.write("				post += \"</tr>\";\r\n");
      out.write("				\r\n");
      out.write("				$(\"tbody\").append(post);	\r\n");
      out.write("			}\r\n");
      out.write("			\r\n");
      out.write("			\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("		function createPages() {\r\n");
      out.write("			console.log(1);\r\n");
      out.write("			$(\"#postCount\").text(\"총 게시글 \"+max+\"건\")\r\n");
      out.write("			\r\n");
      out.write("			$(\"#pager\").empty();\r\n");
      out.write("			for(let i = 1; i <= pageNum; i++) {\r\n");
      out.write("				$(\"#pager\").append(\"<li class='pageBtn' data-page='\"+i+\"' onclick='createPost($(this).data(\\\"page\\\"))'>\"+i+\"</li>\");\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("	\r\n");
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
