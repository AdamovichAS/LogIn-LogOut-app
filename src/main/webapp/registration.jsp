<%@ page import="static java.util.Objects.nonNull" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.09.2019
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/registration" method="POST">
    <label>username:</label>
    <input type="text" required placeholder="login" name="login"><br>
    <label>money:</label>
    <input type="text" required placeholder="money" name="money"><br>
    <label>password:</label>
    <input type="password" required placeholder="password" name="password"><br>
    <label>password:</label>
    <input type="password" required placeholder="repeat password" name="repeatedPassword"><br><br>
    <input type="submit" name="submit" value="Registration"/><br>
</form>
<%
    if(nonNull(request.getAttribute("loginError"))){
    response.getWriter().write((String) request.getAttribute("loginError"));
}
%>
</body>
</html>
