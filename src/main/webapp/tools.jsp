<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%@include file="header.jsp"%>

<h2>Tools:</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Tool type</th>
        <th>Available</th>
        <th>Take/Return</th>
    </tr>

    <c:forEach items="${requestScope.tools}" var="tool">
        <tr>
            <td>${tool.id}</td>
            <td>${tool.name}</td>
            <td>${tool.type}</td>
            <c:choose>
                <c:when test="${tool.available}">
                    <td style="background-color: GREEN"></td>
                    <td>
                        <form>
                            <input type="hidden" name="action" value="take">
                            <input type="hidden" name="id" value="${tool.id}">
                            <input type="submit" value="Take">
                        </form>
                    </td>
                </c:when>
                <c:otherwise>
                    <td style="background-color: RED"></td>
                    <td>
                        <form>
                            <input type="hidden" name="action" value="return">
                            <input type="hidden" name="id" value="${tool.id}">
                            <input type="submit" value="Return">
                        </form>
                    </td>
                </c:otherwise>
            </c:choose>

        </tr>
    </c:forEach>

</table>

</body>
</html>
