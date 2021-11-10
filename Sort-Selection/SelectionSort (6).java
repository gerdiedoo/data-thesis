package sortAlgorithms;

import helperUtils.Utility;

public class SelectionSort {

  public static void main(String argd[]) {
    int[] inputArr = { 10, -80, 5, 76, 92, 100, 52, 1, -10 };
    Utility.printArray(inputArr, true, "Selection Sort");
    for (int sortedBoundary = inputArr.length - 1; sortedBoundary > 0; sortedBoundary--) {
      int largestValIndex = 0;
      for (int i = 1; i <= sortedBoundary; i++) {
        if (inputArr[i] > inputArr[largestValIndex]) {
          largestValIndex = i;
        }
      }
      Utility.swap(inputArr, largestValIndex, sortedBoundary);
    }
    Utility.printArray(inputArr, false, null);
  }
}