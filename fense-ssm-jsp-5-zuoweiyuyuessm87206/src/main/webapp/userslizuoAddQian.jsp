<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户离座添加</title>
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
			var zuoweiid=$('#zuoweiid').val().trim();
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
			var usersslid=$('#usersslid').val().trim();

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
                        //window.location.href = "${contextPath}/lizuoManaMyQian";
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
            <h2>用户离座添加</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <form name="formAdd" id="formAdd" >
            <table width="100%" height=550  align="center" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF" class="newsline" >
                <tr>
                    <td>用户:</td>
                    <td width="90%" bgcolor="" align="left">
                        <select name="usersslid"
                                id="usersslid" style="width: 280px;">
                            <option value="${users.id }">${users.loginname}</option>
                        </select>
                    </td>
                </tr>
		<tr>
			<td>
				姓名:
			</td>
            <td>
                <input type="text" name="xingming" id="xingming" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				电话:
			</td>
            <td>
                <input type="text" name="dianhua" id="dianhua" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				座位:
			</td>
            <td>
                <select name="zuoweiid" id="zuoweiid" style="border:solid 1px #000000; color:#666666"></select>
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
		<tr>
			<td>
				时间:
			</td>
            <td>
                <input type="text" name="shijian" id="shijian" style="border:1px solid #cccccc;" readonly="readonly" size="25px" value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>" />
            </td>

		</tr>
		<tr>
			<td>
				备注:
			</td>
            <td>
                <input type="text" name="beizhu" id="beizhu" size="70px"/>
            </td>

		</tr>

                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2">
                        <input type="button" value="提交" onclick="lizuoAdd();"/>&nbsp;
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

