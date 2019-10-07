<%@ page import="ua.training.util.constans.Commands" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login page</title>
    <meta charset="utf-8">
</head>
<body>
    <form name="LoginForm" method="POST" action ="${pageContext.request.contextPath}/taxsystem/">
        <input type="hidden" name="command" value="${Commands.SIGN_IN}"/>
        <input type="text" name="email" class="form-control mb-2" required autofocus placeholder=<fmt:message key="signin.email" bundle="${rb}"/>>
        <input type="password" name="password" class="form-control mb-2" required placeholder=<fmt:message key="signin.password" bundle="${rb}"/>>
        <button class="btn btn-lg btn-primary btn-block mb-1" type="submit"><fmt:message key="signin" bundle="${rb}"/></button>
    </form>
    <div><fmt:message key="msg.signup" bundle="${rb}"/> <a href="${pageContext.request.contextPath}/taxsystem/?command=${Commands.GET_SIGN_UP_FRAGMENT}"><fmt:message key="signup" bundle="${rb}"/></a></div>
</body>
</html>
