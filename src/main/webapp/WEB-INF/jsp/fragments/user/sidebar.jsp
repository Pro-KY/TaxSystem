<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Commands" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>

<c:set var="sideBarIndex" value="${sessionScope.get(Attributes.SIDEBAR_ACTIVE_INDEX)}"/>

<div class="col-md-3">
    <div class="list-group" id="list-tab" type="tablist">
        <a class="list-group-item list-group-item-action ${sideBarIndex eq 0 or sideBarIndex eq null? 'active' : ''}" href="${pageContext.request.contextPath}/taxsystem/?command=${Command.GET_REPORT_FRAGMENT}&${Parameters.SIDEBAR_ACTIVE_INDEX}=0" type="tab">
            <fmt:message key="main.menu.user.sendreport" bundle="${sessionScope.rb}"/>
        </a>
        <a class="list-group-item list-group-item-action ${sideBarIndex eq 1 ? 'active' : ''}" href="${pageContext.request.contextPath}/taxsystem/?command=${Command.SENT_REPORTS}&${Parameters.SIDEBAR_ACTIVE_INDEX}=1" type="tab" >
            <fmt:message key="main.menu.user.sentreports" bundle="${sessionScope.rb}"/>
        </a>
    </div>
</div>








