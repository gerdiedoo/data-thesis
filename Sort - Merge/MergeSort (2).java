public class MergeSort {

    public static void main(String args[]) {

        int[] input = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(input, 0, input.length - 1);

        System.out.println("Merge Sort : Sorted List");

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i] + "");
        }

    }

    void sort(int input[], int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(input, start, mid);
            sort(input, mid + 1, end);
            merge(input, start, mid, end);
        }
    }

    void merge(int input[], int start, int middle, int end) {
        int left = middle - start + 1;
        int right = end - middle;

        int[] leftArray = new int[left];
        int[] rightArray = new int[right];

        for (int i = 0; i < left; ++i) {
            leftArray[i] = input[start + i];
        }

        for (int j = 0; j < right; ++j) {
            rightArray[j] = input[middle + 1 + j];
        }

        int i = 0, j = 0;
        int k = start;

        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                input[k] = leftArray[i];
                i++;
            } else {
                input[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < left) {
            input[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < right) {
            input[k] = rightArray[j];
            j++;
            k++;
        }
    }

}
