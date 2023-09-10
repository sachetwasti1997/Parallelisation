package mergesort_parallel;

import mergesort_sequential.MergeSort;

import java.util.Random;
import java.util.stream.IntStream;

public class MergeSortTester {
    public static void main(String[] args) {
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        int [] numbers = createArray(100000000);
        int [] num2 = numbers.clone();
        MergeSortParallel parallel = new MergeSortParallel(numbers);
        MergeSort sort = new MergeSort(num2);

        long start = System.currentTimeMillis();
        parallel.parallelMergeSort(0, numbers.length-1, numOfThreads);
        long end = System.currentTimeMillis();

        System.out.println("Time taken for merge "+(end-start));

        start = System.currentTimeMillis();
        sort.sort();
        end = System.currentTimeMillis();

        System.out.println("Time taken for merge "+(end-start));
    }

    private static int[] createArray(int i) {
        Random rand = new Random();
        return IntStream.generate(() -> rand.nextInt(10, 100000010))
                .limit(i)
                .toArray();
    }
}
