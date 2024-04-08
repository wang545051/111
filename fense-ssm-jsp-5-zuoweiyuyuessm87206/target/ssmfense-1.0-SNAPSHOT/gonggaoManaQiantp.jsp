<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>公告图片列表</title>
	<%@include file="common/head.jsp" %>
	<link rel="stylesheet" type="text/css" href="qtimages/css/wst.css"/>
	<link rel="stylesheet" href="${staticPath}/qtimages/hsgbanner.css">
	<script type="text/javascript" src="${staticPath}/qtimages/jquery.js"></script>
	<script type="text/javascript" src="${staticPath}/qtimages/inc.js"></script>
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
			<h2>公告</h2>
			<span></span></div>
	</div>
	<!--标题的结束-->
	<!--内容的开始-->
	<div class="gywstnr">
		<form name="formSearch" id="formSearch" method="post" action="${contextPath}/gonggaoManaQiantp">
        标题:<input type="text" name="biaoti" id="biaoti" size="15px" value="${req.biaoti}"/>&nbsp;&nbsp;

			<input type="submit" name="Submit" value="查找" style='border:solid 1px #000000; color:#666666' />
		</form>
		<table width="100%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse" class="newsline">
			<tr>
				<c:forEach items="${pageInfo.records}" var="info" varStatus="s">
				<td align="center">
					<table width="240" height="240" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td align="center">
								<a href="${contextPath}/gonggaoDetailQian/${info.id}">
									<img src="${contextPath}/${info.image}" width="240px" height="240px" border="0" onerror="this.src='${staticPath}/images/zanwu.jpg'"/>
								</a>
							</td>
						</tr>
						<tr>
							<td height="26" align="center">

								<a href="${contextPath}/gonggaoDetailQian/${info.id}">
									<c:if test="${fn:length(info.biaoti)>'16'}">
										${fn:substring(info.biaoti,0,16)}...
									</c:if>
									<c:if test="${fn:length(info.biaoti)<='16'}">
										${info.biaoti}
									</c:if>
								</a>

							</td>
						</tr>
					</table>
				</td>
				<c:if test="${(s.index+1)%4==0}">
			</tr><tr>
			</c:if>
			</c:forEach>
			</tr>
		</table><br>
		<%@ include file="common/fenye.jsp"%>
		<table width="98%" border="0" align="center" cellpadding="3" cellspacing="1" bordercolor="#00FFFF"
			   style="border-collapse:collapse" class="newsline">
			<tr>
				<td align="center" bgcolor="">
					<%--<input type="button" value="打印" style="width: 60px;" onClick="javascript:window.print()" />--%>
					<input type="button" value="返回" style="width: 60px;" onClick="javascript:history.back()" />
				</td>
			</tr>
		</table>
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
