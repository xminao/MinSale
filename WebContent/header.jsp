<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="container">
  <nav class="navbar navbar-expand-lg navbar-light border border-top-0 border-left-0 border-right-0 sticky-top" style="background-color: #fff;">
    <a class="navbar-brand mx-5" href="#">
        <img src="<%=basePath%>static/logo.svg" width="40" height="40" alt="">
    </a>
  
    <form class="form-inline my-2 my-lg-0 mr-auto">
    <input class="form-control mr-sm-2" type="search" placeholder="输入查找内容" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
    </form>

    <ul class="navbar-nav">
      <button class="btn btn-outline-light text-dark my-2 my-sm-0" onclick="window.location='register.jsp'">注册</button>
        <button class="btn btn-outline-light text-dark my-2 my-sm-0 mx-2" onclick="window.location='login.jsp'">登录</button>
        <button class="btn btn-danger my-2 my-sm-0 mx-2" onclick="window.location='put.jsp'">&emsp;出售&emsp;</button>
    </ul>
  </nav>
</div>