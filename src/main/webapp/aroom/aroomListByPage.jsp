<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	<link rel="stylesheet" href="${APPPATH}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${APPPATH}/css/font-awesome.min.css">
	<link rel="stylesheet" href="${APPPATH}/css/main.css">
	<link href="https://cdn.bootcss.com/animate.css/3.7.2/animate.min.css" rel="stylesheet">
	<style>
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	.tree-closed {
	    height : 40px;
	}
	.tree-expanded {
	    height : auto;
	}
	</style>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid animated fadeInLeftBig">
        <div class="navbar-header ">
          <div><a class="navbar-brand" style="font-size:32px;color: white;" href="#">医疗预约平台</a></div>
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
						<li><a href="loginOut"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
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
            <input type="text" class="form-control" placeholder="查询">
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
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" >
          <h1 class="page-header animated bounceInUp"><a href="${APPPATH}/arrom/aroomListByPage">科室信息</a></h1>
			<form class="form-inline" role="form" style="float:left;">
			  <div class="form-group has-feedback">
			  	<button type="button" class="btn btn-default btn-success animated bounceInUp" onclick="location.href='${APPPATH}/aroom/aroomAdd.jsp'">
					<span class="glyphicon"></span> 增加科室
				</button>
			    <div class="input-group animated bounceInUp" style="margin-left: 730px">
			      <div class="input-group-addon">查询科室</div>
			      <input class="form-control has-success" type="text" placeholder="请输入查询条件" id="queryVal">
			    </div>
			  </div>
			  <button type="button" class="btn btn-warning animated bounceInUp" onclick="query()"><i class="glyphicon glyphicon-search"></i> 查询</button>
			</form>
			<table class="table  table-bordered table-hover">
              <thead>
                <tr class="animated bounceInRight">
				  <th width="30"></th>
                  <th>科室名称</th>
                  <th>科室编号</th>
                  <th>科室地址</th>
                  <th width="100">操作</th>
                </tr>
              </thead>
              <tbody>
               	<c:forEach items="${pageBean.list}" var="aroom" varStatus="i">
	                <tr class="animated bounceInRight">
					  <td>${i.count}</td>
	                  <td>${aroom.aroomName}</td>
	                  <td>${aroom.aroomCode}</td>
	                  <td>${aroom.aroomAddr}</td>
	                  <td>
						  <button type="button" onclick="location.href='${APPPATH}/aroom/aroomEdit?aroomId='+${aroom.aroomId}" class="btn btn-primary btn-xs"><i  class=" glyphicon glyphicon-pencil"></i></button>
					      <button type="button" onclick="location.href='${APPPATH}/aroom/aroomDel?aroomId='+${aroom.aroomId}" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>
					  </td>
	                </tr>         
              	</c:forEach>
              	
              	<tr>
				     <td colspan="6" align="center" class="animated bounceInDown">
						<ul class="pagination">
							<li ><a href="${APPPATH}/aroom/aroomListByPage?nowPage=${pageBean.nowPage==1?1:pageBean.nowPage-1}">上一页</a></li>		
 							<c:forEach  begin="1" end="${pageBean.countPage}" var="num" >
									<li ><span><a href="${APPPATH}/aroom/aroomListByPage?nowPage=${num}">${num}</a></span></li>
							</c:forEach>
							<li ><a href="${APPPATH}/aroom/aroomListByPage?nowPage=${pageBean.nowPage==pageBean.countPage?pageBean.nowPage:pageBean.nowPage+1}">下一页</a></li>
						</ul>
					 </td>
              	</tr>
              </tbody>
			  <tfoot>
			  
			  </tfoot>
            </table>
          
        </div>
      </div>
    </div>
    <script src="${APPPATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APPPATH}/bootstrap/js/bootstrap.min.js"></script>
	<script src="${APPPATH}/script/docs.min.js"></script>
        <script type="text/javascript">
            $(function () {
			    $(".list-group-item").click(function(){
                    // jquery对象的回调方法中的this关键字为DOM对象
                    // $(DOM) ==> JQuery
				    if ( $(this).find("ul") ) { // 3 li
						$(this).toggleClass("tree-closed");
						if ( $(this).hasClass("tree-closed") ) {
							$("ul", this).hide("fast");
						} else {
							$("ul", this).show("fast");
						}
					}
				});
            });
            function query(){
				var queryVal=$("#queryVal").val();
				alert(queryVal);
				window.location.href='${APPPATH}/aroom/aroomListByPage?queryVal='+queryVal;
            }
            
        </script>
  </body>
</html>