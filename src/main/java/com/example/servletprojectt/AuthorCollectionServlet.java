package com.example.servletprojectt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

@WebServlet(name = "AuthorCollection", value = "/AuthorCollection")
public class AuthorCollectionServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {

        LinkedList<Author> authorList = new LinkedList<Author>();
        try (Connection conn = DatabaseConnection.initDatabase()){
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT * from authors";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while( resultSet.next()) {
                authorList.add( new Author(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("author_display.jsp");
            request.setAttribute("authorList", authorList);
            requestDispatcher.forward(request, response);

        }
        catch( SQLException e) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>" + e + "</h1>");
            out.println("</body></html>");
        }
    }
}
