<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="ua.training.util.constans.Attributes" %>

<c:set var="language" value="${not empty sessionScope.language ? sessionScope.language : 'en'}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization.pagecontent" var = "rb"/>

<html>
<head>
    <title>Index page</title>
    <meta charset="utf-8">
</head>
<body>
    <!-- header fragment -->
    <%@include file="/WEB-INF/jsp/fragments/header.jsp" %>
    <!-- header fragment -->

<%--    <c:out value="${language}"/>--%>
    <div class="container pt-3">
<%--        <h1 class="text-center"> <fmt:message key="index.text.greeting" bundle="${rb}"/> </h1>--%>

        <div class="row justify-content-sm-center">
            <div class="col-sm-6 col-md-4">
                <div class="card border-info text-center">
                    <div class="card-body">
                        <!-- signin/signout fragment -->
                        <c:choose>
                            <c:when test="${pageContext.session.getAttribute(Attributes.IS_SIGN_UP) eq true}">
                                <img id="user_icon" alt="user icon" src="${pageContext.request.contextPath}/assets/user.png">
                                <%@include file="/WEB-INF/jsp/fragments/sign_up.jsp" %>
                            </c:when>
                            <c:otherwise>
                                <img id="logo_icon" alt="logo icon" src="${pageContext.request.contextPath}/assets/logo.png">
                                <%@include file="/WEB-INF/jsp/fragments/sign_in.jsp" %>
                            </c:otherwise>
                        </c:choose>
                        <!-- signin/signout fragment -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
