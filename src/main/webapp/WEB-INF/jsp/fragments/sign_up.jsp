<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ua.training.util.constans.Command" %>

<html>
<head>
    <title>Login page</title>
    <meta charset="utf-8">
</head>
<body>
    <form name="SignUpForm" method="POST" action ="${pageContext.request.contextPath}/taxsystem/">
        <input type="hidden" name="command" value="Command.SIGN_UP">
        <!-- user_type -->
        <div class="form-group">
            <label for="usertype">${taxTypeLabel}</label>
            <select class="form-control" id="usertype" name="${Parameters.REPORT_TAXTYPE_ID}">
                <option value="1" selected>${singleTaxType}</option>
                <option value="2"> ${propertyTaxType}</option>
                <option value="3">${touristTaxType}</option>
                <option value="4">${parkingTaxType}</option>
            </select>
        </div>

        <input type="text" name="email" class="form-control mb-2" required autofocus placeholder=<fmt:message key="signin.email" bundle="${rb}"/>>
        <input type="password" name="password" class="form-control mb-2" required placeholder=<fmt:message key="signin.password" bundle="${rb}"/>>
        <button class="btn btn-lg btn-primary btn-block mb-1" type="submit"><fmt:message key="login.signin" bundle="${rb}"/></button>
    </form>
    <div><fmt:message key="msg.signup" bundle="${rb}"/> <a href="${pageContext.request.contextPath}/taxsystem/?command=signup"><fmt:message key="signup" bundle="${rb}"/></a></div>
</body>
</html>
