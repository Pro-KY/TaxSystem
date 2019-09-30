<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <div id="elementsAmountSelect" class="row">
        <div class="col-md-9"></div>
        <div class="col-md-3">
            <label for="inputGroupSelect01"> Elements on the page </label>
            <select class="custom-select" id="inputGroupSelect01" name="${Parameters.REPORT_CONTENT_TYPE}">
                <option value="1" selected >10</option>
                <option value="2">20</option>
                <option value="3">30</option>
            </select>
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
                            <td>${sentReport.inspector ne null ? sentReport.inspector : ''}</td>
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

                    <c:forEach begin="1" end="4" varStatus="counter">
                        <li class="page-item"><a class="page-link" href="#">${counter.index}</a></li>
                    </c:forEach>
                    href="<c:url value="/taxsystem/?universityId=${param.universityId}&page=${counter.count}&command=specialtySelection"/>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </div>
            </div>
        </ul>
    </nav>
</c:if>







