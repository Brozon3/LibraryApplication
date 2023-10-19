<%@ page import="java.util.LinkedList" %>
<%@ page import="com.example.servletprojectt.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <title>Pat's Library: Books</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light container justify-content-md-center mb-3">
            <a class="navbar-brand" href="#" id="top">Pat's Library</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="BookCollection">View Books</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="AuthorCollection">View Authors</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="add_book.jsp">Add a Book</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="add_author.jsp">Add a Book</a>
                    </li>
                </ul>
            </div>
        </nav>
        <% LinkedList<Book> bookList = (LinkedList<Book>) request.getAttribute("bookList");
            for( Book b: bookList) {
                out.println("<div class='container justify-content-md-center border border-primary'>");
                out.println("<h2> Title: " + b.getTitle() + "</h2>");
                out.println("<p> Edition Number:" + b.getEditionNumber() + "</p>");
                out.println("<p> ISBN: " + b.getISBN() + "</p>");
                out.println("<p> Copyright: " + b.getCopyright() + "</p>");
                out.println("<p> Authors: " + "</p>");
                out.println("</div>");
                out.println("<br>");
            }
        %>
        <div class="container justify-content-md-center">
            <a href="#top">Back to Top</a>
            <p>Designed by: Pat Broders</p>
        </div>
    </body>
</html>
