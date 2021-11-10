package main;

/**
 * Created by abdullahodibat.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};
        doSelectionSort(arr1);
        for (int num : arr1) {
            System.out.print(num);
            System.out.print(", ");
        }
    }

    public static void doSelectionSort(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int index = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[index]) {
                    index = j;
                }
            }
            int tmp = input[index];
            input[index] = input[i];
            input[i] = tmp;
        }
    }

}
