<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="isRoleUser" value="${sessionScope.currentUserTypeId != sessionScope.userTypeInspectorId}"/>
<c:set var="command_0" value="${isRoleUser ? 'getReportFragment' : 'processReport'}" scope="page"/>
<c:set var="command_1" value="${isRoleUser ? 'sentReports' : 'handledReports'}" scope="page"/>

<fmt:message var="menu_user_0" key="main.menu.user.sendreport" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_user_1" key="main.menu.user.sentreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_user_2" key="main.menu.user.notifications" bundle="${sessionScope.rb}"/>

<fmt:message var="menu_inpector_0" key="main.menu.inspector.processreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_inpector_1" key="main.menu.inspector.handledreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_admin_0" key="main.menu.admin.usermanagement" bundle="${sessionScope.rb}"/>

<div class="col-md-3">
    <nav class="navbar bg-light">
        <ul class="navbar-nav">
            <!-- 0 -->
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/taxsystem/?command=${command_0}">
                    ${isRoleUser ? menu_user_0 : menu_inpector_0}
                </a>
            </li>
            <!-- 0 -->

            <!-- 1 -->
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/taxsystem/?command=${command_1}">
                    ${isRoleUser ? menu_user_1 : menu_inpector_1}
                </a>
            </li>
            <!-- 1 -->

            <!-- 2 -->
            <li class="nav-item" >
                <a class="nav-link" href="#">
                    ${menu_user_2}
                </a>
            </li>
            <!-- 2 -->
        </ul>
    </nav>
</div>





