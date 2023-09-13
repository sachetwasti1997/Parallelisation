package stream.stream_objects;

public class Book {

    private final String author;
    private final String title;
    private final Integer pages;
    private final Type type;

    public Book(String title, String author, Integer pages, Type type) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.type = type;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPages() {
        return pages;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", pages=" + pages +
                ", type=" + type +
                '}';
    }
}
