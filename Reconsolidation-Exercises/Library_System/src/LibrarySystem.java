// LibrarySystem is a small project bringing all my recapped knowledge together. I try to use data structures like for/while loops, ArrayLists, HashMaps, and switch statements,
// I am also going to use Scanners for user input. I will also have a go at having inheritance in the program. If a bug is encountered, I will try my best to debug it using exceptions.

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        Book defaultBook1 = new Book("Author 1", "This book is added by default", 500);
        Book randomBook = new Book("Random Author 1", "Random Book Title", 1000);
        Book finalAddedBook = new Book("Whew", "Final", 700);
        bookshelf.addBook(defaultBook1);
        bookshelf.addBook(randomBook);
        bookshelf.addBook(finalAddedBook);

        while (running) {
            System.out.println("""
                    Welcome to Library System! Please enter your choice: \n
                    1. Add book
                    2. Remove book
                    3. Borrow book
                    4. Return book
                    5. View available Books
                    6. View borrowed books
                    7. View all books
                    "EXIT": Exit program
                    """);
            switch (scanner.nextLine().toLowerCase().trim()) {
                case "1":
                    System.out.println("Enter the author of the book: ");
                    String bookAuthor = scanner.nextLine();

                    System.out.println("Enter the title of the book: ");
                    String bookName = scanner.nextLine();

                    System.out.println("Enter the number of pages in the book: ");
                    int bookPages = scanner.nextInt();
                    scanner.nextLine();

                    Book book = new Book(bookAuthor, bookName, bookPages);
                    bookshelf.addBook(book); // This
                    break;

                case "2":
                     System.out.println("Enter the ID of the book you wish to remove: ");
                     try {
                         int bookIDRemove = scanner.nextInt();
                         scanner.nextLine();
                         bookshelf.removeBook(bookIDRemove);
                     } catch (InputMismatchException e) {
                         System.out.println("Invalid input, please enter a number");
                         scanner.nextLine(); // needed to clear input/"flush out"
                     }
                     break;

                case "3":
                    System.out.println("Enter the ID of the book you wish to borrow: ");
                    try {
                        int bookIDBorrow = scanner.nextInt();
                        scanner.nextLine();
                        bookshelf.borrowBook(bookIDBorrow);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a number");
                        scanner.nextLine();
                    }
                    break;

                case "4":
                    System.out.println("Enter the ID of the book you wish to return: ");
                    try {
                        int bookIDReturn = scanner.nextInt();
                        scanner.nextLine();
                        bookshelf.returnBook(bookIDReturn);
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input, please enter a number");
                        scanner.nextLine();
                    }
                    break;


                case "5":
                    bookshelf.listAvailableBooks();
                    break;

                case "6":
                    bookshelf.listBorrowedBooks();
                    break;

                case "7":
                     bookshelf.listAllBooks();
                     break;

                case "exit":
                    System.out.println("Exiting program...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");


            }
        }


    }

}
