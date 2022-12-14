<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pers.minho.util.*, java.util.*, pers.minho.entity.*"%>
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
    <!-- 导航栏 -->
<body>
	<jsp:include page="header.jsp" />

    <!-- 商品种类选择 -->
    <div class="container mt-5 p-0 border">
      <nav class="navbar navbar-light bg-light border">
        <span class="navbar-brand mb-0 display-3">想在敏拍找些什么？</span>
      </nav>
      <div class="d-flex justify-content-center">
          <div class="card hvr-grow-shadow m-2" style="width: 150px; height: 170px; background-color: #F0F1F1;">
            <img src="<%=basePath%>static/type_imgs/gadgets.png" class="card-img-top mt-3 mx-auto d-block" alt="..." style="width: 80px;">
            <div class="card-body mt-2">
              <p class="card-text text-center" style="font-size: large;">数码产品</p>
            </div>
          </div>
          <div class="card hvr-grow-shadow m-2" style="width: 150px; height: 170px; background-color: #F0F1F1;">
            <img src="<%=basePath%>static/type_imgs/clothes.png" class="card-img-top mt-3 mx-auto d-block" alt="..." style="width: 80px;">
            <div class="card-body mt-2">
              <p class="card-text text-center" style="font-size: large;">服饰鞋帽</p>
            </div>
          </div>
          <div class="card hvr-grow-shadow m-2" style="width: 150px; height: 170px; background-color: #F0F1F1;">
            <img src="<%=basePath%>static/type_imgs/books.png" class="card-img-top mt-3 mx-auto d-block" alt="..." style="width: 80px;">
            <div class="card-body mt-2">
              <p class="card-text text-center" style="font-size: large;">图书音像</p>
            </div>
          </div>
          <div class="card hvr-grow-shadow m-2" style="width: 150px; height: 170px; background-color: #F0F1F1;">
            <img src="<%=basePath%>static/type_imgs/handbag.png" class="card-img-top mt-3 mx-auto d-block" alt="..." style="width: 80px;">
            <div class="card-body mt-2">
              <p class="card-text text-center" style="font-size: large;">包表首饰</p>
            </div>
          </div>
          <div class="card hvr-grow-shadow m-2" style="width: 150px; height: 170px; background-color: #F0F1F1;">
            <img src="<%=basePath%>static/type_imgs/home.png" class="card-img-top mt-3 mx-auto d-block" alt="..." style="width: 80px;">
            <div class="card-body mt-2">
              <p class="card-text text-center" style="font-size: large;">家居生活</p>
            </div>
          </div>
          <div class="card hvr-grow-shadow m-2" style="width: 150px; height: 170px; background-color: #F0F1F1;">
            <img src="<%=basePath%>static/type_imgs/electric.png" class="card-img-top mt-3 mx-auto d-block" alt="..." style="width: 80px;">
            <div class="card-body mt-2">
              <p class="card-text text-center" style="font-size: large;">家用电器</p>
            </div>
          </div>
          <div class="card hvr-grow-shadow m-2" style="width: 150px; height: 170px; background-color: #F0F1F1;">
            <img src="<%=basePath%>static/type_imgs/beauty.png" class="card-img-top mt-3 mx-auto d-block" alt="..." style="width: 80px;">
            <div class="card-body mt-2">
              <p class="card-text text-center" style="font-size: large;">美容彩妆</p>
            </div>
          </div>
      </div>
    </div>

	<!-- 最新上架 -->
    <!-- 布局测试 -->
    <div class="container mt-5 p-0 border">
    	<nav class="navbar navbar-light bg-light border">
        	<span class="navbar-brand mb-0 display-3">最新上架</span>
      	</nav>

		<div class="row justify-content-md-center">
        	<%
        		List<Goods> goods = (List<Goods>)request.getAttribute("goodsList");
	    		Map<Integer, User> map = (Map<Integer, User>)request.getAttribute("userMap");
	    		for (Goods good : goods) {
        	%>
            <div class="card hvr-grow-shadow my-2 mx-2" style="width:210px;cursor:pointer;" onclick="window.location.href='<%=path%>/goods_info?goodsid=<%=good.getId() %>'">
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
        
		<div class="d-flex justify-content-center">
			<a class="btn btn-outline-light btn-lg border text-dark my-4" href="goods">浏览更多</a>
		</div>
	</div>

	<div class="copyright py-4 text-center text-body">
		<div class="container"><small>Copyright &copy; 敏拍二手 2022</small></div>
	</div>
	
</body>
</html>