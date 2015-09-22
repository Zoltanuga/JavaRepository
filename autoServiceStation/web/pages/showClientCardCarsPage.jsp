<%@ include file="include.jsp" %>

<html>
<head>
    <title><fmt:message key="showClientCardsCarPage.title"/></title>
</head>
<body>
<a href="http://localhost:8080/api/">
    <h4><fmt:message key="showClientCardsCarPage.ref"/></h4></a>

<table border="1" width="100%" cellpadding="0" cellspacing="2" bgcolor="#f0f8ff">
    <tr>
        <th colspan=5><fmt:message key="showClientCardsCarPage.table.header"/></th>
    </tr>
    <tr>
        <th width="20%"><fmt:message key="showClientCardsCarPage.table.column1"/></th>
        <th width="20%"><fmt:message key="showClientCardsCarPage.table.column2"/></th>
        <th width="20%"><fmt:message key="showClientCardsCarPage.table.column3"/></th>
        <th width="20%"><fmt:message key="showClientCardsCarPage.table.column4"/></th>
        <th width="20%"><fmt:message key="showClientCardsCarPage.table.column5"/></th>
    </tr>
    <tr>
        <c:forEach items="${sessionScope.currentClientCars}" var="car">
    <tr align="center">
        <td>${car.make}</td>
        <td>${car.model}</td>
        <td>${car.year}</td>
        <td>${car.vin}</td>
    </tr>
    </c:forEach>
</table>
<form action="Controller">
    <input type="hidden" name="command" value="go_add_car"/>
    <input type="submit" name="addCar" value="Add car"/>
</form></td>

<form action="Controller">
    <input type="hidden" name="command" value="show_orders"/>
    <input type="submit" name="show_orders" value="orders"/>
</form></td>
</body>
</html>
