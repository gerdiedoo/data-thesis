public class selection_sort 
{
    static void selectionSort(int arr[]) {
        for(int k = 0; k < arr.length-1; k++) {
            int min_idx = k;
            for(int j = k+1; j < arr.length; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx]; //swap
            arr[min_idx] = arr[k];
            arr[k] = temp;
        }
    }
    static void printArray(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String args[]) {
        int arr[] = {64,25,12,22,11};
        selectionSort(arr);
        printArray(arr);
    }
}
