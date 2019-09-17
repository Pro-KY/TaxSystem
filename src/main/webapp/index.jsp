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
</head>
<body>
    <jsp:include page="WEB-INF/jsp/header.jsp"/>

    <div class="container pt-3">
        <h1 class="text-center">Welcome!</h1>

        <div class="row justify-content-sm-center">
            <div class="col-sm-6 col-md-4">
                <div class="card border-info text-center">
                    <div class="card-body">
                        <img id="user_icon" alt="user icon" src="${pageContext.request.contextPath}/assets/user.png">

                        <jsp:include page="WEB-INF/jsp/login.jsp"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
