package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdullahodibat.
 */
public class BucketSort {

    public static void main(String[] args) {
        int[] arr = {10, 34, 2, 56, 7, 674, 882, 42, 0, 100};
        bucketSort(arr);
        for (int num : arr) {
            System.out.print(num);
            System.out.print(", ");
        }
    }

    public static void bucketSort(int[] arr) {
        int bucketNum = 5;
        int minValue = arr[0];
        int maxValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) maxValue = arr[i];
            if (arr[i] < minValue) minValue = arr[i];
        }
        int diff = maxValue - minValue;
        int range = diff / bucketNum;

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < bucketNum + 1; i++) {
            result.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            result.get((arr[i] - minValue) / range).add(arr[i]);
        }
        int index = 0;
        for (int j = 0; j < result.size(); j++) {
            int[] subArr = new int[result.get(j).size()];
            for (int i = 0; i < subArr.length; i++) {
                subArr[i] = result.get(j).get(i);
            }
            int[] subArrSorted = doInsertionSort(subArr);
            for (int i = 0; i < subArrSorted.length; i++) {
                arr[index] = subArrSorted[i];
                index++;
            }
        }

    }

    public static int[] doInsertionSort(int[] input) {

        for (int i = 1; i < input.length; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j] < input[j - 1]) {
                    int temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }
        return input;
    }

}
