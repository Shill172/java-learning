// Book contains a book's information

public class Book {
    private String author;
    private String title;
    private int pages;
    private static int idCounter = 1;
    private int id;
    private boolean isBorrowed = false;

    public Book(String author, String title, int pages) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.id = idCounter + 1;
        idCounter++;

    }

    public int getID() {
        return id;
    }


    public boolean getIsBorrowed() {
        return isBorrowed;
    }

    public boolean setBorrowed() {
       return isBorrowed = !isBorrowed;
    }

    public String getBookDetails() {
        return "Book title: " + title + ", author: " + author + ", pages: " + pages + ", isBorrowed: " + isBorrowed + ", ID: " + id;
    }
}
