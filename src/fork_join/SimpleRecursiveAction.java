package fork_join;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {
    private int simulatedWork;

    public SimpleRecursiveAction(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        // if the task is too large then we split it and execute the task in parallel
        if (simulatedWork > 100) {
            System.out.println("Parallel execution and split the task ..."+simulatedWork);
            SimpleRecursiveAction action1 = new SimpleRecursiveAction(simulatedWork / 2);
            SimpleRecursiveAction action2 = new SimpleRecursiveAction(simulatedWork / 2);

            action1.fork();
            action2.fork();

            action1.join();
            action1.join();
        } else {
            System.out.println("The task is rather small so executing sequentially ..."+simulatedWork);
        }
    }
}
