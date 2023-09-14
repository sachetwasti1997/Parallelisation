package stream.stream_objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapFlatMap {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Being and Time", "Heidegger", 560, Type.PHILOSOPHY));
        books.add(new Book("The Trial", "Franz Kafka", 240, Type.NOVEL));
        books.add(new Book("Death on the Nile", "Agatha Christie", 370, Type.THRILLER));
        books.add(new Book("Ancient Greece", "Robert F.", 435, Type.HISTORY));
        books.add(new Book("Ancient Rome", "Robert F.", 860, Type.HISTORY));
        books.add(new Book("Death of Virgil", "Herman Broach", 590, Type.NOVEL));
        books.add(new Book("The Stranger", "Albert Camus", 560, Type.NOVEL));

        var words = Arrays.asList("Adam", "Ana", "Daniel");

        List<Integer> lengths = words.stream().map(String::length).toList();
        lengths.forEach(System.out::println);
        System.out.println("----------------------------------");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        nums.stream().map(x -> x*x).forEach(System.out::println);
        System.out.println("----------------------------------");
        String [] array = {"hello", "shell"};
        List<String> unique = Arrays.stream(array).map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        unique.forEach(System.out::println);
    }
}
