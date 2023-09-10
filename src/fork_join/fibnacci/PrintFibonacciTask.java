package fork_join.fibnacci;

import java.util.concurrent.RecursiveTask;

public class PrintFibonacciTask extends RecursiveTask<Long> {

    private final long n;

    public PrintFibonacciTask(long n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return n;
        } else {
            PrintFibonacciTask task1 = new PrintFibonacciTask(n-1);
            PrintFibonacciTask task2 = new PrintFibonacciTask(n-2);

//            task1.fork();
            task2.fork();

            return task1.compute() + task2.join();
        }
    }
}
