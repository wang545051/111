<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>类别座位添加</title>
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
        // 添加座位
        function zuoweiAdd() {
			var bianhao = $("#bianhao").length > 0 ? $('#bianhao').val().trim():null;
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
			var image = $("#image").length > 0 ? $('#image').val().trim():null;
			if($("#image").length > 0 && image == "")
			{
				alert("please input:环境图片");
			    $('#image').focus();
				return false;
			}

            var param = {
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
                        alert("添加成功！");
                        //window.location.href = "${contextPath}/zuoweiManaMyQian";
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
            <h2>类别座位添加</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <form name="formAdd" id="formAdd" >
            <table width="100%" height=550  align="center" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF" class="newsline" >
                <tr>
                    <td>类别:</td>
                    <td width="90%" bgcolor="" align="left">
                        <select name="leibieid"
                                id="leibieid" style="width: 280px;">
                            <option value="${leibie.id }">${leibie.mingcheng}</option>
                        </select>
                    </td>
                </tr>
		<tr>
			<td>
				编号:
			</td>
            <td>
                <input type="text" name="bianhao" id="bianhao" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				楼层:
			</td>
            <td>
                <select name="loucengid" id="loucengid" style="border:solid 1px #000000; color:#666666"></select>
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
		<tr>
			<td>
				房间:
			</td>
            <td>
                <select name="fangjianid" id="fangjianid" style="border:solid 1px #000000; color:#666666"></select>
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
		<tr>
			<td>
				座位介绍:
			</td>
            <td>
                <textarea name="neirong" id="neirong" style="width:670px;height:200px;" size="70px"></textarea>
            </td>

		</tr>
		<tr>
			<td>
				是否空闲:
			</td>
            <td style="display: none">
                <select name="shenhe" id="shenhe" style="border:solid 1px #000000; color:#666666">
                    <option value="no">no</option>
                    <%--<option value="yes">yes</option>--%>
                </select>
            </td>

		</tr>
		<tr>
			<td>
				环境图片:
			</td>
            <td>
                <input type="text" name="image" id="image" size="50px" readonly="readonly" />
                <input type="button" value="上传" onclick="upx('image')" />
            </td>

		</tr>

                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2">
                        <input type="button" value="提交" onclick="zuoweiAdd();"/>&nbsp;
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

