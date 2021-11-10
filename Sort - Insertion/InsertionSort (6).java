package sortAlgorithms;

import helperUtils.Utility;

public class InsertionSort {

  public static void main(String[] args) {
    int[] inputArr = { 10, -80, 5, 76, 92, 100, 52, 1, -10 };
    Utility.printArray(inputArr, true, "Insertion Sort");
    for (int firstUnsortedIndex = 1; firstUnsortedIndex < inputArr.length; firstUnsortedIndex++) {
      int pickedElement = inputArr[firstUnsortedIndex];
      int i;
      for (i = firstUnsortedIndex; i > 0 && inputArr[i - 1] > pickedElement; i--) {
        inputArr[i] = inputArr[i - 1];
      }
      inputArr[i] = pickedElement;
    }
    Utility.printArray(inputArr, false, null);
  }

}