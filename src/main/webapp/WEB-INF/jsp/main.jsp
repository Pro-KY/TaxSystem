<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="user" scope="session" type="ua.training.persistence.entities.User"/>

<%@ page import="ua.training.util.constans.Attributes" %>
<%@ page import="ua.training.util.constans.Command" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.pagecontent" var = "rb" scope="session"/>

<%--<c:set var="session" value="${pageContext.session}" scope="session"/>--%>
<c:set var="currentUserTypeId" value="${user.userType.role}" scope="session"/>

<c:set var="userTypeIndividualId" value="1" scope="session"/>
<c:set var="userTypeLegalEntityId" value="2" scope="session"/>
<c:set var="userTypeInspectorId" value="3" scope="session"/>

<fmt:message var ="userTypeIndividualText" key="main.usertype.individual" bundle="${rb}"/>
<fmt:message var ="userTypeLegalEntityText" key="main.usertype.legal" bundle="${rb}"/>
<fmt:message var ="userTypeInspectorText" key="main.usertype.inspectorName" bundle="${rb}"/>

<%@ include file="/WEB-INF/jsp/fmt_messages.jsp"%>
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
                    ${empty user.organization ? (user.firstName.concat(" ").concat(user.lastName)) : (user.organization)}
                </h5>
                <!-- user name -->

                <!-- user type -->
                <span class="text-white">
                    ${currentUserTypeId eq userTypeInspectorId ? userTypeInspectorText : (currentUserTypeId eq userTypeLegalEntityId ? userTypeLegalEntityText : userTypeIndividualText)}
                </span>
                <!-- user type -->
            </div>

            <!-- sign out link-->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/taxsystem/?command=${Command.SIGN_OUT}">
                            <fmt:message key="header.singout" bundle="${rb}"/>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- sign out link -->
        </nav>
    </div>
    <!-- TOP navbar -->

    <div class="container-fluid mt-3">
        <div class="row">
            <!-- sidebar -->
            <c:import url="fragments/sidebar.jsp" />
            <!-- sidebar -->

            <!-- center page content -->
            <div class="col-md-9">
                <c:if test="${requestScope.get(Attributes.FRAGMENT_PATH) ne null}">
                    <c:import url="${requestScope.get(Attributes.FRAGMENT_PATH)}" />
                </c:if>
            </div>
            <!-- center page content -->
        </div>
    </div>

    <!-- FOR TESTING -->
        <div>
            param.alertError is null => ${empty alertError}
        </div>
        <div>
            param.alertSuccess is null =>  ${empty alertSuccess}
        </div>
    <!-- FOR TESTING -->

    <!-- ALERT -->
    <c:if test="${(not empty alertError and alertError eq true) or (not empty alertSuccess and alertSuccess eq true)}">
        <div class="container-fluid mt-3">
            <div class="row fixed-bottom">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <%@ include file="/WEB-INF/jsp/alert.jsp"%>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>

    </c:if>
    <!-- ALERT -->
</body>
</html>
