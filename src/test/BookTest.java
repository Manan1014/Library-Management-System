package com.example.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BookTest {

    @Test
    public void testBookCreation() {
        // Create a Book instance with test data

        Book b1 = new Book("12", "Java", "Joshua Bloch", 2008);
        Library l = new Library();
        // Verify the properties of the book
        assertEquals("12", b1.getId());
        assertEquals("Java", b1.getTitle());
        assertEquals("Joshua Bloch", b1.getAuthor());
        assertEquals(2008, b1.getPublicationYear());
        assertTrue(b1.isAvailable());
        assertTrue("Book should be added successfully.", l.addBook(b1));

    }

    @Test
    public void testAddDuplicateBook() {
        Library l = new Library();
        Book book1 = new Book("1234567890", "Title One", "Author One", 2024);
        l.addBook(book1);

        Book book2 = new Book("1234567890", "Title One", "Author One", 2024); // Duplicate

        // Check if the book is detected as a duplicate and not added
        boolean result = l.addBook(book2);
        assertFalse("Duplicate book should not be added.", result);

        // Optional: Check the size of the collection to ensure only one book was added
        assertEquals("Library should contain only one unique book.", 1, l.getBooks().size());
    }
}
