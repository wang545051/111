<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="common/head.jsp" %>
		<%@include file="common/loginstate.jsp" %>

		<link rel="stylesheet" type="text/css" href="${staticPath}/css/base.css" />
		
        <script language="javascript">
       </script>
	</head>

	<body leftmargin="12" topmargin="12" background='${staticPath}/images/allbg.gif'>
			<table width="50%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="10" background="${staticPath}/images/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">帐号余额：</td>
					<td width="10%">￥${sessionScope.user.money}</td>
		        </tr>	
			</table>
	</body>
</html>
