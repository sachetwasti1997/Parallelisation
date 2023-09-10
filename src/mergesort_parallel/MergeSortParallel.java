package mergesort_parallel;

public class MergeSortParallel {
    private final int[] nums;
    private final int[] tempArr;

    public MergeSortParallel(int[] nums) {
        this.nums = nums;
        tempArr = new int[nums.length];
    }

    public void parallelMergeSort(int low, int high, int numOfThreads) {
        if (numOfThreads <= 1) {
            mergeSort(low, high);
            return;
        }
        int middleIndex = (low+high) / 2;
        Thread leftSorter = createThread(low, middleIndex, numOfThreads);
        Thread rightSorter = createThread(middleIndex+1, high, numOfThreads);

        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        merge(low, middleIndex, high);
    }

    public Thread createThread(int low, int high, int numberOfThreads) {
        return new Thread(() -> {
            parallelMergeSort(low, high, numberOfThreads / 2);
        });
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
