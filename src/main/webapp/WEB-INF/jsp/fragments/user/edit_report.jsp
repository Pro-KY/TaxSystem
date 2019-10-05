<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ page import="ua.training.util.constans.Command" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/jsp/fmt_messages.jsp"%>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <c:set var="taxTypeId" value="${reportDto.taxTypeId}" scope="request"/>
            <c:set var="quarterId" value="${reportDto.quarterId}" scope="request"/>
            <!-- form -->

            <!-- id -->
            <div class="mb-2">
                <span class="text-secondary">${reportIdLabel}</span>
                <span>${reportDto.reportId}</span>
            </div>

            <form>
                <div id ="formWrapper">
                    <!-- type -->
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">${taxTypeLabel}</label>
                        <select class="form-control" id="exampleFormControlSelect1" name="${Parameters.REPORT_TAXTYPE_ID}">
                            <option value="1" ${taxTypeId eq 1 ? 'selected' : ''}>${singleTaxType}</option>
                            <option value="2" ${taxTypeId eq 2 ? 'selected' : ''}> ${propertyTaxType}</option>
                            <option value="3" ${taxTypeId eq 3 ? 'selected' : ''}>${touristTaxType}</option>
                            <option value="4" ${taxTypeId eq 4 ? 'selected' : ''}>${parkingTaxType}</option>
                        </select>
                    </div>

                    <!-- quoter -->
                    <div class="form-group">
                        <label for="exampleFormControlSelect2">${quarterLabel}</label>
                        <select class="form-control" id="exampleFormControlSelect2" name="${Parameters.REPORT_QUARTER}">
                            <option ${quarterId eq 1 ? 'selected' : ''}>1</option>
                            <option ${quarterId eq 2 ? 'selected' : ''}>2</option>
                            <option ${quarterId eq 3 ? 'selected' : ''}>3</option>
                            <option ${quarterId eq 4 ? 'selected' : ''}>4</option>
                        </select>
                    </div>

                    <!-- sum-->
                    <div class="form-group">
                        <label for="exampleFormControlInput2">${sumLabel}</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="sum" value="${reportDto.income}" name="${Parameters.REPORT_SUM}">
                    </div>
                </div>

                <input type="hidden" name="${Parameters.REPORT_APPROVAL_ID}" value="${reportDto.reportApprovalId}">
                <input type="hidden" name="${Parameters.REPORT_ID}" value="${reportDto.reportId}">
                <input type="hidden" name="command" value="${Command.EDIT_REPORT}">
                <button type="submit" class="btn btn-primary">${submitButton}</button>
            </form>
            <!-- form -->
        </div>
        <div class="col-md-8"></div>
    </div>
</div>


