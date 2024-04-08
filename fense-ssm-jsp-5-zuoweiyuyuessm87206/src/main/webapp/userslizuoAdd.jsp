<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>后台用户离座添加</title>
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
		// 添加离座
		function lizuoAdd() {
			var xingming = $("#xingming").length > 0 ? $('#xingming').val().trim():null;
			if($("#xingming").length > 0 && xingming == "")
			{
				alert("please input:姓名");
			    $('#xingming').focus();
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
			var zuoweiid = $('#zuoweiid').val().trim();
			var shijian = $("#shijian").length > 0 ? $('#shijian').val().trim():null;
			if($("#shijian").length > 0 && shijian == "")
			{
				alert("please input:时间");
			    $('#shijian').focus();
				return false;
			}
			var beizhu = $("#beizhu").length > 0 ? $('#beizhu').val().trim():null;
			if($("#beizhu").length > 0 && beizhu == "")
			{
				alert("please input:备注");
			    $('#beizhu').focus();
				return false;
			}
			var usersslid = $('#usersslid').val().trim();

			var param = {
				'xingming':xingming,
				'dianhua':dianhua,
				'zuoweiid':zuoweiid,
				'shijian':shijian,
				'beizhu':beizhu,
				'usersslid':usersslid,

			};
			$.ajax({
				type: 'post',
				url: '${basePath}/lizuoAddOrUpdate',
				dataType: "json",
				contentType:"application/json",
				data : JSON.stringify(param),
				success: function (resp) {
					if (resp.success) {
						alert("添加成功！");
						//window.location.href = "${contextPath}/lizuoMana";
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
			<td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;用户离座添加</span></td>
		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				离座用户
			</td>
			<td width="90%" bgcolor="#FFFFFF" align="left">
				<select name="usersslid" id="usersslid" style="width: 280px;">
					<option value="${users.id}">${users.loginname}</option>
				</select>
			</td>
		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				姓名:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="xingming" id="xingming" size="70px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				电话:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="dianhua" id="dianhua" size="70px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				座位:
			</td>
            <td idth="80%" bgcolor="#FFFFFF" align="left">
                <select name="zuoweiid" id="zuoweiid" style="  border:solid 1px #000000; color:#666666"></select>
            </td>
            <script type="text/javascript">
                $.get(basePath + '/zuoweiAll/', function(resp) {
                    if (resp.success) {
                        if(resp.data!=null){
                            var list = resp.data;
                            for(var i=0; i<list.length; i++){
                                var info = list[i];
                                $("#zuoweiid").append("<option value='"+info.id+"' >" + info.bianhao + "</option>");
                            }
                        }
                    }else {
                        alert(resp.message);
                    }
                });
            </script>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				时间:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="shijian" id="shijian" style="border:1px solid #cccccc;" readonly="readonly" size="25px" value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>" />
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
			<td width="20%" bgcolor="#FFFFFF" align="right">
				备注:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="beizhu" id="beizhu" size="70px"/>
            </td>

		</tr>

		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10" bgcolor="#FFFFFF" align="right">&nbsp;</td>
			<td width="90%" bgcolor="#FFFFFF" align="left">
				<input type="button" name="Submit" value="提交" style='border:solid 1px #000000; color:#666666' onclick="lizuoAdd();"/>
				<input type="button" value="返回" style='border:solid 1px #000000; color:#666666' onClick="javascript:history.back()" />
				<input type="reset" name="Submit2" value="重置" style='border:solid 1px #000000; color:#666666'/></td>
		</tr>
	</table>
</form>
</body>
</html>
