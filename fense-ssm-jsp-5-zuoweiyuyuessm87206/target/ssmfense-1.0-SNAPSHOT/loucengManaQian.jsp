<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>楼层列表</title>
    <%@include file="common/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="qtimages/css/wst.css"/>
    <link rel="stylesheet" href="${staticPath}/qtimages/hsgbanner.css">
    <script type="text/javascript" src="${staticPath}/qtimages/jquery.js"></script>
    <script type="text/javascript" src="${staticPath}/qtimages/inc.js"></script>
</head>
<script type="text/javascript">
    //附件下载
    function down(fujianPath) {
        var url = "${contextPath}/common/download?filename=" + fujianPath;
        url = encodeURI(url);
        window.open(url, "_self");
    }
</script>
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
            <h2>楼层</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <form name="formSearch" id="formSearch" method="post" action="${contextPath}/${actionName}">
        名称:<input type="text" style='border:solid 1px #000000; color:#666666' name="mingcheng" id="mingcheng" size="12px" value="${req.mingcheng}"/>&nbsp;&nbsp;

            <input type="submit" name="Submit" value="查找" style='border:solid 1px #000000; color:#666666' />
        </form>
        <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse" class="newsline">
            <tr>
<%--                <td width="40px" align="center" bgcolor="">序号</td>--%>
        <td bgcolor='' align="center">名称</td>

                <td width="40px" align="center" bgcolor="">详细</td>
            </tr>
            <c:forEach items="${pageInfo.records}" var="info" varStatus="s">
                <tr>
<%--                    <td width="40px" align="center">--%>
<%--                            ${s.index+1}--%>
<%--                    </td>--%>
            <td bgcolor="" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.mingcheng)>'16'}">
                        ${fn:substring(info.mingcheng,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.mingcheng}
                    </c:otherwise>
                </c:choose>
            </td>

                    <td width="40px" align="center">
                        <a href="${contextPath}/loucengDetailQian/${info.id}">
                            详细
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table><br>
        <%@ include file="common/fenye.jsp"%>
        <table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF"
               style="border-collapse:collapse" class="newsline">
            <tr>
                <td align="center" bgcolor="">
                    <%--<input type="button" value="打印" style="width: 60px;" onClick="javascript:window.print()" />--%>
                    <input type="button" value="返回" style="width: 60px;" onClick="javascript:history.back()" />
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
