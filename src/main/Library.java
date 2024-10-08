package com.example.library;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<String, Book> books;
    private Map<String, Boolean> borrowedStatus = new HashMap<>();

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
            borrowedStatus.put(book.getId(), false);
            return true; // Successfully added
        } else {
            System.out.println("Book already exists in the library.");
            return false; // Book already exists
        }
    }

    //borrowing functionality
    public boolean borrowBook(String id) {
        // Find the key based on ID
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                boolean isBorrowed = borrowedStatus.getOrDefault(id, false);
                if (!isBorrowed) {
                    borrowedStatus.put(id, true); // Mark the book as borrowed
                    return true; // Successfully borrowed
                } else {
                    System.out.println("Book is already borrowed.");
                    return false; // Book is already borrowed
                }
            }
        }
        System.out.println("Book not found in the library.");
        return false; // Book not found
    }

    public Book getBook(String id) {
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getId().equals(id)) {
                return entry.getValue();
            }
        }
        return null;
    }

    //return a book
    public boolean returnBook(String id) {
        if (borrowedStatus.containsKey(id)) {
            if (borrowedStatus.get(id)) {
                borrowedStatus.put(id, false); // Mark the book as returned
                return true; // Successfully returned
            } else {
                System.out.println("Book was not borrowed.");
                return false; // Book was not borrowed
            }
        } else {
            System.out.println("Book not found.");
            return false; // Book not found
        }
    }

    public boolean isBorrowed(String id) {
        return borrowedStatus.getOrDefault(id, false);
    }

    // Method to get a book from the library
    public Collection<Book> getBooks() {
        return books.values();
    }

    //view book 
    public void viewAvailableBooks() {
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            String id = entry.getValue().getId();
            boolean isBorrowed = borrowedStatus.getOrDefault(id, false);
            if (!isBorrowed) {
                System.out.println("Available Book: " + entry.getValue().getTitle()
                        + " by " + entry.getValue().getAuthor());
            }
        }
    }
}
