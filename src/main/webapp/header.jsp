<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>

<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="hidden" name="action" value="logout">
    <input type="submit" value="Log out">
</form>
