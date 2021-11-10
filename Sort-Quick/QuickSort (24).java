package dip107;

import java.util.Comparator;

public class QuickSort implements SortingAlgorithm {

    public static Comparator<Integer> ascending = Comparator.naturalOrder();

    public static Comparator<Integer> descending = (o1, o2) -> -ascending.compare(o1, o2);

    public static void sort(int[] arr, int low, int high, int order) {
        if (low < high) {
            Comparator<Integer> comp = order == 1 ? ascending : descending;
            int part = partition(arr, low, high, comp);
            sort(arr, low, part, order);
            sort(arr, part + 1, high, order);
        }
    }

    private static int partition(int[] arr, int low, int high, Comparator<Integer> comp) {
        int pivot = arr[(high + low) / 2];
        int i = low - 1;
        int j = high + 1;
        while (true) {
            do i++; while (comp.compare(arr[i], pivot) < 0);
            do j--; while (comp.compare(arr[j], pivot) > 0);

            if (i >= j) {
                return j;
            }
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public void sort(int[] arr, int order) {
        sort(arr, 0, arr.length - 1, order);
    }

}
