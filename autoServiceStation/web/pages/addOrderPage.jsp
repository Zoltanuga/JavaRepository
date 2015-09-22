<%@ include file="include.jsp" %>
<html>
<head>
    <title><fmt:message key="addOrderPage.title"/></title>
</head>
<body>
<h3><fmt:message key="addOrderPage.header"/></h3>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="add_order"/>
    <form>
        <input type="radio" name="OrderStatusInput" value="in_progress" checked><fmt:message key="addOrderPage.radio1"/>
        <br>
        <input type="radio" name="OrderStatusInput" value="completed"><fmt:message key="addOrderPage.radio2"/>
        <br>
        <input type="radio" name="OrderStatusInput" value="cancelled"><fmt:message key="addOrderPage.radio3"/>
    </form>
    <br/>
    <input type="text" name="orderAmountInput" pattern="[A-Za-z]+" placeholder="order amount"/><br/>
    <input type="submit" name="save" value="Save"/>
</form>
</body>
</html>
