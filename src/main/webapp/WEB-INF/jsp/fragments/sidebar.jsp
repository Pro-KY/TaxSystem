<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Command" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>

<c:set var="isTypeUser" value="${sessionScope.currentUserTypeId != sessionScope.userTypeInspectorId}"/>
<c:set var="command_0" value="${isTypeUser ? Command.GET_REPORT_FRAGMENT : Command.PROCESS_REPORT}" scope="page"/>
<c:set var="command_1" value="${isTypeUser ? Command.SENT_REPORTS : Command.HANDLED_REPORTS}" scope="page"/>

<fmt:message var="menu_user_0" key="main.menu.user.sendreport" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_user_1" key="main.menu.user.sentreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_user_2" key="main.menu.user.notifications" bundle="${sessionScope.rb}"/>

<fmt:message var="menu_inpector_0" key="main.menu.inspectorName.processreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_inpector_1" key="main.menu.inspectorName.handledreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_admin_0" key="main.menu.admin.usermanagement" bundle="${sessionScope.rb}"/>


<c:set var="sideBarIndex" value="${pageContext.request.getAttribute(Attributes.SIDEBAR_ACTIVE_INDEX)}" scope="request"/>

<div class="col-md-3">

    <div class="list-group" id="list-tab" role="tablist">
        <a class="list-group-item list-group-item-action ${sideBarIndex eq 0 or sideBarIndex eq null? ' active' : ''}" id="list-home-list" href="${pageContext.request.contextPath}/taxsystem/?command=${command_0}&${Parameters.SIDEBAR_ACTIVE_INDEX}=0" role="tab">
            ${isTypeUser ? menu_user_0 : menu_inpector_0}
        </a>
        <a class="list-group-item list-group-item-action ${sideBarIndex eq 1 ? ' active' : ''}" id="list-profile-list" href="${pageContext.request.contextPath}/taxsystem/?command=${command_1}&${Parameters.SIDEBAR_ACTIVE_INDEX}=1" role="tab" >
            ${isTypeUser ? menu_user_1 : menu_inpector_1}
        </a>
        <a class="list-group-item list-group-item-action" id="list-messages-list" data-toggle="list" href="#" role="tab">
            ${menu_user_2}
        </a>
    </div>
</div>








