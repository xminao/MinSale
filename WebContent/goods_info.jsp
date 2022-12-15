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

    
    <!-- 商品页面 -->
    <div class="container mt-5 p-0 border" style="background-color: #fff;">

        <nav class="navbar navbar-light bg-light border">
            <span class="navbar-brand mb-0 display-3">商品详情页</span>
        </nav>

        <div class="d-flex flex-row justify-content-center">
            <%
            	HttpSession ses = request.getSession();
            	Goods goods = (Goods)request.getAttribute("goods");
            	User seller = (User)request.getAttribute("seller");
            	User user = (User)ses.getAttribute("loginUser");
            %>
            <!-- 商品图片 -->
            <div class="card my-5 mb-3 mx-4" style="width: 350px; height: 350px;">
                <img class="card-img-top m-auto" src="<%=goods.getImg() %>" alt="IMAGE" style="width: 100%; height: 100%;">
            </div>

            <!--  商品信息 -->
            <div class="card my-5 mx-2 border-0" style="width: 600px;">
                <ul class="list-group list-group-flush">
                <li class="list-group-item text-dark h2"><%=goods.getName() %></li>
                <li class="list-group-item">
                    <p class="text-secondary"> 售价：
                        <span class="text-danger h4">￥<%=goods.getPrice() %></span>
                    </p>
                    <p class="text-secondary">简介：
                        <div class="card" style="width: 70%;">
                            <div class="card-body">
                            <%=goods.getDesc() %>
                            </div>
                        </div>
                    </p>
                    <p class="text-secondary">上架时间：
                        <span class="text-body"><%=goods.getCreate_date() %></span>
                    </p>
                    <%
	                    if (user == null || (user != null && user.getId() != seller.getId())) {
                    %>
                    <p class="text-secondary">卖家：
                        <div class="d-flex flex-row justify-content-start p-0" style="background-color: #fff;">
                            <div class="card border-0" style="width: 250px;">
                                <div class="row no-gutters">
                                  <div class="col-3">
                                    <img class="m-2 rounded-circle" src="<%=basePath%>static/logo.svg" alt="user" style="width: 70%;">
                                  </div>
                                  <div class="col-9">
                                    <div class="card-body p-1 m-1">
                                        <p class="card-text m-0"><small><%=seller.getNickname() %></small><a href="#" class="badge badge-info ml-2 p-1">联系用户</a></p>
                                        <p class="card-text m-0"><small class="text-muted">共 5 件商品在出售</small></p>
                                    </div>
                                  </div>
                                </div>
                            </div>
                        </div>
                    </p>
                    <%
	            		}
                    %>
                </li>
                <li class="list-group-item">
                    <div class="d-flex flex-row">
                    	<%
                    		if (user == null || (user != null && user.getId() != seller.getId())) {
                    	%>
                    		<a href="#" class="btn btn-light border-danger my-2 mr-3 btn-lg" style="color: red; background-color: #fff;">立即购买</a>
                    		<%
                    			if (user != null) {
                    				Boolean inCart = (Boolean)request.getAttribute("inCart");
                    				if (inCart != null && inCart == true) {
                    		%>
                    				<a href="cart" class="btn btn-danger my-2 btn-lg">已加入购物车</a>
                    		<%
                    				} else {
                    		%>
                    				<a href="AddCartServlet?id=<%=goods.getId() %>" class="btn btn-danger my-2 btn-lg">加入购物车</a>
                    		<%
                    				}
                    			} else {
                    		%>
	                        	<a href="AddCartServlet?id=<%=goods.getId() %>" class="btn btn-danger my-2 btn-lg">加入购物车</a>
                    	<%
                    			}
                    		} else {
                    	%>
							<a href="#" class="btn btn-info my-2 mr-3">修改商品信息</a>
                        	<a href="DelGoodsServlet?id=<%=goods.getId() %>" class="btn btn-danger my-2">下架商品</a>
                    	<%
                    		}
                    	%>
                    </div>
                </li>
                </ul>
            </div>


        </div>

    </div>

    <jsp:include page="footer.jsp" />

</body>

</html>