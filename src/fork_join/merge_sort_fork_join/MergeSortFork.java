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

        merge(0, middle, nums.length);
    }

    private void mergeSort(int[] nums) {
        if (nums.length <= 1) return;
        int middleIndex = nums.length / 2;
        int [] left = Arrays.copyOfRange(nums, 0, middleIndex);
        int [] right = Arrays.copyOfRange(nums, middleIndex, nums.length);
        mergeSort(left);
        mergeSort(right);
        merge(0, middleIndex, nums.length);
    }


    private void merge(int low, int middle, int high) {
        for (int i=low; i<high; i++) {
            tempArr[i] = nums[i];
        }
        int i = low, k = low;
        int j = middle + 1;
        while (i <= middle && j <= high) {
            if (tempArr[i] <= tempArr[j]) {
                nums[k] = tempArr[i];
                ++i;
            } else {
                nums[k] = tempArr[j];
                ++j;
            }
            k++;
        }
        while (i <= middle) {
            nums[k] = tempArr[i];
            k++;
            i++;
        }
        while(j <= high) {
            nums[k] = tempArr[j];
            k++;
            j++;
        }
    }

}
