<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/doc.min.css">
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
            <div><a class="navbar-brand" style="font-size:32px;" href="user.html">医疗预约平台</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-user"></i> ${loginUser.uname }<span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/loginout"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
					  </ul>
			    </div>
			</li>
            <li style="margin-left:10px;padding-top:8px;">
				<button type="button" class="btn btn-default btn-danger">
					<a href="${APPPATH}/help.jsp" style="color: white"> <span class="glyphicon glyphicon-question-sign"></span> 帮助</a>
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
			<div class="tree">
				<%@ include file="../menu.jsp" %>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<ol class="breadcrumb">
				  <li><a href="#">首页</a></li>
				  <li><a href="#">数据列表</a></li>
				  <li class="active">新增</li>
				</ol>
			<div class="panel panel-default">
              <div class="panel-heading">表单数据<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
			  <div class="panel-body">
				<form role="form" id="saveForm">
				  <div class="form-group">
					<label for="exampleInputPassword1">队列序号</label>
					 <select name="queueId" class="form-control">
						  <c:forEach items="${queueList}" var="queue">
							  <option value="${queue.queueId}">${queue.queueNum}</option>
						  </c:forEach>
					 </select><br/>
					 <label for="exampleInputPassword1">医技组名称</label>
					  <select name="skillgroupId" class="form-control">
						  <c:forEach items="${skillgroupList}" var="skillgroup">
							  <option value="${skillgroup.skillgroupId}">${skillgroup.skillgroupName}</option>
						  </c:forEach>
					  </select><br/>
					<label for="exampleInputPassword1">号源池类型</label>
					  <select name="typeId"  class="form-control">
						  <c:forEach items="${sourcetypeList}" var="sourcetype">
						  <option value="${sourcetype.typeId}">${sourcetype.typeName}</option>
						  </c:forEach>
					  </select><br/>
					  <label for="exampleInputPassword1">号源池数量</label>
					  <input type="text" class="form-control" id="sourceNum" name="sourceNum" placeholder="请输入号源池数量">
				  </div>
				  <button type="button" id="btnSave" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> 新增</button>
				  <button type="button" id="btnReset" class="btn btn-danger"><i class="glyphicon glyphicon-refresh"></i> 重置</button>
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
		</div>
	  </div>
	</div>
    <script src="${pageContext.request.contextPath}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/script/docs.min.js"></script>
	<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
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
				$("#btnReset").click(function(){
					$("#sourceNum").val("");
				});
			    $("#btnSave").click(function(){
			    	var sourceNumVal = $("#sourceNum").val();
			    	if(sourceNumVal==""){
			    		layer.msg("号源池数量不能为空!", {time:1000, icon:0, shift:5}, function(){});
			    		return;
			    	}
			    	$.ajax({
			    		url:"${pageContext.request.contextPath}/source/addSource",
			    		type:"post",
			    		data:$("#saveForm").serialize(),
			    		success:function(result){
			    			if(result.flag){
			    				layer.msg("新增成功!", {time:1000, icon:0, shift:6}, function(){});
								window.location.href='${pageContext.request.contextPath}/source/sourceList';
			    			}else{
			    				layer.msg("新增失败!", {time:1000, icon:0, shift:5}, function(){});
			    			}
			    		}
			    	});
			    });
            });
        </script>
  </body>
</html>
