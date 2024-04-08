<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>后台时段修改</title>
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

        // 修改时段
        function shiduanSet() {
            var id = $('#id').val();
			var jianduan  = $("#jianduan").length > 0 ? $('#jianduan').val().trim():null;
			if($("#jianduan").length > 0 && jianduan == "")
			{
				alert("please input:时间段");
			    $('#jianduan').focus();
				return false;
			}

            var param = {
                'id': id,
				'jianduan':jianduan,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/shiduanAddOrUpdate',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("修改成功！");
                        //window.location.href = "${contextPath}/shiduanMana";
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
            <td colspan="3" background="${staticPath}/img/wbg.gif" class='title'><span>&nbsp;时段修改</span>
            </td>
        </tr>
		<tr align='center' bgcolor="#FFFFFF" height="22">
			<td width="10%" bgcolor="#FFFFFF" align="right">
				时间段:
			</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="text" name="jianduan" id="jianduan" value="${shiduan.jianduan }" size="90px"/>
            </td>

		</tr>

        <tr align='center' bgcolor="#FFFFFF" height="22">
            <td width="10%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
            <td width="90%" bgcolor="#FFFFFF" align="left">
                <input type="hidden" id="id" name="id" value="${shiduan.id}"/>
                <input type="button" value="提交" onclick="shiduanSet();"/>&nbsp;
                <input type="button" value="返回" onClick="javascript:history.back()"/>
                <input type="reset" value="重置"/>&nbsp;
            </td>
        </tr>
    </table>
</form>

</body>
</html>


