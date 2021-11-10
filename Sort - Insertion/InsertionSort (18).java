package com.aokolnychyi.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {

  public static <T extends Comparable<? super T>> void sort(final List<T> elements) {
    for (int index = 1; index < elements.size(); index++) {
      final T currentElement = elements.get(index);
      int previousIndex = index - 1;

      while (previousIndex >= 0 && currentElement.compareTo(elements.get(previousIndex)) < 0) {
        elements.set(previousIndex + 1, elements.get(previousIndex));
        previousIndex--;
      }

      elements.set(previousIndex + 1, currentElement);
    }
  }

  public static <T extends Comparable<T>> void sort(T[] elements) {
    for (int index = 1; index < elements.length; index++) {
      final T currentElement = elements[index];
      int previousIndex = index - 1;

      while (previousIndex >= 0 && currentElement.compareTo(elements[previousIndex]) < 0) {
        elements[previousIndex + 1] = elements[previousIndex];
        previousIndex--;
      }

      elements[previousIndex + 1] = currentElement;
    }
  }

  public static void main(String[] args) {
    final Integer[] ints = new Integer[]{4, 1, 5, 3, 9, 10, 1};
    sort(ints);
    System.out.println(Arrays.toString(ints));
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
    sort(new ArrayList<Integer>());
  }
}
