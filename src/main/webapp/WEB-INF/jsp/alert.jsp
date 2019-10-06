<c:set var="success" value="${not empty alertSuccess and alertSuccess eq true}"/>

<div class="alert ${success ? "alert-success" : "alert-danger"} alert-dismissible fade show" type="alert">
    ${success ? alertSuccessMsg : alertErrorMsg}
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>
