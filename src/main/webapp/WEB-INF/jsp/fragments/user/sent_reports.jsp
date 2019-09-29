<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">

    <div class="row">
        <div class="col-md-3">
            <select class="custom-select" id="inputGroupSelect01" name="${Parameters.REPORT_CONTENT_TYPE}">
                <option value="1" selected >10</option>
                <option value="2">20</option>
                <option value="3">30</option>
            </select>
        </div>
        <div class="col-md-9"></div>
    </div>

    <c:out value="${Attributes.SENT_REPORTS_LIST}"/>

    <div class="row h-50 d-inline-block" style="border: #0b2e13">
<%--        <div class="h-50 d-inline-block">--%>
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
                            <td>${sentReport.inspector}</td>
                            <td>${sentReport.timestamp}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
<%--        </div>--%>
    </div>
</div>

<div class="row">
    <nav aria-label="...">
        <ul class="pagination">
            <li class="page-item disabled">
                <a class="page-link" href="#" tabindex="-1">Previous</a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item active">
                <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
            </li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item">
                <a class="page-link" href="#">Next</a>
            </li>
        </ul>
    </nav>

</div>

