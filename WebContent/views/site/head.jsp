<%/* 公共<head> */%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=basePath%>views/src/bootstrap3/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=basePath%>views/src/css/main.css" rel="stylesheet">
<script src="<%=basePath%>views/src/jquery2/jquery.min.js"></script>
<script src="<%=basePath%>views/src/bootstrap3/js/bootstrap.min.js"></script>
