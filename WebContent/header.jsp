<%@page import="org.eclipse.jdt.internal.compiler.parser.RecoveredRequiresStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pers.minho.util.*, pers.minho.entity.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<nav class="navbar navbar-expand-lg navbar-light border border-top-0 border-left-0 border-right-0 sticky-top" style="background-color: #fff;" id="mainNav">
	    <a class="navbar-brand mx-5" href="<%=path%>/index">
	        <img id="logo" src="<%=basePath%>static/logo.svg" width="40" height="40" alt="">
	    </a>
	  
	    <form class="form-inline my-2 my-lg-0 mr-auto">
		    <input class="form-control mr-sm-2" type="search" placeholder="输入查找内容" aria-label="Search">
		    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
	    </form>
	
	<%
		HttpSession ses = request.getSession();
		if (UserUtil.isLogined(request)) {
			User user = (User)ses.getAttribute("loginUser");
			int cartAmount = (Integer)ses.getAttribute("cartAmount");
	%>
		<a class="navbar-brand mx-3" href="cart">
            <img class="" src="<%=basePath%>static/cart.png" width="25" height="25" alt="">
            <%
            	if (cartAmount != 0) {
            %>
            	<span class="badge badge-pill badge-danger py-0 px-1"><%=cartAmount %></span>
            <%
            	}
            %>
        </a>

        <a class="navbar-brand mx-3" href="#">
            <img class="" src="<%=basePath%>static/chat.png" width="25" height="25" alt="">
            <span class="badge badge-pill badge-danger py-0 px-1">0</span>
        </a>
        
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
	      	<a class="btn btn-outline-light text-dark mx-2 my-2 my-sm-0" href="register">注册</a>
	        <a class="btn btn-outline-light text-dark mx-2 my-2 my-sm-0" href="login">登录</a>
	    </ul>
	<%
		}
	%>
	    <ul class="navbar-nav">
	        <a class="btn btn-success my-2 my-sm-0 mx-2" href="put">&emsp;出售&emsp;</a>
	    </ul>
	</nav>
	
	<!-- 导航栏变化 -->
	<script>
        window.addEventListener('DOMContentLoaded', event => {
          // Navbar shrink function
          var navbarShrink = function () {
              const navbarCollapsible = document.body.querySelector('#mainNav');
              if (!navbarCollapsible) {
                  return;
              }
              if (window.scrollY === 0) {
                  navbarCollapsible.classList.remove('navbar-shrink')
              } else {
                  navbarCollapsible.classList.add('navbar-shrink')
              }

          };

          navbarShrink();

          document.addEventListener('scroll', navbarShrink);

          const mainNav = document.body.querySelector('#mainNav');
          if (mainNav) {
              new bootstrap.ScrollSpy(document.body, {
                  target: '#mainNav',
                  offset: 72,
              });
          };

          const navbarToggler = document.body.querySelector('.navbar-toggler');
          const responsiveNavItems = [].slice.call(
              document.querySelectorAll('#navbarResponsive .nav-link')
          );
          responsiveNavItems.map(function (responsiveNavItem) {
              responsiveNavItem.addEventListener('click', () => {
                  if (window.getComputedStyle(navbarToggler).display !== 'none') {
                      navbarToggler.click();
                  }
              });
          });

          });
      </script>