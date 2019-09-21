<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <label class="input-group-text" for="inputGroupSelect01">${reportTypeName}</label>
                </div>
                <select class="custom-select" id="inputGroupSelect01">
                    <option selected >${selectFormItem}</option>
                    <option>JSON</option>
                    <option>XML</option>
                </select>
            </div>
            <!-- dropdown -->

            <!-- form -->
            <form>
                <div id ="formWrapper">
                    <!-- type -->
                    <div class="form-group">
                        <label for="exampleFormControlSelect1">${taxTypeLabel}</label>
                        <select class="form-control" id="exampleFormControlSelect1">
                            <option>${singleTaxType}</option>
                            <option>${propertyTaxType}</option>
                            <option>${touristTaxType}</option>
                            <option>${parkingTaxType}</option>
                        </select>
                    </div>

                    <!-- quoter -->
                    <div class="form-group">
                        <label for="exampleFormControlSelect2">${quarterLabel}</label>
                        <select class="form-control" id="exampleFormControlSelect2">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>

                    <!-- sum-->
                    <div class="form-group">
                        <label for="exampleFormControlInput2">${sumLabel}</label>
                        <input type="text" class="form-control" id="exampleFormControlInput2" placeholder="sum">
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
                <button type="submit" class="btn btn-primary">${submitButton}</button>
            </form>
            <!-- form -->
        </div>
        <div class="col-md-8"></div>
    </div>
</div>

<script>
    document.getElementById("filesInput").addEventListener('change', openFile, false);
</script>


