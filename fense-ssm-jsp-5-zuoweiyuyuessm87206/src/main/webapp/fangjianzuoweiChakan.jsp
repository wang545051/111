<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String d = request.getParameter("d");
    if (null != d && d.equals("1")) {
        response.setHeader("Content-disposition", "attachment; filename=daochu.xls");
    }
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>座位查看列表</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <script type="text/javascript">
        //导出信息
        function daochu() {
            var url = "${contextPath}/zuoweiChakan?d=1";
            window.location.href=url;
        }
        //删除信息
        function zuoweiDel(id) {
            if (confirm('您确定删除吗?')) {
                $.get(basePath + '/zuoweiDel/' + id, function (resp) {
                    if (resp.success) {
                        alert("删除成功！");
                        //window.location.href = "${contextPath}/zuoweiChankan";
                        document.formSearch.submit();
                        return;
                    } else {
                        alert(resp.message);
                    }
                })
            }
        }

        //跳转到信息修改页
        function zuoweiGet(id) {
            window.location.href = "${contextPath}/zuoweiGet/" + id;
        }

        //跳转到信息详细页
        function zuoweiDetail(id) {
            window.location.href = "${contextPath}/zuoweiDetail/" + id;
        }

        //附件下载
        function down(fujianPath) {
            var url = "${contextPath}/common/download?filename=" + fujianPath;
            url = encodeURI(url);
            window.open(url, "_self");
        }

        //更新信息
        function zuoweiSet(id,property,value) {
            if (confirm('您确定操作吗?')) {
                var param = {};
                param["id"]=id;
                param[property]=value;
                $.post(basePath + '/zuoweiSet', param, function(resp) {
                    if (resp.success) {
                        alert("操作成功！");
                        //window.location.href = "${contextPath}/zuoweiChankan";
                        document.formSearch.submit();
                        return;
                    }else {
                        alert(resp.message);
                    }
                })
            }
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
<body leftmargin="2" topmargin="2">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px"
       bordercolor="#008080">
    <form action="${contextPath}/zuoweiChakan" name="formSearch" id="formSearch" method="post">
        <div style="display: none">
        编号:<input type="text" name="bianhao" id="bianhao" size="15px" value="${req.bianhao}"/>&nbsp;&nbsp;
        类别:
        <select name="leibieid" id="leibieid">
            <option value="">全部</option>
            <c:forEach items="${leibieList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.leibieid}">
                        <option value="${s.id}" selected>
                                ${s.mingcheng }
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">
                                ${s.mingcheng}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>&nbsp;&nbsp;
        楼层:
        <select name="loucengid" id="loucengid">
            <option value="">全部</option>
            <c:forEach items="${loucengList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.loucengid}">
                        <option value="${s.id}" selected>
                                ${s.mingcheng }
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">
                                ${s.mingcheng}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>&nbsp;&nbsp;
        房间:
        <select name="fangjianid" id="fangjianid">
            <option value="">全部</option>
            <c:forEach items="${fangjianList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.fangjianid}">
                        <option value="${s.id}" selected>
                                ${s.mingcheng }
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">
                                ${s.mingcheng}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>&nbsp;&nbsp;
        是否空闲:
        <select name="shenhe" id="shenhe">
            <option value="">全部</option>
            <option value="yes" <c:if test="${req.shenhe == 'yes'}">selected</c:if>>yes</option>
            <option value="no" <c:if test="${req.shenhe == 'no'}">selected</c:if>>no</option>
        </select>&nbsp;&nbsp;

            <input type="submit" value="搜索"/>
        </div>
    </form>
    <tr bgcolor="#E7E7E7">
        <td height="14" colspan="100" background="${staticPath}/images/tbg.gif">座位查看</td>
    </tr>
    <tr align="center" bgcolor="#C0C0C0" height="22">
        <td width="2%">序号</td>
        <td width="5%">编号</td>
        <td width="4%">类别</td>
        <td width="4%">楼层</td>
        <td width="4%">房间</td>
        <td width="4%">是否空闲</td>
        <td width="4%">环境图片</td>

        <td width="10%">操作</td>
    </tr>
    <c:forEach items="${pageInfo.records}" var="info" varStatus="s">
        <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';"
            onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
            <td bgcolor="#FFFFFF" align="center">
                    ${s.index +1 }
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.bianhao)>'16'}">
                        ${fn:substring(info.bianhao,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.bianhao}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.leibie.mingcheng)>'16'}">
                        ${fn:substring(info.leibie.mingcheng,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.leibie.mingcheng}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.louceng.mingcheng)>'16'}">
                        ${fn:substring(info.louceng.mingcheng,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.louceng.mingcheng}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.fangjian.mingcheng)>'16'}">
                        ${fn:substring(info.fangjian.mingcheng,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.fangjian.mingcheng}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.shenhe)>'16'}">
                        ${fn:substring(info.shenhe,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.shenhe}
                    </c:otherwise>
                </c:choose>
            </td>
            <td width='90' align='center'>
                <a href='${contextPath}/${info.image}' target='_blank'>
                    <img src='${contextPath}/${info.image}' width="88" height="99" border="0"  onerror="this.src='${staticPath}/images/zanwu.jpg'" />
                </a>
            </td>

            <td bgcolor="#FFFFFF" align="center">
            <c:choose>
                <c:when test="${info.shenhe=='no'}">
                <input type="button" value="是否空闲" onclick="zuoweiSet(${info.id},'shenhe','yes')"/>
                </c:when>
                <c:otherwise>
                <input type="button" value="取消是否空闲" onclick="zuoweiSet(${info.id},'shenhe','no')"/>
                </c:otherwise>
            </c:choose>

<%--                <input type="button" value="修改" onclick="zuoweiGet(${info.id})"/>--%>
                <input type="button" value="详情" onclick="zuoweiDetail(${info.id})"/>
<%--                <input type="button" value="删除" onclick="zuoweiDel(${info.id})"/>--%>
                    <%--sonTable本表子表管理--%>
                <%--<input type="button" value="座位离座查看" onclick="zuoweilizuoGetByzuoweiid(${info.id})"/>--%>
                <%--<input type="button" value="座位离座添加" onclick="zuoweilizuoAdd(${info.id})"/>--%>
                <%--<input type="button" value="座位入座查看" onclick="zuoweiruzuoGetByzuoweiid(${info.id})"/>--%>
                <%--<input type="button" value="座位入座添加" onclick="zuoweiruzuoAdd(${info.id})"/>--%>
                <%--<input type="button" value="座位预约查看" onclick="zuoweiyuyueGetByzuoweiid(${info.id})"/>--%>
                <%--<input type="button" value="座位预约添加" onclick="zuoweiyuyueAdd(${info.id})"/>--%>

            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="common/fenye.jsp" %>
<table width='98%' border='0' style="margin-top:8px;margin-left: 8px;">
    <tr>
        <td>
            <%--<input type="button" value="导出"  onclick="daochu();" />--%>
            <%--<input type="button" value="打印"  onClick="javascript:window.print()" />--%>
            <input type="button" value="返回" style="width: 120px;" onClick="javascript:history.back()"/>
        </td>

    </tr>
</table>

<div id="tip" style="position:absolute;display:none;border:0px;width:80px; height:80px;">
    <TABLE id="tipTable" border="0" bgcolor="#ffffee">
        <TR align="center">
            <TD><img id="photo" src="" height="160" width="200"></TD>
        </TR>
    </TABLE>
</div>
</body>
</html>
