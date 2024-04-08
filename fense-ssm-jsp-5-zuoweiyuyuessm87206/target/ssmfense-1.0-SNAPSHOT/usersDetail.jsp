<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台用户详情</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <link href="${staticPath}/css/css.css" type=text/css rel=stylesheet>
    <script language="javascript">
        //附件下载
        function down(fujianPath) {
            var url = "${contextPath}/common/download?filename=" + fujianPath;
            url = encodeURI(url);
            window.open(url, "_self");
        }

        //跳转到子表liuyan添加页面
        function usersliuyanAdd(id) {
            var url="${contextPath}/usersliuyanAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表liuyan查看页面
        function usersliuyanGetByusersid(id) {
            var url="${contextPath}/usersliuyanGetByusersid/"+id;
            window.location.href=url;
        }
        //跳转到子表lizuo添加页面
        function userslizuoAdd(id) {
            var url="${contextPath}/userslizuoAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表lizuo查看页面
        function userslizuoGetByusersslid(id) {
            var url="${contextPath}/userslizuoGetByusersslid/"+id;
            window.location.href=url;
        }
        //跳转到子表ruzuo添加页面
        function usersruzuoAdd(id) {
            var url="${contextPath}/usersruzuoAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表ruzuo查看页面
        function usersruzuoGetByusersslid(id) {
            var url="${contextPath}/usersruzuoGetByusersslid/"+id;
            window.location.href=url;
        }
        //跳转到子表yuyue添加页面
        function usersyuyueAdd(id) {
            var url="${contextPath}/usersyuyueAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表yuyue查看页面
        function usersyuyueGetByusersid(id) {
            var url="${contextPath}/usersyuyueGetByusersid/"+id;
            window.location.href=url;
        }

    </script>
</head>
<body leftmargin="2" topmargin="9" background='${staticPath}/img/allbg.gif'>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom:8px">
    <tr bgcolor="#EEF4EA">
        <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;用户详情</span>
        </td>
    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            用户名称:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.loginname }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            密码:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.loginpw }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            类型:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.type}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            类型名称:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.typename }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            姓名:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.xingming }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            性别:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.xingbie}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            年龄:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.nianling }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            地址:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.address }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            电话:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.dianhua }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            审核:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${users.shenhe}
        </td>

    </tr>

    <tr>
        <td width="10" bgcolor="#FFFFFF" align="right">
            &nbsp;
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
                <%--<input type="button" value="留言反馈添加" onclick="usersliuyanAdd(${users.id})"/>--%>
                <%--<input type="button" value="留言反馈查看" onclick="usersliuyanGetByusersid(${users.id})"/>--%>
                <%--<input type="button" value="离座添加" onclick="userslizuoAdd(${users.id})"/>--%>
                <%--<input type="button" value="离座查看" onclick="userslizuoGetByusersslid(${users.id})"/>--%>
                <%--<input type="button" value="入座添加" onclick="usersruzuoAdd(${users.id})"/>--%>
                <%--<input type="button" value="入座查看" onclick="usersruzuoGetByusersslid(${users.id})"/>--%>
                <%--<input type="button" value="预约添加" onclick="usersyuyueAdd(${users.id})"/>--%>
                <%--<input type="button" value="预约查看" onclick="usersyuyueGetByusersid(${users.id})"/>--%>

            <input type="button" value="打印" onClick="javascript:window.print()"/>
            <input type="button" value="返回" onClick="javascript:history.back()"/>
        </td>
    </tr>
</table>
</body>
</html>


