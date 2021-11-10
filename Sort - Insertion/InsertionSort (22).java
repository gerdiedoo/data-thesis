package main;

/**
 * Created by abdullahodibat.
 */
public class InsertionSort {
    public static void main(String a[]) {
        int[] arr1 = {10, 34, 2, 56, 7, 67, 88, 42};
        doInsertionSort(arr1);
        for (int num : arr1) {
            System.out.print(num);
            System.out.print(", ");
        }
    }

    public static void doInsertionSort(int[] input) {

        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
    }

}
