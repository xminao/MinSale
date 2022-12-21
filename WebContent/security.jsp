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

	<!-- 账户安全 -->
    <div class="container mt-3 mb-5 p-0 d-flex flex-row">
      <div class="card" style="width: 200px">
        <ul class="list-group list-group-flush">
            <li class="list-group-item h4 font-weight-normal text-secondary text-center" style="font-family:'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
                个人中心
            </li>
            <li type="button" class="list-group-item h5 text-body font-weight-light pl-4 py-3" style="background-color:#fff;" onclick="window.location.href='personal'">
                <i class="bi bi-gear-fill text-secondary"></i>&emsp;我的信息
            </li>
            <li type="button" class="list-group-item h5 text-body font-weight-light pl-4 py-3" style="background-color: #fff;">
                <i class="bi bi-person-circle text-secondary"></i>&emsp;我的头像
            </li>
            <li type="button" class="list-group-item h5 text-light font-weight-light pl-4 py-3" style="background-color: #28A745;">
              <i class="bi bi-shield-lock-fill text-light"></i>&emsp;账号安全
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
        <div class="card-body ml-4 mr-5 mt-3">
            <div class="d-flex flex-row border-bottom border-top p-4">
              <div style="width: 300px;">
                <i class="bi bi-check-circle-fill text-success"></i>&emsp;绑定邮箱
              </div>
              <div style="width: 300px;">
                已绑定
              </div>
              <div>
                <a href="#" style="text-decoration:none;">重新绑定</a>
              </div>
            </div>

            <div class="d-flex flex-row border-bottom p-4">
              <div style="width: 300px;">
                <i class="bi bi-check-circle-fill text-success"></i>&emsp;设置密码
              </div>
              <div style="width: 300px;">
                已设置
              </div>
              <div>
                <a href="#" style="text-decoration:none;">修改密码</a>
              </div>
            </div>

            <div class="d-flex flex-row border-bottom p-4">
              <div style="width: 300px;">
                <i class="bi bi-exclamation-circle-fill text-warning"></i>&emsp;绑定手机
              </div>
              <div style="width: 300px;">
                未绑定
              </div>
              <div>
                <a href="#" style="text-decoration:none;">绑定手机</a>
              </div>
            </div>

        </div>
      </div>
 
    </div>
    
	<!-- 底部 -->
    <jsp:include page="footer.jsp" />

</body>

</html>