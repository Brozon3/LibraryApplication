package com.example.servletprojectt;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AddBook", value = "/AddBook")
public class AddBookServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        Integer edition = Integer.parseInt(request.getParameter("edition"));
        String copyright = request.getParameter("copyright");

        PrintWriter out = response.getWriter();

        try (Connection conn = DatabaseConnection.getBooksDatabaseConnection()){

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO bicycles(isbn, title, editionNumber, copyright) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, isbn);
            preparedStatement.setString(2, title);
            preparedStatement.setInt(3, edition);
            preparedStatement.setString(4, copyright);

            preparedStatement.executeQuery();

            out.println("<html><body>");
            out.println("<h1>" + title + "</h1>");
            out.println("<h3>" + isbn + "</h3>");
            out.println("<h3>" + edition + "</h3>");
            out.println("<h3>" + copyright + "</h3>");
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
