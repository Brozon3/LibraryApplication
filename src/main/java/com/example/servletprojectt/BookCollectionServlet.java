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

@WebServlet(name = "BookCollection", value = "/BookCollection")
public class BookCollectionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException, ServletException {

        LinkedList<Book> bookList = new LinkedList<Book>();
        try (Connection conn = DatabaseConnection.getBooksDatabaseConnection()){
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT * from titles";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while( resultSet.next()) {
                bookList.add( new Book(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getInt(3));
                System.out.println(resultSet.getInt(4));
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
