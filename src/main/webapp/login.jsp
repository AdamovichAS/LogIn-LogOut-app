<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="POST">
    <label>username:</label>
    <input type="text" required placeholder="login" name="login"><br>
    <label>password:</label>
    <input type="password" required placeholder="password" name="password"><br><br>
    <input type="submit" name="submit" value="Login" />
</form>
</body>
</html>