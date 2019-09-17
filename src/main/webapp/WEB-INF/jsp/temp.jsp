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

    <!-- top navbar -->

    <!-- A vertical navbar -->
    <nav class="navbar bg-light">
        <!-- Links -->
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="#">Link 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link 2</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link 3</a>
            </li>
        </ul>

    </nav>

    <!-- center page -->

    ${firstName} ${lastName}, hello!
    <p>User role is: ${pageContext.session.getAttribute("role")} </p>
    <hr/>
    <a href="taxsystem/?command=logout">Logout</a>
</body>
</html>
