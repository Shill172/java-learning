// Bookshelf holds multiple Books

import java.util.ArrayList;

public class Bookshelf {

    private ArrayList<Book> availableBooks = new ArrayList<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();
    private ArrayList<Book> allBooks = new ArrayList<>();


    public void addBook(Book book) {
        availableBooks.add(book);
        allBooks.add(book);
    }

    public void removeBook(Book book) {
        String status = searchBook(book);
        if (status.equals("Available")) {
            System.out.println("Book: " + book.getBookDetails() + " Removed!");
            availableBooks.remove(book);
            allBooks.remove(book);
        } else if (status.equals("Borrowed")) {
            System.out.println("You cannot return a book which is borrowed");
        } else {
            System.out.println("Book not found, cannot remove");
        }
    }

    public void borrowBook(Book book) {
        String status = searchBook(book);
        if (status.equals("Available")) {
            borrowedBooks.add(book);
            availableBooks.remove(book);
        } else if (status.equals("Borrowed")) {
            System.out.println("You cannot borrow a book which is borrowed");
        } else {
            System.out.println("Book not found, cannot borrow");
        }

    }

    public int getNoAvailableBooks() {
        return availableBooks.size();
    }

    public int getNoBorrowedBooks() {
        return borrowedBooks.size();
    }

    public int getNoAllBooks() {
        return availableBooks.size() + borrowedBooks.size();
    }

    public void listAvailableBooks() {
        System.out.println("Available Books:");
        for (Book book : availableBooks) {
            System.out.println(book.getBookDetails());
        }
    }

    public void listBorrowedBooks() {
        System.out.println("Borrowed books:");
        for (Book book : borrowedBooks) {
            System.out.println(book.getBookDetails());
        }
    }

    public void listAllBooks() {
        System.out.println("All books:");
        listAvailableBooks();
        listBorrowedBooks();
    }

    public String searchBook(Book book) {
        if (availableBooks.contains(book)) {
            return "Available";
        } else if (borrowedBooks.contains(book)) {
            return "Borrowed";
        }
        return "Not Available";
    }

}
