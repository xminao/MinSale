<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pers.minho.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>暂时的主页</title>
</head>
<body>
	<%
		if(UserUtil.isLogined(request)) {
			out.print("<div class=\"alert alert-danger alert-dismissable\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\"aria-hidden=\"true\">&times;</button>自动登录成功</div>");
		}
	%>
	<h2>登录成功了</h2>
</body>
</html>