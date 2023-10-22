<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <tags:bootstrap/>
        <title>Pat's Library</title>
    </head>
    <body>
        <tags:navbar/>
        <div class="container justify-content-md-center">
            <h1><%= "Welcome to Pat's Library" %></h1>
            <br>
            <p>This library contains books that are near and dear to my heart. Feel free to use the
                links to add books and authors of your own to collection! </p>
        </div>
        <tags:footer/>
    </body>
</html>