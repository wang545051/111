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
    <title>房间查看列表</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <script type="text/javascript">
        //导出信息
        function daochu() {
            var url = "${contextPath}/fangjianChakan?d=1";
            window.location.href=url;
        }
        //删除信息
        function fangjianDel(id) {
            if (confirm('您确定删除吗?')) {
                $.get(basePath + '/fangjianDel/' + id, function (resp) {
                    if (resp.success) {
                        alert("删除成功！");
                        //window.location.href = "${contextPath}/fangjianChankan";
                        document.formSearch.submit();
                        return;
                    } else {
                        alert(resp.message);
                    }
                })
            }
        }

        //跳转到信息修改页
        function fangjianGet(id) {
            window.location.href = "${contextPath}/fangjianGet/" + id;
        }

        //跳转到信息详细页
        function fangjianDetail(id) {
            window.location.href = "${contextPath}/fangjianDetail/" + id;
        }

        //附件下载
        function down(fujianPath) {
            var url = "${contextPath}/common/download?filename=" + fujianPath;
            url = encodeURI(url);
            window.open(url, "_self");
        }

        //更新信息
        function fangjianSet(id,property,value) {
            if (confirm('您确定操作吗?')) {
                var param = {};
                param["id"]=id;
                param[property]=value;
                $.post(basePath + '/fangjianSet', param, function(resp) {
                    if (resp.success) {
                        alert("操作成功！");
                        //window.location.href = "${contextPath}/fangjianChankan";
                        document.formSearch.submit();
                        return;
                    }else {
                        alert(resp.message);
                    }
                })
            }
        }

        //跳转到子表zuowei添加页面
        function fangjianzuoweiAdd(id) {
            var url="${contextPath}/fangjianzuoweiAdd/"+id;
            window.location.href=url;
        }
        //跳转到子表zuowei查看页面
        function fangjianzuoweiGetByfangjianid(id) {
            var url="${contextPath}/fangjianzuoweiGetByfangjianid/"+id;
            window.location.href=url;
        }


    </script>
</head>
<body leftmargin="2" topmargin="2">
<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px"
       bordercolor="#008080">
    <form action="${contextPath}/fangjianChakan" name="formSearch" id="formSearch" method="post">
        <div>
        名称:<input type="text" name="mingcheng" id="mingcheng" size="15px" value="${req.mingcheng}"/>&nbsp;&nbsp;

            <input type="submit" value="搜索"/>
        </div>
    </form>
    <tr bgcolor="#E7E7E7">
        <td height="14" colspan="100" background="${staticPath}/images/tbg.gif">房间查看</td>
    </tr>
    <tr align="center" bgcolor="#C0C0C0" height="22">
        <td width="2%">序号</td>
        <td width="5%">名称</td>

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
                    <c:when test="${fn:length(info.mingcheng)>'16'}">
                        ${fn:substring(info.mingcheng,0,16)}...
                    </c:when>
                    <c:otherwise>
                        ${info.mingcheng}
                    </c:otherwise>
                </c:choose>
            </td>

            <td bgcolor="#FFFFFF" align="center">

<%--                <input type="button" value="修改" onclick="fangjianGet(${info.id})"/>--%>
                <input type="button" value="详情" onclick="fangjianDetail(${info.id})"/>
<%--                <input type="button" value="删除" onclick="fangjianDel(${info.id})"/>--%>
                    <%--sonTable本表子表管理--%>
                <%--<input type="button" value="房间座位查看" onclick="fangjianzuoweiGetByfangjianid(${info.id})"/>--%>
                <%--<input type="button" value="房间座位添加" onclick="fangjianzuoweiAdd(${info.id})"/>--%>

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
