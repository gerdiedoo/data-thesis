public class SelectionSort {

    public static void main(String[] args) {

        int[] input = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};

        int i, position, tmp;

        for (i = 0; i < 10; i++) {
            position = smallest(input, 10, i);
            tmp = input[i];
            input[i] = input[position];
            input[position] = tmp;
        }

        System.out.println("Selection Sort : Sorted List");

        for (i = 0; i < 10; i++) {
            System.out.println(input[i]);
        }

    }

    public static int smallest(int a[], int n, int i) {
        int small, position, j;
        small = a[i];
        position = i;

        for (j = i + 1; j < 10; j++) {
            if (a[j] < small) {
                small = a[j];
                position = j;
            }
        }

        return position;
    }

}
