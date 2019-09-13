<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="POST">
    <label>username:</label>
    <input type="text" name="name" value="" />
    <label>password:</label>
    <input type="text" name="lastName" value="" />
    <input type="submit" name="submit" value="Login" />
</form>
</body>
</html>