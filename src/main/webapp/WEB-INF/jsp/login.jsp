<%--
  Created by IntelliJ IDEA.
  User: Yuriy
  Date: 03.09.2019
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="pageContextPath" value="${pageContext.request.contextPath}" scope="page"/>

<html>
<head>
    <title>Login page</title>
    <meta charset="utf-8">
</head>
<body>
<%--    <form name="LoginForm" method="POST" action ="${pageContext.request.contextPath}/taxsystem/">--%>
    <form name="LoginForm" method="POST" action ="${pageContextPath}/taxsystem/">
        <input type="hidden" name="command" value="login">
        <input type="text" name="email" class="form-control mb-2" required autofocus placeholder=<fmt:message key="login.label.email" bundle="${rb}"/>>
        <input type="password" name="password" class="form-control mb-2" required placeholder=<fmt:message key="login.label.password" bundle="${rb}"/>>
        <button class="btn btn-lg btn-primary btn-block mb-1" type="submit"><fmt:message key="login.button.signin" bundle="${rb}"/></button>
    </form>
</body>
</html>
