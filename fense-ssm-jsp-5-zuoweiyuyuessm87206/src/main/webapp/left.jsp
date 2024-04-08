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
        <li><a href="usersAdd.jsp" target='main'>用户添加</a></li>
        <li><a href="usersMana" target='main'>用户管理</a></li>
        <li><a href="userPw.jsp" target='main'>修改密码</a></li>
        <li><a href="usersSet2.jsp" target='main'>修改资料</a></li>
    </ul>
</div>


<div class="div_bigmenu">
    <div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(2);" id="nav_2">轮播管理</div>
    <ul id="ul_2" style="display: none;">
        <li><a href="lunboAdd.jsp" target='main'>轮播添加</a></li>
        <li><a href="lunboMana" target='main'>轮播查询</a></li>
    </ul>
</div>

<div class="div_bigmenu">
    <div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(3);" id="nav_3">公告管理</div>
    <ul id="ul_3" style="display: none;">
        <li><a href="gonggaoAdd.jsp" target='main'>公告添加</a></li>
        <li><a href="gonggaoMana" target='main'>公告查询</a></li>
    </ul>
</div>
<div class="div_bigmenu">
    <div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(9);" id="nav_9">座位管理</div>
    <ul id="ul_9" style="display: none;">

        <li><a href="leibieAdd.jsp" target='main'>类别添加</a></li>
        <li><a href="leibieMana" target='main'>类别查询</a></li>
        <li><a href="loucengAdd.jsp" target='main'>楼层添加</a></li>
        <li><a href="loucengMana" target='main'>楼层查询</a></li>
        <li><a href="fangjianAdd.jsp" target='main'>房间添加</a></li>
        <li><a href="fangjianMana" target='main'>房间查询</a></li>
        <li><a href="zuoweiAdd.jsp" target='main'>座位添加</a></li>
        <li><a href="zuoweiMana" target='main'>座位查询</a></li>
    </ul>
</div>

<div class="div_bigmenu">
    <div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(7);" id="nav_7">预约管理</div>
    <ul id="ul_7" style="display: none;">

        <li><a href="yuyueMana" target='main'>预约查询</a></li>
    </ul>
</div>


<div class="div_bigmenu">
    <div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(8);" id="nav_8">入座管理</div>
    <ul id="ul_8" style="display: none;">
        <li><a href="ruzuoAdd.jsp" target='main'>入座添加</a></li>
        <li><a href="ruzuoMana" target='main'>入座查询</a></li>
    </ul>
</div>

<div class="div_bigmenu">
    <div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(5);" id="nav_5">离座管理</div>
    <ul id="ul_5" style="display: none;">
        <li><a href="lizuoAdd.jsp" target='main'>离座添加</a></li>
        <li><a href="lizuoMana" target='main'>离座查询</a></li>
    </ul>
</div>

<div class="div_bigmenu">
    <div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(4);" id="nav_4">时段管理</div>
    <ul id="ul_4" style="display: none;">
        <li><a href="shiduanAdd.jsp" target='main'>时段添加</a></li>
        <li><a href="shiduanMana" target='main'>时段查询</a></li>
    </ul>
</div>



<div class="div_bigmenu">
    <div class="div_bigmenu_nav_left" onclick="javascript:lefttoggle(6);" id="nav_6">系统管理</div>
    <ul id="ul_6" style="display: none;">
        <li><a href="lianjieAdd.jsp" target='main'>友情连接添加</a></li>
        <li><a href="lianjieMana" target='main'>友情连接查询</a></li>

        <li><a href="dxAdd.jsp" target='main'>介绍添加</a></li>
        <li><a href="dxMana" target='main'>介绍管理</a></li>
        <li><a href="liuyanMana" target='main'>留言管理</a></li>
    </ul>
</div>
</body>
</html>



