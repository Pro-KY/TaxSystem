<%@ page contentType="text/html;charset=UTF-8"%>
<c:set var="pageContextPath" value="${pageContext.request.contextPath}" scope="page"/>
<%@ page import="ua.training.util.constans.Command"%>

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
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <a class="navbar-brand" href="#">Tax Reports System</a>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="${pageContextPath}/taxsystem/?command=changeLanguage&language=en" id="dropdown09" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="flag-icon flag-icon-us"> </span> English</a>
                        <div class="dropdown-menu" aria-labelledby="dropdown09">
                            <a class="dropdown-item" href="${pageContextPath}/taxsystem/?command=${Command.CHANGE_LANGUAGE}&language=ua"><span class="flag-icon flag-icon-ua"> </span>  Ukrainian</a>
                            <a class="dropdown-item" href="${pageContextPath}/taxsystem/?command=${Command.CHANGE_LANGUAGE}&language=ru"><span class="flag-icon flag-icon-ru"> </span>  Russian</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>

    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" crossorigin="anonymous"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
