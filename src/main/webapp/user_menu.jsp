<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 14.09.2019
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%="Hello, "  + request.getSession().getAttribute("login") + ", you  role is: " + request.getSession().getAttribute("role").toString()%>
    <br>
    <a href="${pageContext.request.contextPath}/logout" target="_blank">logout</a><br>
</body>
</html>
