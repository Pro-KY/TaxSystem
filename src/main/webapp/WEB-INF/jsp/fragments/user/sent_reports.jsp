<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ page import="ua.training.util.constans.Command" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:message var="not_signed_label" key="sent.reports.not.assigned.label" bundle="${sessionScope.rb}" scope="request"/>

<c:url scope="request" var="sizeThreeCommand" value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=3&${Parameters.PAGE_INDEX}=${Attributes.CURRENT_PAGE_INDEX}&command=${Command.SENT_REPORTS}"/>


<div class="container">
    <div id="elementsAmountSelect" class="row">
        <div class="col-md-9"></div>
        <div class="col-md-3">
            <div class="dropdown show">
                <a class="btn dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <fmt:message key="sent.reports.page.size" bundle="${rb}"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="${sizeThreeCommand}"> 3 </a>
                    <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=5&${Parameters.PAGE_INDEX}=${Attributes.CURRENT_PAGE_INDEX}&command=${Command.SENT_REPORTS}"/>"> 5 </a>
                    <a class="dropdown-item" href="<c:url value="/taxsystem/?${Parameters.PAGE_SIZE}=10&${Parameters.PAGE_INDEX}=${param.currentPageIndex}&command=${Command.SENT_REPORTS}"/>">10</a>
                    <a class="dropdown-item" href="<c:url value="/taxsystem/?${Parameters.PAGE_SIZE}=15&${Parameters.PAGE_INDEX}=${Attributes.CURRENT_PAGE_INDEX}&command=${Command.SENT_REPORTS}"/>">15</a>
                </div>
            </div>
        </div>
    </div>

    <div style="border: #0b2e13">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col"><fmt:message key="sent.reports.table.header.number" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="sent.reports.table.header.state" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="sent.reports.table.header.inspector" bundle="${rb}"/></th>
                        <th scope="col"><fmt:message key="sent.reports.table.header.datetime" bundle="${rb}"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="sentReport" items="${pageContext.request.getAttribute(Attributes.SENT_REPORTS_LIST)}" >
                        <tr>
                            <td>${sentReport.reportNumber}</td>
                            <td>${sentReport.state}</td>
                            <td>${sentReport.inspector eq null ? sentReport.inspector : not_signed_label}</td>
                            <td>${sentReport.timestamp}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
    </div>
</div>

${requestScope.paginationInfo.isLeftButtonDisabled}
${sessionScope.currentPageIndex}
${requestScope.paginationInfo.allPagesAmount}

<c:if test="${requestScope.paginationInfo.allPagesAmount > 1}">
    <nav aria-label="...">
        <ul class="pagination" style="list-style-type: none;">
            <div class="container-fluid">
                <div class="btn-group">
                    <li class="${requestScope.paginationInfo.isLeftButtonDisabled ? 'page-item disabled' : 'page-item'}"><span class="page-link">Previous</span></li>

                    <c:forEach begin="0" end="4" varStatus="counter">
                        <li class="${(sessionScope.currentPageIndex) eq counter.index ? 'page-item active' : 'page-item'}"><a class="page-link" href="#">${counter.index+1}</a></li>
                    </c:forEach>
                    <li class="${requestScope.paginationInfo.isRightButtonDisabled ? 'page-item disabled' : 'page-item'}"><a class="page-link" href="#">Next</a></li>
                </div>
            </div>
        </ul>
    </nav>
</c:if>







