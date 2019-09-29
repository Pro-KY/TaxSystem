<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container-fluid">
    <c:forEach items="${Attributes.PAGE_LIST}" var="event">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th scope="col"><fmt:message key="sent.reports.table.header.number" bundle="${rb}"/></th>
                <th scope="col"><fmt:message key="sent.reports.table.header.state" bundle="${rb}"/></th>
                <th scope="col"><fmt:message key="sent.reports.table.header.inspector" bundle="${rb}"/></th>
                <th scope="col"><fmt:message key="sent.reports.table.header.datetime" bundle="${rb}"/></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th scope="row">1</th>
                <td><c:out value="${event.reportId}"/></td>
<%--                <td>${event.reportStateId}</td>--%>
                <td>@@df</td>
                <td>@mdo</td>
            </tr>
            </tbody>
        </table>
    </c:forEach>
</div>

