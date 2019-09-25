<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="ua.training.util.constans.Parameters" %>
<%@ page import="ua.training.util.constans.Attributes" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<fmt:message var="selectFormItem" key="sendreport.dropdown.item.form" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="dropDownBtnLabel" key="sendreport.dropdown.label" bundle="${sessionScope.rb}" scope="request"/>
<%--form--%>
<fmt:message var="taxTypeLabel" key="sendreport.form.label.taxtype" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="quarterLabel" key="sendreport.form.label.quorter" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="sumLabel" key="sendreport.form.label.sum" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="submitButton" key="sendreport.form.button.submit" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="singleTaxType" key="sendreport.form.select.taxtype.first" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="propertyTaxType" key="sendreport.form.select.taxtype.second" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="touristTaxType" key="sendreport.form.select.taxtype.third" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="parkingTaxType" key="sendreport.form.select.taxtype.fourth" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="reportTypeName" key="sendreport.select.report.format" bundle="${sessionScope.rb}" scope="request"/>
<%--inpute file--%>
<fmt:message var="inputFilePlaceholder" key="sendreport.input.file.placeholder" bundle="${sessionScope.rb}" scope="request"/>
<fmt:message var="inputFileButtonName" key="sendreport.input.file.button" bundle="${sessionScope.rb}" scope="request"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <!-- form -->
            <form>
                <!-- report_type -->
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <label class="input-group-text" for="inputGroupSelect01">${reportTypeName}</label>
                    </div>
                    <select class="custom-select" id="inputGroupSelect01" name="${Parameters.REPORT_CONTENT_TYPE}">
                        <option value="1" selected >${selectFormItem}</option>
                        <option value="2">JSON</option>
                        <option value="3">XML</option>
                    </select>
                </div>
                <!-- report_type -->

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

                <div id ="inputFileWrapper">
                    <!-- load file -->
                    <div class="input-group mb-3">
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" id="filesInput">
                            <label class="custom-file-label" for="filesInput" id = "inputFileLabel" data-browse="${inputFileButtonName}">${inputFilePlaceholder}</label>
                        </div>
                    </div>
                    <!-- load file -->
                </div>

                <input type="hidden" name="command" value="sendReport">
                <input type="hidden" id="fileContentInput" name="${Parameters.REPORT_FILE_CONTENT}">
                <button type="submit" class="btn btn-primary">${submitButton}</button>
            </form>
            <!-- form -->
        </div>
        <div class="col-md-8"></div>
    </div>
    <c:if test="${pageContext.getAttribute('alert') eq true}">
        <div class="alert alert-success" role="alert">
            This is a success alert—check it out!
        </div>
    </c:if>
</div>

<script>
    document.getElementById("filesInput").addEventListener('change', openFile, false);
</script>


