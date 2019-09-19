<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="isRoleUser" value="${sessionScope.currentRole eq sessionScope.roleUser}"/>
<fmt:message var="menu_user_0" key="main.menu.user.sendreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_user_1" key="main.menu.user.sentreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_user_2" key="main.menu.user.notifications" bundle="${sessionScope.rb}"/>

<fmt:message var="menu_inpector_0" key="main.menu.inspector.sentreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_inpector_1" key="main.menu.inspector.handledreports" bundle="${sessionScope.rb}"/>
<fmt:message var="menu_admin_0" key="main.menu.admin.usermanagement" bundle="${sessionScope.rb}"/>


<div class="col-md-3">
    <nav class="navbar bg-light">
        <ul class="navbar-nav">
            <!-- 0 -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    ${isRoleUser ? menu_user_0 : menu_user_0}
                </a>
            </li>
            <!-- 0 -->

            <!-- 1 -->
            <li class="nav-item">
                <a class="nav-link" href="#">
                    ${isRoleUser ? menu_user_1 : menu_inpector_1}
                </a>
            </li>
            <!-- 1 -->

            <!-- 2 -->
            <li class="nav-item" >
                <a class="nav-link" href="#">
                    ${isRoleUser && sessionScope.? menu_user_2 : ''}
                </a>
            </li>
            <!-- 2 -->
        </ul>
    </nav>
</div>





