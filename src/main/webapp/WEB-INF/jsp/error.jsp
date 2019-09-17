<%--
  Created by IntelliJ IDEA.
  User: Yuriy
  Date: 03.09.2019
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Error page</title>
    <meta charset="utf-8">
</head>
<body>
    <h3>Error</h3>

    <c:set var="myName" value="Alex"/>
    <h1>${myName}</h1>

    <c:if test="${10 > 9}">
    <p>True<p>
        </c:if>
        <c:if test="${10 < 9}">
    <p>False<p>
        </c:if>

    <hr/>
    <jsp:expression>(request.getAttribute("errorMsg") != null)
        ? (String) request.getAttribute("error") : "unknown error"</jsp:expression>
    <hr/>
</body>
</html>
