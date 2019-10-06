<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ page import="ua.training.util.constans.Command" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:message var="not_signed_label" key="sent.reports.not.assigned.text" bundle="${sessionScope.rb}" scope="request"/>

<c:url scope="request" var="pageSizeThreeUrl" value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=3&command=${Command.SENT_REPORTS}"/>
<%--<c:url scope="request" var="changeIndexUrl" value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=${sessionScope.paginationInfo.pageSize}&${Parameters.SELECTED_PAGE_INDEX}=${Attributes.CURRENT_PAGE_INDEX}&command=${Command.SENT_REPORTS}"/>--%>

<div class="container">
    <div id="elementsAmountSelect" class="row">
        <div class="col-md-10"></div>
<%--        page size--%>
        <div class="col-md-2">
            <div class="dropdown show">
                <a class="dropdown-toggle nav-link" href="#" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <fmt:message key="sent.reports.page.size" bundle="${rb}"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="${pageSizeThreeUrl}"> 3 </a>
                    <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=5&command=${Command.SENT_REPORTS}"/>"> 5 </a>
                    <a class="dropdown-item" href="<c:url value="/taxsystem/?${Parameters.PAGE_SIZE}=10&command=${Command.SENT_REPORTS}"/>">10</a>
                    <a class="dropdown-item" href="<c:url value="/taxsystem/?${Parameters.PAGE_SIZE}=15&command=${Command.SENT_REPORTS}"/>">15</a>
                    <a class="dropdown-item" href="<c:url value="/taxsystem/?${Parameters.PAGE_SIZE}=25&command=${Command.SENT_REPORTS}"/>">25</a>
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
                    <th scope="col"><fmt:message key="sent.reports.table.header.inspectorName" bundle="${rb}"/></th>
                    <th scope="col"><fmt:message key="sent.reports.table.header.datetime" bundle="${rb}"/></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="report" items="${pageContext.request.getAttribute(Attributes.SENT_REPORTS_LIST)}" >
                <tr class="table-row" data-href="${pageContext.request.contextPath}?${Parameters.REPORT_APPROVAL_ID}=${report.reportApprovalId}&command=${Command.REPORT_DETAILS}">
                    <td>${report.reportId}</td>
                    <td>${report.state}</td>
                    <td>${report.inspectorName eq null ? report.inspectorName : not_signed_label}</td>
                    <td>${report.timestamp}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="row mt-4">
        <div class="col-md-3"></div>
        <div class="col-md-3">
            <%--PAGINATION--%>
            <c:if test="${sessionScope.paginationInfo.allPagesAmount > 1}">
                <nav aria-label="...">
                    <ul class="pagination" style="list-style-type: none;">
                        <div class="container-fluid">
                            <div class="btn-group">
                                <c:if test="${sessionScope.paginationInfo.allPagesAmount > 1}">
                                    <li class="${sessionScope.paginationInfo.isLeftButtonDisabled ? 'page-item disabled' : 'page-item'}">
                                        <a class="page-link" href="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=${sessionScope.paginationInfo.pageSize}&${Parameters.PREV_PAGE_CLICK}=true&command=${Command.SENT_REPORTS}">Previous</a>
                                    </li>
                                </c:if>

                                <c:forEach begin="${sessionScope.paginationInfo.startPageIndex}" end="${sessionScope.paginationInfo.endPageIndex}" varStatus="counter">
                                    <li class="${(sessionScope.paginationInfo.currentPageIndex) eq counter.index ? 'page-item active' : 'page-item'}">
                                        <a class="page-link" href="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=${sessionScope.paginationInfo.pageSize}&${Parameters.SELECTED_PAGE_INDEX}=${counter.index}&command=${Command.SENT_REPORTS}"> ${counter.index+1} </a>
                                    </li>
                                </c:forEach>

                                <c:if test="${sessionScope.paginationInfo.allPagesAmount > 1}">
                                    <li class="${sessionScope.paginationInfo.isRightButtonDisabled ? 'page-item disabled' : 'page-item'}">
                                        <a class="page-link" href="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=${sessionScope.paginationInfo.pageSize}&${Parameters.NEXT_PAGE_CLICK}=true&command=${Command.SENT_REPORTS}">Next</a>
                                    </li>
                                </c:if>
                            </div>
                        </div>
                    </ul>
                </nav>
            </c:if>
            <%--PAGINATION--%>
        </div>
        <div class="col-md-3"></div>
    </div>

</div>

<%--TESTING--%>
<%--<p>isLeftButtonDisabled : ${sessionScope.paginationInfo.isLeftButtonDisabled}</p>--%>
<%--<p>isRightButtonDisabled : ${sessionScope.paginationInfo.isRightButtonDisabled}</p>--%>
<%--<p>currentPageIndex ${sessionScope.currentPageIndex}</p>--%>
<%--<p>allPagesAmount ${sessionScope.paginationInfo.allPagesAmount}</p>--%>
<%--<p>startPageIndex : ${sessionScope.paginationInfo.startPageIndex}</p>--%>
<%--<p>endPageIndex : ${sessionScope.paginationInfo.endPageIndex}</p>--%>
<%--TESTING--%>











