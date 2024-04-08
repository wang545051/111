<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body>
<script type="text/javascript">
    function tiao() {
        <c:if test="${sessionScope.userType==0}">
        window.location.href = "<%=path %>/main.jsp";
        </c:if>
        <c:if test="${sessionScope.userType==1}">
        window.location.href = "<%=path %>/main.jsp";
        </c:if>
        window.location.href = "<%=path %>/main.jsp";
    }

    setTimeout(tiao, 0)
</script>
<br> <br> <br> <br> <br> <br> <br> <br> <br>
<center><img src="<%=path %>/img/loading.gif"></center>
</body>
</html>
