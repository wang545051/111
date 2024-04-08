<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>用户注册</title>
    <%@include file="common/head.jsp" %>
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
        // 添加用户
        function usersAdd() {
            			var loginname = $("#loginname").length > 0 ? $('#loginname').val().trim():null;
			if(("#loginname").length > 0 && loginname == "")
			{
				alert("please input:用户名称");
			    $('#loginname').focus();
				return false;
			}
			var loginpw = $("#loginpw").length > 0 ? $('#loginpw').val().trim():null;
			if(("#loginpw").length > 0 && loginpw == "")
			{
				alert("please input:密码");
			    $('#loginpw').focus();
				return false;
			}
			var type = $("#type").length > 0 ? $('#type').val().trim():null;
			if(("#type").length > 0 && type == "")
			{
				alert("please input:类型");
			    $('#type').focus();
				return false;
			}
			var typename = $("#typename").length > 0 ? $('#typename').val().trim():null;
			if(("#typename").length > 0 && typename == "")
			{
				alert("please input:类型名称");
			    $('#typename').focus();
				return false;
			}
			var xingming = $("#xingming").length > 0 ? $('#xingming').val().trim():null;
			if(("#xingming").length > 0 && xingming == "")
			{
				alert("please input:姓名");
			    $('#xingming').focus();
				return false;
			}
			var xingbie=$('#xingbie').val().trim();
			var nianling = $("#nianling").length > 0 ? $('#nianling').val().trim():null;
			if(("#nianling").length > 0 && nianling == "")
			{
				alert("please input:年龄");
			    $('#nianling').focus();
				return false;
			}
			var address = $("#address").length > 0 ? $('#address').val().trim():null;
			if(("#address").length > 0 && address == "")
			{
				alert("please input:地址");
			    $('#address').focus();
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
			var shenhe=$('#shenhe').val().trim();

            var param = {
                				'loginname':loginname,
				'loginpw':loginpw,
				'type':type,
				'typename':typename,
				'xingming':xingming,
				'xingbie':xingbie,
				'nianling':nianling,
				'address':address,
				'dianhua':dianhua,
				'shenhe':shenhe,

            };
            $.ajax({
                type: 'post',
                url: '${basePath}/usersAddOrUpdate',
                dataType: "json",
                contentType:"application/json",
                data : JSON.stringify(param),
                success: function (resp) {
                    if (resp.success) {
                        alert("注册成功！");
                        //window.location.href = "${contextPath}/usersManaMyQian";
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
<%--<%@ include file="qttop.jsp"%>--%>
<!--头部代码的结束-->

<!--子页面banner-->
<%--<div class="scban"></div>--%>
<!--子页面banner-->

<!--banner图片的开始-->
<%--<%@ include file="bht.jsp"%>--%>
<!--banner图片的结束-->

<!--页面导航部分的开始-->
<!--页面导航部分的结束-->

<!--主题内容的开始-->
<!--关于菜菜饭店网上订餐系统的开始-->
<div class="gywst">
    <!--标题的开始-->
    <div class="gywst_title">
        <div class="gywstc">
            <h2>用户注册</h2>
            <span></span></div>
    </div>
    <!--标题的结束-->
    <!--内容的开始-->
    <div class="gywstnr">
        <form name="formAdd" id="formAdd" >
            <table width="100%" height=550  align="center" cellpadding="3" cellspacing="1" bgcolor="#FFFFFF" class="newsline" >
		<tr>
			<td>
				用户名称:
			</td>
            <td>
                <input type="text" name="loginname" id="loginname" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				密码:
			</td>
            <td>
                <input type="text" name="loginpw" id="loginpw" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				类型:
			</td>
            <td>
                <select name="type" id="type" style="border:solid 1px #000000; color:#666666" onchange='$("#typename").val($(this).find("option:selected").text());'>
                    <option value="2">用户</option>
                </select>
            </td>

		</tr>
		<tr>
			<td>
				类型名称:
			</td>
            <td>
                <input type="text" name="typename" id="typename" value="" readonly="readonly" size="70px"/>
                <script type="text/javascript">
                    $("#typename").val($("#type").find("option:selected").text());
                </script>
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
				性别:
			</td>
            <td>
                <select name="xingbie" id="xingbie" style="border:solid 1px #000000; color:#666666">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>

		</tr>
		<tr>
			<td>
				年龄:
			</td>
            <td>
                <input type="text" name="nianling" id="nianling" size="70px"/>
            </td>

		</tr>
		<tr>
			<td>
				地址:
			</td>
            <td>
                <input type="text" name="address" id="address" size="70px"/>
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
		<tr style="display: none;">
			<td>
				审核:
			</td>
            <td style="display: none">
                <select name="shenhe" id="shenhe" style="border:solid 1px #000000; color:#666666">
                    <option value="yes">yes</option>
                    <option value="no">no</option>
                </select>
            </td>

		</tr>

                <tr>
                    <td>&nbsp;</td>
                    <td colspan="2">
                        <input type="button" value="提交" onclick="usersAdd();"/>&nbsp;
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
<%--<%@ include file="qtdown.jsp" %>--%>
<!--底部的结束-->
</body>
</html>

