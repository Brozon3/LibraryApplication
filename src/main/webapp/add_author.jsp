<%--
  Created by IntelliJ IDEA.
  User: Pat
  Date: 2023-10-18
  Time: 1:34 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Pat's Library: Add an Author</title>
    </head>
    <body>
        <h1><%= "Add an Author" %></h1>
        <form action="AddAuthor" method="Post">
            <label for="firstName">First Name: </label>
            <input type="text" id="firstName">
            <br>
            <label for="lastName">Last Name: </label>
            <input type="text" id="lastName">
        </form>
        <a href="index.jsp">Home</a>
    </body>
</html>
