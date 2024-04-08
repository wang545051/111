<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>文件上传</title>
    <%@ include file="head.jsp" %>
</head>

<body>
<font class="red" style="font-size: 18px;">上传完毕</font>
${requestScope.newFujianName}<br/>
${requestScope.oldFujianName}<br/>
${requestScope.fujianPath}<br/>
${requestScope.id}<br/>
<script language="javascript">
    <c:if test="${requestScope.id=='null'}">
    window.parent.document.getElementById("fujian").value = "${requestScope.fujianPath}";
    </c:if>
    <c:if test="${requestScope.id!='null'}">
    window.parent.document.getElementById("${requestScope.id}").value = "${requestScope.fujianPath}";
    </c:if>

</script>
</body>
</html>
