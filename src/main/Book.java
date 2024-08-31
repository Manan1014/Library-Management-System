package com.example.library;

import java.util.UUID;

public class Book {

    private String id;
    private String title;
    private String author;
    private int publicationYear;
    private boolean available;

    // Constructor
    public Book(String title, String author, int publicationYear) {
        this.id = UUID.randomUUID().toString();  // Generate unique ID
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true; // Assume available by default
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isAvailable() {
        return available;
    }
}
