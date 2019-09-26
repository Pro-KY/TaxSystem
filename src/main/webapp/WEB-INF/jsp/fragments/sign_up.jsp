<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ua.training.util.constans.Command" %>
<%@ page import="ua.training.util.constans.Parameters" %>

<html>
<head>
    <title>Login page</title>
    <meta charset="utf-8">
</head>
<body>
<div class="container-fluid">
    <form name="SignUpForm" method="POST" action ="${pageContext.request.contextPath}/taxsystem/">
        <input type="hidden" name="command" value="${Command.SIGN_UP}">
        <!-- user_type -->
        <div class="form-group">
            <label for="usertype"><fmt:message key="signup.user.type.label" bundle="${rb}"/></label>
            <select class="form-control" id="usertype" name="${Parameters.USER_TYPE}">
                <option value="1" selected><fmt:message key="signup.user.type.individual" bundle="${rb}"/></option>
                <option value="2"> <fmt:message key="signup.user.type.legalentity" bundle="${rb}"/> </option>
            </select>
        </div>
        <div class="row justify-content-start" >
            <div class="col-md-6">
                <div class="form-group">
                    <label for="fistName"><fmt:message key="signup.user.firstName" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="fistName" placeholder="sum" name="${Parameters.USER_FIRST_NAME}">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="lastName"><fmt:message key="signup.user.lastName" bundle="${rb}"/></label>
                    <input type="text" class="form-control" id="lastName" placeholder="sum" name="${Parameters.USER_LAST_NAME}">
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="organization"><fmt:message key="signup.user.organization" bundle="${rb}"/></label>
            <input type="text" class="form-control" id="organization" placeholder="sum" name="${Parameters.USER_ORGANIZATION}">
        </div>
        <div class="form-group">
            <label for="address"><fmt:message key="signup.user.address" bundle="${rb}"/></label>
            <input type="text" class="form-control" id="address" placeholder="sum" name="${Parameters.USER_ADDRESS}">
        </div>
        <button type="submit" class="btn btn-primary"><fmt:message key="sendreport.form.button.submit" bundle="${rb}"/></button>
    </form>
    <div><fmt:message key="msg.sigin" bundle="${rb}"/> <a href="${pageContext.request.contextPath}/taxsystem/?command=${Command.GET_SIGN_IN_FRAGMENT}"><fmt:message key="signin" bundle="${rb}"/></a></div>
</div>

</body>
</html>
