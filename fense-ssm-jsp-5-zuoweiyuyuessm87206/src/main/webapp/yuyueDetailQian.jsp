<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>预约详情</title>
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
            <h2>预约信息</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <table width="100%" height=550  align="center" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF" class="newsline" >
    <tr>
        <td width="39%" height="44px">
            姓名:
        </td>
        <td width="39%">
            ${yuyue.xingming }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            电话:
        </td>
        <td width="39%">
            ${yuyue.dianhua }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            座位:
        </td>
        <td width="39%">
            ${yuyue.zuowei.bianhao}
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            时段:
        </td>
        <td width="39%">
            ${yuyue.shiduan.jianduan}
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            日期:
        </td>
        <td width="39%">
            ${yuyue.riqi }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            备注:
        </td>
        <td width="39%">
            ${yuyue.beizhu }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            用户:
        </td>
        <td width="39%">
            ${yuyue.users.loginname}
        </td>

    </tr>

            <tr>
                <td>&nbsp;</td>
                <td colspan="3">

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



