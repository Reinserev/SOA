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
    <spring:url value="/resources/js/upload.js" var="pageJS"/>

</head>

<body>

<header>
    <%--includes Bootstrap CSS & JS, JQuery JS--%>
    <%@ include file="header.jsp" %>
</header>

<c:url var="fileUploadURL" value="${pageContext.request.contextPath}/upload"/>

<p hidden id="baseURL">${pageContext.request.contextPath}</p>

<div class="card">

    <div class="card-body">

        <div class="d-flex justify-content-center">

            Select a File to Load:

            <br>

            <input type="file" id="fileToLoad">

        </div>

        <div class="d-flex justify-content-center">
            <label for="labels">Choose a label :</label>

            <select id="labels">
                <c:forEach items="${labels}" var="currentLabel">
                    <option value="${currentLabel}">${currentLabel}</option>
                </c:forEach>
            </select>
        </div>

        <br>

        <div class="d-flex justify-content-center">
            <button id="uploadButton">Load Selected File</button>
        </div>

    </div>
</div>

<footer>
    <%@ include file="footer.jsp" %>
</footer>

<script type="text/javascript" src="${pageJS}"></script>

</body>
</html>
