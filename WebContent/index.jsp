<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pers.minho.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
  <title>敏拍 - 二手交易平台</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

    <!-- 导航栏 -->
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #eefafa;">
        <a class="navbar-brand mx-5" href="#">
            <img src="<%=basePath%>static/logo.svg" width="40" height="40" alt="">
        </a>
      
        <form class="form-inline my-2 my-lg-0 mr-auto">
	        <input class="form-control mr-sm-2" type="search" placeholder="输入查找内容" aria-label="Search">
	        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
        </form>

        <ul class="navbar-nav">
            <button class="btn btn-primary my-2 my-sm-0" onclick="window.location='login.jsp'">登录</button>
        </ul>
    </nav>

</body>
</html>