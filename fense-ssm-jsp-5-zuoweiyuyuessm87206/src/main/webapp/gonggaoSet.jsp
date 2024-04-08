<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台公告修改</title>
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

        // 修改公告
        function gonggaoSet() {
            var id = $('#id').val();
			var biaoti  = $("#biaoti").length > 0 ? $('#biaoti').val().trim():null;
			if($("#biaoti").length > 0 && biaoti == "")
			{
				alert("please input:标题");
			    $('#biaoti').focus();
				return false;
			}
			var neirong=$('#neirong').val().trim();
			var image  = $("#image").length > 0 ? $('#image').val().trim():null;
			if($("#image").length > 0 && image == "")
			{
				alert("please input:图片");
			    $('#image').focus();
				return false;
			}
			var shijian  = $("#shijian").length > 0 ? $('#shijian').val().trim():null;
			if($("#shijian").length > 0 && shijian == "")
			{
				alert("please input:时间");
			    $('#shijian').focus();
				return false;
			}

            var param = {
                'id': id,
				'biaoti':biaoti,
				'neirong':neirong,
				'image':image,
				'shijian':shijian,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/gonggaoAddOrUpdate',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("修改成功！");
                        //window.location.href = "${contextPath}/gonggaoMana";
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
            <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;公告修改</span>
            </td>
        </tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				标题:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="biaoti" id="biaoti" value="${gonggao.biaoti }" size="90px"/>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				内容:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <textarea name="neirong" id="neirong" style="width:670px;height:200px;">${gonggao.neirong}</textarea>
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				图片:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="image" id="image" value="${gonggao.image}" size="50px" readonly="readonly" />
                <input type="button" value="上传" onclick="upx('image')" />
            </td>

		</tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				时间:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="shijian" id="shijian" style="border:1px solid #cccccc;" readonly="readonly" size="20px" value="${gonggao.shijian}" />
            </td>

		</tr>

        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" id="id" name="id" value="${gonggao.id}"/>
                <input type="button" value="提交" onclick="gonggaoSet();"/>&nbsp;
                <input type="button" value="返回" onClick="javascript:history.back()"/>
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>


