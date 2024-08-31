package com.example.library;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<String, Book> books;

    public Library() {
        books = new HashMap<>();
    }

    // Method to generate a unique key for a book
    private String generateKey(Book book) {
        return book.getTitle() + "-" + book.getAuthor(); // or use book.getISBN() if available
    }

    // Method to add a book to the library uniquely
    public boolean addBook(Book book) {
        String key = generateKey(book);
        if (!books.containsKey(key)) {
            books.put(key, book);
            return true; // Successfully added
        } else {
            System.out.println("Book already exists in the library.");
            return false; // Book already exists
        }
    }

    // Method to get a book from the library
    public Collection<Book> getBooks() {
        return books.values();
    }
}
