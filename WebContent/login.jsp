<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>登录 - 敏拍二手交易平台</title>
	<!-- 公共头 -->
	<jsp:include page="head.jsp" />
</head>

<body class="my-login-page">

	<%
		if(request.getAttribute("isLoginOk") != null && request.getAttribute("isLoginOk").equals("false")) {
			out.print("<div class=\"alert alert-danger alert-dismissable\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\"aria-hidden=\"true\">&times;</button>登录失败，请检查邮箱和密码</div>");
		}
	%>
	
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<a href="index">
							<img src="<%=basePath%>static/logo.svg" alt="logo">
						</a>
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title">登录</h4>
							<form method="POST" class="my-login-validation" action="login">
								<div class="form-group">
									<label for="email">邮箱</label>
									<input id="email" type="email" class="form-control" name="inputEmail" value="" required autofocus>
									<div class="invalid-feedback">
										邮箱格式错误
									</div>
								</div>

								<div class="form-group">
									<label for="password">密码
										<a href="forgot.html" class="float-right">
											忘记密码?
										</a>
									</label>
									<input id="password" type="password" class="form-control" name="inputPassword" required data-eye>
								    <div class="invalid-feedback">
								    	请填写密码
							    	</div>
								</div>

								<div class="form-group">
									<div class="custom-checkbox custom-control">
										<input type="checkbox" name="autoLogin" id="remember" class="custom-control-input">
										<label for="remember" class="custom-control-label">记住我</label>
									</div>
								</div>

								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block">
										点击登录
									</button>
								</div>
								<div class="mt-4 text-center">
									还没有敏拍账号? 
									<a href="register.jsp">立即注册</a>
								</div>
							</form>
						</div>
					</div>
					<div class="footer">
						Copyright &copy; 2022 &mdash; Minho 
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		// 5秒后自动关闭提示
		window.setTimeout(function(){
		    $('[data-dismiss="alert"]').alert('close');
		}, 5000);
	</script>
</body>
</html>
