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
    <title>Login page</title>
    <meta charset="utf-8">
</head>
<body>
    <form name="LoginForm" method="POST" action ="${pageContext.request.contextPath}/taxsystem/">
        <input type="hidden" name="command" value="login">
        <input type="text" name="login" class="form-control mb-2" placeholder="Email" required autofocus>
        <input type="password" name="password" class="form-control mb-2" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block mb-1" type="submit">Sign in</button>
    </form>
</body>
</html>
