<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台预约修改</title>
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

        // 修改预约
        function yuyueSet() {
            var id = $('#id').val();
			var xingming  = $("#xingming").length > 0 ? $('#xingming').val().trim():null;
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
			var zuoweiid=$('#zuoweiid').val().trim();
			var shiduanid=$('#shiduanid').val().trim();
			var riqi  = $("#riqi").length > 0 ? $('#riqi').val().trim():null;
			if($("#riqi").length > 0 && riqi == "")
			{
				alert("please input:日期");
			    $('#riqi').focus();
				return false;
			}
			var beizhu  = $("#beizhu").length > 0 ? $('#beizhu').val().trim():null;
			if($("#beizhu").length > 0 && beizhu == "")
			{
				alert("please input:备注");
			    $('#beizhu').focus();
				return false;
			}
			var usersid=$('#usersid').val().trim();

            var param = {
                'id': id,
				'xingming':xingming,
				'dianhua':dianhua,
				'zuoweiid':zuoweiid,
				'shiduanid':shiduanid,
				'riqi':riqi,
				'beizhu':beizhu,
				'usersid':usersid,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/yuyueAddOrUpdate',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("修改成功！");
                        //window.location.href = "${contextPath}/yuyueMana";
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
            <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;预约修改</span>
            </td>
        </tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				姓名:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="xingming" id="xingming" value="${yuyue.xingming }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				电话:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="dianhua" id="dianhua" value="${yuyue.dianhua }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				座位:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <select name="zuoweiid" id="zuoweiid" style="  border:solid 1px #000000; color:#666666">
                    <option value="${yuyue.zuowei.id }">${yuyue.zuowei.bianhao }</option>
                </select>
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
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				时段:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <select name="shiduanid" id="shiduanid" style="  border:solid 1px #000000; color:#666666">
                    <option value="${yuyue.shiduan.id }">${yuyue.shiduan.jianduan }</option>
                </select>
            </td>
            <script type="text/javascript">
                $.get(basePath + '/shiduanAll/', function(resp) {
                    if (resp.success) {
                        if(resp.data!=null){
                            var list = resp.data;
                            for(var i=0; i<list.length; i++){
                                var info = list[i];
                                $("#shiduanid").append("<option value='"+info.id+"' >" + info.jianduan + "</option>");
                            }
                        }
                    }else {
                        alert(resp.message);
                    }
                });
            </script>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				日期:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="riqi" id="riqi" style="border:1px solid #cccccc;" class="Wdate" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd'})" onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" size="15px" value="${yuyue.riqi}" />
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				备注:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="beizhu" id="beizhu" value="${yuyue.beizhu }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				用户:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <select name="usersid" id="usersid" style="width: 280px;">
                    <option value="${yuyue.users.id }">${yuyue.users.loginname}</option>
                </select>
            </td>

		</tr>

        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" id="id" name="id" value="${yuyue.id}"/>
                <input type="button" value="提交" onclick="yuyueSet();"/>&nbsp;
                <input type="button" value="返回" onClick="javascript:history.back()"/>
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>


