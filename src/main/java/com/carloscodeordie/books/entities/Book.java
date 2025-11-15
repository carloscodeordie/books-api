package com.carloscodeordie.books.entities;

public class Book {
    private String author;
    private String title;
    private String category;

    public Book() {
        super();
    }

    public Book(String author, String title, String category) {
        this.author = author;
        this.title = title;
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
