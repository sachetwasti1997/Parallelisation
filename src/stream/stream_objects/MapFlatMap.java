package stream.stream_objects;

import stream.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapFlatMap {
    public static void main(String[] args) {
        List<Book> books = util.getBooksList();

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
