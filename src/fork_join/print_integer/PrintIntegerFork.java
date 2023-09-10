package fork_join.print_integer;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class PrintIntegerFork extends RecursiveAction {

    private final List<Integer> nums;

    public PrintIntegerFork(List<Integer> nums) {
        this.nums = nums;
    }

    @Override
    protected void compute() {
        if (nums.size() < 2) {
            for (Integer nm: nums) {
                System.out.print(nm+" ");
            }
        } else {
            List<Integer> leftNms = nums.subList(0, nums.size() / 2);
            List<Integer> rightNms = nums.subList(nums.size()/2, nums.size());

            PrintIntegerFork fork1 = new PrintIntegerFork(leftNms);
            PrintIntegerFork fork2 = new PrintIntegerFork(rightNms);

            fork1.fork();
            fork2.fork();

            fork1.join();
            fork2.join();
        }
    }
}
