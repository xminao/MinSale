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
	<jsp:include page="header.jsp" />

    <!-- 商品种类选择 -->
    <div class="container">
      <h5 class="mx-2 my-3">想在敏拍找些什么？</h5>
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
    <div class="container mt-5">
        <h5 class="mx-2 my-4">最新上架</h5>
        <div class="d-flex justify-content-center">
        	<%
        		List<Goods> goods = (List<Goods>)request.getAttribute("goodsList");
        		Map<Integer, User> map = (Map<Integer, User>)request.getAttribute("userMap");
        		for (Goods good : goods) {
        	%>
        	<div class="card hvr-grow-shadow m-2" style="width:210px">
                <div class="card-header py-1">
                  <p class="card-text m-0"><small><%=map.get(good.getSeller_id()).getNickname() %></small></p>
                  <p class="card-text m-0"><small class="text-muted"><%=good.getCreate_date() %></small></p>
                </div>
                <img class="card-img-top my-2 mx-auto d-block" src="<%=good.getImg()%>" alt="Card image" style="width:190px;">
                <div class="card-body py-2 px-3">
                  <h5 class="card-title text-dark font-weight-light"><%=good.getDesc() %></h5>
                  <p class="card-text"><h6 class="font-weight-bold">￥<%=good.getPrice() %></h6></p>
                  <p class="card-text"><small class="text-muted">八成新</small></p>
                </div>
            </div>
        	<%
        		}
        	%>
        </div>

        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-end m-2">
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
        </nav>
    </div>
    
    <!-- 最新上架 -->
    <div class="container mt-5">
        <h5 class="mx-2 my-4">最新上架</h5>
        <div class="d-flex justify-content-center">
            <div class="card hvr-grow-shadow m-2" style="width:210px">
                <div class="card-header py-1">
                  <p class="card-text m-0"><small>刀哥</small></p>
                  <p class="card-text m-0"><small class="text-muted">5 天前上架</small></p>
                </div>
                <img class="card-img-top my-2 mx-auto d-block" src="<%=basePath%>static/goods_imgs/jyt.png" alt="Card image" style="width:190px;">
                <div class="card-body py-2 px-3">
                  <h5 class="card-title text-dark font-weight-light">头开过的机油桶</h5>
                  <p class="card-text"><h6 class="font-weight-bold">￥98.0</h6></p>
                  <p class="card-text"><small class="text-muted">八成新</small></p>
                </div>
            </div>
            <div class="card hvr-grow-shadow m-2" style="width:210px">
              <div class="card-header py-1">
                <p class="card-text m-0"><small>刀哥</small></p>
                <p class="card-text m-0"><small class="text-muted">5 天前上架</small></p>
              </div>
              <img class="card-img-top my-2 mx-auto d-block" src="<%=basePath%>static/goods_imgs/rsd.png" alt="Card image" style="width:190px;">
              <div class="card-body py-2 px-3">
                  <h5 class="card-title text-dark font-weight-light">热水袋</h4>
                <p class="card-text"><h6 class="font-weight-bold">￥62.0</h6></p>
                <p class="card-text"><small class="text-muted">六成新</small></p>
              </div>
            </div>
            <div class="card hvr-grow-shadow m-2" style="width:210px">
              <div class="card-header py-1">
                <p class="card-text m-0"><small>虎哥</small></p>
                <p class="card-text m-0"><small class="text-muted">5 天前上架</small></p>
              </div>
              <img class="card-img-top my-2 mx-auto d-block" src="<%=basePath%>static/goods_imgs/zt.png" alt="Card image" style="width:190px;">
              <div class="card-body py-2 px-3">
                  <h5 class="card-title text-dark font-weight-light">两个砖头</h4>
                <p class="card-text"><h6 class="font-weight-bold">￥22.0</h6></p>
                <p class="card-text"><small class="text-muted">二成新</small></p>
              </div>
            </div>
            <div class="card hvr-grow-shadow m-2" style="width:210px">
              <div class="card-header py-1">
                <p class="card-text m-0"><small>刀哥</small></p>
                <p class="card-text m-0"><small class="text-muted">5 天前上架</small></p>
              </div>
              <img class="card-img-top my-2 mx-auto d-block" src="<%=basePath%>static/goods_imgs/xb.png" alt="Card image" style="width:190px;">
              <div class="card-body py-2 px-3">
                  <h5 class="card-title text-dark font-weight-light">三瓶雪碧</h4>
                <p class="card-text"><h6 class="font-weight-bold">￥33.0</h6></p>
                <p class="card-text"><small class="text-muted">八成新</small></p>
              </div>
            </div>
            <div class="card hvr-grow-shadow m-2" style="width:210px">
              <div class="card-header py-1">
                <p class="card-text m-0"><small>刀哥</small></p>
                <p class="card-text m-0"><small class="text-muted">5 天前上架</small></p>
              </div>
              <img class="card-img-top my-2 mx-auto d-block" src="<%=basePath%>static/goods_imgs/pig.png" alt="Card image" style="width:190px;">
              <div class="card-body py-2 px-3">
                  <h5 class="card-title text-dark font-weight-light">一头猪</h4>
                <p class="card-text"><h6 class="font-weight-bold">￥5888.0</h6></p>
                <p class="card-text"><small class="text-muted">八成新</small></p>
              </div>
            </div>
        </div>

        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-end m-2">
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
              <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </ul>
        </nav>
    </div>
</body>
</html>