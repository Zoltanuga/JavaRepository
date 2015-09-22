<%@ include file="include.jsp" %>
<html>
<head>
    <title><fmt:message key="checkClientPage.title"/></title>
</head>
<body>
<h3><fmt:message key="checkClientPage.header"/></h3>
<form action="Controller" method="post">
    <input type="hidden" name="command" value="check_client"/>
    <input type="text" name="clientFirstNameInput" pattern="[A-Za-z]+" placeholder="first name"/><br/>
    <input type="text" name="clientLastNameInput" pattern="[A-Za-z]+" placeholder="last name"/><br/>
    <input type="submit" name="check" value="Check"  />
</form>

</body>
</html>
