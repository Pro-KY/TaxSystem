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

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.pagecontent" var = "rb" scope="session"/>

<c:set var="session" value="${pageContext.session}" scope="session"/>
<c:set var="currentUserType" value="${user.userType.type}" scope="session"/>

<c:set var="userTypeLegalEntity" value="legal entity" scope="session"/>
<c:set var="userTypeIndividual" value="individual" scope="session"/>
<c:set var="userTypeInspector" value="inspector" scope="session"/>

<fmt:message var ="userTypeIndividualText" key="main.usertype.individual" bundle="${rb}"/>
<fmt:message var ="userTypeLegalEntityText" key="main.usertype.legal" bundle="${rb}"/>
<fmt:message var ="userTypeInspectorText" key="main.usertype.inspector" bundle="${rb}"/>

<%--<c:set var="UserTypeIndividual" value="1" scope="session"/>--%>

<html>
<head>
    <title>Main page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <style type="text/css">
        <%@include file="/css/styles.css" %>
        <%@include file="/css/bootstrap.min.css" %>
    </style>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
    <script src="<c:url value="/js/scripts.js" />"></script>
</head>
<body>
    <!-- TOP navbar -->
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
<%--            <a class="navbar-brand" href="#">User Name</a>--%>
            <div>
                <!-- user name -->
                <h5 class="text-white h5">
<%--                 TODO: add organization name if user type is legal--%>
                    ${user.organization eq null ? (user.firstName.concat(" ").concat(user.lastName)) : (user.organization)}
                </h5>
                <!-- user name -->

                <!-- user type -->
                <span class="text-white">
                    ${currentUserType eq userTypeInspector ? userTypeInspector : (currentUserType eq userTypeLegalEntity ? userTypeLegalEntityText : userTypeIndividualText)}
                </span>
                <!-- user type -->
            </div>

            <!-- sign out link-->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/taxsystem/?command=logout">
                            <fmt:message key="header.singout" bundle="${rb}"/>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- sign out link -->
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
                <c:if test="${requestScope.get('fragmentPath') != null}">
                    <c:import url="${requestScope.get('fragmentPath')}" />
                </c:if>
<%--                <jsp:include page="${requestScope.get('fragmentPath')}"/>--%>
<%--                <jsp:include page="${requestScope.get('fragmentPath')}"/>--%>
            </div>
            <!-- center page content -->
        </div>
    </div>
</body>
</html>
