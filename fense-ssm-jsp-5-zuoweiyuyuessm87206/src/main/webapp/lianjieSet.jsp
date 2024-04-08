<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台友情链接修改</title>
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

        // 修改友情链接
        function lianjieSet() {
            var id = $('#id').val();
			var name  = $("#name").length > 0 ? $('#name').val().trim():null;
			if($("#name").length > 0 && name == "")
			{
				alert("please input:名称");
			    $('#name').focus();
				return false;
			}
			var url  = $("#url").length > 0 ? $('#url').val().trim():null;
			if($("#url").length > 0 && url == "")
			{
				alert("please input:链接地址");
			    $('#url').focus();
				return false;
			}

            var param = {
                'id': id,
				'name':name,
				'url':url,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/lianjieAddOrUpdate',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("修改成功！");
                        //window.location.href = "${contextPath}/lianjieMana";
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
            <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;友情链接修改</span>
            </td>
        </tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				名称:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="name" id="name" value="${lianjie.name }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				链接地址:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="url" id="url" value="${lianjie.url }" size="90px"/>
            </td>

		</tr>

        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" id="id" name="id" value="${lianjie.id}"/>
                <input type="button" value="提交" onclick="lianjieSet();"/>&nbsp;
                <input type="button" value="返回" onClick="javascript:history.back()"/>
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>


