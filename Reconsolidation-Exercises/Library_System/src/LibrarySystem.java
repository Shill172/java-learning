// LibrarySystem is a small project bringing all my recapped knowledge together

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        bookshelf.listAvailableBooks();

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
                    String bookName = scanner.nextLine();

                    System.out.println("Enter the title of the book: ");
                    String bookAuthor = scanner.nextLine();

                    System.out.println("Enter the number of pages in the book: ");
                    int bookPages = scanner.nextInt();
                    scanner.nextLine();

                    Book book = new Book(bookAuthor, bookName, bookPages);
                    bookshelf.addBook(book); // This
                    break;

                case "2":
                     System.out.println("Enter the ID of the book you wish to remove: ");
                     int bookIDRemove = scanner.nextInt();
                     scanner.nextLine();
                     bookshelf.removeBook(bookIDRemove);
                     break;

                case "3":
                    System.out.println("Enter the ID of the book you wish to borrow: ");
                    int bookIDBorrow = scanner.nextInt();
                    scanner.nextLine();
                    bookshelf.borrowBook(bookIDBorrow);
                    break;

                case "4":
                    System.out.println("Enter the ID of the book you wish to return: ");
                    int bookIDReturn = scanner.nextInt();
                    scanner.nextLine();
                    bookshelf.returnBook(bookIDReturn);
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


            }
        }


    }
}
