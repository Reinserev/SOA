<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="string" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <spring:url value="/resources/lib/bootstrap.css" var="bootstrapCss"/>
    <spring:url value="/resources/lib/bootstrap.js" var="bootstrapJs"/>
    <spring:url value="/resources/lib/jquery-3.4.1.min.js" var="jQuery"/>
    <spring:url value="/resources/js/article.js" var="pageJS"/>
    <spring:url value="/resources/css/article.css" var="pageCSS"/>

    <title>Login</title>
</head>

<body>
<header>
    <%--includes Bootstrap CSS & JS, JQuery JS--%>
    <%@ include file="header.jsp" %>
</header>

<form:form method="POST"
           action="${pageContext.request.contextPath}/login" modelAttribute="loginDTO">
    <table>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>

<a href="${pageContext.request.contextPath}/articles/recent/1"><h5
        class="card-title">Login as guest</h5>
</a>

<script type="text/javascript" src="${pageJS}"></script>
<link rel="stylesheet" type="text/css" href="${pageCSS}">

</body>
</html>
