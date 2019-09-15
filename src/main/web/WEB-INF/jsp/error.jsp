<%--
  Created by IntelliJ IDEA.
  User: Yuriy
  Date: 03.09.2019
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Error page</title>
    <meta charset="utf-8">
</head>
<body>
    <h3>Error</h3>
    <hr/>
    <jsp:expression>(request.getAttribute("errorMsg") != null)
        ? (String) request.getAttribute("error") : "unknown error"</jsp:expression>
    <hr/>
</body>
</html>
