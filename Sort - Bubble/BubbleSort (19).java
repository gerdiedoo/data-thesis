package main;

/**
 * Created by abdullahodibat.
 */
public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {1, 2, 4, 5, 6, 9, 10};
        bubbleSort.sort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean sorted = true;
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    sorted = false;
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
            if (sorted) break;
        }
        return array;
    }
}
