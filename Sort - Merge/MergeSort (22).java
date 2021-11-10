package main;

/**
 * Created by abdullahodibat.
 */
public class MergeSort {
    public static void main(String args[]) {

        int[] arr = {8, 4, 5, 1, 2, 3, 6, 9, 8};
        int length = arr.length;
        int[] tmp = new int[length];
        mergeSort(arr, tmp, 0, length - 1);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public static void mergeSort(int[] arr, int[] tmp, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(arr, tmp, low, middle);
            mergeSort(arr, tmp, middle + 1, high);
            merge(arr, tmp, low, middle, high);
        }

    }

    private static void merge(int[] arr, int[] tmp, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;
        int k = low;

        for (int o = low; o <= high; o++) {
            tmp[o] = arr[o];
        }

        while (i <= middle && j <= high) {
            if (tmp[i] < tmp[j]) {
                arr[k] = tmp[i];
                k++;
                i++;
            } else {
                arr[k] = tmp[j];
                k++;
                j++;
            }
        }
        while (i <= middle) {
            arr[k] = tmp[i];
            i++;
            k++;
        }
    }

}
