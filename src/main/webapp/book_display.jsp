<%@ page import="java.util.LinkedList" %>
<%@ page import="com.example.servletprojectt.Book" %><%--
  Created by IntelliJ IDEA.
  User: Pat
  Date: 2023-10-18
  Time: 1:34 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Pat's Library: Books</title>
    </head>
    <body>
        <% LinkedList<Book> bookList = (LinkedList<Book>) request.getAttribute("bookList");
            for( Book b: bookList) {
                out.println("<h2> Title:" + b.getTitle() + "</h2>");
                out.println("<h3> ISBN:" + b.getISBN() + "</h3>");
                out.println("<h3> Authors:" + "</h3>");
                out.println("<br>");
            }
        %>
    </body>
</html>
