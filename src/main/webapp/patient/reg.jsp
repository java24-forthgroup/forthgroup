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
            <div><a class="navbar-brand" style="font-size:32px;" href="${APPPATH}/main">医疗预约平台</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
                            <i class="glyphicon glyphicon-patient"></i> ${loginUser.uname } <span class="caret"></span>
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

            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <ol class="breadcrumb">
                <li><a href="#">登录</a></li>

                <li class="active">注册</li>
            </ol>
            <div class="panel panel-default">
                <div class="panel-heading"><div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
                <div class="panel-body">
                    <form role="form" id="saveForm">

                        <div class="form-group">
                            <label 用户名></label>

                            <input type="text" class="form-control" id="uname" name="uname" value="${user.uname}" placeholder="请输入用户名">
                            <span id="warning" style="color:red"></span>
                        </div>
                        <div class="form-group">
                            <label 密码></label>
                            <input type="text" class="form-control" id="upwd" name="upwd" value="${user.upwd}"placeholder="请输入密码">
                        </div>

                        <div class="form-group">
                            <label 真实姓名></label>
                            <input type="text" class="form-control" id="patientName" name="patientName" value="${patient.patientName}"placeholder="请输真实姓名">
                        </div>
                        <div class="form-group">
                            <label 患者性别></label>
                                男<input type="checkbox" id="patientSex" name="patientSex" value="男">
                                女<input type="checkbox"  id="patientSex" name="patientSex" value="女">
                            </div>

                        <div class="form-group">
                            <label 年龄></label>
                            <input type="text" class="form-control" id="patientAge" name="patientAge" value="${patient.patientAge}"placeholder="请输入年龄">
                        </div>

                        <button type="button" id="btnSave" class="btn btn-success"><i class="glyphicon glyphicon-plus"></i> 注册</button>
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
<script src="${APPPATH }/jquery/jquery-2.1.1.min.js"></script>
<script src="${APPPATH }/bootstrap/js/bootstrap.min.js"></script>
<script src="${APPPATH }/script/docs.min.js"></script>
<script src="${APPPATH }/layer/layer.js"></script>
<script type="text/javascript">
    var flag = false;
    $("#uname").change(function(){

        $.ajax({
            url:"${APPPATH }/user/findOneByUname",
            type:"post",
            data:{"uname":$("#uname").val()},
            success:function(data){

                if(data.flag){

                    $("#warning").html("用户名已存在");
                    flag=false;
                }else{
                    $("#warning").html("");
                    flag=true;
                }
            }
        })
    });
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
            if(flag==false){
                layer.msg("用户名已存在!", {time:1000, icon:0, shift:5}, function(){});
                return;
            }
            var patientNameVal = $("#patientName").val();
            if(patientNameVal==""){
                layer.msg("患者名称不能为空!", {time:1000, icon:0, shift:5}, function(){});
                return;
            }
            var patientAgeVal = $("#patientAge").val();
            if(patientAgeVal==""){
                layer.msg("类型名称不能为空!", {time:1000, icon:0, shift:5}, function(){});
                return;
            }
            var patientSexVal = $("#patientSex").val();
            if(patientSexVal==""){
                layer.msg("类型名称不能为空!", {time:1000, icon:0, shift:5}, function(){});
                return;
            }
            var patientCountVal = $("#uname").val();
            if(patientCountVal==""){
                layer.msg("用户名不能为空!", {time:1000, icon:0, shift:5}, function(){});
                return;
            }
            var patientStatusVal = $("#upwd").val();
            if(patientStatusVal==""){
                layer.msg("密码不能为空!", {time:1000, icon:0, shift:5}, function(){});
                return;
            }

            $.ajax({

                url:"${APPPATH}/patient/save",
                type:"post",
                data:$("#saveForm").serialize(),
                success:function(result){
                    if(result.flag){
                        layer.msg("注册成功!", {time:1000, icon:0, shift:6}, function(){});
                        window.location.href="${APPPATH}/patient/index";
                    }else{
                        layer.msg("注册失败!", {time:1000, icon:0, shift:5}, function(){});
                    }
                }
            });
        });
    });
</script>
</body>
</html>
