<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>入座列表</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
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
            <h2>入座</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <form name="formSearch" id="formSearch" method="post" action="${contextPath}/ruzuoManaMyQian">
        姓名:<input type="text" name="xingming" id="xingming" size="15px" value="${req.xingming}"/>&nbsp;&nbsp;
        电话:<input type="text" name="dianhua" id="dianhua" size="15px" value="${req.dianhua}"/>&nbsp;&nbsp;
        座位:
        <select name="zuoweiid" id="zuoweiid">
            <option value="">全部</option>
            <c:forEach items="${zuoweiList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.zuoweiid}">
                        <option value="${s.id}" selected>
                                ${s.bianhao }
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">
                                ${s.bianhao}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>&nbsp;&nbsp;
        备注:<input type="text" name="beizhu" id="beizhu" size="15px" value="${req.beizhu}"/>&nbsp;&nbsp;
<%--        用户:
        <select name="usersslid" id="usersslid">
            <option value="">全部</option>
            <c:forEach items="${usersList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.usersslid}">
                        <option value="${s.id}" selected>
                                ${s.loginname }
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">
                                ${s.loginname}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>&nbsp;&nbsp;--%>

            <input type="submit" name="Submit" value="查找" style='border:solid 1px #000000; color:#666666' />
        </form>
        <table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse" class="newsline">
            <tr>
                <td width="40px" align="center" bgcolor="">序号</td>
        <td align="center">姓名</td>
        <td align="center">电话</td>
        <td align="center">座位</td>
        <td align="center">时间</td>
        <td align="center">备注</td>
        <td align="center">用户</td>

                <td width="40px" align="center" bgcolor="">详细</td>
            </tr>
            <c:forEach items="${pageInfo.records}" var="info" varStatus="s">
                <tr>
                    <td width="40px" align="center">
                            ${s.index+1}
                    </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.xingming)>'16'}">
                        ${fn:substring(info.xingming,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.xingming}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.dianhua)>'16'}">
                        ${fn:substring(info.dianhua,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.dianhua}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.zuowei.bianhao)>'16'}">
                        ${fn:substring(info.zuowei.bianhao,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.zuowei.bianhao}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.shijian)>'16'}">
                        ${fn:substring(info.shijian,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.shijian}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.beizhu)>'16'}">
                        ${fn:substring(info.beizhu,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.beizhu}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.users.loginname)>'16'}">
                        ${fn:substring(info.users.loginname,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.users.loginname}
                    </c:otherwise>
                </c:choose>
            </td>

                    <td width="40px" align="center">
                        <a href="${contextPath}/ruzuoDetailQian/${info.id}">
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
