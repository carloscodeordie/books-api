package com.carloscodeordie.books.controllers;

import com.carloscodeordie.books.entities.Book;
import org.springframework.web.bind.annotation.*;

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
    public List<Book> fetchBooks(@RequestParam(required = false) String category) {
        if (category == null) {
            return books;
        }
        return books
                .stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category))
                .toList();
    }

    @GetMapping("/books/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return this.books
                .stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/books")
    public void createBook(@RequestBody Book newBook) {
        for (Book book : books) {
            // Validates if the book is already added in the books list
            if (book.getTitle().equalsIgnoreCase(newBook.getTitle())) {
                return;
            }
        }

        books.add(newBook);
    }
}
