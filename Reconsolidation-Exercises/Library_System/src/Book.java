// Book contains a book's information

public class Book {
    private String author;
    private String title;
    private int pages;

    public Book(String author, String title, int pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
    }

    public String getBookDetails() {
        return "Book title: " + title + ", author: " + author + ", pages: " + pages;
    }
}
