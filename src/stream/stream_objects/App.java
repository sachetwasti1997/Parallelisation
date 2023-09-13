package stream.stream_objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();
        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on the Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Herman Broach", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

        System.out.println("-------------------------------------");

        books.forEach(System.out::println);

        System.out.println("-------------------------------------");

        var filteredBooks = books.stream().filter(b -> b.getType().equals(Type.NOVEL)).toList();
        filteredBooks.forEach(System.out::println);

        System.out.println("-------------------------------------");

        books.stream().filter(b -> b.getType().equals(Type.NOVEL))
                .sorted(Comparator.comparing(Book::getAuthor)).forEach(System.out::println);

        System.out.println("-------------------------------------");

        books.stream().filter(b -> b.getType().equals(Type.NOVEL))
                .sorted(Comparator.comparing(Book::getAuthor))
                .map(Book::getAuthor)
                .forEach(System.out::println);

    }
}
