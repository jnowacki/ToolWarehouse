<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Tools:</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Tool type</th>
        <th>Available</th>
    </tr>

    <c:forEach items="${applicationScope.tools}" var="tool">
        <tr>
            <td>${tool.id}</td>
            <td>${tool.name}</td>
            <td>${tool.type}</td>
            <c:choose>
                <c:when test="${tool.available}">
                    <td style="background-color: GREEN"></td>
                </c:when>
                <c:otherwise>
                    <td style="background-color: RED"></td>
                </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>

</table>

</body>
</html>
