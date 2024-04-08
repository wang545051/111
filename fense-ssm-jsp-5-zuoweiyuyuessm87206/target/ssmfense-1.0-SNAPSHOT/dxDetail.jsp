<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台介绍详情</title>
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


    </script>
</head>
<body leftmargin="2" topmargin="9" background='${staticPath}/img/allbg.gif'>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom:8px">
    <tr bgcolor="#EEF4EA">
        <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;介绍详情</span>
        </td>
    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            类别:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${dx.leibie }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            内容:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${dx.content }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            时间:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${dx.addtime }
        </td>

    </tr>

    <tr>
        <td width="10" bgcolor="#FFFFFF" align="right">
            &nbsp;
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">

            <input type="button" value="打印" onClick="javascript:window.print()"/>
            <input type="button" value="返回" onClick="javascript:history.back()"/>
        </td>
    </tr>
</table>
</body>
</html>


