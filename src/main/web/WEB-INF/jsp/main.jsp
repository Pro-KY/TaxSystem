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
    <title>Index page</title>
    <meta charset="utf-8">
</head>
<body>
    <hr/>
<%--    <jsp:useBean id="user" class="ua.training.persistance.beans.User">--%>
<%--        <jsp:setProperty name="user" property="param1" value="value1" />--%>
<%--    </jsp:useBean>--%>

    ${firstName} ${lastName}, hello!
    <hr/>
    <a href="taxsystem/?command=logout">Logout</a>
</body>
</html>
