<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台用户修改</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <link href="${staticPath}/css/css.css" type=text/css rel=stylesheet>
    <script type="text/javascript" src="${staticPath}/js/popup.js"></script>
    <script type="text/javascript">
        //文件上传
        function upx(id) {
            var pop = new Popup({contentType: 1, isReloadOnClose: false, width: 400, height: 200});
            pop.setContent("contentUrl", "${contextPath}/common/upload/?id=" + id);
            pop.setContent("title", "文件上传");
            pop.build();
            pop.show();
        }

        // 修改用户
        function usersSet() {
            var id = $('#id').val();
			var loginname  = $("#loginname").length > 0 ? $('#loginname').val().trim():null;
			if($("#loginname").length > 0 && loginname == "")
			{
				alert("please input:用户名称");
			    $('#loginname').focus();
				return false;
			}
			var loginpw=$('#loginpw').val().trim();
			var type  = $("#type").length > 0 ? $('#type').val().trim():null;
			if($("#type").length > 0 && type == "")
			{
				alert("please input:类型");
			    $('#type').focus();
				return false;
			}
			var typename  = $("#typename").length > 0 ? $('#typename').val().trim():null;
			if($("#typename").length > 0 && typename == "")
			{
				alert("please input:类型名称");
			    $('#typename').focus();
				return false;
			}
			var xingming  = $("#xingming").length > 0 ? $('#xingming').val().trim():null;
			if($("#xingming").length > 0 && xingming == "")
			{
				alert("please input:姓名");
			    $('#xingming').focus();
				return false;
			}
			var xingbie=$('#xingbie').val().trim();
			var nianling  = $("#nianling").length > 0 ? $('#nianling').val().trim():null;
			if($("#nianling").length > 0 && nianling == "")
			{
				alert("please input:年龄");
			    $('#nianling').focus();
				return false;
			}
			var address  = $("#address").length > 0 ? $('#address').val().trim():null;
			if($("#address").length > 0 && address == "")
			{
				alert("please input:地址");
			    $('#address').focus();
				return false;
			}
			var dianhua = $("#dianhua").length > 0 ? $('#dianhua').val().trim():null;
			if ($("#dianhua").length > 0) {
				if (dianhua == "") {
					alert("please input:电话");
					$('#dianhua').focus();
					return false;
				} else {
					if (/^[1][3,4,5,6,7,8,9][0-9]{9}$/.test(dianhua)) {
					} else {
						alert("必需手机格式");
						$('#dianhua').focus();
						return false;
					}
				}
			}
			var shenhe=$('#shenhe').val().trim();

            var param = {
                'id': id,
				'loginname':loginname,
				'loginpw':loginpw,
				'type':type,
				'typename':typename,
				'xingming':xingming,
				'xingbie':xingbie,
				'nianling':nianling,
				'address':address,
				'dianhua':dianhua,
				'shenhe':shenhe,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/usersAddOrUpdate',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("修改成功！");
                        //window.location.href = "${contextPath}/usersMana";
                    } else {
                        alert(resp.message);
                    }
                }
            });
        }
    </script>
</head>


<body>

<form name="formAdd" id="formAdd">
    <table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC"
           style="margin-bottom:8px">
        <tr bgcolor="#EEF4EA">
            <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;用户修改</span>
            </td>
        </tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				用户名称:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="loginname" id="loginname" value="${users.loginname }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				密码:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="loginpw" id="loginpw" value="" size="90px"/>&nbsp;(请输入新密码,不输入则原密码不变!)*
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				类型:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <select name="type" id="type" style="border:solid 1px #000000; color:#666666" onchange='$("#typename").val($(this).find("option:selected").text());'>
                    <option value="${users.type }">${users.typename }</option>
                    <option value="0">管理</option>
                    <%-- <option value="1">老师</option>--%>
                    <option value="2">用户</option>
                </select>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				类型名称:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="typename" id="typename" value="{users.typename}" readonly="readonly" size="90px"/>
                <script type="text/javascript">
                    $("#typename").val($("#type").find("option:selected").text());
                </script>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				姓名:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="xingming" id="xingming" value="${users.xingming }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				性别:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <select name="xingbie" id="xingbie" style="border:solid 1px #000000; color:#666666">
                    <option value="${users.xingbie }">${users.xingbie }</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				年龄:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="nianling" id="nianling" value="${users.nianling }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				地址:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="address" id="address" value="${users.address }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				电话:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="dianhua" id="dianhua" value="${users.dianhua }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				审核:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <select name="shenhe" id="shenhe" style="border:solid 1px #000000; color:#666666">
                    <option value="${users.shenhe }">${users.shenhe }</option>
                    <option value="no">no</option>
                    <option value="yes">yes</option>
                </select>
            </td>

		</tr>

        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" id="id" name="id" value="${users.id}"/>
                <input type="button" value="提交" onclick="usersSet();"/>&nbsp;
                <input type="button" value="返回" onClick="javascript:history.back()"/>
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>


