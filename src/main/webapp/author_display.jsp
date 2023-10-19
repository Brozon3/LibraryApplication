<%@ page import="com.example.servletprojectt.Author" %>
<%@ page import="java.util.LinkedList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Pat's Library: Authors</title>
    </head>
    <body>
        <% LinkedList<Author> authorList = (LinkedList<Author>) request.getAttribute("authorList");
            for( Author a: authorList) {
                out.println("<h2> Name:" + a.getName() + "</h2>");
                out.println("<p> ID:" + a.getAuthorID() + "</p>");
                out.println("<p> Books:" + "</p>");
                out.println("<br>");
            }
        %>
        <a href="index.jsp">Home</a>
    </body>
</html>
