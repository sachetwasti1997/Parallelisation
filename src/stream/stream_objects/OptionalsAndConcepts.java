package stream.stream_objects;

import stream.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class OptionalsAndConcepts {
    public static void main(String[] args) {
        List<Book> books = util.getBooksList();

        System.out.println(books.stream().count());

        List<Integer> nums = Arrays.asList(1, 2,3, 4);
        Optional<Integer> result = nums.stream().reduce(Integer::max);
//        System.out.println(result.get());
        result.ifPresent(System.out::println);

        //maximum number of pages
        books.stream().map(Book::getPages).reduce(Integer::max).ifPresent(System.out::println);
        // book with the maximum number of pages
        var res = books.stream().reduce((b1, b2) -> b1.getPages() > b2.getPages() ? b1 : b2);
        System.out.println(res.get());

        // sum of all the pages
        IntStream pageStream = books.stream().mapToInt(Book::getPages);
        System.out.println(pageStream.sum());
    }
}
