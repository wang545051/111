<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>用户登陆</title>
    <%@include file="common/head.jsp" %>
    <link rel="stylesheet" type="text/css" href="${staticPath}/qtimages/css/wst.css"/>
    <link rel="stylesheet" href="${staticPath}/qtimages/hsgbanner.css">
    <script type="text/javascript" src="${staticPath}/qtimages/jquery.js"></script>
    <script type="text/javascript" src="${staticPath}/qtimages/inc.js"></script>
    <script type="text/javascript" src="${staticPath}/js/popup.js"></script>
</head>
<body>

<!--头部代码的开始-->
<%@ include file="qttop.jsp" %>
<!--头部代码的结束-->

<!--子页面banner-->
<%--<div class="scban"></div>--%>
<!--子页面banner-->

<!--banner图片的开始-->
<%@ include file="bht.jsp" %>

<!--banner图片的结束-->

<!--页面导航部分的开始-->

<!--页面导航部分的结束-->

<!--主题内容的开始-->
<div class="gywst">
    <!--标题的开始-->
    <div class="gywst_title">
        <div class="gywstc">
            <h2>用户登录 </h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr" style="width: 400px">
        <c:if test="${sessionScope.user==null}">
            <form action="" method="post" name="formlogin" id="formlogin"
                  style="display: inline">
                <table width="100%" height="52%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="93" height="50">&nbsp;</td>
                        <td width="99" height="28">用户名:</td>
                        <td height="28" colspan="2"><input name="loginname" type="text" id="loginname"
                                                           placeholder="请输入用户名"
                                                           style="width:160px; height:40px; border:solid 1px #000000; color:#666666;"/>
                        </td>
                    </tr>
                    <tr>
                        <td height="50">&nbsp;</td>
                        <td height="28">密码:</td>
                        <td height="28" colspan="2"><input name="loginpw" type="password" id="loginpw"
                                                           placeholder="请输入密码"
                                                           style="width:160px; height:40px; border:solid 1px #000000; color:#666666"/>
                        </td>
                    </tr>
                    <tr>
                        <td height="50">&nbsp;</td>
                        <td height="28">权限:</td>
                        <td height="28" colspan="2">
                            <select name="type" id="type"
                                    style="width:160px; height:40px; border:solid 1px #000000; color:#666666">
                                <option value="2">用户</option>
                                <option value="0">管理员</option>
                                <!--quxanxiaxndexnglxu-->
                            </select></td>
                    </tr>
                    <tr>
                        <td height="50">&nbsp;</td>
                        <td height="28">验证码</td>
                        <td width="80" height="28"><input name="captcha" type="text" id="captcha"
                                                          style=" height:30px; border:solid 1px #000000; color:#666666; width:110px"/>
                        </td>
                        <td width="868"><a href="javascript:loadimage();"><img alt="看不清请点我！"
                                                                               name="randImage"
                                                                               id="randImage"
                                                                               src="${contextPath}/captcha" width="60"
                                                                               height="20" border="1"
                                                                               align="absmiddle"/></a></td>
                    </tr>
                    <tr>
                        <td height="50" align="center">&nbsp;</td>
                        <td height="38" colspan="3" align="left"><input type="button" name="Submit"
                                                                        value="登陆" class="hsgbutton"
                                                                        onclick="login();"/>
                            <input type="reset" name="Submit2" value="重置" class="hsgbutton"/></td>
                    </tr>
                </table>
            </form>
        </c:if>
        <c:if test="${sessionScope.user!=null}">
            <table width="90%" height="82%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="31%" height="30">用户名</td>
                    <td width="69%" height="30">${sessionScope.user.loginname}
                    </td>
                </tr>
                <tr>
                    <td height="30">权限</td>
                    <td height="30">${sessionScope.user.typename}
                    </td>
                </tr>
                <tr>
                    <td height="30" colspan="2" align="center"><input type="button" name="Submit3"
                                                                      value="退出"
                                                                      onclick="javascript:location.href='${contextPath}/userlogout.jsp';"/>
                        <input type="button" name="Submit32" value="个人后台"
                               onclick="javascript:location.href='${contextPath}/main.jsp';"/>
                    </td>
                </tr>
            </table>
        </c:if>


        <div class="clear"></div>
    </div>
    <!--内容的结束-->
</div>

<!--主题内容的结束-->

<!--底部的开始-->
<%@ include file="qtdown.jsp" %>
<!--底部的结束-->
</body>
<script type="text/javascript">
    function login() {
        var loginname = $('#loginname').val().trim();
        var loginpw = $('#loginpw').val().trim();
        var captcha = $('#captcha').val().trim();
        var type = $('#type').val();
        var fromurl = document.referrer;
        if (loginname == "") {
            alert("请输入用户名");
            $('#loginname').focus();
            return false;
        }
        if (loginpw == "") {
            alert("请输入密码");
            $('#loginpw').focus();
            return false;
        }
        if (captcha == "") {
            alert("请输入验证码");
            $('#captcha').focus();
            return false;
        }

        var param = {
            loginname: loginname,
            loginpw: loginpw,
            type:  type,
            captcha: captcha
        };
        $.ajax({
            type:'post',
            url: '${basePath}/login',
            data: param,
            dataType: "json",
            success: function (resp) {
                if (resp.success) {
                    alert("验证成功");
                    window.location.href = "${contextPath}/default.jsp";
                }else {
                    alert(resp.message);
                }
            }
        });
    }

</script>
</html>




