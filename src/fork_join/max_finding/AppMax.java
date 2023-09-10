package fork_join.max_finding;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class AppMax {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        var p = createArray(400000);
        ParallelMaxFind task = new ParallelMaxFind(p, 0, p.length - 1);
        System.out.println(pool.invoke(task));
    }

    private static long[] createArray(int i) {
        var rand = new Random();
        long[] arr = new long[i];
        for (int k=0; k<i; k++) {
            arr[k] = rand.nextLong(0, 453223423);
        }
        return arr;
    }


}
