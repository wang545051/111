<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>公告添加</title>
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
        // 添加公告
        function gonggaoAdd() {
			var biaoti = $("#biaoti").length > 0 ? $('#biaoti').val().trim():null;
			if(("#biaoti").length > 0 && biaoti == "")
			{
				alert("please input:标题");
			    $('#biaoti').focus();
				return false;
			}
			var neirong=$('#neirong').val().trim();
			var image = $("#image").length > 0 ? $('#image').val().trim():null;
			if(("#image").length > 0 && image == "")
			{
				alert("please input:图片");
			    $('#image').focus();
				return false;
			}
			var shijian = $("#shijian").length > 0 ? $('#shijian').val().trim():null;
			if(("#shijian").length > 0 && shijian == "")
			{
				alert("please input:时间");
			    $('#shijian').focus();
				return false;
			}

            var param = {
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
                        alert("添加成功！");
                        //window.location.href = "${contextPath}/gonggaoManaMyQian";
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
            <h2>公告添加</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <form name="formAdd" id="formAdd" >
            <table width="100%" height=550  align="center" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF" class="newsline" >
		<tr>
			<td>
				标题:
			</td>
            <td>
                <input type="text" name="biaoti" id="biaoti" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				内容:
			</td>
            <td width="80%" bgcolor="#FFFFFF" align="left">
                <textarea name="neirong" id="neirong" style="width:670px;height:200px;"></textarea>
            </td>

		</tr>
		<tr>
			<td>
				图片:
			</td>
            <td>
                <input type="text" name="image" id="image" size="50px" readonly="readonly" />
                <input type="button" value="上传" onclick="upx('image')" />
            </td>

		</tr>
		<tr>
			<td>
				时间:
			</td>
            <td>
                <input type="text" name="shijian" id="shijian" style="border:1px solid #cccccc;" readonly="readonly" size="25px" value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>" />
            </td>

		</tr>

                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2">
                        <input type="button" value="提交" onclick="gonggaoAdd();"/>&nbsp;
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

