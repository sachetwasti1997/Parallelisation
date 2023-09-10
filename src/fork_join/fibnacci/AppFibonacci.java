package fork_join.fibnacci;

import java.util.concurrent.ForkJoinPool;

public class AppFibonacci {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        PrintFibonacciTask task = new PrintFibonacciTask(50);
        System.out.println(pool.invoke(task));
    }
}
// 1 1 2 3 5
