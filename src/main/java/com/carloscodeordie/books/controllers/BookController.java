package com.carloscodeordie.books.controllers;

import com.carloscodeordie.books.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController(value = "/api")
public class BookController {

    private List<Book> books = new ArrayList<Book>();

    public BookController() {
        super();
        this.initBooks();
    }

    private void initBooks() {
        this.books.addAll(List.of(
            new Book("Author 1", "Title 1", "Category 1"),
            new Book("Author 2", "Title 2", "Category 2")
        ));
    }

    @GetMapping(value = "/books")
    public List<Book> fetchBooks() {
        return books;
    }

    @GetMapping("/books/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return this.books
                .stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }
}
