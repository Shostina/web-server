<%--
  Created by IntelliJ IDEA.
  User: anastasia
  Date: 07.08.18
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Sample Application JSP Page</title>
</head>

<body>
<%=(String)request.getAttribute("message") %>
<form action="/signIn" method="POST">
    Login: <input type="text" name="login"/>
    Password: <input type="password" name="password"/>
    <input type="submit" value="Sign in">
</form>
<form action="/signUp" method="POST">
    Login: <input type="text" name="login"/>
    Password: <input type="password" name="password"/>
    <input type="submit" value="Sign up">
</form>
</body>
</html>