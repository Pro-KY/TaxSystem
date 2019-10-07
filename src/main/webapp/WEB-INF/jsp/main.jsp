<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="user" scope="session" type="ua.training.persistence.entities.User"/>

<%@ page import="ua.training.util.constans.Attributes" %>
<%@ page import="ua.training.util.constans.Commands" %>

<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="localization.pagecontent" var = "rb" scope="session"/>

<c:set var="userTypeId" value="${user.userType.id}" scope="session"/>

<c:set var="userTypeIndividualId" value="1" scope="session"/>
<c:set var="userTypeLegalEntityId" value="2" scope="session"/>
<c:set var="userTypeInspectorId" value="3" scope="session"/>

<fmt:message var ="userTypeIndividualText" key="main.usertype.individual" bundle="${rb}" scope="request"/>
<fmt:message var ="userTypeLegalEntityText" key="main.usertype.legal" bundle="${rb}" scope="request"/>
<fmt:message var ="userTypeInspectorText" key="main.usertype.inspector" bundle="${rb}" scope="request"/>

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
        <nav class="navbar navbar-expand-lg navbar-dark main-bg-color">
<%--            <a class="navbar-brand" href="#">User Name</a>--%>
            <div>
                <!-- user name -->
                <h5 class="text-white h5">
                    ${empty user.organization ? (user.firstName.concat(" ").concat(user.lastName)) : (user.organization)}
                </h5>
                <!-- user name -->

                <!-- user type -->
                <span class="text-white">
                    ${userTypeId eq userTypeInspectorId ? userTypeInspectorText : (userTypeId eq userTypeLegalEntityId ? userTypeLegalEntityText : userTypeIndividualText)}
                </span>
                <!-- user type -->
            </div>

            <!-- address -->
            <span class="navbar-text text-white mt-md-n4 ml-md-5">
                ${not empty user.address ? user.address : ''}
            </span>
            <!-- address -->

            <!-- sign out link-->
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/taxsystem/?command=${Commands.SIGN_OUT}">
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
            <!-- SIDEBAR -->
            <c:set var = "isUser" value = "${userTypeId eq userTypeIndividualId or userTypeId eq userTypeLegalEntityId}"/>
            <c:choose>
                <c:when test = "${isUser}">
                    <c:import url="fragments/user/sidebar.jsp" />
                </c:when>
                <c:otherwise>
                    <c:import url="fragments/inspector/sidebar.jsp" />
                </c:otherwise>
            </c:choose>
<%--            <c:import url="fragments/sidebar.jsp" />--%>
            <!-- SIDEBAR -->

            <!--MAIN CONTENT-->
            <div class="col-md-9">
                <c:if test="${not empty requestScope.get(Attributes.FRAGMENT_PATH)}">
<%--                    <c:import url="${requestScope.get(Attributes.FRAGMENT_PATH)}" />--%>
                    <jsp:include page="${requestScope.get(Attributes.FRAGMENT_PATH)}"/>
                </c:if>
            </div>
            <!--MAIN CONTENT-->
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
