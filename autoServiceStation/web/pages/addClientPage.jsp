<%@ include file="include.jsp" %>
<html>
<head>
    <title><fmt:message key="addClientPage.title"/></title>
</head>
<body>
<h3><fmt:message key="addClientPage.header"/></h3>

<form action="Controller" method="post">
    <input type="hidden" name="command" value="add_client"/>

    <input type="text" name="clientFirstNameInput" pattern="[A-Za-z]+" placeholder="first name"
           value="${requestScope.firstNameInsertingClient}"/><br/>
    <input type="text" name="clientLastNameInput" pattern="[A-Za-z]+" placeholder="last name"
           value="${requestScope.lastNameInsertingClient}"/><br/>
    <input type="date" name="clientDateOfBirthInput" pattern="[0-9]{4}[0-9]{2}[0-9]{2}"
           placeholder="birth date YYYYMMDD"/><br/>
    <input type="tel" name="clientPhoneInput" pattern="[0-9]{2}[0-9]{7}" placeholder="phone XX-XXXXXXX"/><br/>
    <input type="email" name="clientEmailInput" placeholder="email"><br/>
    <textarea name="clientAddressInput" cols="40" rows="1" placeholder="address"></textarea>
    <input type="submit" name="save" value="Save"/>

</form>
</body>
</html>
