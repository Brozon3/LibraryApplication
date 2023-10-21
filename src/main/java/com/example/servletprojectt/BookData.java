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

@WebServlet(name="BookData", urlPatterns={"/BookCollection", "/AddBook"})
public class BookData extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        String title = request.getParameter("title");
        String isbn = request.getParameter("isbn");
        int edition = Integer.parseInt(request.getParameter("edition"));
        String copyright = request.getParameter("copyright");

        PrintWriter out = response.getWriter();

        try (Connection conn = DatabaseConnection.initDatabase()){

            PreparedStatement preparedStatement = conn.prepareStatement(
                    "INSERT INTO titles (isbn, title, editionNumber, copyright) VALUES (?, ?, ?, ?)");

            preparedStatement.setString(1, isbn);
            preparedStatement.setString(2, title);
            preparedStatement.setInt(3, edition);
            preparedStatement.setString(4, copyright);

            preparedStatement.executeQuery();

            out.println("<html><body>");
            out.println("<h1>" + title + " was successfully added to Pat's Library.</h1>");
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

        LinkedList<Book> bookList = new LinkedList<Book>();
        try (Connection conn = DatabaseConnection.initDatabase()){
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT * from titles";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while( resultSet.next()) {
                bookList.add( new Book(resultSet.getString(1), resultSet.getString(2),
                                        resultSet.getInt(3), resultSet.getInt(4)));
            }

            for (Book b: bookList){
                PreparedStatement authorStatement = conn.prepareStatement(
                        "SELECT * FROM authorisbn " +
                            "INNER JOIN authors ON authorisbn.authorID = authors.authorID " +
                            "WHERE isbn = (?)");
                authorStatement.setString(1, b.getISBN());
                ResultSet authors = authorStatement.executeQuery();

                while (authors.next()) {
                    b.addAuthor(new Author(authors.getInt("authorID"), authors.getString("firstName"),
                                            authors.getString("lastName")));
                }

            }

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("book_display.jsp");
            request.setAttribute("bookList", bookList);
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
