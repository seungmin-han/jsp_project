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
<script src="./script/script.js"></script>
<link rel="stylesheet" href="./style/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="wrap">
		<div id="communityWrap">
			<h2>전체 게시글</h2>
			<p id="postCount"></p>
			<form method="post" name="searchForm">
				<input type="text" name="keyword">
				<input type="button" onclick="search()" value="검색">
			</form>
			<table id="communityTable">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
			
				</tbody>
			</table>
			<ul id="pager"></ul>
			<div class="clear"></div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script type="text/javascript">
		let category = ("<%= request.getParameter("c") %>"=="null") ? "" : "notice";
		let postDatas = JSON.parse(getList(0,category));
		let currentPage = 1;
		let limit = 10;
		let max;
		let pageNum;
		window.onload = function() {
			createPost(currentPage);
			
		}
		
		function search() {
			let keyword = searchForm.keyword.value;
			console.log(keyword);
			postDatas = JSON.parse(getList(0,category,keyword));
			createPost(1);
		}

		function createPost(page) {
			currentPage = page;
			max = postDatas.length;
			pageNum = Math.ceil(max / limit);
			if(pageNum < 1) pageNum = 1;
			console.log(max, pageNum);
			$("tbody").empty();
			createPages();	
			if(postDatas.length < 1) {
				let post = "<tr>";
				post += "<td colspan='5'> 검색된 게시물이 없습니다. </td>";
				post += "</tr>";
				$("tbody").append(post);	
			}
			
			for (let idx=(page-1)*limit; idx < page*limit; idx++) {
				let data = postDatas[idx]; 
				let post = "<tr>";
				post += "<td>"+(max - idx)+"</td>";
				post += "<td><a href='postView.jsp?ifptSeq="+data['ifptSeq']+"'>["+data['ifrgSido']+"]"+data['ifptTitle']+"</a></td>";
				post += "<td>"+data['ifmbId']+"</td>";
				post += "<td>"+data['ifptRegDatetime'].slice(0,10)+"</td>";
				post += "<td>"+data['ifptViewer']+"</td>";
				post += "</tr>";
				
				$("tbody").append(post);	
			}
			
			
		}
		
		function createPages() {
			console.log(1);
			$("#postCount").text("총 게시글 "+max+"건")
			
			$("#pager").empty();
			for(let i = 1; i <= pageNum; i++) {
				$("#pager").append("<li class='pageBtn' data-page='"+i+"' onclick='createPost($(this).data(\"page\"))'>"+i+"</li>");
			}
		}
		

	
	</script>
</body>
</html>