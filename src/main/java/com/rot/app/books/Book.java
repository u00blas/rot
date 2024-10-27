package com.rot.app.books;

import java.util.List;
import java.util.Objects;

public class Book {

    private static Long ids = 0L;
    private Long id;
    private String title;
    private String author;
    private List<String> proposals;
    private String answer;

    public Book() {
        this.id = getNextId();
    }

    public Book(String title, String author, List<String> proposals) {
        this.id = getNextId();
        this.title = title;
        this.author = author;
        this.proposals = proposals;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getProposals() {
        return proposals;
    }

    public void setProposals(List<String> proposals) {
        this.proposals = proposals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", answer='" + answer + '\'' +
                ", proposals=" + proposals +
                '}';
    }

    private static Long getNextId() {
        return ids++;
    }
}
