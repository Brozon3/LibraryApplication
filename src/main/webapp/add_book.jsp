<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <title>Pat's Library: Add a Book</title>
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
                        <a class="nav-link" href="add_author.jsp">Add an Author</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container justify-content-md-center">
            <h1><%= "Add a Book" %></h1>
            <form action="AddBook" method="Post">

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="title">Title: </span>
                    </div>
                    <input type="text" name="title" class="form-control" placeholder="The Best Book Ever" aria-label="Title" aria-describedby="title">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="isbn">ISBN: </span>
                    </div>
                    <input type="text" name="isbn" class="form-control" placeholder="0123456789" aria-label="ISBN" aria-describedby="isbn">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="edition">Edition #: </span>
                    </div>
                    <input type="text" name="edition" class="form-control" placeholder="1" aria-label="edition" aria-describedby="edition">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="copyright">Copyright Year: </span>
                    </div>
                    <input type="text" name="copyright" class="form-control" placeholder="2000" aria-label="copyright" aria-describedby="copyright">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="firstName">Author First Name: </span>
                    </div>
                    <input type="text" name="firstName" class="form-control" placeholder="Joe" aria-label="authorFirstName" aria-describedby="authorFirstName">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="lastName">Author Last Name: </span>
                    </div>
                    <input type="text" name="lastName" class="form-control" placeholder="Blow" aria-label="authorLastName" aria-describedby="authorLastName">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <div class="container justify-content-md-center fixed-bottom">
            <p>Designed by: Pat Broders</p>
        </div>
    </body>
</html>
