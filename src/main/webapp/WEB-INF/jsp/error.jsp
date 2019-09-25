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
<c:set var="errorMsg" value="${pageContext.getAttribute('errorMsg')}" scope="request"/>
<html>
<head>
    <title>Error page</title>
    <meta charset="utf-8">
</head>
<body>
    <h3>Error code: ${""}</h3>
    <p> Error message: ${errorMsg} != null ? ${errorMsg} : Unknown error}</p>
</body>
</html>
