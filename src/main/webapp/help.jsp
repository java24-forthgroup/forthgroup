<%@ page language="java"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/main.css">

    <link rel="icon" href="favicon.ico" type="image/x-icon" />
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="css/normalize.css" type="text/css" />
    <link rel="stylesheet" href="css/index.css" type="text/css" />
    <script language="javascript" type="text/javascript" src="bootstrap/js/Kunyi.Respond.min.js" ></script>
    <script language="javascript" type="text/javascript" src="bootstrap/js/KunyiHTML5.min.js"></script>
    <script language="javascript" type="text/javascript" src="bootstrap/js/Kunyilibrary.js"></script>

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
        .navbar-right{
            margin-right:10px;
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
                <li style="padding-top:3px;">
                    <div class="btn-group">
                        <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
                            <i class="glyphicon glyphicon-user"></i> ${loginUser.uname } <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
                            <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
                            <li class="divider"></li>
                            <li><a href="logout"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
                        </ul>
                    </div>
                </li>
                <li style="margin-left:10px;padding-top:3px;">
                    <button type="button" class="btn btn-default btn-danger">
                        <a href="${APPPATH}/help.jsp" style="color: white"> <span class="glyphicon glyphicon-question-sign"></span> 帮助</a>
                    </button>
                </li>
            </ul>
            <form class="navbar-form navbar-right" style="margin-right:150px">
                <input type="text" class="form-control" placeholder="查询">
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <%@ include file="menu.jsp" %>
            </div>
        </div>
      <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header"></h1>
         <div class="row placeholders">
            <div class="navSub2 nav_Menu01">
                <dl>
                    <dt>尊敬的病人家属：</dt>
                    <dd class="pic"><img src="images/pic/pic_001.jpg" width="126" height="77"></dd>
                    <dd class="text">欢迎您来我院探望亲友！为了保证病人的休息和治疗，维护良好的医疗秩序，请您配合在规定的时间内探视病人。</dd>
                    <dd class="info"><em>我院病房探视时间为：</em>
                        <p>每周一至周六：下午 3：00 - 7：00</p><p>周日：上午 9：00 - 12：00</p><p>下午 3：00 -  7：00</p></dd>
                </dl>
                <div class="BottomHidden"></div>
                <dl>
                    <dt>医院标题</dt>
                    <dd class="pic"><img src="images/pic/pic_002.jpg" width="126" height="77"></dd>
                    <dd class="text"><p>座落于中华民族的发源地 -  ，是历史悠久的西医医院。</p><p>医院详细地址位于城区东郊， 。</p></dd>
                    <dd class="info"><em>急救电话 ： </em>
                        <span>120</span></dd>
                </dl>
            </div>
            <div class="navSub3 nav_Route">
                <dl><dt>乘车路线</dt>
                    <dd><em>公交全部路线</em><p>
                        101路、109路东线、80路、2路、2路快线、82路、65路、98路、47路、158路 </p></dd>
                    <dd><em>长途汽车客运中心站</em>
                        <p>101路、109东线、2路 </p></dd>
                    <dd class="text"><p><em>长途汽车客运北站</em> </p>
                        <p><span>77路、47路</span><span>158路</span></p>
                    </dd>
                    <dd><em>汽车客运站</em>
                        <p>40路</p></dd>
                </dl>
                <%--<a href="http://map.baidu.com/ target="_blank">电子地图</a>--%>
            </div><div class="clear"></div>
        </div>

            <%--<div class="row placeholders">
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>帮助</h4>
                    <span class="text-muted">woniuxy</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>帮助</h4>
                    <span class="text-muted">woniuxy</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>帮助</h4>
                    <span class="text-muted">woniuxy</span>
                </div>
                <div class="col-xs-6 col-sm-3 placeholder">
                    <img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">
                    <h4>帮助</h4>
                    <span class="text-muted">woniuxy</span>
                </div>
            </div>--%>
        </div>
    </div>
</div>
<script src="jquery/jquery-2.1.1.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script src="script/docs.min.js"></script>
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
</script>
</body>
</html>

