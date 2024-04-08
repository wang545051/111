<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台座位详情</title>
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

        //跳转到子表lizuo添加页面
        function zuoweilizuoAdd(id) {
            var url="${contextPath}/zuoweilizuoAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表lizuo查看页面
        function zuoweilizuoGetByzuoweiid(id) {
            var url="${contextPath}/zuoweilizuoGetByzuoweiid/"+id;
            window.location.href=url;
        }
        //跳转到子表ruzuo添加页面
        function zuoweiruzuoAdd(id) {
            var url="${contextPath}/zuoweiruzuoAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表ruzuo查看页面
        function zuoweiruzuoGetByzuoweiid(id) {
            var url="${contextPath}/zuoweiruzuoGetByzuoweiid/"+id;
            window.location.href=url;
        }
        //跳转到子表yuyue添加页面
        function zuoweiyuyueAdd(id) {
            var url="${contextPath}/zuoweiyuyueAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表yuyue查看页面
        function zuoweiyuyueGetByzuoweiid(id) {
            var url="${contextPath}/zuoweiyuyueGetByzuoweiid/"+id;
            window.location.href=url;
        }

    </script>
</head>
<body leftmargin="2" topmargin="9" background='${staticPath}/img/allbg.gif'>
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
       style="margin-bottom:8px">
    <tr bgcolor="#EEF4EA">
        <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;座位详情</span>
        </td>
    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            编号:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${zuowei.bianhao }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            类别:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${zuowei.leibie.mingcheng}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            楼层:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${zuowei.louceng.mingcheng}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            房间:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${zuowei.fangjian.mingcheng}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            座位介绍:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${zuowei.neirong }
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            是否空闲:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            ${zuowei.shenhe}
        </td>

    </tr>
    <tr>
        <td width="10%" bgcolor="#FFFFFF" align="right">
            环境图片:
        </td>
        <td width="90%" bgcolor="#FFFFFF" align="left">
            <img src="${contextPath}/${zuowei.image}" alt="" width="550" height="350" onerror="this.src='${staticPath}/images/zanwu.jpg'" />
            <br />
        <c:choose>
            <c:when test='${ null != zuowei.image && !zuowei.image.equals("")}'>
                <a href="#" onclick="down('${zuowei.image}')" style="font-size: 11px;color: red">下载</a>
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
                <%--<input type="button" value="离座添加" onclick="zuoweilizuoAdd(${zuowei.id})"/>--%>
                <%--<input type="button" value="离座查看" onclick="zuoweilizuoGetByzuoweiid(${zuowei.id})"/>--%>
                <%--<input type="button" value="入座添加" onclick="zuoweiruzuoAdd(${zuowei.id})"/>--%>
                <%--<input type="button" value="入座查看" onclick="zuoweiruzuoGetByzuoweiid(${zuowei.id})"/>--%>
                <%--<input type="button" value="预约添加" onclick="zuoweiyuyueAdd(${zuowei.id})"/>--%>
                <%--<input type="button" value="预约查看" onclick="zuoweiyuyueGetByzuoweiid(${zuowei.id})"/>--%>

            <input type="button" value="打印" onClick="javascript:window.print()"/>
            <input type="button" value="返回" onClick="javascript:history.back()"/>
        </td>
    </tr>
</table>
</body>
</html>


