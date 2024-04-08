<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>My JSP 'userXinxi.jsp' starting page</title>
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
			var xingming  = $("#xingming").length > 0 ? $('#xingming').val().trim():null;
			if($("#xingming").length > 0 && xingming == "")
			{
				alert("please input:姓名");
				$('#xingming').focus();
				return false;
			}
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

			var param = {
				'id': id,
				'xingming':xingming,
				'nianling':nianling,
				'address':address,
				'dianhua':dianhua,

			};
			$.ajax({
				type: 'post',
				url: '${basePath}/usersAddOrUpdate?isUPdateSession=true',
				dataType: "json",
				contentType:"application/json",
				data : JSON.stringify(param),
				success: function (resp) {
					if (resp.success) {
						alert("修改资料成功！");
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
	<table width="98%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC">
		<tr>
			<td width="20%" height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
				用户名：
			</td>
			<td width="80%" bgcolor="#FFFFFF">
				&nbsp;
				<input type="text" name="loginname" id="loginname" readonly="readonly" value="${sessionScope.user.loginname }"/>
			</td>
		</tr>
		<%--<tr>
			<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
				密 码：
			</td>
			<td bgcolor="#FFFFFF">
				&nbsp;
				<input type="password" name="loginpw" value="${sessionScope.user.loginpw }"/>
			</td>
		</tr>--%>
		<tr>
			<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
				真实姓名：
			</td>
			<td bgcolor="#FFFFFF">
				&nbsp;
				<input type="text" id="xingming"  name="xingming" value="${sessionScope.user.xingming }"/>
			</td>
		</tr>
		<%--<tr>
			<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
				住址：
			</td>
			<td bgcolor="#FFFFFF">
				&nbsp;
				<input type="text" id="address" name="address" value="${sessionScope.user.address }"/>
			</td>
		</tr>--%>

		<tr>
			<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
				联系方式：
			</td>
			<td bgcolor="#FFFFFF">
				&nbsp;
				<input type="text" id="dianhua" name="dianhua" value="${sessionScope.user.dianhua }"/>
			</td>
		</tr>
		<%--<tr>
			<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
				年龄：
			</td>
			<td bgcolor="#FFFFFF">
				&nbsp;
				<input type="text" id="nianling" name="nianling" value="${sessionScope.user.nianling }"/>
			</td>
		</tr>--%>
		<%--<tr>
			<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
				余额：
			</td>
			<td bgcolor="#FFFFFF">
				&nbsp;
				<input type="text" name="" readonly="readonly" value="${sessionScope.user.money }"/>
				&lt;%&ndash;  <a href="<%=path %>/site/userinfo/userChongzhi.jsp"  >充值</a> &ndash;%&gt;
			</td>



		</tr>
		<tr>
			<td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
				积分：
			</td>
			<td bgcolor="#FFFFFF">
				&nbsp;
				<input type="text" name="" readonly="readonly" value="${sessionScope.user.jifen }"/>
			</td>
		</tr>--%>
		<%-- <tr>
            <td height="30" align="right" bgcolor="#F9F9F9" style="font-size: 11px;">
                QQ：
            </td>
            <td bgcolor="#FFFFFF">
                &nbsp;
                <input type="text" name="qq" value="${sessionScope.user.qq }"/>
            </td>
        </tr> --%>
		<tr>
			<td height="30" align="right" bgcolor="#F9F9F9">
				&nbsp;
			</td>
			<td bgcolor="#FFFFFF">
				&nbsp;
				<input type="hidden" id="id" name="id" value="${sessionScope.user.id }">
				<input type="button" value="确定" onclick="usersSet();"/>
				<%--<input type="button" value="取消" onclick="closeOpen()"/>--%>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
