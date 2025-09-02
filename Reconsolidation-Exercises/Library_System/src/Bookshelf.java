// Bookshelf holds multiple Books

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
        switch (status) {
            case "Available" -> {
                System.out.println("Removing book " + "'" + id + "'");
                availableBooks.remove(id);
                allBooks.remove(id);
            }
            case "Borrowed" -> System.out.println("You cannot remove book " + "'" + id + "' as it is borrowed");
            case "Unavailable" -> System.out.println("You cannot remove book " + "'" + id + "' as it doesn't exist");
        }
    }

    public void borrowBook(int id) {
        String status = testAvailability(id);
        switch (status) {
            case "Available" -> {
                System.out.println("Borrowing book " + "'" + id + "'");
                borrowedBooks.put(availableBooks.get(id).getID(), availableBooks.get(id));
                borrowedBooks.get(id).setBorrowed();
                availableBooks.remove(id);
            }
            case "Borrowed" -> System.out.println("You cannot borrow book " + "'" + id + "' as it is already borrowed");
            case "Unavailable" -> System.out.println("you cannot borrow book " + "'" + id + "' as it doesn't exist");
        }

    }

    public void returnBook(int id) {
        String status = testAvailability(id);
        switch (status) {
            case "Available" -> System.out.println("Book " + "'" + id + "' is available meaning you cant return it");
            case "Borrowed" -> {
                System.out.println("Returning book " + "'" + id + "'");
                availableBooks.put(borrowedBooks.get(id).getID(), borrowedBooks.get(id));
                availableBooks.get(id).setBorrowed();
                borrowedBooks.remove(id);
            }
            case "Unavailable" -> System.out.println("You cannot return book " + "'" + id + "' as it doesn't exist");
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
        for (Book book : allBooks.values()) {
            System.out.println(book.getBookDetails());
        }
    }

    private String testAvailability(int id) {
        Book ifNull = allBooks.get(id);
        boolean ifBorrowed = ifNull.getIsBorrowed();
        if (ifNull == null) {
            System.out.println("This book doesn't exist");
            return "Non-existent";
        } else if (ifBorrowed) {
            System.out.println("This book is borrowed.");
            return "Borrowed";
        } else {
            System.out.println("This books available");
            return "Available";
        }
    }





}
