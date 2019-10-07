<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Commands" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:message var="notAssignedText" key="sent.reports.not.assigned.text" bundle="${rb}" scope="request"/>
<fmt:message var="approved" key="report.details.report.state.approved" bundle="${rb}" scope="request"/>
<fmt:message var="rejected" key="report.details.report.state.rejected" bundle="${rb}" scope="request"/>
<fmt:message var="require_changes" key="report.details.report.state.reqchanges" bundle="${rb}" scope="request"/>
<fmt:message var="processing" key="report.details.report.state.processing" bundle="${rb}" scope="request"/>
<fmt:message var="changed" key="report.details.report.state.changed" bundle="${rb}" scope="request"/>


<div class="card border-0 mb-2">
    <div class="card-header">
        ${reportDetails.userTypeId eq userTypeIndividualId ? userTypeIndividualText : userTypeLegalEntityText}
    </div>
    <div class="card-body">
        <h5 class="card-title">${reportDetails.userName}</h5>
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
    </div>
</div>

<form>
    <div class="form-group">
        <div class="row container-fluid">
            <div class="col-md-3">
                <div class="input-group mt-4">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect02"><fmt:message key="sent.reports.table.header.state" bundle="${rb}"/></label>
                    </div>
                    <select class="custom-select" id="inputGroupSelect02" name="${Parameters.REPORTS_APPROVAL_TYPE}">
                        <option value="1" selected >${approved}</option>
                        <option value="2">${rejected}</option>
                        <option value="3">${require_changes}</option>
                    </select>
                </div>
                <input type="hidden" name="command" value="${Commands.APPROVE_REPORT}">
                <input type="hidden" name="${Parameters.REPORT_APPROVAL_ID}" value="${reportDetails.reportApprovalId}">
                <button type="submit" class="btn btn-primary mt-md-5"><fmt:message key="sendreport.form.button.submit" bundle="${rb}"/></button>
            </div>
            <div class="col-md-9 mt-n2">
                <div class="form-group" id="refusal_cause_textfield">
                    <label for="comment"><fmt:message key="report.approve.refusal.case" bundle="${rb}"/></label>
                    <textarea class="form-control" rows="4" id="comment" name="${Parameters.REFUSAL_CAUSE}"></textarea>
                </div>
            </div>
        </div>
    </div>
</form>

<script>
$(function(){
    $('#inputGroupSelect02').change(function() {
        let selectedValue = $('#inputGroupSelect02').val();

        if(selectedValue === '2') {
            $('#refusal_cause_textfield').show();
        } else {
            $('#refusal_cause_textfield').hide();
        }

        console.log(selectedValue);
    })
});
</script>

