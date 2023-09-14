package stream.stream_objects;

import java.util.Arrays;
import java.util.List;

public class GenerateAllPossiblePairs {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] arr1 = {4, 5};

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4, 5);

        List<List<Integer>> pairs = list1.stream().flatMap( i ->
                list2.stream().map(j -> Arrays.asList(i, j))
        ).toList();

        pairs.forEach(System.out::println);
    }
}
