<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9" />
	<link href="css/left.css" type="text/css" rel="stylesheet" />
	<title>左侧菜单</title>
	<script src="js/jquery.min.js"></script>
	<script language="javascript" type="text/javascript" charset="utf-8" src="js/admin.js"></script>
</head>

<body oncontextmenu="return false" ondragstart="return false" onSelectStart="return false">

<div class="div_bigmenu">
	<div class="div_bigmenu_nav_down" id="nav_1" onclick="javascript:lefttoggle(1);">用户管理</div>
	<ul id="ul_1">

		<li><a href="userPw.jsp" target='main'>修改密码</a></li>
		<li><a href="userXinxiSet.jsp" target='main'>修改资料</a></li>
		<%--<li><a href="userMoney.jsp" target='main'>我的余额</a></li>--%>
	</ul>
</div>



<div class="div_bigmenu">
	<div class="div_bigmenu_nav_down" onclick="javascript:lefttoggle(4);" id="nav_4">家教管理</div>
	<ul id="ul_4">
		<li><a href="jiajiaoAdd.jsp" target='main'>家教添加</a></li>
		<li><a href="jiajiaoManaMy.action" target='main'>我的家教管理</a></li>

	</ul>
</div>



<%--<div class="div_bigmenu">
	<div class="div_bigmenu_nav_down" onclick="javascript:lefttoggle(7);" id="nav_7">订单管理</div>
	<ul id="ul_7">


		<li><a href="dingdanMana.action" target='main'>订单查询</a></li>
		&lt;%&ndash;<li><a href="dingdanChakanMy.action" target='main'>我的订单管理</a></li>&ndash;%&gt;
	</ul>
</div>--%>

<%--<div class="div_bigmenu">
	<div class="div_bigmenu_nav_down" onclick="javascript:lefttoggle(8);" id="nav_8">支付方式管理</div>
	<ul id="ul_8">
		<li><a href="zhifufangshiAdd.jsp" target='main'>支付方式添加</a></li>
		<li><a href="zhifufangshiMana.action" target='main'>支付方式查询</a></li>
	</ul>
</div>--%>







<div class="div_bigmenu">
	<div class="div_bigmenu_nav_down" onclick="javascript:lefttoggle(6);" id="nav_6">系统管理</div>
	<ul id="ul_6">

		<li><a href="liuyanMana.action" target='main'>留言管理</a></li>
		<%--<li><a href="xiaoxiMana.action" target='main'>消息管理</a></li>--%>

	</ul>
</div>

</body>
</html>



