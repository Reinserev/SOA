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
    <spring:url value="/resources/js/articleList.js" var="pageJS"/>

    <title>${pageTitle}</title>
</head>

<body>
<header>
    <%--includes Bootstrap CSS & JS, JQuery JS--%>
    <%@ include file="header.jsp" %>
</header>

<div class="card">

    <div class="card-body">
        <c:forEach var="rowId" begin="0" end="${noOfRows - 1}" step="1">

            <div class="row">

                <c:forEach var="itemId" begin="${rowId * noOfCols}" end="${rowId * noOfCols + noOfCols - 1}">
                    <c:if test="${!empty articles[itemId]}">
                        <div class="col-4">
                            <div class="card-item">
                                <div class="card">
                                    <div class="card-body">
                                        <a href="${pageContext.request.contextPath}/articles/view/${articles[itemId].id}"><h5
                                                class="card-title">${articles[itemId].title}</h5>
                                        </a>
                                        <p class="card-text">${articles[itemId].text}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:if>

                </c:forEach>

            </div>

            <br>

        </c:forEach>
    </div>

</div>

<br>

<div class="d-flex justify-content-center">

    <h5>

        <c:if test="${page!=1}">
            <a href="${pageContext.request.contextPath}/articles/${link}/${page-1}"> ${page-1} </a>
        </c:if>

        <a href="${pageContext.request.contextPath}/articles/${link}/${page}"> ${page} </a>

        <c:if test="${flag==true}">
            <a href="${pageContext.request.contextPath}/articles/${link}/${page+1}"> ${page+1} </a>
        </c:if>

    </h5>

</div>

<c:if test="${loggedIn}">
<a id="uploadLink" class="nav-link" href="${pageContext.request.contextPath}/articles/upload">Upload a new
    article</a>
</c:if>

<footer>
    <%@ include file="footer.jsp" %>
</footer>

<script type="text/javascript" src="${pageJS}"></script>

</body>
</html>
