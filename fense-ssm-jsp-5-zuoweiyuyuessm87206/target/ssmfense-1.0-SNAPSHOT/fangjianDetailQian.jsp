<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>房间详情</title>
    <%@include file="common/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="qtimages/css/wst.css"/>
    <link rel="stylesheet" href="${staticPath}/qtimages/hsgbanner.css">
    <script type="text/javascript" src="${staticPath}/qtimages/jquery.js"></script>
    <script type="text/javascript" src="${staticPath}/qtimages/inc.js"></script>
    <script language="javascript">
        function down(fujianPath) {
            var url = "${contextPath}/common/download?filename=" + fujianPath;
            url = encodeURI(url);
            window.open(url, "_self");
        }

        //跳转到子表zuowei添加页面
        function fangjianzuoweiAddQian(id) {
            var url="${contextPath}/fangjianzuoweiAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表zuowei查看页面
        function fangjianzuoweiGetByfangjianidQian(id) {
            var url="${contextPath}/fangjianzuoweiGetByfangjianidQian/"+id;
            window.location.href=url;
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
            <h2>房间信息</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <table width="100%" height=550  align="center" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF" class="newsline" >
    <tr>
        <td width="39%" height="44px">
            名称:
        </td>
        <td width="39%">
            ${fangjian.mingcheng }
        </td>

    </tr>

            <tr>
                <td>&nbsp;</td>
                <td colspan="3">
                <input type="button" value="座位添加" onclick="fangjianzuoweiAddQian(${fangjian.id})"/>
                <input type="button" value="座位查看" onclick="fangjianzuoweiGetByfangjianidQian(${fangjian.id})"/>

                    <input type="button" value="返回" onClick="javascript:history.back()" />
                    <%--<input type="button" value="打印" style="width: 60px;" onClick="javascript:window.print()" />--%>
                </td>
            </tr>
        </table>
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



