<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台轮播图详情</title>
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
        <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;轮播图详情</span>
        </td>
    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            标题:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${lunbo.biaoti }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            图片:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            <img src="${contextPath}/${lunbo.image}" alt="" width="550" height="350" onerror="this.src='${staticPath}/images/zanwu.jpg'" />
            <br />
        <c:choose>
            <c:when test='${ null != lunbo.image && !lunbo.image.equals("")}'>
                <a href="#" onclick="down('${lunbo.image}')" style="font-size: 11px;color: red">下载</a>
            </c:when>
            <c:otherwise>
                暂无
            </c:otherwise>
        </c:choose>
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


