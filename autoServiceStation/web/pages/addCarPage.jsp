<%@ include file="include.jsp" %>
<html>
<head>
    <title><fmt:message key="addCarPage.title"/></title>
</head>
<body>
<h3><fmt:message key="addCarPage.header"/></h3>
<br/>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="add_car"/>
    <input type="text" name="carMakeInput" pattern="[A-Za-z]+" placeholder="car make"/><br/>
    <input type="text" name="carModelInput" pattern="[A-Za-z0-9]+" placeholder="car model"/><br/>
    <input type="date" name="carYearInput" pattern="[0-9]{4}" placeholder="car year"/><br/>
    <input type="tel" name="carVinInput" pattern="[A-Z0-9]{17}" placeholder="car vin"/><br/>
    <input type="submit" name="save" value="Save"/>
</form>

</body>
</html>
