<%@ page language="java" pageEncoding="gb2312" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE9"/>
    <link rel="icon" href="favicon.ico" type="image/x-icon"/>
    <title>��վ��̨</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/loginstate.jsp" %>
</head>
<frameset rows="96,*" frameborder="no" border="0" framespacing="0">
    <frame src="top.jsp" noresize="noresize" id="topFrame" frameborder="0" name="topFrame" marginwidth="0"
           marginheight="0" scrolling="no">
    <frameset rows="*" cols="185,*" id="frame" framespacing="0" frameborder="no" border="0">
        <frame src="mygo.jsp" name="leftFrame" id="leftFrame" noresize="noresize" marginwidth="0" marginheight="0"
               frameborder="0" scrolling="yes">
        <frame src="sy.jsp" name="main" id="main" marginwidth="8" marginheight="5" frameborder="0" scrolling="yes">
    </frameset>

    <noframes>
        <body>��ǰ�������֧�ֿ��!</body>
    </noframes>
</frameset>
</html>


