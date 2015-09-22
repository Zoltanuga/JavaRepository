<%@ include file="include.jsp" %>
<html>
<head>
    <title><fmt:message key="main.title"/></title>
</head>
<body>
<div align="center">
    <h1><fmt:message key="main.header"/></h1>

    <form action="Controller" method="post">
        <c:choose>
            <c:when test="${sessionScope.emailInput}=='/'">
                <c:set var="currentEmail" value=""/>
                <c:set var="currentPassword" value=""/>
                <c:set var="isAdmin" value="true"/>
            </c:when>
            <c:otherwise>
                <c:set var="currentEmail" value="${sessionScope.emailInput}"/>
                <c:set var="currentPassword" value="${sessionScope.passwordInput}"/>
                <c:set var="isAdmin" value="false"/>
            </c:otherwise>
        </c:choose>
        <input type="email" name="emailInput" placeholder="email" value="${currentEmail}"/><br/>
        <input type="password" name="passwordInput" placeholder="password" value="${currentPassword}"/><br/>
        <input type="hidden" name="command" value="main"/>
        <input type="submit" name="login" value="log in"/>
    </form>

    <form action="Controller" method="post">
        <input type="hidden" name="command" value="main_redirect"/>
    </form>
</div>
</body>
</html>
