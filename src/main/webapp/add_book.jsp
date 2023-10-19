<%--
  Created by IntelliJ IDEA.
  User: Pat
  Date: 2023-10-18
  Time: 1:33 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add a Book</title>
    </head>
    <body>
        <h1><%= "Add a Book" %></h1>
        <form action="AddBook" method="Post">
            <label for="title">Title: </label>
            <input type="text" id="title">
            <br>
            <label for="isbn">ISBN: </label>
            <input type="text" id="isbn">
            <br>
            <label for="edition">Edition #: </label>
            <input type="number" id="edition">
            <br>
            <label for="copyright">Copyright Year: </label>
            <input type="text" id="copyright">
        </form>
        <a href="index.jsp">Home</a>
    </body>
</html>
