<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${ItemPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ItemPath}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${ItemPath}/css/main.css">
	<link rel="stylesheet" href="${ItemPath}/css/doc.min.css">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	</style>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="sourceType.html">医疗预约平台</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">

					<i class="glyphicon glyphicon-sourceType"></i> ${loginUser.uname } <span class="caret"></span>

					<i class="glyphicon glyphicon-user">${loginUser.uname}</i><span class="caret"></span>

				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="${ItemPath}/logout"><i class="glyphicon glyphicon-off"></i>退出系统</a></li>
					  </ul>
			    </div>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
				  <span class="glyphicon glyphicon-question-sign"></span> 帮助
				</button>
			</li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">

        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
				  <li><a href="#">首页</a></li>
				  <li><a href="#">科室信息</a></li>
				  <li class="active">新增科室</li>
				</ol>
			<div class="panel panel-default">
              <div class="panel-heading">科室数据<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
			  <div class="panel-body">
				<form role="form">
				  <div class="form-group">

					<label >医技组</label>
					  <SELECT name="skillgroup.skillgroupId">
						  <c:forEach items="${skillgroupList }" var="skillgroup">
							  <option value='${skillgroup.skillgroupId }'>
									  ${skillgroup.skillgroupName }</option>
						  </c:forEach>
					  </SELECT>
				  </div>
				  <div class="form-group">
					  <label >日期</label>
					<input type="date"  date-date-format="yyyy-mm-dd" id="date" name="date">
				  </div>
					<div class="form-group">
					  	<label >开始时间</label>
						<input type="String" class="form-control" date-date-format="yyyy-mm-dd" id="datestart" name="datestart">
					</div>
					<div class="form-group">
					  <label >结束时间</label>
					  <input type="String" class="form-control" date-date-format="yyyy-mm-dd" id="datelast" name="datelast">
					</div>


				  <button type="button" id="btnSave" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> 新增</button>

					<div class="form-group">
					<label for="exampleInputPassword1">科室名称</label>
					<input type="text" id="aroomName" name="aroomName" class="form-control"  placeholder="请输入科室名称">
				  </div>
				  <div class="form-group">
					<label for="exampleInputPassword1">科室编号</label>
					<input type="text" id="aroomCode" name="aroomCode" class="form-control"  placeholder="请输入科室编号">
				  </div>
				  <div class="form-group">
					<label for="exampleInputEmail1">科室地址</label>
					<input type="email" id="aroomAddr" name="aroomAddr" class="form-control" placeholder="请输入科室地址">
				  </div>
				  <button type="button" id="btnAroomAdd" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i>确定新增</button>
				  <button type="button" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 重置</button>

				</form>
			  </div>
			</div>
        </div>
      </div>
    </div>
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
		<div class="modal-content">
		  <div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
			<h4 class="modal-title" id="myModalLabel">帮助</h4>
		  </div>
		  <div class="modal-body">
			<div class="bs-callout bs-callout-info">
				<h4>测试标题1</h4>
				<p>测试内容1，测试内容1，测试内容1，测试内容1，测试内容1，测试内容1</p>
			  </div>
			<div class="bs-callout bs-callout-info">
				<h4>测试标题2</h4>
				<p>测试内容2，测试内容2，测试内容2，测试内容2，测试内容2，测试内容2</p>
			  </div>
		  </div>
		  <!--
		  <div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="button" class="btn btn-primary">Save changes</button>
		  </div>
		  -->
		</div>
	  </div>
	</div>
    <script src="${ItemPath}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${ItemPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${ItemPath}/script/docs.min.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
				    if ( $(this).find("ul") ) {
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});

			    $("#btnSave").click(function(){
			    	var datelast = $("#datelast").val();

			    	if(datelast==""){
			    		layer.msg("开始时间不能为空!", {time:1000, icon:0, shift:5}, function(){});
			    		return;
			    	}
					var datestart = $("#datestart").val();

					if(datestart==""){
						layer.msg("结束时间不能为空!", {time:1000, icon:0, shift:5}, function(){});
						return;
					}

			    	$.ajax({

			    		url:"${APPPATH}/schedule/save",
			    		type:"post",
			    		data:$("#saveForm").serialize(),
			    		success:function(result){
			    			if(result.flag){
			    				layer.msg("新增成功!", {time:1000, icon:0, shift:6}, function(){});
			    				window.location.href="${APPPATH}/schedule/index";
			    			}else{
			    				layer.msg("新增失败!", {time:1000, icon:0, shift:5}, function(){});
			    			}
			    		}
			    	});
			    });

				$("#btnAroomAdd").click(function() {
					//alert("1222");
					$.ajax({
						url:"${APPPATH}/aroom/aroomAdd",
						type:"post",
						data:{"aroomName":$("#aroomName").val(),"aroomCode":$("#aroomCode").val(),"aroomAddr":$("#aroomAddr").val()},
						success:function(result){
							window.location.href = "${APPPATH}/aroom/aroomListByPage";
						}
					});
				});

            });
        </script>
  </body>
</html>
