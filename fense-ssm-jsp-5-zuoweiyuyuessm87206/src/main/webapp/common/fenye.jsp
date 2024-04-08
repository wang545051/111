<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 分页 -->
<table border='0' cellpadding='0' cellspacing='0' align="center">
    <tr>
        <td width='98%' align="right">
            共<span style='color:#FF0000'>${pageInfo.total}</span>条记录&nbsp;&nbsp;&nbsp;&nbsp;
            每页<span style='color:#FF0000'>${pageInfo.pageSize}</span>条&nbsp;&nbsp;&nbsp;&nbsp;
            第<span style='color:#FF0000'>${pageInfo.pageNum}</span>页/共${pageInfo.pageCount}页&nbsp;&nbsp;&nbsp;&nbsp;
            <c:if test="${pageInfo.pageNum ==1}">
                首&nbsp;页&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;
            </c:if>
            <c:if test="${pageInfo.pageNum!=1}">
                <a style='color: red' href='javascript:;' onclick="goPage(1)">首&nbsp;页</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a style='color: red' href='javascript:;' onclick="goPage(${pageInfo.pageNum-1})">上一页</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
            </c:if>
            <c:if test="${pageInfo.pageNum >= pageInfo.pageCount}">
                下一页&nbsp;&nbsp;末&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
            </c:if>
            <c:if test="${pageInfo.pageNum  < pageInfo.pageCount}">
                <a style='color: red' href='javascript:;'
                   onclick="goPage(${pageInfo.pageNum +1})">下一页</a>&nbsp;&nbsp;<a style='color: red' href='javascript:;' onclick="goPage(${pageInfo.pageCount})">末&nbsp;页</a>
            </c:if>
        </td>
    </tr>
</table>
<script type="text/javascript" language="JavaScript">
    function goPage(pageNo) {
        document.formSearch.action = document.formSearch.action + "?pageNo=" + pageNo;
        document.formSearch.submit();
    }
</script>
