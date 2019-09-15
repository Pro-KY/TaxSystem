<%--
  Created by IntelliJ IDEA.
  User: Yuriy
  Date: 03.09.2019
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
</head>
<body>
    <div class="container pt-3">
        <h1 class="text-center">Welcome!</h1>

        <div class="row justify-content-sm-center">
            <div class="col-sm-6 col-md-4">
                <div class="card border-info text-center">
                    <div class="card-body">
                        <img id="img_logo" alt="Company logo" src="${pageContext.request.contextPath}/assets/logo.png">
<%--                        <h4 class="text-center">Tax Report System</h4>--%>

                        <jsp:include page="WEB-INF/jsp/login.jsp"/>
                    </div>
                </div>
            </div>
        </div>

        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </div>
</body>
</html>
