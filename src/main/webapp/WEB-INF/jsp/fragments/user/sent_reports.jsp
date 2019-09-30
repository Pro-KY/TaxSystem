<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ page import="ua.training.util.constans.Command" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<fmt:message var="not_signed_label" key="sent.reports.not.assigned.label" bundle="${sessionScope.rb}" scope="request"/>

<div class="container">
    <div id="elementsAmountSelect" class="row">
        <div class="col-md-9"></div>
        <div class="col-md-3">
            <div class="dropdown show">
                <a class="btn dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <fmt:message key="sent.reports.page.size" bundle="${rb}"/>
                </a>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="<c:url value="${pageContext.request.contextPath}?${Parameters.PAGE_SIZE}=5&${Parameters.PAGE_INDEX}=${Attributes.CURRENT_PAGE_INDEX}&command=${Command.SENT_REPORTS}"/>"> 5 </a>
                    <a class="dropdown-item" href="<c:url value="/taxsystem/?${Parameters.PAGE_SIZE}=10&${Parameters.PAGE_INDEX}=${param.currentPageIndex}&command=${Command.SENT_REPORTS}"/>">10</a>
                    <a class="dropdown-item" href="<c:url value="/taxsystem/?${Parameters.PAGE_SIZE}=15&${Parameters.PAGE_INDEX}=${Attributes.CURRENT_PAGE_INDEX}&command=${Command.SENT_REPORTS}"/>">15</a>
                </div>
            </div>
        </div>
    </div>

    ${pageContext.session.getAttribute(Attributes.CURRENT_PAGE_INDEX)}

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
<%--MORE THAN 5 SHOW ONLY 5 ELSE SHOW LESS--%>

<%--<c:if test="${requestScope.numberOfPages > 1}">--%>
<c:if test="${4 > 1}">
    <nav aria-label="...">
        <ul class="pagination" style="list-style-type: none;">
            <div class="container-fluid">
                <div class="btn-group">
                    <li class="page-item disabled"><span class="page-link">Previous</span></li>

                    <c:forEach begin="1" end="5" varStatus="counter">
                        <li class="page-item"><a class="page-link" href="#">${counter.index}</a></li>
                    </c:forEach>
<%--                    href="<c:url value="/taxsystem/?universityId=${param.universityId}&page=${counter.count}&command=specialtySelection"/>--%>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </div>
            </div>
        </ul>
    </nav>
</c:if>







