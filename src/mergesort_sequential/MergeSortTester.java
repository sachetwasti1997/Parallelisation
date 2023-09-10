package mergesort_sequential;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTester {
    public static void main(String[] args) {
        var rand = new Random();
        int[] num = new int[rand.nextInt(14, 25)];
        for (int i=0; i< num.length; i++) {
            num[i] = rand.nextInt(1, 65);
        }
        System.out.println(Arrays.toString(num));
        var mergeSort = new MergeSort(num);
        mergeSort.sort();
        System.out.println(Arrays.toString(num));
    }
}
