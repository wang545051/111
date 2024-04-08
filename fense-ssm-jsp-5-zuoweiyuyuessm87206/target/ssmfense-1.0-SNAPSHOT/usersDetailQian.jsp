<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户详情</title>
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

        //跳转到子表liuyan添加页面
        function usersliuyanAddQian(id) {
            var url="${contextPath}/usersliuyanAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表liuyan查看页面
        function usersliuyanGetByusersidQian(id) {
            var url="${contextPath}/usersliuyanGetByusersidQian/"+id;
            window.location.href=url;
        }
        //跳转到子表lizuo添加页面
        function userslizuoAddQian(id) {
            var url="${contextPath}/userslizuoAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表lizuo查看页面
        function userslizuoGetByusersslidQian(id) {
            var url="${contextPath}/userslizuoGetByusersslidQian/"+id;
            window.location.href=url;
        }
        //跳转到子表ruzuo添加页面
        function usersruzuoAddQian(id) {
            var url="${contextPath}/usersruzuoAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表ruzuo查看页面
        function usersruzuoGetByusersslidQian(id) {
            var url="${contextPath}/usersruzuoGetByusersslidQian/"+id;
            window.location.href=url;
        }
        //跳转到子表yuyue添加页面
        function usersyuyueAddQian(id) {
            var url="${contextPath}/usersyuyueAddQian/"+id;
            window.location.href=url;
        }
        //跳转到子表yuyue查看页面
        function usersyuyueGetByusersidQian(id) {
            var url="${contextPath}/usersyuyueGetByusersidQian/"+id;
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
            <h2>用户信息</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <table width="100%" height=550  align="center" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF" class="newsline" >
    <tr>
        <td width="39%" height="44px">
            用户名称:
        </td>
        <td width="39%">
            ${users.loginname }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            密码:
        </td>
        <td width="39%">
            ${users.loginpw }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            类型:
        </td>
        <td width="39%">
            ${users.type}
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            类型名称:
        </td>
        <td width="39%">
            ${users.typename }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            姓名:
        </td>
        <td width="39%">
            ${users.xingming }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            性别:
        </td>
        <td width="39%">
            ${users.xingbie}
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            年龄:
        </td>
        <td width="39%">
            ${users.nianling }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            地址:
        </td>
        <td width="39%">
            ${users.address }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            电话:
        </td>
        <td width="39%">
            ${users.dianhua }
        </td>

    </tr>
    <tr>
        <td width="39%" height="44px">
            审核:
        </td>
        <td width="39%">
            ${users.shenhe}
        </td>

    </tr>

            <tr>
                <td>&nbsp;</td>
                <td colspan="3">
                <input type="button" value="留言反馈添加" onclick="usersliuyanAddQian(${users.id})"/>
                <input type="button" value="留言反馈查看" onclick="usersliuyanGetByusersidQian(${users.id})"/>
                <input type="button" value="离座添加" onclick="userslizuoAddQian(${users.id})"/>
                <input type="button" value="离座查看" onclick="userslizuoGetByusersslidQian(${users.id})"/>
                <input type="button" value="入座添加" onclick="usersruzuoAddQian(${users.id})"/>
                <input type="button" value="入座查看" onclick="usersruzuoGetByusersslidQian(${users.id})"/>
                <input type="button" value="预约添加" onclick="usersyuyueAddQian(${users.id})"/>
                <%--<input type="button" value="预约查看" onclick="usersyuyueGetByusersidQian(${users.id})"/>--%>

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



