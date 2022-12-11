<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>注册 - 敏拍二手交易平台</title>
	<!-- 公共头 -->
	<jsp:include page="head.jsp" />
</head>

<body class="my-login-page">
	<%
		if(request.getAttribute("isRegister")!=null) {
	%>
	<div class="alert alert-danger" role="alert">
		<%
			if(!request.getAttribute("isEmail").equals("")) {
    			out.print(request.getAttribute("isEmail")+"<br />");
    		}
			if(!request.getAttribute("isExist").equals("")) {
				out.print(request.getAttribute("isExist")+"<br />");
			}
			if(!request.getAttribute("isPwd").equals("")) {
    			out.print(request.getAttribute("isPwd")+"<br />");
    		}
			if(!request.getAttribute("isPwdSame").equals("")) {
    			out.print(request.getAttribute("isPwdSame"));
			}
		%>
	</div>
	<%
		}
	%>
	
	<section class="h-100">
		<div class="container h-100">
			<div class="row justify-content-md-center h-100">
				<div class="card-wrapper">
					<div class="brand">
						<img src="<%=basePath%>static/logo.svg" alt="logo">
					</div>
					<div class="card fat">
						<div class="card-body">
							<h4 class="card-title">注册</h4>
							<form method="POST" class="my-login-validation" action="register">

								<div class="form-group">
									<label for="email">邮箱</label>
									<input id="email" type="email" class="form-control" name="inputEmail" required>
									<div class="invalid-feedback">
										Your email is invalid
									</div>
								</div>
								
								<div class="form-group">
									<label for="name">昵称</label>
									<input id="name" type="text" class="form-control" name="nickname" required autofocus>
									<div class="invalid-feedback">
										请输入你的昵称
									</div>
								</div>

								<div class="form-group">
									<label for="password">密码</label>
									<input id="password" type="password" class="form-control" name="inputPassword" required data-eye>
									<div class="invalid-feedback">
										请填写密码
									</div>
								</div>
								
								<div class="form-group">
									<label for="password">确认密码</label>
									<input id="password" type="password" class="form-control" name="inputPasswordConfirm" required data-eye>
									<div class="invalid-feedback">
										请确认密码
									</div>
								</div>

								<div class="form-group">
									<div class="custom-checkbox custom-control">
										<input type="checkbox" name="agree" id="agree" class="custom-control-input">
										<label for="agree" class="custom-control-label">我同意 <a href="#">敏拍二手交易平台用户协议</a></label>
										<div class="invalid-feedback">
											你需要点击同意协议才可以继续
										</div>
									</div>
								</div>

								<div class="form-group m-0">
									<button type="submit" class="btn btn-primary btn-block">
										立即注册
									</button>
								</div>
								<div class="mt-4 text-center">
									已经有敏拍账号? <a href="login.jsp">立即登录</a>
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

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		// 5秒后自动关闭提示
		window.setTimeout(function(){
		    $('[data-dismiss="alert"]').alert('close');
		}, 5000);
	</script>
</body>
</html>