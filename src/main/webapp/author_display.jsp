<%@ page import="com.example.servletprojectt.Author" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
    <head>
        <tags:bootstrap/>
        <title>Pat's Library: Authors</title>
    </head>
    <body>
        <tags:navbar/>
        <% LinkedList<Author> authorList = (LinkedList<Author>) request.getAttribute("authorList");
            for( Author a: authorList) {
                out.println("<div class='container justify-content-md-center border border-primary'>");
                out.println("<h2> Name: " + a.getName() + "</h2>");
                out.println("<p> ID: " + a.getAuthorID() + "</p>");
                out.println("<p> Books: " + a.getBookList() +"</p>");
                out.println("</div>");
                out.println("<br>");
            }
        %>
        <br>
        <br>
        <br>
        <tags:footerwithbutton/>
    </body>
</html>
