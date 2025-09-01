// Bookshelf holds multiple Books

import java.util.ArrayList;
import java.util.HashMap;

public class Bookshelf {

    private HashMap<Integer, Book> availableBooks = new HashMap<>();
    private HashMap<Integer, Book> borrowedBooks = new HashMap<>();
    private HashMap<Integer, Book> allBooks = new HashMap<>();


    public void addBook(Book book) {
        availableBooks.put(book.getID(), book);
        allBooks.put(book.getID(), book);
    }

    public void removeBook(int id) {
        String status = testAvailability(id);
        if (status.equals("Available")) {
            System.out.println("Removing book " + id);
            availableBooks.remove(id);
            allBooks.remove(id);
        }
    }

    public void borrowBook(int id) {
        String status = testAvailability(id);
        if (status.equals("Available")) {
            availableBooks.put(borrowedBooks.get(id).getID(), borrowedBooks.get(id));
            availableBooks.remove(id);
        }

    }

    public void listAvailableBooks() {
        System.out.println("Number of Available Books: " + availableBooks.size() + "\nAvailable Books: ");
        for (Book book : availableBooks.values()) {
            System.out.println(book.getBookDetails());
        }
    }

    public void listBorrowedBooks() {
        System.out.println("Number of Borrowed books: " + borrowedBooks.size() + "\nBorrowed Books: ");
        for (Book book : borrowedBooks.values()) {
            System.out.println(book.getBookDetails());
        }
    }

    public void listAllBooks() {
        System.out.println("Number of Total books: " + allBooks.size() + "\nTotal Books: ");
        listAvailableBooks();
        listBorrowedBooks();
    }

    private String testAvailability(int id) {
        Book ifNull = allBooks.get(id);
        boolean ifBorrowed = ifNull.getIsBorrowed();
        if (ifNull == null) {
            System.out.println("Book not found, cannot borrow");
            return "Non-existent";
        } else if (ifBorrowed) {
            System.out.println("Book is borrowed already, cannot borrow");
            return "Borrowed";
        } else {
            System.out.println("Book is available for action.");
            return "Available";
        }
    }





}
