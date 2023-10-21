package com.example.servletprojectt;
import java.util.ArrayList;
import java.util.Objects;

public class Author {
    private final int authorID;
    private final String firstName;
    private final String lastName;
    private final ArrayList<Book> bookList;

    public Author(int authorID, String firstName, String lastName) {
        this.authorID = authorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bookList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Books: " + getBookList();
    }

    public int getAuthorID() {
        return authorID;
    }

    public String getName() { return firstName + " " + lastName; }

    public String getBookList() {

        StringBuilder books = new StringBuilder();
        for (Book b: this.bookList){
            books.append(b.getTitle()).append(" || ");
        }
        return books.substring(0, books.length() - 4);
    }

    public void addBook(Book book){
        boolean found = false;
        for (Book b: bookList){
            if (Objects.equals(b.getISBN(), book.getISBN())) {
                found = true;
                break;
            }
        }
        if (!found){
            bookList.add(book);
        }
    }

}
