package mergesort_sequential;

public class MergeSort {

    private final int[] nums;
    private final int[] tempArr;

    public MergeSort(int[] nums) {
        this.nums = nums;
        tempArr = new int[nums.length];
    }

    public void sort() {
        mergeSort(0, nums.length-1);
    }

    private void mergeSort(int low, int high) {
        //base-case
        if (low >= high) {
            return;
        }
        //middle-item
        int middle = (low+high)/2;

        //recursivly divide
        mergeSort(low, middle);
        mergeSort(middle+1, high);

        //combine results
        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {
        for (int i=low; i<=high; i++) {
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

    public int[] getNums() {
        return nums;
    }
}
