<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="${APPPATH }/bootstrap/css/bootstrap-datetimepicker.min.css">
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
			<div><a class="navbar-brand" style="font-size:32px;" href="user.html">用户维护</a></div>
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
				<li><a href="#">首页</a></li>
				<li><a href="#">数据列表</a></li>
				<li class="active">预约</li>
			</ol>
			<div class="panel panel-default">
				<div class="panel-heading">表单数据<div style="float:right;cursor:pointer;" data-toggle="modal" data-target="#myModal"><i class="glyphicon glyphicon-question-sign"></i></div></div>
				<div class="panel-body">
					<form role="form" id="bookForm">

						<div class="form-group">


							<div class="form-group">
								<div class="form-group">
									<label>选择日期：</label>
									<!--指定 date标记-->
										<div >
											<input type="" name="bookTime"  class="form-control" id="bookTime" autocomplete="off">
										</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label >预约医技</label>
							<SELECT name="skillgroup.skillgroupId" id="skillgroup" class="form-control">

								<option value=''></option>

							</SELECT>
						</div>
						<div class="form-group">
							<label >预约项目</label>
							<SELECT name="project.projectId" id="project" class="form-control">

									<option value=''></option>

							</SELECT>
						</div>
						<div class="form-group">
							<label >医生</label>
							<SELECT name="emp.empId" id="Doctor" class="form-control">

								<option value=''></option>

							</SELECT>
						</div>

						<div class="form-group">

							<input type="hidden" class="form-control" id="patientId" name="patient.patientId" value="${patient.patientId}">

						</div>


						<button type="button" id="btnSave" class="btn btn-success"><i class="glyphicon glyphicon-edit"></i> 预约</button>

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
<script src="${APPPATH }/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script src="${APPPATH }/bootstrap/js/bootstrap.min.js"></script>
<script src="${APPPATH }/script/docs.min.js"></script>
<script src="${APPPATH }/layer/layer.js"></script>

<script type="text/javascript">

	$.fn.datetimepicker.dates['zh'] = {
		days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
		daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
		daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
		months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
		monthsShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
		meridiem: ["上午", "下午"],
		//suffix:      ["st", "nd", "rd", "th"],
		today: "今天"
	};
	$("#bookTime").datetimepicker({
		language: 'zh',  //用自己设置的时间文字
		//weekStart: 1,  //一周从那天开始，默认为0，从周日开始，可以设为1从周一开始
		startDate:new Date(), //开始时间，可以写字符串，也可以直接写日期格式new Date(),在这之前的日期不能选择
		endDate:new Date(new Date().getTime()+1000*60*60*24*15),
		//daysOfWeekDisabled: [0,4,6],  //一周的周几不能选
		todayBtn: 0,  //是否显示今天按钮，0为不显示
		autoclose: 1, //选完时间后是否自动关闭
		todayHighlight: 1,  //高亮显示当天日期
		startView: 2, //0从小时视图开始，选分;1	从天视图开始，选小时;2从月视图开始，选天;3从年视图开始，选月;4从十年视图开始，选年
		minView: 2,//最精确时间，默认0；0从小时视图开始，选分；1从天视图开始，选小时；2从月视图开始，选天；3从年视图开始，选月；4从十年视图开始，选年
		//maxView:4,  //默认值：4, ‘decade’
		//keyboardNavigation:true,  //是否可以用键盘方向键选日期，默认true
		forceParse: 0, //强制解析,你输入的可能不正规，但是它胡强制尽量解析成你规定的格式（format）
		format: 'yyyy-mm-dd ',// 格式,注意ii才是分，mm或MM都是月
		//minuteStep:5, //选择分钟时的跨度，默认为5分钟
		//pickerPosition:"top-right",  // ‘bottom-left’，’top-right’，’top-left’’bottom-right’
		//showMeridian:0, //在日期和小时选择界面，出现上下午的选项,默认false
		// showSecond: false,
		// showMillisec: true,
		//timeFormat: 'hh:mm:ss:l',
		//bootcssVer: 3,
	});
	//联动
	var skillgroups =[];
	var skillgroup = document.getElementById("skillgroup");
	$("#bookTime").change(function(){
        skillgroup.options.length=0;
		project.options.length=0;
		$.ajax({
			url:"${APPPATH }/schedule/queryByDate",
			type:"post",
			data:{"bookTime":$("#bookTime").val()},

			success:function(data){

                skillgroups = data;
				for (var i = 0; i < skillgroups.length; i++) {
					var op = new Option(skillgroups[i].skillgroup.skillgroupName,skillgroups[i].skillgroup.skillgroupId);
					skillgroup.options.add(op);
				}
				queryBySkillgroup();
				queryDoctorBySkillgroup();
			}
		})
	});

    var projects = [];
    var project = document.getElementById("project");
    $("#skillgroup").change(function(){
		queryBySkillgroup();
    });

	function queryBySkillgroup(){
		project.options.length=0;
		$.ajax({
			url:"${APPPATH }/Project/queryBySkillgroup",
			type:"post",
			data:{"skillgroupId":$("#skillgroup").val()},

			success:function(data){

				projects = data;

				for (var i = 0; i < projects.length; i++) {

					var op1 = new Option(projects[i].projectName,projects[i].projectId);
					project.options.add(op1);
				}
			}
		})
	}
	var Doctors= [];
	var Doctor = document.getElementById("Doctor"); //医生的option
	$("#skillgroup").change(function(){
		queryDoctorBySkillgroup();
	});
	function queryDoctorBySkillgroup(){
		Doctor.options.length=0;
		$.ajax({
			url:"${APPPATH }/emp/queryDoctorBySkillgroup",
			type:"post",
			data:{"skillgroupId":$("#skillgroup").val()},

			success:function(data){

				Doctors = data;

				for (var i = 0; i < Doctors.length; i++) {

					var op2 = new Option(Doctors[i].empName,Doctors[i].empId);
					Doctor.options.add(op2);
				}
			}
		})
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
		$("#btnSave").click(function(){

			$.ajax({
				url:"${APPPATH}/apprecord/book",
				type:"post",
				data:$("#bookForm").serialize(),
				success:function(result){
					if(result.flag){
						layer.msg("预约成功!", {time:1000, icon:0, shift:6}, function(){});
						window.location.href='${APPPATH}/main';
					}else{
						layer.msg("类型修改失败!", {time:1000, icon:0, shift:5}, function(){});
					}
				}
			});
		});
	});
</script>
</body>
</html>
