<%--
  Created by IntelliJ IDEA.
  User: Yuriy
  Date: 03.09.2019
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Index page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <style type="text/css">
        <%@include file="/css/styles.css" %>
        <%@include file="/css/bootstrap.min.css" %>
    </style>
</head>
<body>
    <!-- TOP navbar -->
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
<%--            <a class="navbar-brand" href="#">User Name</a>--%>
            <div>
                <h5 class="text-white h5">User name</h5>
                <span class="text-white">user type </span>
            </div>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Logut</a>
                    </li>
                </ul>
            </div>
        </nav>
    </div>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-3">
                <!-- A vertical navbar -->
                <nav class="navbar bg-light">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link 1</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link 2</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link 3</a>
                        </li>
                    </ul>
                </nav>
            </div>

            <div class="col-md-9">
                <!-- center page content -->
                <h1> Main page content will be here </h1>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
