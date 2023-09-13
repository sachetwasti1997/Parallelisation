package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        int [] nums = {1, 5, 3, -2, 9, 12};
        Arrays.stream(nums).filter(x -> x > 0).forEach(ele -> System.out.print(ele+" "));

        String[] names = {"Adam", "Denial", "Martha", "Kevin", "Ben", "Joe", "Brad", "Susan"};
        Stream.of(names).filter(x -> x.startsWith("B")).forEach(System.out::println);
        System.out.println("-----------------------------------");
        Stream.of(names).sorted().forEach(System.out::println);
        System.out.println("-----------------------------------");
        Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
