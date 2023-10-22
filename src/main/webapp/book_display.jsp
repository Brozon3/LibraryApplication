<%@ page import="java.util.LinkedList" %>
<%@ page import="com.example.servletprojectt.Book" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
    <head>
        <tags:bootstrap/>
        <title>Pat's Library: Books</title>
    </head>
    <body>
        <tags:navbar/>
        <% LinkedList<Book> bookList = (LinkedList<Book>) request.getAttribute("bookList");
            for( Book b: bookList) {
                out.println("<div class='container justify-content-md-center border border-primary'>");
                out.println("<h2> Title: " + b.getTitle() + "</h2>");
                out.println("<p> Edition Number: " + b.getEditionNumber() + "</p>");
                out.println("<p> ISBN: " + b.getISBN() + "</p>");
                out.println("<p> Copyright: " + b.getCopyright() + "</p>");
                out.println("<p> Authors: " + b.getAuthorList() + "</p>");
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
