// LibrarySystem is a small project bringing all my recapped knowledge together

public class LibrarySystem {
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        Book book1 = new Book("Author 1", "Book 1", 1000);
        Book book2 = new Book("Author 2", "Book 2", 2000);
        Book book3 = new Book("Author 3", "Book 3", 3000);
        Book book4 = new Book("Author 4", "Book 4", 4000);
        Book book5 = new Book("Author 5", "Book 5", 5000);

        bookshelf.addBook(book1);
        bookshelf.addBook(book2);
        bookshelf.addBook(book3);
        bookshelf.addBook(book4);
        bookshelf.addBook(book5);

        System.out.println();

        bookshelf.removeBook(book1);
        bookshelf.removeBook(book1);
        bookshelf.borrowBook(book1);

        System.out.println();

        bookshelf.borrowBook(book2);
        bookshelf.removeBook(book2);
        bookshelf.borrowBook(book2);

        System.out.println();

        bookshelf.listAvailableBooks();
        bookshelf.listBorrowedBooks();
        bookshelf.listAllBooks();

        System.out.println();

        System.out.println(bookshelf.getNoAvailableBooks());
        System.out.println(bookshelf.getNoBorrowedBooks());
        System.out.println(bookshelf.getNoAllBooks());
    }
}
