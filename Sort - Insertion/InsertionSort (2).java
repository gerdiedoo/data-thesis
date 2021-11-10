public class InsertionSort {

    public static void main(String[] args) {

        int[] input = {10, 9, 7, 101, 23, 44, 12, 78, 34, 23};

        for (int i = 1; i < 10; i++) {

            int tmp = input[i];
            int x = i - 1;

            while (x >= 0 && tmp <= input[x]) {
                input[x + 1] = input[x];
                x = x - 1;
            }

            input[x + 1] = tmp;

        }

        System.out.println("Insertion Sort : Sorted List");

        for (int i = 0; i < 10; i++) {
            System.out.println(input[i]);
        }

    }

}
