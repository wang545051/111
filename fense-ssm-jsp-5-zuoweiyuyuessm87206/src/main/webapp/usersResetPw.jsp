<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>密码重置</title>
	<%@include file="common/head.jsp" %>
	<script type="text/javascript" src="${staticPath}/js/popup.js"></script>
	<link rel="stylesheet" type="text/css" href="qtimages/css/wst.css"/>
	<link rel="stylesheet" href="${staticPath}/qtimages/hsgbanner.css">
	<script type="text/javascript" src="${staticPath}/qtimages/jquery.js"></script>
	<script type="text/javascript" src="${staticPath}/qtimages/inc.js"></script>
	<script language="javascript">
		function resetPw() {
			var loginname = $('#loginname').val().trim();;
			var xingming = $('#xingming').val().trim();
			var dianhua = $('#dianhua').val().trim();
			if (loginname == "") {
				alert("用户名称不能空");
				return;
			}
			if (xingming == "") {
				alert("姓名不能空");
				return;
			}
			if (dianhua == "") {
				alert("电话不能空");
				return;
			}
			var param = {
				'loginname':loginname,
				'xingming':xingming,
				'dianhua':dianhua,
			};
			$.post(basePath + '/usersResetPw', param, function(resp) {
				var pop=new Popup({ contentType:4,isReloadOnClose:false,width:250,height:100});
				if (resp.success) {
					pop.setContent("title","温馨提示");
					pop.setContent("alertCon",resp.data);

				}else {
					pop.setContent("title","温馨提示");
					pop.setContent("alertCon",resp.message);
				}
				pop.build();
				pop.show();
			})
		}
	</script>
</head>
<body>
<!--头部代码的开始-->
<%@ include file="qttop.jsp"%>
<!--头部代码的结束-->

<!--子页面banner-->
<%--<div class="scban"></div>--%>
<!--子页面banner-->

<!--banner图片的开始-->
<%@ include file="bht.jsp"%>
<!--banner图片的结束-->

<!--页面导航部分的开始-->
<!--页面导航部分的结束-->

<!--主题内容的开始-->
<!--关于菜菜饭店网上订餐系统的开始-->
<div class="gywst">
	<!--标题的开始-->
	<div class="gywst_title">
		<div class="gywstc">
			<h2>重置密码</h2>
			<span></span></div>
	</div>
	<!--标题的结束-->
	<!--内容的开始-->
	<div class="gywstnr">
		<form>
			用户名称:<input type="text" style='border:solid 1px #000000; color:#666666' name="loginname" id="loginname" size="12px" />&nbsp;&nbsp;
			姓名:<input type="text" style='border:solid 1px #000000; color:#666666' name="xingming" id="xingming" size="12px" />&nbsp;&nbsp;
			电话:<input type="text" style='border:solid 1px #000000; color:#666666' name="dianhua" id="dianhua" size="12px" />&nbsp;&nbsp;
			<input type="button" onclick="resetPw();" value="重置密码"/>
		</form>
		<div class="clear"></div>
	</div>
	<!--内容的结束-->
</div>
<!--主题内容的结束-->

<!--底部的开始-->
<%@ include file="qtdown.jsp" %>
<!--底部的结束-->
</body>
</html>
