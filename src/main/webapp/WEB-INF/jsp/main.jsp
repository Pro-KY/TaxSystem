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
<c:set var="currentRole" value="${user.userType.type}" scope="session"/>
<c:set var="roleUser" value="user" scope="session"/>
<c:set var="roleInspector" value="inspector" scope="session"/>
<c:set var="UserTypeIndividualConstant" value="1" scope="session"/>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.pagecontent" var = "rb" scope="session"/>

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
                        <c:when test="${currentRole eq roleInspector}">
                            <fmt:message key="main.usertype.inspector" bundle="${rb}"/>
                        </c:when>
                        <c:when test="${currentRole eq roleUser}">
                            <c:if test="${user.physical eq UserTypeIndividualConstant}">
                                <fmt:message key="main.usertype.individual" bundle="${rb}"/>
                            </c:if>
                            <fmt:message key="main.usertype.legal" bundle="${rb}"/>
                        </c:when>
                        <c:otherwise>
                            <fmt:message key="main.usertype.inspector" bundle="${rb}"/>
                        </c:otherwise>
                    </c:choose>
                </span>
                <!-- user type -->
            </div>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/taxsystem/?command=logout">
                            <fmt:message key="header.singout" bundle="${rb}"/>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>

    <div class="container-fluid">
        <div class="row">
            <!-- menu -->
            <c:import url="fragments/menu.jsp" />
<%--            <jsp:include page="fragments/menu.jsp"/>--%>
<%--            <%@include file="fragments/menu.jsp" %>--%>
            <!-- menu -->

            <!-- center page content -->
            <div class="col-md-9">
                <h1> Main page content will be here </h1>
            </div>
            <!-- center page content -->
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
