<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<html>
<head>
    <title>后台登陆</title>
    <%@include file="common/head.jsp" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style type="text/css">
        <!--
        * {
            overflow: hidden;
            font-size: 9pt;
        }
        body {
            margin-left: 0px;
            margin-top: 0px;
            margin-right: 0px;
            margin-bottom: 0px;
            background-repeat: repeat-x;
            background-color: #821f2a;
        }

        -->
    </style>
</head>
<script type="text/javascript">
    <c:if test="${sessionScope.user!=null}">
    window.location.href = "${contextPath}/main.jsp";
    </c:if>

    function login() {
        var loginname = $("#loginname").length > 0 ? $('#loginname').val().trim():null;
        var loginpw = $('#loginpw').length > 0 ? $('#loginpw').val().trim():null;
        var captcha = $('#captcha').length > 0 ? $('#captcha').val().trim():null;
        var type = $('#type').length > 0 ? $('#type').val().trim():null;
        if ($("#loginname").length > 0 && loginname == "") {
            alert("请输入用户名");
            $('#loginname').focus();
            return false;
        }
        if ($("#loginpw").length > 0 && loginpw == "") {
            alert("请输入密码");
            $('#loginpw').focus();
            return false;
        }
        if ($("#captcha").length > 0 && captcha == "") {
            alert("请输入验证码");
            $('#captcha').focus();
            return false;
        }

        var param = {
            loginname: loginname,
            loginpw: loginpw,
            type: type,
            captcha: captcha
        };
        $.ajax({
            type: 'post',
            url: '${basePath}/login',
            data: param,
            dataType: "json",
            success: function (resp) {
                if (resp.success) {
                    alert("登陆成功！");
                    window.location.href = "${contextPath}/main.jsp";
                } else {
                    alert(resp.message);
                }
            }
        });
    }

    function loadimage() {
        document.getElementById("randImage").src = "${contextPath}/captcha?" + Math.random();
    }

</script>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"  background="${staticPath}/images/login.png">
<table width="1000" height="564" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="193" colspan="3">
            <div align="center" style="color: #CCFFCC;font-size: 26pt;font-weight: bold;">后台登录</div>
        </td>
    </tr>
    <tr>
        <td width="352" rowspan="2" valign="top">&nbsp;</td>
        <td width="211" height="152">
            <form action="" method="post" name="form1"
                  style="display: inline">
                <table width="205" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                        <td width="44" height="30"><span class="STYLE9">用户:</span></td>
                        <td height="30" colspan="2"><input name="loginname" type="text" id="loginname"
                                                           style="width:100px; height:16px; border:solid 1px #000000; color:#666666">
                        </td>
                    </tr>
                    <tr>
                        <td height="30"><span class="STYLE9">密码:</span></td>
                        <td height="30" colspan="2"><input name="loginpw" type="password" id="loginpw"
                                                           style="width:100px; height:16px; border:solid 1px #000000; color:#666666">
                        </td>
                    </tr>
                    <tr>
                        <td height="30"><span class="STYLE9">权限:</span></td>
                        <td height="30" colspan="2">
                            <select name="type" id="type">
                            <option value="0">管理员</option>
                             <%--<option value="1">老师</option>--%>
                            <option value="2">用户</option>
                            <!--quxanxiaxndexnglxu-->
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td height="30"><span class="STYLE9">验证码:</span></td>
                        <td width="59" height="30"><input name="captcha" type="text" id="captcha"
                                                          style=" height:20px; border:solid 1px #000000; color:#666666; width:50px"/>
                        <td width="102"><a href="javascript:loadimage();"><img alt="看不清请点我！" name="randImage"
                                                                               id="randImage" src="${contextPath}/captcha" width="60"
                                                                               height="20" border="1" align="absmiddle">
                        </a></td>
                    </tr>
                    <tr>
                        <td height="30" colspan="3">
                            <input type="button" name="Submit" value="登陆"
                                                           onClick="login()"
                                                           style="background:url(${staticPath}/images/the_formbtn.gif) no-repeat;color:#000000;width:80px;height: 24px; border:0px;line-height:24px; font-size:12px;margin-right: 5px; cursor:pointer">
                            <input type="button" name="Submit" value="注册"
                                   onClick="javascript:location.href='usersreg.jsp';"
                                   style="background:url(${staticPath}/images/the_formbtn.gif) no-repeat;color:#000000;width:80px;height: 24px; border:0px;line-height:24px; font-size:12px;margin-right: 5px; cursor:pointer">
                            <input type="reset" name="Submit2" value="重置"
                                   style="background:url(${staticPath}/images/the_formbtn.gif) no-repeat;color:#000000;width:80px;height: 24px; border:0px;line-height:24px; font-size:12px;margin-right: 5px; cursor:pointer">
                        </td>
                    </tr>
                </table>
            </form>
        </td>
        <td width="437" rowspan="2">&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;</td>
    </tr>
</table>
</body>
</html>



