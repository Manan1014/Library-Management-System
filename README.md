# Library Management System

## Overview

The Library Management System is a Java-based application developed using Test-Driven Development (TDD) principles. This system manages the lifecycle of books within a library, ensuring that all functionalities are driven by tests and validated against expected outcomes.

## Features

- **Add Books**: Add new books to the library collection.
- **Duplicate Book Handling**: Prevent the addition of duplicate books based on ISBN.
- **Borrow Books**: Borrow available books and ensure they are not borrowed more than once.
- **Return Books**: Return borrowed books and make them available for others.
- **View Available Books**: List all books currently available for borrowing.


## Project Structure

- `Book.java`: Defines the `Book` class with attributes like ISBN, title, author, publication year, and availability status.
- `Library.java`: Contains the `Library` class that manages the collection of books, their borrowing status, and provides methods to add, borrow, return, and view books.
- `BookTest.java`: Includes JUnit tests to verify the functionality of the `Book` and `Library` classes.

## Setup and Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/Manan1014/library-management-system.git
   cd library-management-system
   mvn clean install
   mvn test

