import java.util.*;

public class Sorting {

    // Counting sort
    public static int[] countingSort(int[] a) {

        int k = a.length;
        int[] b = new int[k + 1];

        if (k == 0) {
            return a;
        }
        int x = a[0];
        for (int i = 1; i < k; i++) {
            if (a[i] > x)
                x = a[i];
        }
        int[] c = new int[x + 1];

        for (int i = 0; i < x; ++i) {
            c[i] = 0;
        }

        for (int i = 0; i < k; i++) {
            c[a[i]]++;
        }

        for (int i = 1; i <= x; i++) {
            c[i] += c[i - 1];
        }

        for (int i = k - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]]--;
        }

        for (int i = 0; i < k; i++) {
            a[i] = b[i];
        }
        return a;
    }

    // Insertion sort
    public static int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i;
            while (j > 0 && a[j - 1] > key) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = key;
        }
        return a;
    }

    // Radix sort
    public static int[] radixSort(int[] a) {
        int k = a.length;

        if (k == 0) {
            return a;
        }
        int max = a[0];

        for (int i = 1; i < k; i++) {
            if (a[i] > max)
                max = a[i];
        }
        for (int j = 1; max / j > 0; j *= 10) {
            countingSort(a);
        }
        return a;
    }

    public final static int MAX_INPUT = 524287;
    public final static int MIN_INPUT = 0;

    // Read ints from a Scanner and returns an array of the ints read
    private static int[] getInts(Scanner s) {
        ArrayList<Integer> a = new ArrayList<Integer>();

        while (s.hasNextInt()) {
            int i = s.nextInt();
            if ((i <= MAX_INPUT) && (i >= MIN_INPUT))
                a.add(i);
        }

        return toIntArray(a);
    }

    // Copies an ArrayList of Integer to an array of int
    private static int[] toIntArray(ArrayList<Integer> a) {
        int[] ret = new int[a.size()];
        for (int i = 0; i < ret.length; i++)
            ret[i] = a.get(i);
        return ret;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.printf("Enter the sorting algorithm to use ([c]ounting, [i]nsertion, [r]adix): ");
        char algo = s.next().charAt(0);

        System.out.printf("Enter the integers that you would like sorted, followed by a non-integer character: ");
        int[] unsorted_values = getInts(s);
        int[] sorted_values = {};

        s.close();

        switch (algo) {
            case 'c':
                sorted_values = countingSort(unsorted_values);
                break;
            case 'i':
                sorted_values = insertionSort(unsorted_values);
                break;
            case 'r':
                sorted_values = radixSort(unsorted_values);
                break;
            default:
                System.out.println("Invalid sorting algorithm");
                System.exit(0);
                break;
        }

        System.out.println(Arrays.toString(sorted_values));
    }
}
