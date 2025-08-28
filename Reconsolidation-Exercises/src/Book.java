// Book class contains the book author, title and number of pages.

public class Book {
    private String title;
    private String author;
    private int pages;

    Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nPages: " + pages;
    }
}
