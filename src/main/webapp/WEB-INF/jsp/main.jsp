<%--
  Created by IntelliJ IDEA.
  User: Yuriy
  Date: 03.09.2019
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="user" scope="session" type="ua.training.persistance.beans.User"/>
<c:set var="session" value="${pageContext.session}" scope="session"/>
<c:set var="userType" value="${user.userType.type}" scope="session"/>

<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="localization.pagecontent" var = "rb"/>

<html>
<head>
    <title>Main page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <style type="text/css">
        <%@include file="/css/styles.css" %>
        <%@include file="/css/bootstrap.min.css" %>
    </style>
</head>
<body>
    <!-- TOP navbar -->
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
<%--            <a class="navbar-brand" href="#">User Name</a>--%>
            <div>
                <!-- user name -->
                <h5 class="text-white h5">
                    ${user.firstName} ${user.lastName}
                </h5>
                <!-- user name -->

                <!-- user type -->
                <span class="text-white">
                    <c:choose>
                        <c:when test="${userType == 'inspector'}">
                            <fmt:message key="main.label.usertype.inspector" bundle="${rb}"/>
                        </c:when>
                        <c:when test="${userType == 'user'}">
                            <c:if test="${user.physical} == '1'">
                                <fmt:message key="main.label.usertype.individual" bundle="${rb}"/>
                            </c:if>
                            <fmt:message key="main.label.usertype.legal" bundle="${rb}"/>
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="main.label.usertype.inspector" bundle="${rb}"/>
                        </c:otherwise>
                    </c:choose>
                </span>
                <!-- user type -->
            </div>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/taxsystem/?command=logout"> Logout </a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>

    <!-- A vertical navbar -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <nav class="navbar bg-light">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Send report</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Sended reports</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"> Notifications </a>
                        </li>
                    </ul>
                </nav>
            </div>

            <!-- center page content -->
            <div class="col-md-9">
                <h1> Main page content will be here </h1>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
