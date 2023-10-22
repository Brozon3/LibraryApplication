<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
    <head>
        <tags:bootstrap/>
        <title>Pat's Library: Add a Book</title>
    </head>
    <body>
        <tags:navbar/>
        <div class="container justify-content-md-center">
            <h1><%= "Add a Book" %></h1>
            <form action="AddBook" method="Post">

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="title">Title: </span>
                    </div>
                    <input type="text" name="title" class="form-control" placeholder="The Best Book Ever"
                           aria-label="Title" aria-describedby="title" required="required"
                           maxlength="75" oninvalid="alert('Book title must be less than 75 characters long.');">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="isbn">ISBN: </span>
                    </div>
                    <input type="text" name="isbn" class="form-control" placeholder="0123456789"
                           aria-label="ISBN" aria-describedby="isbn" required="required"
                           pattern="[0-9]{9}" oninvalid="alert('ISBN must be 9 digits.')">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="edition">Edition #: </span>
                    </div>
                    <input type="text" name="edition" class="form-control" placeholder="1"
                           aria-label="edition" aria-describedby="edition" required="required"
                           pattern="[0-9]{1,2}" oninvalid="alert('Edition number must be less than 100.');">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="copyright">Copyright Year: </span>
                    </div>
                    <input type="text" name="copyright" class="form-control" placeholder="2000"
                           aria-label="copyright" aria-describedby="copyright" required="required"
                           pattern="[0-9]{4}" oninvalid="alert('Copyright year must be 4 digits.');">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="firstName">Author First Name: </span>
                    </div>
                    <input type="text" name="firstName" class="form-control" placeholder="Joe"
                           aria-label="authorFirstName" aria-describedby="authorFirstName" required="required"
                           maxlength="50" oninvalid="alert('First name must be less than 50 characters long.');">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="lastName">Author Last Name: </span>
                    </div>
                    <input type="text" name="lastName" class="form-control" placeholder="Blow"
                           aria-label="authorLastName" aria-describedby="authorLastName" required="required"
                           maxlength="50" oninvalid="alert('Last name must be less than 50 characters long.');">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <tags:footer/>
    </body>
</html>