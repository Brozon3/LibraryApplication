package com.example.servletprojectt;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddAuthor", value = "/AddAuthor")
public class AddAuthorServlet {
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        PrintWriter out = response.getWriter();

        try (Connection conn = DatabaseConnection.initDatabase()){

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO bicycles(firstName, lastName) VALUES (?, ?)");

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            preparedStatement.executeQuery();

            out.println("<html><body>");
            out.println("<h1>" + firstName + lastName + "</h1>");
            out.println("</body></html>");

        }
        catch( SQLException e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<h1>" + e + "</h1>");
            out.println("</body></html>");
        }

    }
}
