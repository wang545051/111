
<%@ page language="java" pageEncoding="UTF-8"%>
<%-- 登录判断--%>
<script type="text/javascript">
    <c:if test="${sessionScope.user==null}">
    javascript:alert('对不起，请您先登陆！');
    window.location.href = "${contextPath}/userlog.jsp";
    </c:if>
</script>

