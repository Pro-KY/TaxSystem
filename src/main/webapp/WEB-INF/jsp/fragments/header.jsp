<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="ua.training.util.constans.Command"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Header page</title>
    <meta charset="utf-8">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.1.0/css/flag-icon.min.css" rel="stylesheet">

    <style type="text/css">
        <%@include file="/css/styles.css" %>
        <%@include file="/css/bootstrap.min.css" %>
    </style>
</head>
<body>
    <div class="container-fluid">
        <nav class="navbar navbar-expand-lg navbar-dark bg-secondary">
            <a class="navbar-brand" href="#">Tax Reports System</a>

                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown show">
                        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <fmt:message key="header.language" bundle="${rb}"/>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="taxsystem/?command=${Command.CHANGE_LANGUAGE}&language=ua"><span class="flag-icon flag-icon-ua"> </span> Ukrainian</a>
                            <a class="dropdown-item" href="taxsystem/?command=${Command.CHANGE_LANGUAGE}&language=en"><span class="flag-icon flag-icon-us"> </span> English</a>
                        </div>
                    </li>
                </ul>
        </nav>
    </div>

    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
