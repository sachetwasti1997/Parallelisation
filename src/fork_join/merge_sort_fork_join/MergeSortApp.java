package fork_join.merge_sort_fork_join;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MergeSortApp {
    public static void main(String[] args) {
        var fork = new ForkJoinPool();
        var arr = createArr(1000000);
        var task = new MergeSortFork(arr);
        fork.invoke(task);
    }

    private static int[] createArr(int i) {
        var rand = new Random();
        var arr = new int[i];
        for (int k=0; k<i; k++) {
            arr[k] = rand.nextInt(2, 65433445);
        }
        return arr;
    }
}
