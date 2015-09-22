<%@ include file="include.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="http://localhost:8080/api/">
    <h4><fmt:message key="showClientCardsCarPage.ref"/></h4></a>

<table border="1" width="100%" cellpadding="0" cellspacing="2" bgcolor="#f0f8ff">
    <tr>
        <th colspan=5><fmt:message key="showOrdersPage.table.header"/></th>
    </tr>
    <tr>
        <th width="20%"><fmt:message key="showOrdersPage.table.column1"/></th>
        <th width="20%"><fmt:message key="showOrdersPage.table.column2"/></th>
    </tr>
    <tr>
        <c:forEach items="${orders}" var="car">
            <tr align="center">
                <td>${car.make}</td>
                <td>${car.model}</td>
                <td>${car.year}</td>
                <td>${car.vin}</td>
            </tr>
        </c:forEach>
</table>
<form action="Controller">
    <input type="hidden" name="command" value="go_add_order"/>
    <input type="submit" name="addCar" value="Add car"/>
</form></td>
</body>
</html>
