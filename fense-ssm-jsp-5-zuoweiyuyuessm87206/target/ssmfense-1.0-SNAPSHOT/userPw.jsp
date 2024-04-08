<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>后台修改密码</title>
	<%@include file="common/head.jsp" %>
	<%@include file="common/loginstate.jsp" %>
	<link href="${staticPath}/css/css.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="${staticPath}/js/popup.js"></script>

	<script language="javascript">
		// 修改密码
		function pwEdit() {
			var id = $('#id').val();
			var loginpw=$('#loginpw').val().trim();
			if(loginpw == "")
			{
				alert("新密码不能空");
				return false;
			}

			var loginpw2=$('#loginpw2').val().trim();
			if(loginpw2 == "")
			{
				alert("请输入确认密码");
				return false;
			}

			if(loginpw2 != loginpw)
			{
				alert("两次输入密码不一致，请重新输入！");
				return false;
			}

			var param = {
				'id':id,
				'loginpw':loginpw,

			};
			$.ajax({
				type: 'post',
				url: '${basePath}/usersAddOrUpdate',
				dataType: "json",
				contentType:"application/json",
				data : JSON.stringify(param),
				success: function (resp) {
					if (resp.success) {
						alert("修改密码成功！");
						//window.location.href = "${contextPath}/usersMana";
					} else {
						alert(resp.message);
					}
				}
			});
		}
	</script>
</head>

<body leftmargin="2" topmargin="9" >
<form method="post" action="" name="formPw">
	<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
		<tr bgcolor="#EEF4EA">
			<td colspan="2" class='title'><span>&nbsp;</span></td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				登录名：
			</td>
			<td width="90%" bgcolor="#FFFFFF">
				<input type="text" value="${sessionScope.user.loginname }" name="loginname" id="loginname" style="width: 250px;" disabled="disabled"/>
			</td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				新密码：
			</td>
			<td width="90%" bgcolor="#FFFFFF">
				<input type="password" id="loginpw" name="loginpw" style="width: 250px;"/>
			</td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				确认密码：
			</td>
			<td width="90%" bgcolor="#FFFFFF">
				<input type="password" id="loginpw2" name="loginpw2" style="width: 250px;"/>
			</td>
		</tr>
		<tr bgcolor="#FFFFFF">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				&nbsp;
			</td>
			<td width="90%" bgcolor="#FFFFFF">
				<input type="hidden" id="id" name="id" value="${sessionScope.user.id}"/>
				<input type="button" value="修改" onclick="pwEdit();"/>
				&nbsp;&nbsp;&nbsp;
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>