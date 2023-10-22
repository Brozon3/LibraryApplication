<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html>
    <head>
        <tags:bootstrap/>
        <title>Pat's Library: Add an Author</title>
    </head>
    <body>
        <tags:navbar/>
        <div class="container justify-content-md-center">
            <h1><%= "Add an Author" %></h1>
            <form action="AddAuthor" method="Post">

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="firstName">First Name:</span>
                    </div>
                    <input type="text" name="firstName" class="form-control" placeholder="Joe"
                           aria-label="First Name" aria-describedby="firstName" required="required">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="lastName">Last Name:</span>
                    </div>
                    <input type="text" name="lastName" class="form-control" placeholder="Blow"
                           aria-label="Last Name" aria-describedby="lastName" required="required">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        <tags:footer/>
    </body>
</html>
