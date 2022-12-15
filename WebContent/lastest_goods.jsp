<%@page import="pers.minho.service.GoodsService"%>
<%@page import="org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pers.minho.util.*, java.util.*, pers.minho.entity.*, pers.minho.service.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <title>敏拍 - 二手交易平台</title>
	<!-- 公共头 -->
	<jsp:include page="head.jsp" />
</head>
<body>
    <!-- 导航栏 -->
	<jsp:include page="header.jsp" />

    <!-- 商品列表 -->
    <div class="container mt-5 p-0 border" style="background-color: #fff;">

        <nav class="navbar navbar-expand-lg navbar-light bg-light border">
        <%
        	if (request.getParameter("searchName") == null) {
        %>
            <a class="navbar-brand display-4" href="#">最新上架</a>
       	<%
        	} else {
       	%>
       		<a class="navbar-brand text-secondary" href="#">搜索 "<span class="text-success"><%=request.getParameter("searchName") %></span>" 的结果</a>
   		<%
    		}
   		%>
            <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
              <form class="form-inline my-2 my-lg-0" action="goods" method="post">
                <input class="form-control mr-sm-2" type="search" placeholder="输入商品名" aria-label="Search" name="searchName">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">查找商品</button>
              </form>
            </div>
        </nav>

        <div class="row justify-content-md-start m-sm-auto">
        	<%
	        	//List<Goods> goods=(List<Goods>)request.getAttribute("goodsList");
        		List<Goods> goods = (List<Goods>)request.getAttribute("goodsPageList");
	    		Map<Integer, User> map = (Map<Integer, User>)request.getAttribute("userMap");
	    		for (Goods good : goods) {
        	%>
            <div class="card hvr-grow-shadow my-2 mx-2" style="width:211px;cursor:pointer;" onclick="window.location.href='<%=path%>/goods_info?id=<%=good.getId() %>'">
                <div class="card-header py-1">
                  <div class="media">
                    <img class="mr-4 my-auto" src="<%=basePath%>static/logo.svg" alt="user" style="width: 20%;">
                    <div class="media-body">
                      <p class="card-text m-0"><small><%=map.get(good.getSeller_id()).getNickname() %></small></p>
                      <p class="card-text m-0"><small class="text-muted"><%=good.getCreate_date() %></small></p>
                    </div>
                  </div>
                </div>
                <img class="card-img-top my-2 mx-auto d-block" src="<%=good.getImg() %>" alt="Card image" style="width:190px; height:190px;">
                <div class="card-body py-2 px-3">
                  <h5 class="card-title text-dark font-weight-light"><%=good.getName() %></h5>
                  <p class="card-text"><h6 class="font-weight-bold">￥<%=good.getPrice() %></h6></p>
                  <p class="card-text"><small class="text-muted">八成新</small></p>
                </div>
            </div>
            <%
        		}
        	%>
        </div>

        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center my-3">
            	<%
	            	GoodsPage gPage = (GoodsPage)request.getAttribute("goodsPage");
					int currentPage = gPage.getCurrentPage();
					int totalPage= gPage.getTotalPage();
					if (currentPage - 1 > 0) {
				%>
					<li class="page-item"><a class="page-link" href="goods?currentPage=<%=currentPage - 1%>">上一页</a></li>
				<%
					} else {
				%>
					<li class="page-item disabled"><a class="page-link" href="#">上一页</a></li>
				<%
					}
					
					for (int i=1; i<=totalPage; i++) {
						if (i == currentPage) {
				%>
              		<li class="page-item active"><a class="page-link" href="goods?currentPage=<%=i %>"><%=i %></a></li>
				<%
						} else {
				%>
					<li class="page-item"><a class="page-link" href="goods?currentPage=<%=i %>"><%=i %></a></li>
				<%
						}
					}
				%>
              		<li class="page-item disabled"><h5 class="text-secondary" tabindex="-1">&emsp;...&emsp;</h5></li>
              	<%
              		if (currentPage != totalPage) {
              	%>
              		<li class="page-item"><a class="page-link" href="goods?currentPage=<%=currentPage + 1%>">下一页</a></li>
           		<%
              		} else {
           		%>
           			<li class="page-item disabled"><a class="page-link" href="#">下一页</a></li>
       			<%
          			}
       			%>
            </ul>
        </nav>

    </div>
    
    <jsp:include page="footer.jsp" />

</body>

</html>
