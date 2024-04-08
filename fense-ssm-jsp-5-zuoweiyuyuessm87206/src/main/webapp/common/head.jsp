<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" import="java.util.Date" %>
<%
    String contextPath = request.getContextPath();
    String basePath = request.getScheme() + "://"+request.getServerName() + ":"+request.getServerPort() + contextPath;
    String staticPath = basePath + "/static";
    request.setAttribute("contextPath", contextPath);
    request.setAttribute("basePath", basePath);
    request.setAttribute("staticPath", staticPath);
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>
<script src="${staticPath}/jquery/3.4.1/jquery.min.js"></script>
<script src="${staticPath}/js/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
    // 将基础路径写入js变量，用于js获取
    window.basePath = '${basePath}';
    window.staticPath = '${staticPath}'
</script>

