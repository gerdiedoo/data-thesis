package com.aokolnychyi.sorting;

public class BinarySearch {

  public static <T extends Comparable<T>> int findIndexOfElement(T[] array, T targetElement) {
    int lowestElementIndex = 0;
    int highestElementIndex = array.length - 1;

    while (lowestElementIndex <= highestElementIndex) {
      final int middleElementIndex = (lowestElementIndex + highestElementIndex) / 2;
      if (array[middleElementIndex].compareTo(targetElement) < 0) {
        lowestElementIndex = middleElementIndex + 1;
      } else if (array[middleElementIndex].compareTo(targetElement) > 0) {
        highestElementIndex = middleElementIndex - 1;
      } else {
        return middleElementIndex;
      }
    }
    return -1;
  }


  public static void main(String[] args) {
    final Integer[] array1 = new Integer[]{1, 2, 3, 4, 5, 6};
    final Integer[] array2 = new Integer[]{-10, -2, 0, 3, 5};
    final Integer[] array3 = new Integer[]{1};
    final Integer[] array4 = new Integer[]{};

    System.out.println("Index of 3 in array1: " + findIndexOfElement(array1, 3));
    System.out.println("Index of 1 in array1: " + findIndexOfElement(array1, 1));
    System.out.println("Index of 6 in array1: " + findIndexOfElement(array1, 6));
    System.out.println("Index of 2 in array1: " + findIndexOfElement(array1, 2));

    System.out.println("Index of -10 in array2: " + findIndexOfElement(array2, -10));
    System.out.println("Index of 0 in array2: " + findIndexOfElement(array2, 0));
    System.out.println("Index of 3 in array2: " + findIndexOfElement(array2, 3));

    System.out.println("Index of 1 in array3: " + findIndexOfElement(array3, 1));
    System.out.println("Index of -2 in array3: " + findIndexOfElement(array3, -2));

    System.out.println("Index of 1 in array4: " + findIndexOfElement(array4, 1));
  }
}
