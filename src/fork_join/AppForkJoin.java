package fork_join;

public class AppForkJoin {
    /*
    fork() - recursivly executes the given task in the pool
            We call it when we use RecursiveTask<T> or RecursiveAction
    join() - returns the result of computation when it is finished
    invoke() - executes the given task + wait + return thr result upon completion
     */
    public static void main(String[] args) {
        SimpleRecursiveAction action = new SimpleRecursiveAction(800);
        action.invoke();
    }

}
