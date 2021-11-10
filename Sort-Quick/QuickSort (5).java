package sortAlgorithms;

import helperUtils.Utility;

public class QuickSort {

  public static void main(String[] args) {
    int[] inputArr = { 10, -80, 5, 76, 92, 100, 52, 1, -10 };
    Utility.printArray(inputArr, true, "Quick Sort");
    quickSort(inputArr, 0, inputArr.length);
    Utility.printArray(inputArr, false, null);
  }

  public static void quickSort(int[] arr, int start, int end) {
    if (end - start < 2) {
      return;
    }

    int partitionIndex = partition(arr, start, end);
    quickSort(arr, start, partitionIndex);
    quickSort(arr, partitionIndex + 1, end);
  }

  public static int partition(int[] arr, int start, int end) {
    int i = start;
    int j = end;
    int pivot = arr[start];

    while (i < j) {
      while (i < j && arr[--j] >= pivot)
        ;
      if (i < j) {
        arr[i] = arr[j];
      }
      while (i < j && arr[++i] <= pivot)
        ;
      if (i < j) {
        arr[j] = arr[i];
      }
    }
    arr[j] = pivot;

    return j;
  }
}