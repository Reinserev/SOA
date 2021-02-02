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

    <title>${article.title}</title>
</head>

<body>
<header>
    <%--includes Bootstrap CSS & JS, JQuery JS--%>
    <%@ include file="header.jsp" %>
</header>

<p hidden id="var">${pageContext.request.contextPath}/articles/delete/${article.id}</p>

<p hidden id="baseURL">${pageContext.request.contextPath}</p>

<div class="card">

    <div class="card-body">
        <h4>
            ${article.title}
        </h4>

        <br>

        <div class="article_content">
            <h5>
                <pre>${article.text}</pre>
            </h5>
        </div>
    </div>

</div>

<c:if test="${loggedIn}">
    <div class="d-flex justify-content-center">
        <button id="removeArticleButton">Remove article</button>
    </div>
</c:if>

<footer>
    <%@ include file="footer.jsp" %>
</footer>

<script type="text/javascript" src="${pageJS}"></script>
<link rel="stylesheet" type="text/css" href="${pageCSS}">

</body>
</html>
