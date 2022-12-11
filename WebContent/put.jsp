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
	<title>发布闲置 - 二手交易平台</title>
	<!-- 公共头 -->
	<jsp:include page="head.jsp" />
</head>

<body>
    <!-- 导航栏 -->
	<jsp:include page="header.jsp" />

    <div class="container my-2">
        <form method="POST" action="put">
            <ul class="nav nav-tabs justify-content-center" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                  <a class="nav-link active" id="info-tab" data-toggle="tab" href="#info" role="tab" aria-controls="info" aria-selected="true">物品信息</a>
                </li>
                <li class="nav-item" role="presentation">
                  <a class="nav-link" id="image-tab" data-toggle="tab" href="#image" role="tab" aria-controls="image" aria-selected="false">物品图片</a>
                </li>
                <li class="nav-item" role="presentation">
                  <a class="nav-link" id="put-tab" data-toggle="tab" href="#put" role="tab" aria-controls="put" aria-selected="false">发布物品</a>
                </li>
            </ul>
            <div class="tab-content" id="myTabContent">
                <div class="tab-pane fade show active" id="info" role="tabpanel" aria-labelledby="info-tab">
                    <div class="d-flex justify-content-center">
                        <div class="my-5" style="width: 600px;">
                            <div class="form-group">
                                <label for="selectType">物品分类</label>
                                <select class="custom-select" id="selectType" name="selectType" required autofocus>
                                    <option value="">请选择</option>
                                    <option value="1">数码产品</option>
                                    <option value="2">服饰鞋帽</option>
                                    <option value="3">图书音像</option>
                                    <option value="4">包表首饰</option>
                                    <option value="5">家居生活</option>
                                    <option value="6">家用电器</option>
                                    <option value="7">美容彩妆</option>
                                </select>
                            </div>
        
                            <div class="form-group">
                                <label for="inputTitle">发布标题</label>
                                <input type="text" maxlength="20" class="form-control" id="inputTitle" placeholder="输入标题" name="inputTitle" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="inputDesc">物品描述</label>
                                <textarea class="form-control" id="inputDesc" rows="3" name="inputDesc" required></textarea>
                            </div>
        
                            <div class="form-group">
                                <label for="inputPrice">出售价格</label>
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">￥</span>
                                    </div>
                                    <input type="number" class="form-control" min="1" max="999999" step="0.01" id="inputPrice" name="inputPrice" required>
                                    </div>
                            </div>
        
                            <div class="form-group m-auto" style="width: 100px;">
                                <button type="button" class="btn btn-outline-primary btn-block" onclick="toStep('image')">
                                    下一步
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
    
                <div class="tab-pane fade" id="image" role="tabpanel" aria-labelledby="image-tab">
                    <div class="d-flex flex-column justify-content-center">
                        <div class="jumbotron my-5 mx-auto border border-info text-center" style="width: 400px; height: 300px; background-color: #CCE9E4;">
                            <img src="<%=basePath%>static/add_img.png" class="mx-auto d-block" alt="..." style="width: 80px;">
                            <div class="form-group my-2">
                                <input type="button" id="i-check" value="上传照片" class="btn btn-primary" onclick="$('#i-file').click();">
							    <input type="file" name="file" id='i-file'  accept=".png, .jpg" onchange="$('#location').val($('#i-file').val());" style="display: none">
                            </div>
                        </div>
                        <div class="m-auto" style="width: 100px;">
                            <button type="button" class="btn btn-outline-primary btn-block" onclick="toStep('put')">
                                下一步
                            </button>
                        </div>
                    </div>
                </div>
    
                <div class="tab-pane fade" id="put" role="tabpanel" aria-labelledby="put-tab">
                    <div class="d-flex flex-column justify-content-center">
                        <div class="mx-auto my-4" style="width: 100px;">
                            <button type="submit" class="btn btn-outline-primary btn-block">
                                发布
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>

        <div class="d-flex justify-content-center">

        </div>
    </div>
</body>

<script>
    function toStep(arg) {
        let inputTitle = document.getElementById("inputTitle")
        let selectType = document.getElementById("selectType")
        let inputDesc = document.getElementById("inputDesc")
        let inputPrice = document.getElementById("inputPrice")
        if (arg === "image") {
            if (inputTitle.value !== "" && selectType.value !== "" && inputDesc.value !== "" && inputPrice.value !== "") {
                $('#myTab a[href="#image"]').tab('show')
            } else {
            	alert("请完整填写")
            }
        } else if (arg === "put") {
            $('#myTab a[href="#put"]').tab('show')
        }
    }

</script>
</html>