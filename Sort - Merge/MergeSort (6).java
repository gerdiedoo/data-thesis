package sortAlgorithms;

import helperUtils.Utility;

public class MergeSort {

  public static void main(String args[]) {
    int[] inputArr = { 10, -80, 5, 76, 92, 100, 52, 1, -10 };
    Utility.printArray(inputArr, true, "Merge Sort");
    mergeSort(inputArr, 0, inputArr.length);
    Utility.printArray(inputArr, false, null);
  }

  public static void mergeSort(int[] arr, int start, int end) {
    split(arr, start, end);
  }

  public static void split(int[] arr, int start, int end) {
    if (end - start < 2) {
      return;
    }

    int mid = (start + end) / 2;
    split(arr, start, mid);
    split(arr, mid, end);
    merge(arr, start, mid, end);
  }

  public static void merge(int[] arr, int start, int mid, int end) {
    if (arr[mid - 1] <= arr[mid]) {
      return;
    }
    int i = start;
    int j = mid;
    int tempIndex = 0;
    int[] temp = new int[end - start];

    while ((i < mid) && (j < end)) {
      temp[tempIndex++] = arr[i] > arr[j] ? arr[j++] : arr[i++];
    }

    System.arraycopy(arr, i, arr, start + tempIndex, mid - i);
    System.arraycopy(temp, 0, arr, start, tempIndex);

  }

}