<%--
  Created by IntelliJ IDEA.
  User: anastasia
  Date: 07.08.18
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SignIn</title>
</head>
<body>
<p>Congratulations, you registered.</p>
<p>Login: ${login}</p>

<form action="/signIn" method="POST">
    Login: <input type="text" name="login"/>
    Password: <input type="password" name="password"/>
    <input type="submit" value="Sign in">
</form>
</body>
</html>
