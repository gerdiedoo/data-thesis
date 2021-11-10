package com.aokolnychyi.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

  // all elements must be in [0, 1)
  public static void sort(Double[] array, int numberOfBuckets) {
    final ArrayList<List<Double>> buckets = new ArrayList<>(numberOfBuckets);

    for (int bucketIndex = 0; bucketIndex < numberOfBuckets; bucketIndex++) {
      buckets.add(new ArrayList<>());
    }

    for (Double element : array) {
      final int bucketIndex = getBucketIndex(element, numberOfBuckets);
      buckets.get(bucketIndex).add(element);
    }

    buckets.forEach(Collections::sort);

    int currentOutputIndex = 0;

    for (int bucketIndex = 0; bucketIndex < numberOfBuckets; bucketIndex++) {
      final List<Double> bucket = buckets.get(bucketIndex);
      for (Double element : bucket) {
        array[currentOutputIndex] = element;
        currentOutputIndex++;
      }
    }
  }

  private static int getBucketIndex(Double element, int numberOfBuckets) {
    return (int) (element * numberOfBuckets);
  }

  public static void main(String[] args) {
    final Double[] doubles = new Double[]{0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
    sort(doubles, 3);
    sort(new Double[]{}, 3);
    System.out.println(Arrays.toString(doubles));
  }
}
