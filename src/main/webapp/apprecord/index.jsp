<%@ page language="java" pageEncoding="utf-8"%>
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
	<style>
	a:hover{
		cursor:pointer;
	}
	.tree li {
        list-style-type: none;
		cursor:pointer;
	}
	table tbody tr:nth-child(odd){background:#F4F4F4;}
	table tbody td:nth-child(even){color:#C00;}
	</style>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <div><a class="navbar-brand" style="font-size:32px;" href="#">用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li style="padding-top:8px;">
				<div class="btn-group">
				  <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
					<i class="glyphicon glyphicon-apprecord"></i> ${loginUser.uname }<span class="caret"></span>
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
			<div class="tree">
                <%@ include file="../menu.jsp" %>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="panel panel-default">
			  <div class="panel-heading">
				<h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
			  </div>
			  <div class="panel-body">
<form class="form-inline" role="form" style="float:left;">
  <div class="form-group has-feedback">
    <div class="input-group">
      <div class="input-group-addon">查询条件</div>
      <input class="form-control has-success" type="text" id="queryPatientName" name="queryPatientName" placeholder="请输入患者姓名">
    </div>
  </div>
  <button type="button" class="btn btn-warning" id="btnQuery"><i class="glyphicon glyphicon-search"></i> 查询</button>
</form>
<button type="button" onclick="delSourcetypes()" class="btn btn-danger" style="float:right;margin-left:10px;"><i class=" glyphicon glyphicon-remove"></i> 删除</button>

<br>
 <hr style="clear:both;">
          <div class="table-responsive">
          <form id="delForm">
            <table class="table  table-bordered">
              <thead>
                <tr >
                  <th width="30">#</th>
				  <th width="30"><input type="checkbox" id="checkAll"></th>


                    <th>医生姓名</th>
                    <th>医技项目</th>
                    <th>患者名字</th>
                    <th>是否签到</th>
                    <th>是否缴费</th>
                    <th width="100">操作</th>
                </tr>
              </thead>
              
              <tbody id="tableContent">
                
              </tbody>
             
			  <tfoot>
			     <tr >
				     <td colspan="9" align="center">
						<ul class="pagination" id="byPage">
								
							 </ul>
					 </td>
				 </tr>

			  </tfoot>
            </table>
             </form>
          </div>
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
        	var queryFlag = false;
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
			    $("#btnQuery").click(function(){
			    	var queryVal = $("#queryPatientName").val();
			    	if(queryVal!=""){
			    		queryFlag = true;
			    	}
			    	queryByPage(1);
			    });
			    $("#checkAll").click(function(){
			    	var flag = $(this).prop("checked");
			    	$.each($("#tableContent .abc"),function(index,obj){
			    		obj.checked=flag;
			    	});
			    });
			    queryByPage(1);
            });
            $("tbody .btn-success").click(function(){
                window.location.href = "assignRole.html";
            });
            $("tbody .btn-primary").click(function(){
                window.location.href = "edit.html";
            });
            function delSourcetypes(){
            	layer.confirm("是否删除选中的用户?",  {icon: 3, title:'提示'}, function(cindex){
    			    layer.close(cindex);
    			    $.ajax({
    			    	url:"${APPPATH}/apprecord/delSourcetypes",
    			    	type:"post",
    			    	data:$("#delForm").serialize(),
    			    	success:function(result){
    			    		if(result.flag){
    			    			layer.msg("删除成功!", {time:1000, icon:0, shift:6}, function(){});
    			    			window.location.href="${APPPATH}/apprecord/index";
    			    		}else{
    			    			layer.msg("删除失败!", {time:1000, icon:0, shift:5}, function(){});
    			    		}
    			    	}
    			    });
    			    
    			}, function(cindex){
    			    layer.close(cindex);
    			});
            }
            function updatePatient(apprecordId){
            	window.location.href="${APPPATH}/apprecord/findOne?apprecordId="+apprecordId;
            }

            function deletePatient(apprecordId){
            	layer.confirm("是否删除该患者?",  {icon: 3, title:'提示'}, function(cindex){
    			    layer.close(cindex);
    			    $.ajax({
    			    	url:"${APPPATH}/apprecord/delete",
    			    	type:"post",
    			    	data:{"apprecordId":apprecordId},
    			    	success:function(result){
    			    		if(result.flag){
    			    			layer.msg("删除成功!", {time:1000, icon:0, shift:6}, function(){});
    			    			window.location.href="${APPPATH}/apprecord/index";
    			    		}else{
    			    			layer.msg("删除失败!", {time:1000, icon:0, shift:5}, function(){});
    			    		}
    			    	}
    			    });
    			    
    			}, function(cindex){
    			    layer.close(cindex);
    			});
            }

            function confirm(apprecordId){
                layer.confirm("是否确认该记录?",  {icon: 3, title:'提示'}, function(cindex){
                    layer.close(cindex);
                    $.ajax({
                        url:"${APPPATH}/apprecord/confirm",
                        type:"post",
                        data:{"apprecordId":apprecordId},
                        success:function(result){
                            if(result.flag){
                                layer.msg("确认成功!", {time:1000, icon:0, shift:6}, function(){});
                                window.location.href="${APPPATH}/apprecord/index";
                            }else{
                                layer.msg("确认失败!", {time:1000, icon:0, shift:5}, function(){});
                            }
                        }
                    });

                }, function(cindex){
                    layer.close(cindex);
                });
            }

            function queryByPage(nowPage){
            	var jsonData = {"nowPage":nowPage};
            	if(queryFlag){
            		jsonData.queryVal= $("#queryPatientName").val();
            	}
            	$.ajax({
            		url:"${APPPATH }/apprecord/findAllByPage",
            		type:"post",
            		data:jsonData,
            		success:function(result){
            			if(result.flag){
            				//result.pageBean
            				//result.pageBean.list
            				var tableStr = "";
            				$.each(result.obj.list,function(index,apprecord){
            					//生成jQuery对象，进行装配或者使用html方法拼字符串
	            				tableStr+="<tr>";
		                        tableStr+="<td>"+(index+1)+"</td>";
		          				tableStr+="<td><input type='checkbox' class='abc' name='apprecordId' value='"+apprecord.apprecordId+"'></td>";
		                        tableStr+="<td>"+apprecord.emp.empName+"</td>";
                                tableStr+="<td>"+apprecord.project.projectName+"</td>";
                                tableStr+="<td>"+apprecord.patient.patientName+"</td>";
                                tableStr+="<td>"+apprecord.attendStatus+"</td>";
                                tableStr+="<td>"+apprecord.costStatus+"</td>";
		                        tableStr+="<td>";
                                tableStr+="<button type='button' onclick='confirm("+apprecord.apprecordId+")' class='btn btn-success btn-xs'><i class='glyphicon glyphicon-ok'></i></button>";
		          				tableStr+="<button type='button' onclick='updatePatient("+apprecord.apprecordId+")' class='btn btn-primary btn-xs'><i class='glyphicon glyphicon-pencil'></i></button>";
		          				tableStr+="<button type='button' onclick='deletePatient("+apprecord.apprecordId+")' class='btn btn-danger btn-xs'><i class='glyphicon glyphicon-remove'></i></button>";
		          				tableStr+="</td>";
	                          	tableStr+="</tr>";
            					
            				});
            				$("#tableContent").html(tableStr);
            				var byPageStr="";
            				byPageStr+="<li class='"+(result.obj.nowPage==1?'disabled':'')+"'><a onclick='queryByPage("+(result.obj.nowPage-1)+")'>上一页</a></li>";
							for(var i=1;i<=result.obj.countPage;i++){
								if(i==result.obj.nowPage){
	            					byPageStr+="<li class='active'><a onclick='queryByPage("+(i)+")'>"+i+"<span class='sr-only'>(current)</span></a></li>";
								}else{
	            					byPageStr+="<li><a onclick='queryByPage("+(i)+")'>"+i+"</a></li>";
								}
							}
							byPageStr+="<li class='"+(result.obj.nowPage==result.obj.countPage?'disabled':'')+"'><a onclick='queryByPage("+(result.obj.nowPage+1)+")'>下一页</a></li>";
            				$("#byPage").html(byPageStr);
            			}else{
            				layer.msg("查询失败!", {time:1000, icon:0, shift:5}, function(){});
            			}
            		}
            	});
            }
        </script>
  </body>
</html>
