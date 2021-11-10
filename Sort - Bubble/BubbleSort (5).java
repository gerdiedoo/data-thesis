package sortAlgorithms;

import helperUtils.Utility;

public class BubbleSort {

  public static void main(String args[]) {
    int[] inputArr = { 10, -80, 5, 76, 92, 100, 52, 1, -10 };
    Utility.printArray(inputArr, true, "Bubble Sort");
    for (int sortedBoundary = inputArr.length - 1; sortedBoundary > 0; sortedBoundary--) {
      for (int i = 0; i < sortedBoundary; i++) {
        if (inputArr[i] > inputArr[i + 1]) {
          Utility.swap(inputArr, i, i + 1);
        }
      }
    }
    Utility.printArray(inputArr, false, null);
  }
}