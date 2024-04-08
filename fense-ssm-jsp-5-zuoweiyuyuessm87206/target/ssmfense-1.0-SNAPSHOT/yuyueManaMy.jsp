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
    <title>预约管理列表</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <script type="text/javascript">
        //导出信息
        function daochu() {
            var url = "${contextPath}/yuyueManaMy?d=1";
            window.location.href=url;
        }
        //删除信息
        function yuyueDel(id) {
            if (confirm('您确定删除吗?')) {
                $.get(basePath + '/yuyueDel/' + id, function (resp) {
                    if (resp.success) {
                        alert("删除成功！");
                        //window.location.href = "${contextPath}/yuyueManaMy";
                        document.formSearch.submit();
                        return;
                    } else {
                        alert(resp.message);
                    }
                })
            }
        }

        //跳转到信息修改页
        function yuyueGet(id) {
            window.location.href = "${contextPath}/yuyueGet/" + id;
        }

        //跳转到信息详细页
        function yuyueDetail(id) {
            window.location.href = "${contextPath}/yuyueDetail/" + id;
        }

        //附件下载
        function down(fujianPath) {
            var url = "${contextPath}/common/download?filename=" + fujianPath;
            url = encodeURI(url);
            window.open(url, "_self");
        }

        //更新信息
        function yuyueSet(id,property,value) {
            if (confirm('您确定操作吗?')) {
                var param = {};
                param["id"]=id;
                param[property]=value;
                $.post(basePath + '/yuyueSet', param, function(resp) {
                    if (resp.success) {
                        alert("操作成功！");
                        //window.location.href = "${contextPath}/yuyueManaMy";
                        document.formSearch.submit();
                        return;
                    }else {
                        alert(resp.message);
                    }
                })
            }
        }



    </script>
</head>
<body leftmargin="2" topmargin="2">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px"
       bordercolor="#008080">
    <form action="${contextPath}/yuyueManaMy" name="formSearch" id="formSearch" method="post">
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
        时段:
        <select name="shiduanid" id="shiduanid">
            <option value="">全部</option>
            <c:forEach items="${shiduanList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.shiduanid}">
                        <option value="${s.id}" selected>
                                ${s.jianduan }
                        </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${s.id}">
                                ${s.jianduan}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>&nbsp;&nbsp;
        日期:<input type="text" name="riqi" id="riqi" style="border:1px solid #cccccc;" class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})"  size="15px" value="${req.riqi}"/>&nbsp;&nbsp;
        备注:<input type="text" name="beizhu" id="beizhu" size="15px" value="${req.beizhu}"/>&nbsp;&nbsp;
<%--        用户:
        <select name="usersid" id="usersid">
            <option value="">全部</option>
            <c:forEach items="${usersList}" var="s">
                <c:choose>
                    <c:when test="${s.id==req.usersid}">
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

        <input type="submit" value="搜索"/>
    </form>
    <tr bgcolor="#E7E7E7">
        <td height="14" colspan="100" background="${staticPath}/images/tbg.gif">预约管理</td>
    </tr>
    <tr align="center" bgcolor="#C0C0C0" height="22">
        <td width="2%">序号</td>
        <td width="5%">姓名</td>
        <td width="4%">电话</td>
        <td width="4%">座位</td>
        <td width="4%">时段</td>
        <td width="5%">日期</td>
        <td width="5%">备注</td>
        <td width="4%">用户</td>

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
                    <c:when test="${fn:length(info.shiduan.jianduan)>'16'}">
                        ${fn:substring(info.shiduan.jianduan,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.shiduan.jianduan}
                    </c:otherwise>
                </c:choose>
            </td>
            <td bgcolor="#FFFFFF" align="center">
                <c:choose>
                    <c:when test="${fn:length(info.riqi)>'16'}">
                        ${fn:substring(info.riqi,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.riqi}
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

            <td bgcolor="#FFFFFF" align="center">

                <input type="button" value="修改" onclick="yuyueGet(${info.id})"/>
                <input type="button" value="详情" onclick="yuyueDetail(${info.id})"/>
                <input type="button" value="删除" onclick="yuyueDel(${info.id})"/>
                    <%--sonTable本表子表管理--%>

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
