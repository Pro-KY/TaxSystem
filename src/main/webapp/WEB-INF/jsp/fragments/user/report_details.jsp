<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ page import="ua.training.util.constans.Command" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:message var="notAssignedText" key="sent.reports.not.assigned.text" bundle="${rb}" scope="request"/>
<fmt:message var="approved" key="report.details.report.state.approved" bundle="${rb}" scope="request"/>
<fmt:message var="rejected" key="report.details.report.state.rejected" bundle="${rb}" scope="request"/>
<fmt:message var="reqchanges" key="report.details.report.state.reqchanges" bundle="${rb}" scope="request"/>
<fmt:message var="processing" key="report.details.report.state.processing" bundle="${rb}" scope="request"/>
<fmt:message var="changed" key="report.details.report.state.changed" bundle="${rb}" scope="request"/>


<div class="card border-0 mb-4">
    <div class="card-header">
        <fmt:message key="main.usertype.inspectorName" bundle="${rb}"/>
    </div>
    <div class="card-body">
        <h5 class="card-title">${reportDetails.inspectorName ne null ? reportDetails.inspectorName : notAssignedText}</h5>
    </div>
    <%--CHANGE_BTN--%>
    <c:if test="${reportDetails.approvalStateId eq 2}">
        <span class="d-flex justify-content-end mt-n4">
            <a href="taxsystem/?command=${Command.CHANGE_INSPECTOR}" class="btn btn-warning"><fmt:message key="report.details.change.btn" bundle="${rb}"/></a>

        </span>
    </c:if>
    <%--CHANGE_BTN--%>
</div>

<div class="card border-0">
    <div class="card-header">
        <fmt:message key="sent.reports.table.header.state" bundle="${rb}"/>
    </div>
    <div class="card-body">
        <%--APPROVAL_STATE--%>
        <c:choose>
            <c:when test = "${reportDetails.approvalStateId eq 1}">
                <h5 class="card-title text-success">
                    ${approved}
                </h5>
            </c:when>
            <c:when test = "${reportDetails.approvalStateId eq 2}">
                <h5 class="card-title text-danger">
                    ${rejected}
                </h5>
            </c:when>
            <c:when test = "${reportDetails.approvalStateId eq 3}">
                <h5 class="card-title text-warning">
                    ${reqchanges}
                </h5>
            </c:when>
            <c:when test = "${reportDetails.approvalStateId eq 4}">
                <h5 class="card-title text-primary">
                    ${processing}
                </h5>
            </c:when>
            <c:otherwise>
                <h5 class="card-title text-info">
                    ${changed}
                </h5>
            </c:otherwise>
        </c:choose>
        <%--APPROVAL_STATE--%>
        <%--REFUSAL_CAUSE--%>
        <c:if test="${reportDetails.approvalStateId eq 2}">
            <p class="card-text">${reportDetails.refusalCause}</p>
        </c:if>
        <%--REFUSAL_CAUSE--%>
    </div>
</div>

<div class="card border-0">
    <div class="card-header">
        <fmt:message key="report.details.report.content" bundle="${rb}"/>
    </div>
    <div class="card-body">
        <div class="row">
            <div class="col-md-3 text-secondary"><fmt:message key="report.details.report.id" bundle="${rb}"/></div>
            <div class="col-md-3 text-secondary"><fmt:message key="report.details.report.taxtype" bundle="${rb}"/></div>
            <div class="col-md-3 text-secondary"><fmt:message key="report.details.report.income" bundle="${rb}"/></div>
            <div class="col-md-3 text-secondary"><fmt:message key="report.details.report.quarter" bundle="${rb}"/></div>
        </div>
        <div class="row p-3 d-flex">
            <div class="col-md-3 text-dark"><h5>${reportDetails.report.id}</h5></div>
            <div class="col-md-3 text-dark">
                <%--TAX_TYPE--%>
                <c:set var="taxType" value="${reportDetails.report.taxType}" scope="request"/>
                <c:choose>
                    <c:when test = "${taxType.id eq 1}">
                        <h5 class="card-title text-dark">
                            <fmt:message key="sendreport.form.select.taxtype.first" bundle="${rb}"/>
                        </h5>
                    </c:when>
                    <c:when test = "${taxType.id eq 2}">
                        <h5 class="card-title text-dark">
                            <fmt:message key="sendreport.form.select.taxtype.second" bundle="${rb}"/>
                        </h5>
                    </c:when>
                    <c:when test = "${taxType.id eq 3}">
                        <h5 class="card-title text-dark">
                            <fmt:message key="sendreport.form.select.taxtype.third" bundle="${rb}"/>
                        </h5>
                    </c:when>
                    <c:otherwise>
                        <h5 class="card-title text-dark">
                            <fmt:message key="sendreport.form.select.taxtype.fourth" bundle="${rb}"/>
                        </h5>
                    </c:otherwise>
                </c:choose>
                <%--TAX_TYPE--%>
            </div>
            <div class="col-md-3 text-dark"><h5>${reportDetails.report.sum}</h5></div>
            <div class="col-md-3 text-dark"><h5>${reportDetails.report.quarter}</h5></div>
        </div>

        <%--EDIT_REPORT_BTN--%>
        <c:if test="${reportDetails.approvalStateId eq 3}">
            <span class="d-flex justify-content-end mr-n4 mt-n3">
                <a href="taxsystem/?command=${Command.GET_REPORT}&${Parameters.REPORT_ID}=${reportDetails.report.id}&${Parameters.REPORT_APPROVAL_ID}=${reportDetails.reportApprovalId}" class="btn btn-primary">
                    <fmt:message key="report.details.report.btn" bundle="${rb}"/>
                </a>
            </span>
        </c:if>
        <%--EDIT_REPORT_BTN--%>
    </div>
</div>

<div class="row">
    <div class="col-md-9"></div>
    <div class="col-md-3"></div>
</div>
