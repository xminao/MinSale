<%@page import="org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pers.minho.util.*, pers.minho.entity.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<nav class="navbar navbar-expand-lg navbar-light border border-top-0 border-left-0 border-right-0 sticky-top" style="background-color: #fff;">
	    <a class="navbar-brand mx-5" href="<%=path%>/index">
	        <img src="<%=basePath%>static/logo.svg" width="40" height="40" alt="">
	    </a>
	  
	    <form class="form-inline my-2 my-lg-0 mr-auto">
		    <input class="form-control mr-sm-2" type="search" placeholder="输入查找内容" aria-label="Search">
		    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
	    </form>
	
	<%
		HttpSession ses = request.getSession();
		if (UserUtil.isLogined(request)) {
			User user = (User)ses.getAttribute("loginUser");
	%>
		<div class="dropdown show">
		          <a class="nav-item nav-link dropdown-toggle border-0" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="background: transparent; color: #000000;">
		            <%=user.getNickname()%>
		          </a>
		   
		          <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
		            <a class="dropdown-item" href="#">个人中心</a>
		            <a class="dropdown-item" href="LoginOutServlet">登出</a>
		          </div>
		</div>
	<% 
		} else {
	%>
	    <ul class="navbar-nav">
	      	<a class="btn btn-outline-light text-dark mx-2 my-2 my-sm-0" href="register.jsp">注册</a>
	        <a class="btn btn-outline-light text-dark mx-2 my-2 my-sm-0" href="login.jsp">登录</a>
	    </ul>
	<%
		}
	%>
	    <ul class="navbar-nav">
	        <a class="btn btn-danger my-2 my-sm-0 mx-2" href="put.jsp">&emsp;出售&emsp;</a>
	    </ul>
	</nav>