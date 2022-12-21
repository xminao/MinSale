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
	
    <!-- 我的信息 -->
    <div class="container mt-3 mb-5 p-0 d-flex flex-row">
      <div class="card" style="width: 200px">
        <ul class="list-group list-group-flush">
            <li class="list-group-item h4 font-weight-normal text-secondary text-center" style="font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                个人中心
            </li>
            <li type="button" class="list-group-item h5 text-light font-weight-light pl-4 py-3" style="background-color:#28A745;">
                <i class="bi bi-gear-fill text-light"></i>&emsp;我的信息
            </li>
            <li type="button" class="list-group-item h5 text-body font-weight-light pl-4 py-3" style="background-color: #fff;">
                <i class="bi bi-person-circle text-secondary"></i>&emsp;我的头像
            </li>
            <li type="button" class="list-group-item h5 text-body font-weight-light pl-4 py-3" style="background-color: #fff;" onclick="window.location.href='security'">
              <i class="bi bi-shield-lock-fill text-secondary"></i>&emsp;账号安全
            </li>
            <li type="button" class="list-group-item h5 text-body font-weight-light pl-4 py-3 border-bottom" style="background-color: #fff;">
              <i class="bi bi-clipboard-check-fill text-secondary"></i>&emsp;我的订单
            </li>
            <li type="button" class="list-group-item h5 text-body font-weight-light pl-4 py-3 border-bottom" style="background-color: #fff;">
              <i class="bi bi-bag-heart-fill text-secondary"></i>&emsp;我的商品
          </li>
        </ul>
      </div>

      <div class="card" style="width: 900px; height: 600px;">
  		<%
  			User user = (User)request.getAttribute("user");
  		%>
        <div class="card-body ml-4 mr-5 mt-3">
            <form action="personal">
              <div class="form-group row mb-4">
                <label for="inputNickname" class="col-sm-2 col-form-label text-right">用户名:</label>
                <div class="col-sm-4 p-2 ml-2">
                  <p class="text-secondary m-0"><%=user.getEmail() %></p>
                </div>
              </div>
              <div class="form-group row text-right mb-4">
                  <label for="inputNickname" class="col-sm-2 col-form-label text-right">昵称:</label>
                  <div class="col-sm-4">
                    <input class="form-control" id="inputNickname" name="new_nickname" value="<%=user.getNickname() %>">
                  </div>
              </div>
              <div class="form-group row mb-4">
                <label for="inputSign" class="col-sm-2 col-form-label text-right">个人签名:</label>
                <div class="col-sm-8">
                  <textarea class="form-control" placeholder="输入你的个性签名" id="inputSign" rows="3"></textarea>
                </div>
              </div>
              <div class="form-group row">
                <label for="checkSex" class="col-sm-2 col-form-label text-right">性别:</label>
                <div class="col-sm-4">
                  <button type="button" class="btn btn-info mr-3 py-1 px-2">男</button>
                  <button type="button" class="btn btn-light border mr-3 py-1 px-2">女</button>
                  <button type="button" class="btn btn-light border py-1 px-2">保密</button>
                </div>
              </div>

              <div class="text-center border-top my-4 pt-3">
                <button type="submit" class="btn btn-outline-success">保存</button>
              </div>

            </form>

        </div>
      </div>
 
    </div>
    
	<!-- 底部 -->
    <jsp:include page="footer.jsp" />

</body>

</html>