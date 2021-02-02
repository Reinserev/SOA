<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <spring:url value="/resources/lib/bootstrap.css" var="bootstrapCss"/>
    <spring:url value="/resources/lib/bootstrap.js" var="bootstrapJs"/>
    <spring:url value="/resources/lib/jquery-3.4.1.min.js" var="jQuery"/>
    <spring:url value="/resources/lib/sockjs-1.5.0.js" var="sockJS"/>

    <link rel="stylesheet" type="text/css" href="${bootstrapCss}">
</head>

<body>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<nav class="navbar navbar-expand-lg navbar-light">
    <a id="homeLink" class="navbar-brand" href="${pageContext.request.contextPath}/articles/recent/1">News Site</a>

    <ul class="navbar-nav mr-auto">

        <c:forEach items="${labels}" var="currentLabel">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/articles/${currentLabel}/1">${currentLabel}</a>
            </li>
        </c:forEach>

    </ul>
</nav>

<script src="${jQuery}"></script>
<script src="${bootstrapJs}"></script>
<script src="${sockJS}"></script>

</body>

</html>
