<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 16.09.2019
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/update" method="POST">
    <label>money:</label>
    <input type="number" required placeholder="money" name="money"><br>
    <label>password:</label>
    <input type="password" required placeholder="password" name="password"><br>
    <input type="submit" name="submit" value="update"/><br>
</form>
</body>
</html>
