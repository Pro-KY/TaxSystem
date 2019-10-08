<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ page import="ua.training.util.constans.Commands" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="myTag" uri="/WEB-INF/datetag.tld" %>

<fmt:message var="not_signed_label" key="sent.reports.not.assigned.text" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="checking_label" key="sent.reports.table.header.checking" bundle="${sessionScope.rb}" scope="page"/>
<fmt:message var="sender_label" key="sent.reports.table.header.sender" bundle="${sessionScope.rb}" scope="page"/>

<c:url scope="request" var="pageSizeThreeUrl" value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=3&command=${Commands.SENT_REPORTS}"/>
<c:set var="command" value="${userTypeId eq userTypeInspectorId ? Commands.GET_UNTREATED_REPORTS : Commands.SENT_REPORTS}" scope="page"/>
<c:set var="command_1" value="${userTypeId eq userTypeInspectorId ? Commands.GET_APPROVING_FRAGMENT : Commands.REPORT_DETAILS}" scope="page"/>

<div class="container">
    <div id="elementsAmountSelect" class="row">
        <%--  reports type (inspector) --%>
            <div class="col-md-2">
                <c:if test="${userTypeId eq userTypeInspectorId}">
                    <div class="dropdown show">
                        <a class="dropdown-toggle nav-link" href="#" id="reportsTypeDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <fmt:message key="report.types.text" bundle="${rb}"/>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="reportsTypeDropdown">
                            <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.REPORTS_APPROVAL_TYPE}=4&command=${command}"/>">
                                <fmt:message key="report.types.allReports" bundle="${rb}"/>
                            </a>
                            <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.REPORTS_APPROVAL_TYPE}=5&command=${command}"/>">
                                <fmt:message key="report.types.changed" bundle="${rb}"/>
                            </a>
                        </div>
                    </div>
                </c:if>
            </div>
        <%--  reports type (inspector) --%>

        <div class="col-md-8"></div>
<%--        page size--%>
        <div class="col-md-2">
            <div class="dropdown show">
                <a class="dropdown-toggle nav-link" href="#" id="pageSizeDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <fmt:message key="sent.reports.page.size" bundle="${rb}"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="pageSizeDropdown">
                    <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=3&command=${command}"/>"> 3 </a>
                    <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=5&command=${command}"/>"> 5 </a>
                    <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=10&command=${command}"/>">10</a>
                    <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=15&command=${command}"/>">15</a>
                    <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=25&command=${command}"/>">25</a>
                </div>
            </div>
        </div>
<%--        page size--%>
    </div>

    <div style="border: #0b2e13">
        <table class="table">
            <thead>
                <tr>
                    <th scope="col"><fmt:message key="sent.reports.table.header.number" bundle="${rb}"/></th>
                    <th scope="col"><fmt:message key="sent.reports.table.header.state" bundle="${rb}"/></th>
                    <th scope="col">${userTypeId eq userTypeInspectorId ? sender_label : checking_label}</th>
                    <th scope="col"><fmt:message key="sent.reports.table.header.datetime" bundle="${rb}"/></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="report" items="${paginationInfo.paginationList}" >
                <tr class="table-row" data-href="${pageContext.request.contextPath}?${Parameters.REPORT_APPROVAL_ID}=${report.reportApprovalId}&command=${command_1}">
                    <td>${report.reportId}</td>
                    <td>${report.state eq 'changed' ? 'processing' : report.state}</td>
                    <td>
                        <c:choose>
                            <c:when test="${not empty report.inspectorName}">
                                ${report.inspectorName}
                            </c:when>
                            <c:when test="${not empty report.userName}">
                                ${report.userName}
                            </c:when>
                            <c:otherwise>
                                ${not_signed_label}
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <myTag:sentdate timestamp="${report.timestamp}"/>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="row mt-4">
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <%--PAGINATION--%>
            <c:if test="${sessionScope.paginationInfo.allPagesAmount > 1}">
                <nav aria-label="...">
                    <ul class="pagination" style="list-style-type: none;">
                        <div class="container-fluid">
                            <div class="btn-group">
                                <c:if test="${sessionScope.paginationInfo.allPagesAmount > 1}">
                                    <li class="${sessionScope.paginationInfo.isLeftButtonDisabled ? 'page-item disabled' : 'page-item'}">
                                        <a class="page-link" href="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=${sessionScope.paginationInfo.pageSize}&${Parameters.PREV_PAGE_CLICK}=true&command=${command}">Previous</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="${sessionScope.paginationInfo.startPageIndex}" end="${sessionScope.paginationInfo.endPageIndex}" varStatus="counter">
                                    <li class="${(sessionScope.paginationInfo.currentPageIndex) eq counter.index ? 'page-item active' : 'page-item'}">
                                        <a class="page-link" href="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=${sessionScope.paginationInfo.pageSize}&${Parameters.SELECTED_PAGE_INDEX}=${counter.index}&command=${command}"> ${counter.index+1} </a>
                                    </li>
                                </c:forEach>

                                <c:if test="${sessionScope.paginationInfo.allPagesAmount > 1}">
                                    <li class="${sessionScope.paginationInfo.isRightButtonDisabled ? 'page-item disabled' : 'page-item'}">
                                        <a class="page-link" href="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=${sessionScope.paginationInfo.pageSize}&${Parameters.NEXT_PAGE_CLICK}=true&command=${command}">Next</a>
                                    </li>
                                </c:if>
                            </div>
                        </div>
                    </ul>
                </nav>
            </c:if>
            <%--PAGINATION--%>
        </div>
<%--        <div class="col-md-3"></div>--%>
    </div>

</div>

<%--TESTING--%>
<%--<p>isLeftButtonDisabled : ${sessionScope.paginationInfo.isLeftButtonDisabled}</p>--%>
<%--<p>isRightButtonDisabled : ${sessionScope.paginationInfo.isRightButtonDisabled}</p>--%>
<%--<p>currentPageIndex ${sessionScope.paginationInfo.currentPageIndex}</p>--%>
<%--<p>allPagesAmount ${sessionScope.paginationInfo.allPagesAmount}</p>--%>
<%--<p>startPageIndex : ${sessionScope.paginationInfo.startPageIndex}</p>--%>
<%--<p>endPageIndex : ${sessionScope.paginationInfo.endPageIndex}</p>--%>
<%--TESTING--%>











