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

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        LinkedList<Author> authorList = new LinkedList<>();
        Author existingAuthor = null;

        boolean authorExists = false;
        boolean bookExists = false;


        PrintWriter out = response.getWriter();

        try (Connection conn = DatabaseConnection.initDatabase()){

            PreparedStatement bookStatement = conn.prepareStatement(
                    "SELECT * FROM titles WHERE isbn = (?)");
            bookStatement.setString(1, isbn);
            ResultSet matchingBook = bookStatement.executeQuery();

            if (matchingBook.next()){
                bookExists = true;
            }

            Statement authorStatement = conn.createStatement();
            String authorQuery = "SELECT * from authors";
            ResultSet resultSet = authorStatement.executeQuery(authorQuery);

            while (resultSet.next()){
                authorList.add(new Author(resultSet.getInt("authorID"), resultSet.getString("firstName"),
                                    resultSet.getString("lastName")));
            }

            for (Author a: authorList){
                if (a.getFirstName().equals(firstName) && a.getLastName().equals(lastName)) {
                    existingAuthor = a;
                    authorExists = true;
                    break;
                }
            }

            if (authorExists && !bookExists){
                PreparedStatement titlesStatement = conn.prepareStatement(
                        "INSERT INTO titles (isbn, title, editionNumber, copyright) VALUES (?, ?, ?, ?)"
                );
                titlesStatement.setString(1, isbn);
                titlesStatement.setString(2, title);
                titlesStatement.setInt(3, edition);
                titlesStatement.setString(4, copyright);
                titlesStatement.executeQuery();

                PreparedStatement authorISBNStatement = conn.prepareStatement(
                        "INSERT INTO authorisbn (authorID, isbn) VALUES (?, ?)"
                );
                authorISBNStatement.setInt(1, existingAuthor.getAuthorID());
                authorISBNStatement.setString(2, isbn);
                authorISBNStatement.executeQuery();

                out.println("<html><body>");
                out.println("<h1>" + title + " was successfully added to Pat's Library.</h1>");

            } else if (bookExists) {
                out.println("<html><body>");
                out.println("<h1> A book with an ISBN of " + isbn + " already exists.</h1>");

            } else {
                out.println("<html><body>");
                out.println("<h1>" + title + " was not added to Pat's Library because " +
                            firstName + " " + lastName + " could not be found in the authors database. </h1>");
            }
            out.println("<br>");
            out.println("<a href='index.jsp'>Home</a>");
            out.println("</body></html>");


        }
        catch( SQLException e) {
            out.println("<html><body>");
            out.println("<h1>" + e + "</h1>");
            out.println("</body></html>");
        }

    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {

        LinkedList<Book> bookList = new LinkedList<>();
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
