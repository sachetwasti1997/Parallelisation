package fork_join.merge_sort_fork_join;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class MergeSortFork extends RecursiveAction {

    private final int[] nums;
    private final int[] tempArr;

    public MergeSortFork(int[] nums) {
        this.nums = nums;
        tempArr = new int[nums.length];
    }

    @Override
    protected void compute() {
        if (nums.length <= 10) {
            mergeSort(nums);
            return;
        }

        int middle = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int [] right = Arrays.copyOfRange(nums, middle, nums.length);

        MergeSortFork task = new MergeSortFork(left);
        MergeSortFork task1 = new MergeSortFork(right);

        invokeAll(task, task1);

        merge(left, right, nums);
    }

    private void mergeSort(int[] nums) {
        if (nums.length <= 1) return;
        int middleIndex = nums.length / 2;
        int [] left = Arrays.copyOfRange(nums, 0, middleIndex);
        int [] right = Arrays.copyOfRange(nums, middleIndex, nums.length);
        mergeSort(left);
        mergeSort(right);
        merge(left, right, nums);
    }

    private void merge(int[] left, int[] right, int[] originalArray) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                originalArray[k++] = left[i++];
            }else {
                originalArray[k++] = right[j++];
            }
        }
        while (i < left.length) {
            originalArray[k++] = left[i++];
        }
        while (j < right.length) {
            originalArray[k++] = right[j++];
        }
    }

}
