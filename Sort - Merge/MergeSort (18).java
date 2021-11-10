package com.aokolnychyi.sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {

  public static <T extends Comparable<T>> void sort(List<T> list) {
    sort(list, 0, list.size() - 1);
  }

  private static <T extends Comparable<T>> void sort(List<T> list, int startIndex, int endIndex) {
    if (startIndex < endIndex) {
      final int middleIndex = (startIndex + endIndex) / 2;
      sort(list, startIndex, middleIndex);
      sort(list, middleIndex + 1, endIndex);
      mergeSortedSequences(list, startIndex, middleIndex, endIndex);
    }
  }

  private static <T extends Comparable<T>> void mergeSortedSequences(
      List<T> list,
      int startIndex,
      int splitIndex,
      int endIndex) {

    final List<T> firstSubList = new ArrayList<>(list.subList(startIndex, splitIndex + 1));
    final List<T> secondSubList = new ArrayList<>(list.subList(splitIndex + 1, endIndex + 1));

    // The next part can be replaced with return CollectionUtils.collate(firstSubList, secondSubList);
    // It merges two sorted Collections, a and b, into a single, sorted List retaining the natural ordering.
    // Alternative for arrays -> Arrays.copyOfRange(original, from, to)
    int currentFirstSubListIndex = 0;
    int currentSecondSubListIndex = 0;
    int currentIndex = startIndex;

    while (currentFirstSubListIndex < firstSubList.size() && currentSecondSubListIndex < secondSubList.size()) {
      final T firstSubListElement = firstSubList.get(currentFirstSubListIndex);
      final T secondSubListElement = secondSubList.get(currentSecondSubListIndex);

      if (firstSubListElement.compareTo(secondSubListElement) <= 0) {
        list.set(currentIndex++, firstSubListElement);
        currentFirstSubListIndex++;
      } else {
        list.set(currentIndex++, secondSubListElement);
        currentSecondSubListIndex++;
      }
    }

    while (currentFirstSubListIndex < firstSubList.size()) {
      final T firstSubListElement = firstSubList.get(currentFirstSubListIndex);
      list.set(currentIndex++, firstSubListElement);
      currentFirstSubListIndex++;
    }

    while (currentSecondSubListIndex < secondSubList.size()) {
      final T secondSubListElement = secondSubList.get(currentSecondSubListIndex);
      list.set(currentIndex++, secondSubListElement);
      currentSecondSubListIndex++;
    }
  }

  public static <T extends Comparable<T>> LinkedList<T> sort(LinkedList<T> list) {
    if (list.size() <= 1) {
      return list;
    }
    final int numberOfElements = list.size();
    final int middleIndex = (numberOfElements - 1) / 2;
    final LinkedList<T> firstSubList = new LinkedList<>(list.subList(0, middleIndex + 1));
    final LinkedList<T> secondSubList = new LinkedList<>(list.subList(middleIndex + 1, numberOfElements));
    final LinkedList<T> sortedFirstSubList = sort(firstSubList);
    final LinkedList<T> sortedSecondSubList = sort(secondSubList);
    return mergeSortedLists(sortedFirstSubList, sortedSecondSubList);
  }

  // O(firstList + secondList) time, O(firstList + secondList) space for the merged list.
  // If you write your implementation in terms of Nodes, then you can use O(1) additional space.
  private static <T extends Comparable<? super T>> LinkedList<T> mergeSortedLists(
    LinkedList<T> firstSortedList,
    LinkedList<T> secondSortedList) {

    final LinkedList<T> mergedList = new LinkedList<>();

    T firstListElement = firstSortedList.peek();
    T secondListElement = secondSortedList.peek();

    while (firstListElement != null && secondListElement != null) {
      if (firstListElement.compareTo(secondListElement) <= 0) {
        mergedList.add(firstListElement);
        firstSortedList.remove();
        firstListElement = firstSortedList.peek();
      } else {
        mergedList.add(secondListElement);
        secondSortedList.remove();
        secondListElement = secondSortedList.peek();
      }
    }

    while (firstListElement != null) {
      mergedList.add(firstListElement);
      firstSortedList.remove();
      firstListElement = firstSortedList.peek();
    }

    while (secondListElement != null) {
      mergedList.add(secondListElement);
      secondSortedList.remove();
      secondListElement = secondSortedList.peek();
    }

    return mergedList;
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
    sort(new ArrayList<Integer>());
    System.out.println(list);
    final LinkedList<Integer> linkedList = new LinkedList<>();
    linkedList.add(4);
    linkedList.add(1);
    linkedList.add(5);
    linkedList.add(3);
    linkedList.add(9);
    linkedList.add(10);
    linkedList.add(1);
    sort(new LinkedList<Integer>());
    System.out.println(sort(linkedList));
  }
}
