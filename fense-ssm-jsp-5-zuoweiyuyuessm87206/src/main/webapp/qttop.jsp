 <%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="wtop">
    <div class="wtopc">
        <div class="wtopl"><span style="font-size: 30px">图书馆座位预约管理系统</span></div>
        <div class="wtopr fr">
            <c:if test="${sessionScope.user==null}">
                <table width="583" height="30" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="right">
                            <input type="button" name="Submit32" value="用户登陆"
                                   onClick="javascript:location.href='${contextPath}/userlog.jsp';"/>
                            <input type="button" name="Submit32" value="用户注册"
                                   onClick="javascript:location.href='${contextPath}/usersAddQian.jsp';"/>
                        </td>
                    </tr>
                </table>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                <table width="545" height="30" border="0" cellpadding="0" cellspacing="0">
                    <form action="jspmtemp?ac=login&amp;a=a" method="post" name="f11" id="f11" style="display: inline">
                        <tr>
                            <td width="226" height="30" align="right">用户名:</td>
                            <td width="10" align="right">&nbsp;</td>
                            <td width="53" align="left">${sessionScope.user.loginname}
                            </td>
                            <td width="37" align="left">
                                权限:
                            </td>
                            <td width="78" align="left">${sessionScope.user.typename}
                            </td>
                            <td width="68" align="left"><input type="button" name="Submit2" value="个人后台"
                                                               onclick="location.href='${contextPath}/main.jsp';"/></td>
                            <td width="75" align="center"><input type="button" name="Submit2" value="退出"
                                                                 onclick="location.href='${contextPath}/userlogout.jsp';"/>
                            </td>
                        </tr>
                    </form>
                </table>
            </c:if>
        </div>
    </div>
</div>
<div id="hsgbanner">
    <div class="navgrp">
        <ul class="nav" id="nav">
            <li class="cur"><a href="${contextPath}/default.jsp">网站首页</a></li>
            <li><a href="${contextPath}/dxManaQian">介绍</a></li>
            <li><a href="${contextPath}/gonggaoManaQiantp">公告</a></li>
            <li><a href="${contextPath}/zuoweiManaQiantp?shenhe=yes">座位信息</a></li>
            <li><a href="${contextPath}/liuyanAddQian.jsp">在线留言</a></li>
            <li><a href="${contextPath}/liuyanManaQian">留言信息</a></li>
            <li><a href="${contextPath}/login.jsp">后台管理</a></li>
        </ul>
    </div>
</div>