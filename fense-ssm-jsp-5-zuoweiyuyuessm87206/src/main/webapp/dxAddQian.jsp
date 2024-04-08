<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>介绍添加</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
    <script type="text/javascript" src="${staticPath}/js/popup.js"></script>
    <script language="JavaScript" src="${staticPath}/js/public.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="qtimages/css/wst.css"/>
    <link rel="stylesheet" href="${staticPath}/qtimages/hsgbanner.css">
    <script type="text/javascript" src="${staticPath}/qtimages/jquery.js"></script>
    <script type="text/javascript" src="${staticPath}/qtimages/inc.js"></script>

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
			if(("#leibie").length > 0 && leibie == "")
			{
				alert("please input:类别");
			    $('#leibie').focus();
				return false;
			}
			var content=$('#content').val().trim();
			var addtime = $("#addtime").length > 0 ? $('#addtime').val().trim():null;
			if(("#addtime").length > 0 && addtime == "")
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
                        //window.location.href = "${contextPath}/dxManaMyQian";
                    } else {
                        alert(resp.message);
                    }
                }
            });
        }
    </script>
</head>
<body>

<!--头部代码的开始-->
<%@ include file="qttop.jsp"%>
<!--头部代码的结束-->

<!--子页面banner-->
<%--<div class="scban"></div>--%>
<!--子页面banner-->

<!--banner图片的开始-->
<%@ include file="bht.jsp"%>
<!--banner图片的结束-->

<!--页面导航部分的开始-->
<!--页面导航部分的结束-->

<!--主题内容的开始-->
<!--关于菜菜饭店网上订餐系统的开始-->
<div class="gywst">
    <!--标题的开始-->
    <div class="gywst_title">
        <div class="gywstc">
            <h2>介绍添加</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <form name="formAdd" id="formAdd" >
            <table width="100%" height=550  align="center" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF" class="newsline" >
		<tr>
			<td>
				类别:
			</td>
            <td>
                <input type="text" name="leibie" id="leibie" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				内容:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <textarea name="content" id="content" style="width:670px;height:200px;"></textarea>
            </td>

		</tr>
		<tr>
			<td>
				时间:
			</td>
            <td>
                <input type="text" name="addtime" id="addtime" style="border:1px solid #cccccc;" readonly="readonly" size="25px" value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>" />
            </td>

		</tr>

                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2">
                        <input type="button" value="提交" onclick="dxAdd();"/>&nbsp;
                        <input type="button" value="返回" onClick="javascript:history.back()" />
                        <%--<input type="reset" name="Submit22" value="重置"/>--%>
                    </td>
                </tr>
            </table>
        </form>
        <div class="clear"></div>
    </div>
    <!--内容的结束-->
</div>
<!--主题内容的结束-->

<!--底部的开始-->
<%@ include file="qtdown.jsp" %>
<!--底部的结束-->
</body>
</html>
