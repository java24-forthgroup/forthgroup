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

	<link rel="stylesheet" href="${APPPATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APPPATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APPPATH}/css/main.css">
	<link rel="stylesheet" href="${APPPATH}/css/doc.min.css">
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
					<i class="glyphicon glyphicon-user">${loginUser.uname}</i><span class="caret"></span>
				  </button>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
						<li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
						<li class="divider"></li>
						<li><a href="${APPPATH}/logout"><i class="glyphicon glyphicon-off"></i>退出系统</a></li>
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
			<%@ include file="../menu.jsp" %>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
				</div>
				<div class="panel-body">
			<div class="panel panel-default">
              <div class="panel-heading">数据列表<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
			  <div class="panel-body">

				  <form role="form" id="updForm">
					  <div class="form-group">
						  <label >医技组</label>
						  <input type="hidden"  id="scheduleId" name="scheduleId" value="${schedule.scheduleId}">
						  <SELECT name="skillgroup.skillgroupId">
							  <c:forEach items="${skillgroupList }" var="skillgroup">
								  <option value='${skillgroup.skillgroupId }'
										  <c:if test="${skillgroup.skillgroupId==schedule.skillgroup.skillgroupId }"> selected="selected" </c:if>>
										  ${skillgroup.skillgroupName }</option>
							  </c:forEach>
						  </SELECT>
					  </div>
					  <div class="form-group">
						  <label >日期</label>
						  <input type="date"  date-date-format="yyyy-mm-dd" id="date" name="date" value="${schedule.date}">
					  </div>
					  <div class="form-group">
						  <label >开始时间</label>
						  <input type="String" class="form-control" date-date-format="yyyy-mm-dd" id="datestart" name="datestart" value="${schedule.datestart}">
					  </div>
					  <div class="form-group">
						  <label >结束时间</label>
						  <input type="String" class="form-control" date-date-format="yyyy-mm-dd" id="datelast" name="datelast" value="${schedule.datelast}">
					  </div>


					  <button type="button" id="btnUpdate" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> 修改</button>

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

    <script src="${APPPATHPath}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APPPATHPath}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APPPATHPath}/script/docs.min.js"></script>
	<script src="${APPPATH }/layer/layer.js"></script>

    <script src="${APPPATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APPPATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APPPATH}/script/docs.min.js"></script>

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

			    $("#btnUpdate").click(function(){
			    	var typeNameVal = $("#typeName").val();
			    	if(typeNameVal==""){
			    		layer.msg("类型名称不能为空!", {time:1000, icon:0, shift:5}, function(){});
			    		return;
			    	}

			    	$.ajax({
			    		url:"${APPPATH}/schedule/update",
			    		type:"post",
			    		data:$("#updForm").serialize(),
			    		success:function(result){
			    			if(result.flag){
			    				layer.msg("排班修改成功!", {time:1000, icon:0, shift:6}, function(){});
			    				window.location.href='${APPPATH}/schedule/index';
			    			}else{
			    				layer.msg("排班修改失败!", {time:1000, icon:0, shift:5}, function(){});
			    			}
			    		}
			    	});
			    });

				$("#btnCroomEdit").click(function() {
					$.ajax({
						url:"${APPPATH}/croom/croomEditSubmit",
						type:"post",
						data:{"aroomId":$("#aroomId").val(),"croomId":$("#croomId").val(),"croomCode":$("#croomCode").val(),"croomAddr":$("#croomAddr").val()},
						success:function(result){
							window.location.href = "${APPPATH}/croom/croomListByPage";
						}
					});
				});

            });
            
        </script>
  </body>
</html>
