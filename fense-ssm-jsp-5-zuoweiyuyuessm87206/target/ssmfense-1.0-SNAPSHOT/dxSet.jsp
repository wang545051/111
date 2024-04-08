<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台介绍修改</title>
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

        // 修改介绍
        function dxSet() {
            var id = $('#id').val();
			var leibie  = $("#leibie").length > 0 ? $('#leibie').val().trim():null;
			if($("#leibie").length > 0 && leibie == "")
			{
				alert("please input:类别");
			    $('#leibie').focus();
				return false;
			}
			var content=$('#content').val().trim();
			var addtime  = $("#addtime").length > 0 ? $('#addtime').val().trim():null;
			if($("#addtime").length > 0 && addtime == "")
			{
				alert("please input:时间");
			    $('#addtime').focus();
				return false;
			}

            var param = {
                'id': id,
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
                        alert("修改成功！");
                        //window.location.href = "${contextPath}/dxMana";
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
            <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;介绍修改</span>
            </td>
        </tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				类别:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="leibie" id="leibie" value="${dx.leibie }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				内容:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <textarea name="content" id="content" style="width:670px;height:200px;">${dx.content}</textarea>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				时间:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="addtime" id="addtime" style="border:1px solid #cccccc;" readonly="readonly" size="20px" value="${dx.addtime}" />
            </td>

		</tr>

        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" id="id" name="id" value="${dx.id}"/>
                <input type="button" value="提交" onclick="dxSet();"/>&nbsp;
                <input type="button" value="返回" onClick="javascript:history.back()"/>
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>


