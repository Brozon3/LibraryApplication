package com.example.servletprojectt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;

@WebServlet(name="AuthorData", urlPatterns = {"/AuthorCollection", "/AddAuthor"})
public class AuthorData extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        PrintWriter out = response.getWriter();

        try (Connection conn = DatabaseConnection.initDatabase()){

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO authors (firstName, lastName) VALUES (?, ?)");

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);

            preparedStatement.executeQuery();

            out.println("<html><body>");
            out.println("<h1>" + firstName + " " + lastName + " was successfully added to Pat's Library.</h1>");
            out.println("<br>");
            out.println("<a href='index.jsp'>Home</a>");
            out.println("</body></html>");

        }
        catch( SQLException e) {
            e.printStackTrace();
            out.println("<html><body>");
            out.println("<h1>" + e + "</h1>");
            out.println("</body></html>");
        }

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {

        LinkedList<Author> authorList = new LinkedList<Author>();
        try (Connection conn = DatabaseConnection.initDatabase()){
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT * from authors";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while( resultSet.next()) {
                authorList.add( new Author(resultSet.getInt(1), resultSet.getString(2),
                                            resultSet.getString(3)));
            }

            for (Author a: authorList){
                PreparedStatement authorStatement = conn.prepareStatement(
                        "SELECT * FROM authorisbn " +
                                "INNER JOIN titles ON authorisbn.isbn = titles.isbn " +
                                "WHERE authorID = (?)");
                authorStatement.setInt(1, a.getAuthorID());
                ResultSet books = authorStatement.executeQuery();

                while (books.next()) {
                    a.addBook(new Book(books.getString("titles.isbn"), books.getString("title"), books.getInt("editionNumber"), Integer.parseInt(books.getString("copyright"))));
                }

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
