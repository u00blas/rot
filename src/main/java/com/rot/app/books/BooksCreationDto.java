package com.rot.app.books;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BooksCreationDto {
    private List<Book> books;
    @NotNull(message = "Der Titel darf nicht leer sein")
    private String title;

    // default and parameterized constructor
    public BooksCreationDto() {
        this.books = new ArrayList<>();
    }

    public BooksCreationDto(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    // getter and setter


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
