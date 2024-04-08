<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>后台添加介绍</title>
	<%@include file="common/head.jsp" %>
	<%@include file="common/loginstate.jsp" %>
	<link href="${staticPath}/css/css.css" type=text/css rel=stylesheet>
	<script type="text/javascript" src="${staticPath}/js/popup.js"></script>
	<script type="text/javascript">
		//文件上传
		function upx(id) {
			var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:200});
			pop.setContent("contentUrl","${contextPath}/common/upload/?id="+id);
			pop.setContent("title","文件上传");
			pop.build();
			pop.show();
		}
		// 添加介绍
		function dxAdd() {
			var leibie = $("#leibie").length > 0 ? $('#leibie').val().trim():null;
			if($("#leibie").length > 0 && leibie == "")
			{
			    alert("please input:类别");
			    $('#leibie').focus();
			    return false;
			}
			var content=$('#content').val().trim();
			var addtime = $("#addtime").length > 0 ? $('#addtime').val().trim():null;
			if($("#addtime").length > 0 && addtime == "")
			{
			    alert("please input:时间");
			    $('#addtime').focus();
			    return false;
			}

			var param = {
				'leibie':leibie,
				'content':content,
				'addtime':addtime,

			};
			$.ajax({
				type: 'post',
				url: '${basePath}/dxAddOrUpdate',
				dataType: "json",
				contentType:"application/json",
				data : JSON.stringify(param),
				success: function (resp) {
					if (resp.success) {
						alert("添加成功！");
						//window.location.href = "${contextPath}/dxMana";
					} else {
						alert(resp.message);
					}
				}
			});
		}
	</script>
</head>

<body leftmargin="2" topmargin="9" background='${staticPath}/img/allbg.gif'>
<form id="formAdd" name="formAdd" >
	<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
		<tr bgcolor="#EEF4EA">
			<td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;介绍添加</span></td>
		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				类别:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="leibie" id="leibie" size="70px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				内容:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <textarea name="content" id="content" style="width:522px;height:200px;" size="70px"></textarea>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				时间:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="addtime" id="addtime" style="border:1px solid #cccccc;" readonly="readonly" size="25px" value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>" />
            </td>

		</tr>

		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
			<td width="90%" bgcolor="#FFFFFF" align="left">
				<input type="button" name="Submit" value="提交" style='border:solid 1px #000000; color:#666666' onclick="dxAdd();"/>
				<input type="button" value="返回" style='border:solid 1px #000000; color:#666666' onClick="javascript:history.back()" />
				<input type="reset" name="Submit2" value="重置" style='border:solid 1px #000000; color:#666666'/></td>
		</tr>
	</table>
</form>
</body>
</html>
