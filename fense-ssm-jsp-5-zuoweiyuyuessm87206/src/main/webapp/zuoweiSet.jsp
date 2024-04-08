<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台座位修改</title>
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

        // 修改座位
        function zuoweiSet() {
            var id = $('#id').val();
			var bianhao  = $("#bianhao").length > 0 ? $('#bianhao').val().trim():null;
			if($("#bianhao").length > 0 && bianhao == "")
			{
				alert("please input:编号");
			    $('#bianhao').focus();
				return false;
			}
			var leibieid=$('#leibieid').val().trim();
			var loucengid=$('#loucengid').val().trim();
			var fangjianid=$('#fangjianid').val().trim();
			var neirong=$('#neirong').val().trim();
			var shenhe=$('#shenhe').val().trim();
			var image  = $("#image").length > 0 ? $('#image').val().trim():null;
			if($("#image").length > 0 && image == "")
			{
				alert("please input:环境图片");
			    $('#image').focus();
				return false;
			}

            var param = {
                'id': id,
				'bianhao':bianhao,
				'leibieid':leibieid,
				'loucengid':loucengid,
				'fangjianid':fangjianid,
				'neirong':neirong,
				'shenhe':shenhe,
				'image':image,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/zuoweiAddOrUpdate',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("修改成功！");
                        //window.location.href = "${contextPath}/zuoweiMana";
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
            <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;座位修改</span>
            </td>
        </tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				编号:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="bianhao" id="bianhao" value="${zuowei.bianhao }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				类别:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <select name="leibieid" id="leibieid" style="  border:solid 1px #000000; color:#666666">
                    <option value="${zuowei.leibie.id }">${zuowei.leibie.mingcheng }</option>
                </select>
            </td>
            <script type="text/javascript">
                $.get(basePath + '/leibieAll/', function(resp) {
                    if (resp.success) {
                        if(resp.data!=null){
                            var list = resp.data;
                            for(var i=0; i<list.length; i++){
                                var info = list[i];
                                $("#leibieid").append("<option value='"+info.id+"' >" + info.mingcheng + "</option>");
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
				楼层:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <select name="loucengid" id="loucengid" style="  border:solid 1px #000000; color:#666666">
                    <option value="${zuowei.louceng.id }">${zuowei.louceng.mingcheng }</option>
                </select>
            </td>
            <script type="text/javascript">
                $.get(basePath + '/loucengAll/', function(resp) {
                    if (resp.success) {
                        if(resp.data!=null){
                            var list = resp.data;
                            for(var i=0; i<list.length; i++){
                                var info = list[i];
                                $("#loucengid").append("<option value='"+info.id+"' >" + info.mingcheng + "</option>");
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
				房间:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <select name="fangjianid" id="fangjianid" style="  border:solid 1px #000000; color:#666666">
                    <option value="${zuowei.fangjian.id }">${zuowei.fangjian.mingcheng }</option>
                </select>
            </td>
            <script type="text/javascript">
                $.get(basePath + '/fangjianAll/', function(resp) {
                    if (resp.success) {
                        if(resp.data!=null){
                            var list = resp.data;
                            for(var i=0; i<list.length; i++){
                                var info = list[i];
                                $("#fangjianid").append("<option value='"+info.id+"' >" + info.mingcheng + "</option>");
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
				座位介绍:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <textarea name="neirong" id="neirong" style="width:670px;height:200px;">${zuowei.neirong}</textarea>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				是否空闲:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <select name="shenhe" id="shenhe" style="border:solid 1px #000000; color:#666666">
                    <option value="${zuowei.shenhe }">${zuowei.shenhe }</option>
                    <option value="no">no</option>
                    <option value="yes">yes</option>
                </select>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				环境图片:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="image" id="image" value="${zuowei.image}" size="50px" readonly="readonly" />
                <input type="button" value="上传" onclick="upx('image')" />
            </td>

		</tr>

        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" id="id" name="id" value="${zuowei.id}"/>
                <input type="button" value="提交" onclick="zuoweiSet();"/>&nbsp;
                <input type="button" value="返回" onClick="javascript:history.back()"/>
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>


