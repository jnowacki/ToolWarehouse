<%--
  Created by IntelliJ IDEA.
  User: jedrz
  Date: 19.05.2019
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Log in</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="hidden" name="submitted" value="true">
    <input type="hidden" name="action" value="login">
    Username: <input type="text" name="username"><br>
    Password: <input type="text" name="password"><br>
    <input type="submit" value="Log in">
</form>

<c:if test="${param.submitted}">
<h3>Login not successful</h3>
</c:if>

</body>
</html>
