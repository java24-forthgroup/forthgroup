<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<link rel="stylesheet" href="${APPPATH }/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APPPATH }/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APPPATH }/css/main.css">
	<link rel="stylesheet" href="${APPPATH }/css/doc.min.css">
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
					<i class="glyphicon glyphicon-user"></i> ${loginUser.uname } <span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="${APPPATH }/logout"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
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
				  <li><a href="${APPPATH}/main">首页</a></li>
				  <li><a href="${APPPATH }/user/index">数据列表</a></li>
				  <li class="active">分配角色</li>
				</ol>
			<div class="panel panel-default">
			  <div class="panel-body">
				<form role="form" class="form-inline" id="assignRoleForm">
					<input type="hidden" id="userId" name="userId" value="${userId }" />
				  <div class="form-group">
					<label for="exampleInputPassword1">未分配角色列表</label><br>
					<select id="left" name="leftRids" class="form-control" multiple size="10" style="width:100px;overflow-y:auto;">
                        <c:forEach items="${unAssignRoles}" var="role">
                        	<option value="${role.roleId}">${role.roleName }</option>
                        </c:forEach>
                    </select>
				  </div> 
				  <div class="form-group">
                        <ul>
                            <li class="btn btn-default glyphicon glyphicon-chevron-right" onclick="leftToRight()" ></li>
                            </br>
                            <li class="btn btn-default glyphicon glyphicon-chevron-left"  onclick="rightToLeft()" style="margin-top: 50px;"></li>
                        </ul>
				  </div>
				  <div class="form-group" style="margin-left:40px;">
					<label for="exampleInputPassword1">已分配角色列表</label><br>
					<select id="right" name="rightRids" class="form-control" multiple size="10" style="width:100px;overflow-y:auto;">
	                     <c:forEach items="${assignRoles}" var="role">
	                        	<option value="${role.roleId }">${role.roleName}</option>
	                     </c:forEach>
                    </select>
				  </div>
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
		</div>
	  </div>
	</div>
    <script src="${APPPATH }/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APPPATH }/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APPPATH }/script/docs.min.js"></script>
	<script src="${APPPATH }/layer/layer.js"></script>
        <script type="text/javascript">
	        function leftToRight(){
	        	var leftOption = $("#left option");
	        	for(var i=0;i<leftOption.length;i++){
	        		if(leftOption.eq(i).prop("selected")){
	        			$("#right").append(leftOption.eq(i));
	        		}
	        	}
	        	
	        	$.ajax({
		    		url:"${APPPATH}/emp/assignRoleDo",
		    		type:"post",
		    		data:$("#assignRoleForm").serialize(),
		    		success:function(result){
		    			if(result.flag){
		    				layer.msg("新增成功!", {time:1000, icon:6, shift:6}, function(){});
		    			}else{
		    				layer.msg("新增失败!", {time:1000, icon:5, shift:5}, function(){});
		    			}
		    		}
		    	});
	        }
	        function rightToLeft(){
	        	var rightOption = $("#right option");
	        	for(var i=0;i<rightOption.length;i++){
	        		if(rightOption.eq(i).prop("selected")){
	        			$("#left").append(rightOption.eq(i));
	        		}
	        	}
	        	
	        	$.ajax({
		    		url:"${APPPATH}/emp/removeRole",
		    		type:"post",
		    		data:$("#assignRoleForm").serialize(),
		    		success:function(result){
		    			if(result.flag){
		    				layer.msg("取消成功!", {time:1000, icon:6, shift:6}, function(){});
		    			}else{
		    				layer.msg("取消失败!", {time:1000, icon:5, shift:5}, function(){});
		    			}
		    		}
		    	});
	        }
	        
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
			    
            });
            
        </script>
  </body>
</html>
