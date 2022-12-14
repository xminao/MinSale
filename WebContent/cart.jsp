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
    
    <!-- 商品页面 -->
    <div class="container mt-5 p-0 border" style="background-color: #fff;">
        <!-- 标题头 -->
        <nav class="navbar navbar-light bg-light border">
            <span class="navbar-brand mb-0 display-3">我的购物车</span>
        </nav>

        <!-- 购物车 -->
        <%
	        Map<Integer, Goods> goods_map = (Map<Integer, Goods>)request.getAttribute("cartMap"); 
			Set<Map.Entry<Integer, Goods>> set = goods_map.entrySet();
			double countPrice = 0;
        %>
        <div class="card m-2 border">
            <ul class="list-group list-group-flush">
            	<%
                    for (Map.Entry entry : set) {
                    	Goods good = (Goods)entry.getValue();
                    	countPrice += good.getPrice();
            	%>
                <li class="list-group-item d-flex flex-row p-2" style="height: 200px;background-color: #fff;">
                    <!-- 选择框 -->
                    <div class="card mr-2 p-4 border-0" style="width: 5%;">
                        <div class="form-check mt-5">
                            <input class="good-check form-check-input position-static" style="scale: 1.8;" type="checkbox" id="blankCheckbox" value="option1">
                        </div>
                    </div>
                    <!-- 商品信息 -->
                    <div class="card d-flex flex-row ml-0 border-top-0 border-bottom-0 border-left-0" style="width: 80%; height: 100%; cursor:pointer;" onclick="window.location.href='<%=path%>/goods_info?goodsid=<%=good.getId() %>'">
                        <div class="card d-flex flex-row border-0 m-3">
                            <!-- 商品图片 -->
                            <img class="card-img-top mr-3" src="<%=good.getImg() %>" alt="图片走丢啦" style="width: 150px; height: 150px;">
                            <!-- 文字信息 -->
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item text-dark h4" style="background-color: #fff;"><%=good.getName() %></li>
                                <li class="list-group-item border-0" style="background-color: #fff;">
                                    售价：
                                    <span class="h4"><span class="h5">￥<span class="good-price"><%=good.getPrice() %></span>
                                </li>
                                <li class="list-group-item border-0 pt-0" style="background-color: #fff;">
                                    <span class="badge badge-info">联系卖家</span>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <!-- 商品操作 -->
                    <div class="card ml-2 border-0" style="width: 15%;">
                        <div class="card-body text text-center mt-5">
                            <a href="DelCartServlet?delId=<%=entry.getKey() %>" class="btn btn-danger" for="customCheck1">删除</a>
                        </div>
                    </div>
                </li>
                <%
                	}
                %>
            </ul>

            <!-- 底部结算 -->
            <nav class="navbar navbar-light justify-content-between mt-3 border" style="background-color: #fff;">
                <div class="form-check ml-2">
                    <input class="form-check-input position-static" style="scale: 1.2;" type="checkbox" id="selectAll" value="option1">
                    <a class="navbar-brand ml-2" for="selectAll">全选</a>
                </div>
                <div class="d-flex flex-row">
                    <p class="h5 mr-4 mt-2 text-secondary">已选择 <span class="text-danger" id="amount">0</span> 件商品</p>
                    <p class="h5 mt-2 text-secondary">共计￥</p>
                    <p class="h3 mr-5 text-danger" id="total-price">0</p>
                    <button class="btn btn-outline-success mr-1" type="submit">结算</button>
                </div>
            </nav>
        </div>

        <div class="d-flex flex-row justify-content-center">

        </div>

    </div>

  <div class="copyright py-4 text-center text-body">
    <div class="container"><small>Copyright &copy; 敏拍二手 2022</small></div>
  </div>

</body>

<script>
	var amount = 0;
	var totalPrice = 0;
	var checks = document.querySelectorAll(".good-check");
	var prices = document.querySelectorAll(".good-price");
	var selectAll = document.getElementById("selectAll")
	
	function total() {
	    amount = 0;
	    totalPrice = 0;
	    for (let i=0; i< checks.length; i++) {
	        if (checks[i].checked === true) {
	            amount += 1;
	            totalPrice += Number(prices[i].textContent);
	        }
	        document.getElementById('amount').innerHTML = amount;
	        document.getElementById('total-price').innerHTML = totalPrice;
	    }
	
	    if (amount === checks.length) {
	        selectAll.checked = true
	    } else {
	        selectAll.checked = false
	    }
	}
	
	for (let i=0; i< checks.length; i++) {
	    checks[i].addEventListener("click", function () {
	        total()
	    })
	}
	
	selectAll.addEventListener("click", function() {
	    if (selectAll.checked === true) {
	        for (let i=0; i<checks.length; i++) {
	            checks[i].checked = true
	        }
	    } else {
	        for (let i=0; i<checks.length; i++) {
	            checks[i].checked = false
	        }
	    }
	    total()
	})
</script>

</html>