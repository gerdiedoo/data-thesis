package com.aokolnychyi.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort {

  public static <T extends Comparable<? super T>> void sort(List<T> elements) {
    for (int outerIndex = 0; outerIndex < elements.size(); outerIndex++) {
      int currentMinElementIndex = outerIndex;
      for (int innerIndex = outerIndex + 1; innerIndex < elements.size(); innerIndex++) {
        T currentMinElement = elements.get(currentMinElementIndex);
        T currentElement = elements.get(innerIndex);
        if (currentElement.compareTo(currentMinElement) < 0) {
          currentMinElementIndex = innerIndex;
        }
      }
      if (currentMinElementIndex != outerIndex) {
        Collections.swap(elements, currentMinElementIndex, outerIndex);
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
  }

}
