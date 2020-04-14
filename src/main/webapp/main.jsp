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
    #carousel-example-generic img {
        margin: 0 auto;
    }

    #carousel-example-generic {
        margin-top: 0px;
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
				<%@ include file="menu.jsp" %>
			</div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header"></h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
            <a href="/apprecord/goBook?userId=${loginUser.userId}"> <h4>去预约</h4></a>
            </div><br/><br/>

              <!--轮播图-->
              <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                  <!-- 轮播图上的序号 -->
                  <ol class="carousel-indicators">
                      <li data-target="#carousel-example-generic" data-slide-to="0"
                          class="active"></li>
                      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                  </ol>
                  <!-- 设置滑动的图片-->
                  <div class="carousel-inner">
                      <div class="item active">
                          <img src="images/201607271939462.jpg" alt="...">
                      </div>

                      <div class="item">
                          <img src="images/2016072719555688.jpg" alt="...">
                      </div>

                      <div class="item">
                          <img src="images/2016072720014091.jpg" alt="...">
                      </div>
                  </div>
                  <!-- 控制图片滑动额左右箭头 -->
                  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
                  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next"> <span class="glyphicon glyphicon-chevron-right"></span></a>
              </div>

              <section class="doctorsBase BaseMark">
                  <div class="toolsBase">
                      <div class="title"><em>专家介绍</em>  <span>Expert Introduction</span></div>
                      <div class="tools"><a href="javascript:;" class="ASwitch" id="DSearchSwitch">快速查找</a><form method="get" class="search" action="Search.html" onSubmit="return Kunyi.CheckSearchFrom()"><input type="hidden" name="Type" value="2" /><input type="text" name="SearchWords" placeholder="请输入医生名字" class="animated"  value="" autocomplete="off"   maxlength="28" /><input class="btn" type="submit" value="" /></form>
                          <a href="keshi.html" class="Amore">更多 >></a>
                          <a href="javascript:;" class="Aprev"></a>
                          <a href="javascript:;" class="Anext"></a>
                      </div>
                      <div class="clear"></div>
                  </div>
                  <div class="contents">
                      <ul data-num="0">

                          <li><a href="ys.html" title="医生姓名" target="_blank" class="img"><img alt="李小龙" title="李小龙" src="images/doctor/2012121911592436.jpg" width="120" height="162" /></a>
                              <a href="ys.html" title="医生姓名" target="_blank" class="name">李小龙</a>
                              <a href="keshi.html" title="所在医院" target="_blank" class="office">山西大同医院</a>
                              <a href="ys.html" title="姓名" target="_blank" class="post">主任医师  研究生导师</a>
                              <a href="ys.html" title="姓名" target="_blank" class="btn more">详细</a>
                              <a href="#" target="_blank" class="btn date">预约</a>
                          </li>
                          <li><a href="ys.html" title="医生姓名" target="_blank" class="img"><img alt="周鑫" title="周鑫" src="images/doctor/2012121916201285.jpg" width="120" height="162" /></a>
                              <a href="ys.html" title="医生姓名" target="_blank" class="name">周鑫</a>
                              <a href="keshi.html" title="所在医院" target="_blank" class="office">山西大同医院</a>
                              <a href="ys.html" title="姓名" target="_blank" class="post">主任医师  研究生导师</a>
                              <a href="ys.html" title="姓名" target="_blank" class="btn more">详细</a>
                              <a href="#" target="_blank" class="btn date">预约</a></li>
                          <li><a href="ys.html" title="医生姓名" target="_blank" class="img"><img alt="何云川" title="何云川" src="images/doctor/2012121916261831.jpg" width="120" height="162" /></a>
                              <a href="ys.html" title="医生姓名" target="_blank" class="name">何云川</a>
                              <a href="keshi.html" title="所在医院" target="_blank" class="office">山西大同医院</a>
                              <a href="ys.html" title="姓名" target="_blank" class="post">主任医师  研究生导师</a>
                              <a href="ys.html" title="姓名" target="_blank" class="btn more">详细</a>
                              <a href="#" target="_blank" class="btn date">预约</a>
                          </li>
                          <li><a href="ys.html" title="医生姓名" target="_blank" class="img"><img alt="张志军" title="张志军" src="images/doctor/2012121917235496.jpg" width="120" height="162" /></a>
                              <a href="ys.html" title="医生姓名" target="_blank" class="name">姓名</a>
                              <a href="keshi.html" title="所在医院" target="_blank" class="office">山西大同医院</a>
                              <a href="ys.html" title="姓名" target="_blank" class="post">主任医师  研究生导师</a>
                              <a href="ys.html" title="姓名" target="_blank" class="btn more">详细</a>
                              <a href="#" target="_blank" class="btn date">预约</a>
                          </li>
                          <li><a href="ys.html" title="医生姓名" target="_blank" class="img"><img alt="翟宏刚" title="翟宏刚" src="images/doctor/2012121916265127.jpg" width="120" height="162" /></a>
                              <a href="ys.html" title="医生姓名" target="_blank" class="name">翟宏刚</a>
                              <a href="keshi.html" title="所在医院" target="_blank" class="office">山西大同医院</a>
                              <a href="ys.html" title="姓名" target="_blank" class="post">主任医师  研究生导师</a>
                              <a href="ys.html" title="姓名" target="_blank" class="btn more">详细</a>
                              <a href="#" target="_blank" class="btn date">预约</a>
                          </li>
                          <li><a href="ys.html" title="医生姓名" target="_blank" class="img"><img alt="金晓霞" title="金晓霞" src="images/doctor/2016032608442264.png" width="120" height="162" /></a>
                              <a href="ys.html" title="医生姓名" target="_blank" class="name">金晓霞</a>
                              <a href="keshi.html" title="所在医院" target="_blank" class="office">山西大同医院</a>
                              <a href="ys.html" title="姓名" target="_blank" class="post">主任医师  研究生导师</a>
                              <a href="ys.html" title="姓名" target="_blank" class="btn more">详细</a>
                              <a href="#" target="_blank" class="btn date">预约</a>
                          </li>
                      </ul>
                  </div>
                  <div class="DFastSearch">
                      <div class="DFTitle"><label>按医生姓名首字母查找</label> <button class="animated">关闭查找</button></div>
                      <div class="DFContent">
                          <div class="DListBase"></div>
                          <div class="IndexWords">
                              <ul><li data-index="0">A</li><li data-index="1" class="other">B</li><li data-index="2">C</li><li data-index="3" class="other">D</li><li data-index="4">E</li><li data-index="5" class="other">F</li><li data-index="6">G</li><li data-index="7" class="other">H</li><li data-index="8">I</li><li data-index="9" class="other">J</li><li data-index="10">K</li><li data-index="11" class="other">L</li><li data-index="12">M</li></ul>
                              <ul><li data-index="13" class="other">N</li><li data-index="14">O</li><li class="other" data-index="15">P</li><li data-index="16">Q</li><li data-index="17" class="other">R</li><li data-index="18">S</li><li data-index="19" class="other">T</li><li data-index="20">U</li><li data-index="21" class="other">V</li><li data-index="22">W</li><li data-index="23" class="other">X</li><li data-index="24">Y</li><li data-index="25" class="other">Z</li></ul>
                          </div>
                      </div>
                  </div>
              </section>

          <section class="officesBase BaseMark">
                  <div class="toolsBase">
                      <div class="title"><em>重点专科</em>  <span>Key Specialty</span></div>
                      <div class="tools"><a href="javascript:;" class="ASwitch" id="OSearchSwitch">快速查找科室</a>
                          <a href="keshi.html" class="Amore">更多 >></a>
                          <a href="javascript:;" class="Aprev"></a>
                          <a href="javascript:;" class="Anext"></a>
                      </div>
                      <div class="clear"></div>
                  </div>
                  <div class="contents">
                      <ul data-num="0">
                          <li><i class="ico01"></i>
                              <div class="img animated"><img alt="呼吸内科" src="images/pic/pic_007.png" width="80" height="80" /></div>
                              <a href="keshimx.html" title="呼吸内科" class="office">呼吸内科</a>
                              <p>我科始建于上世纪70年代初，目前为卫生部国家重点专科建设项目单位，山西省重点……</p>
                              <a href="keshimx.html" title="呼吸内科" class="btn more">查看详细</a>
                              <a href="keshiys.html" title="呼吸内科医生" class="btn doctor">科室专家</a></li>

                          <li><i class="ico01"></i>
                              <div class="img animated"><img alt="神经内科" src="images/pic/pic_009.png" width="80" height="80" /></div>
                              <a href="Office-12.html" title="神经内科" class="office">神经内科</a>
                              <p>医院标题神经内科始建于1954年，经过半个多世纪的发展，目前已发展为全……</p>
                              <a href="Office-12.html" title="神经内科" class="btn more">查看详细</a>
                              <a href="ExpertInfo-12.html" title="神经内科医生" class="btn doctor">科室专家</a></li>

                          <li><i class="ico01"></i>
                              <div class="img animated"><img alt="内分泌科" src="images/pic/pic_008.png" width="80" height="80" /></div>
                              <a href="Office-4.html" title="内分泌科" class="office">内分泌科</a>
                              <p>医院标题内分泌代谢科，是国家重点专科、山西省重点专科、山西省糖尿病防治……</p>
                              <a href="Office-4.html" title="内分泌科" class="btn more">查看详细</a>
                              <a href="ExpertInfo-4.html" title="内分泌科医生" class="btn doctor">科室专家</a></li>
                          <li><i class="ico01"></i>
                              <div class="img animated"><img alt="神经内科康馨病房" src="images/pic/pic_012.png" width="80" height="80" /></div>
                              <a href="Office-57.html" title="神经内科康馨病房" class="office">神经内科康馨病房</a>
                              <p>医院标题神经内科康馨病房为国家临床重点专科神经内科干部保健病房，成立于……</p>
                              <a href="Office-57.html" title="神经内科康馨病房" class="btn more">查看详细</a>
                              <a href="ExpertInfo-57.html" title="神经内科康馨病房医生" class="btn doctor">科室专家</a></li>
                          <li><i class="ico01"></i>
                              <div class="img animated"><img alt="心内科" src="images/pic/pic_010.png" width="80" height="80" /></div>
                              <a href="Office-8.html" title="心内科" class="office">心内科</a>
                              <p>医院标题心血管内科是国家级临床重点专科、山西临床重点专科、山西省心血管……</p>
                              <a href="Office-8.html" title="心内科" class="btn more">查看详细</a>
                              <a href="ExpertInfo-8.html" title="心内科医生" class="btn doctor">科室专家</a></li>
                          <li><i class="ico01"></i>
                              <div class="img animated"><img alt="肾病风湿免疫科" src="images/pic/pic_013.png" width="80" height="80" /></div>
                              <a href="Office-6.html" title="肾病风湿免疫科" class="office">肾病风湿免疫科</a>
                              <p>医院标题肾病风湿免疫科成立于1985年，由肾病专业及风湿病专业组成，是……</p>
                              <a href="Office-6.html" title="肾病风湿免疫科" class="btn more">查看详细</a>
                              <a href="ExpertInfo-6.html" title="肾病风湿免疫科医生" class="btn doctor">科室专家</a></li>
                          <li><i class="ico01"></i>
                              <div class="img animated"><img alt="呼吸内科康馨病房" src="images/pic/pic_012.png" width="80" height="80" /></div>
                              <a href="Office-101.html" title="呼吸内科康馨病房" class="office">呼吸内科康馨病房</a>
                              <p>医院标题呼吸与危重症医学科康馨病房为国家临床重点专科呼吸与危重症医学科……</p>
                              <a href="Office-101.html" title="呼吸内科康馨病房" class="btn more">查看详细</a>
                              <a href="ExpertInfo-101.html" title="呼吸内科康馨病房医生" class="btn doctor">科室专家</a></li>
                          <li><i class="ico01"></i>
                              <div class="img animated"><img alt="心外科" src="images/pic/pic_010.png" width="80" height="80" /></div>
                              <a href="Office-33.html" title="心外科" class="office">心外科</a>
                              <p>医院标题、山西省心血管病医院心血管外科是国家临床重点专科之一，是省内综……</p>
                              <a href="Office-33.html" title="心外科" class="btn more">查看详细</a>
                              <a href="ExpertInfo-33.html" title="心外科医生" class="btn doctor">科室专家</a></li>
                      </ul>
                      <div class="hackR"></div><div class="hackL"></div>
                  </div>
                  <div class="hiddenLineR"></div><div class="hiddenLineL"></div>
                  <div class="OFastSearch">
                      <div class="OFTitle"><label>快速查找科室</label> <button class="animated">返回重点科室</button></div>
                      <div class="OFContent">
                          <div class="OListBase"></div>
                      </div>
                  </div>
              </section>
          </div>
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
