<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>文件上传</title>
    <%@ include file="head.jsp" %>
    <script language="javascript">
        function check() {
            if (document.formAdd.fujian.value == "") {
                alert("请选择文件");
                return false;
            }
            return true;
        }

        function fujianchange() {
            if (document.formAdd.fujian.value != "") {
                document.formAdd.submit();
            }
        }
    </script>
</head>

<body>
<form action="${contextPath}/common/uploadfile" name="formAdd" method="post" enctype="multipart/form-data">
    <input type="file" name="fujian" id="fujian" onchange="fujianchange();"
           onKeyDown="javascript:alert('此信息不能手动输入');return false;"/>
    <input type="hidden" name="id" value="${requestScope.id}"/>
    <input type="submit" value="提交" onclick="return check()"/>
</form>
</body>
</html>
