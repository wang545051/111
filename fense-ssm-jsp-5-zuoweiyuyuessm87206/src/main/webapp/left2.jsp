<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9"/>
	<title>左侧菜单</title>
	<%@include file="common/head.jsp" %>
	<%@include file="common/loginstate.jsp" %>
	<link href="${staticPath}/css/left.css" type="text/css" rel="stylesheet"/>
	<script src="${staticPath}/js/jquery.min.js"></script>
	<script language="javascript" type="text/javascript" charset="utf-8" src="${staticPath}/js/admin.js"></script>
</head>

<body oncontextmenu="return false" ondragstart="return false" onSelectStart="return false">

<div class="div_bigmenu">
	<div class="div_bigmenu_nav_left" id="nav_1" onclick="javascript:lefttoggle(1);">用户管理</div>
	<ul id="ul_1" style="display: none;">
		<li><a href="userPw.jsp" target='main'>修改密码</a></li>
		<li><a href="usersSet2.jsp" target='main'>修改资料</a></li>
	</ul>
</div>



<div class="div_bigmenu">
	<div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(7);" id="nav_7">预约管理</div>
	<ul id="ul_7" style="display: none;">

		<li><a href="yuyueChakanMy" target='main'>我的预约查询</a></li>
	</ul>
</div>


<div class="div_bigmenu">
	<div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(8);" id="nav_8">入座管理</div>
	<ul id="ul_8" style="display: none;">
		<li><a href="ruzuoChakanMy" target='main'>我的入座查询</a></li>
	</ul>
</div>



<div class="div_bigmenu">
	<div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(5);" id="nav_5">离座管理</div>
	<ul id="ul_5" style="display: none;">
		<li><a href="lizuoChakanMy" target='main'>我的离座查询</a></li>
	</ul>
</div>




<div class="div_bigmenu">
	<div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(6);" id="nav_6">系统管理</div>
	<ul id="ul_6" style="display: none;">
		<li><a href="liuyanChakanMy" target='main'>我的留言管理</a></li>
	</ul>
</div>
</body>
</html>



