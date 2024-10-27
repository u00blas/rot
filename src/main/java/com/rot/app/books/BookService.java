package com.rot.app.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {

    private final static List<Book> books = new ArrayList<>();
    private static Long id = 0L;

    public List<Book> findAll() {
        if (books.isEmpty()) {
            books.add(new Book("The Fellowship of the Ring", "J. R. R. Olaf", Arrays.asList("One Ring to rule", "One Ring to find them", "One Ring to bring")));
            books.add(new Book("The Two Towers", "J. R. R. Tolkien", Arrays.asList("Two Ring to rule", "Two Ring to find them")));
            books.add(new Book("The Return of the King", "J. R. R. Sepp", Arrays.asList("Three Ring to rule", "Three Ring to find them", "Three Ring", "Four Rings")));
        }
        return books;
    }

    public void save(Book book) {
        books.add(book);
    }

    public void delete(Book book) {
        books.remove(book);
    }

    public void update(Book book) {
        books.remove(book);
        books.add(book);
    }

    public Book findById(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void saveAll(List<Book> books) {
        for (Book book : books) {
            if (findById(book.getId()) != null) {
                update(book);
            } else {
                save(book);
            }
        }
    }

    public Long getNextId() {
        return id++;
    }
}
