package com.aokolnychyi.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

  public static <T extends Comparable<? super T>> void sort(List<T> elements) {
    final int numberOfElements = elements.size();

    for (int outerIndex = 0; outerIndex < numberOfElements; outerIndex++) {
      for (int innerIndex = numberOfElements - 1; innerIndex > outerIndex; innerIndex--) {
        final T currentElement = elements.get(innerIndex);
        final T nextElement = elements.get(innerIndex - 1);
        // < to keep the sorting stable
        if (currentElement.compareTo(nextElement) < 0) {
          Collections.swap(elements, innerIndex, innerIndex - 1);
        }
      }
    }
  }

  public static <T extends Comparable<T>> void sort(T[] elements) {
    for (int lowestIndex = 0; lowestIndex < elements.length; lowestIndex++) {
      for (int currentIndex = elements.length - 1; currentIndex > lowestIndex; currentIndex--) {
        final T currentElement = elements[currentIndex];
        final T nextElement = elements[currentIndex - 1];
        // < to keep the sorting stable
        if (currentElement.compareTo(nextElement) < 0) {
          elements[currentIndex] = nextElement;
          elements[currentIndex - 1] = currentElement;
        }
      }
    }
  }

  public static void main(String[] args) {
    final List<Integer> list = new ArrayList<>();
    list.add(4);
    list.add(1);
    list.add(5);
    list.add(3);
    list.add(9);
    list.add(10);
    list.add(1);
    sort(list);
    System.out.println(list);
    final Integer[] ints = new Integer[]{4, 1, 5, 3, 9, 10, 1};
    sort(ints);
    System.out.println(Arrays.toString(ints));
  }
}

