<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/WEB-INF/jsp/fmt_messages.jsp"%>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <!-- form -->
            <form>
                <div id ="formWrapper">
                    <!-- type -->
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">${taxTypeLabel}</label>
                        <select class="form-control" id="exampleFormControlSelect1" name="${Parameters.REPORT_TAXTYPE_ID}">
                            <option value="1" selected>${singleTaxType}</option>
                            <option value="2"> ${propertyTaxType}</option>
                            <option value="3">${touristTaxType}</option>
                            <option value="4">${parkingTaxType}</option>
                        </select>
                    </div>

                    <!-- quoter -->
                    <div class="form-group">
                        <label for="exampleFormControlSelect2">${quarterLabel}</label>
                        <select class="form-control" id="exampleFormControlSelect2" name="${Parameters.REPORT_QUARTER}">
                            <option selected>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>

                    <!-- sum-->
                    <div class="form-group">
                        <label for="exampleFormControlInput2">${sumLabel}</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="sum" name="${Parameters.REPORT_SUM}">
                    </div>
                </div>

                <input type="hidden" name="command" value="sendReport">
                <input type="hidden" id="fileContentInput" name="${Parameters.REPORT_FILE_CONTENT}">
                <button type="submit" class="btn btn-primary">${submitButton}</button>
            </form>
            <!-- form -->
        </div>
        <div class="col-md-8"></div>
    </div>
    <c:if test="${pageContext.request.getAttribute('alert')}">
        <div class="alert alert-success alert-dismissible fade show" role="alert">
            ${alertReportSendSuccess}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
    </c:if>
</div>

<script>
    document.getElementById("filesInput").addEventListener('change', openFile, false);
</script>


