package fork_join.max_finding;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFind extends RecursiveTask<Long> {

    private final long [] nums;
    private final int lowIndex;
    private final int highIndex;

    public ParallelMaxFind(long[] nums, int lowIndex, int highIndex) {
        this.nums = nums;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    @Override
    protected Long compute() {
        if (highIndex - lowIndex < 1000) {
            return findMaxSeq(lowIndex, highIndex);
        }else {
            int middleIndex = (highIndex+lowIndex)/2;
            ParallelMaxFind task1 = new ParallelMaxFind(nums, lowIndex, middleIndex);
            ParallelMaxFind task2 = new ParallelMaxFind(nums, middleIndex+1, highIndex);
            invokeAll(task1, task2);
            return Math.max(task1.join(), task2.join());
        }
    }
    private Long findMaxSeq(int start, int end) {
        long max = nums[start];
        for (int i=start+1; i<=end; i++) {
            max = Long.max(max, nums[i]);
        }
        return max;
    }
}
